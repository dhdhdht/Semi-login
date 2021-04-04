package com.daytwo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.daytwo.biz.LoginBiz;
import com.daytwo.dto.LoginDto;


@WebServlet("/naver.do")
public class NaverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		LoginBiz biz = new LoginBiz();
		HttpSession session = request.getSession();
		
		
		String clientId = "zOyYdXgy2oaLzPhWWPFb";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "zA5CXh6aif";//애플리케이션 클라이언트 시크릿값";
	    String code = request.getParameter("code");
	    String state = request.getParameter("state");
	    String redirectURI = URLEncoder.encode("http://localhost:8787/naver.do", "UTF-8");
	    
	    
	    System.out.println("code : " + code);
	    System.out.println("state : " + state);
	    StringBuffer apiURL = new StringBuffer();
	    apiURL.append("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&");
	    apiURL.append("client_id=" + clientId);
	    apiURL.append("&client_secret=" + clientSecret);
	    apiURL.append("&redirect_uri=" + redirectURI);
	    apiURL.append("&code=" + code);
	    apiURL.append("&state=" + state);
	    String access_token = "";
	    String refresh_token = "";
	    //System.out.println("apiURL="+apiURL);
	    
	    try {
	      URL url = new URL(apiURL.toString());
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	        System.out.println("String res :" + res.toString());
	        
	        JSONParser parsing = new JSONParser();
	        Object obj = parsing.parse(res.toString());
	        JSONObject jsonObj = (JSONObject)obj;
	        
	        access_token = (String)jsonObj.get("access_token");
	        refresh_token = (String)jsonObj.get("refresh_token");
	        
	        String token = access_token;
			String header = "Bearer " + token;
			String apiurl = "https://openapi.naver.com/v1/nid/me";
			
			Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("Authorization", header);
	        String responseBody = get(apiurl, requestHeaders);


	        System.out.println("RB : " + responseBody);
	        
	        Object responseBodyObj = parsing.parse(responseBody);
	        JSONObject Jresponse = (JSONObject)responseBodyObj;
	        JSONObject resObj = (JSONObject)Jresponse.get("response");
	        
	        System.out.println("Jobj : " + Jresponse);
	        System.out.println("resobj : " + resObj);
	        System.out.println("json : " + jsonObj);
	        
	        
	        String naverCode = (String)resObj.get("id");
	        String email = (String)resObj.get("email");
	        String name = (String)resObj.get("name");
	        String phone = (String)resObj.get("mobile");
	        
	        //네이버에서 가져오는 값들(아이디, 이메일, 이름, 핸드폰번호)
	        LoginDto dbdto = new LoginDto();
	        dbdto.setMember_id(naverCode);
	        dbdto.setMember_email(email);
	        dbdto.setMember_name(name);
	        dbdto.setMember_phone(phone);
	        	        
	        System.out.println("dto : " + dbdto.getMember_email());
	        
	        int useremailchk = biz.naverCheck(dbdto.getMember_email());
	        
	        
	        //이미 회원일때
	        if (useremailchk > 0) {
	        	//1. 세션에 로그인값 담아줘야되고(이때는 naver가 아닌 db값)
	        	LoginDto dto = biz.getlogininfo(email);
	        	
	        	session.setAttribute("dto", dto);
	        	session.setMaxInactiveInterval(10 * 60);
	        	//2. 유저 메인페이지로 보내줘야되고
	        	jsResponse(response, "usermain.jsp", "네이버아이디로 로그인");
	        	
	        } else {
	        	//회원이 아닐때
	        	//1. 회원가입에 값이 담겨있어야되고
	        	//2. 그 값을 회원가입페이지로 보내줘야되고
	        	request.setAttribute("dbdto", dbdto);
	        	RequestDispatcher dispatch = request.getRequestDispatcher("nregist.jsp");
	        	dispatch.forward(request, response);
	        	
	        }
	        
	        
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    
	    
	}   
	    
	    
	    
	    private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }


	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }

	}
	    
	    private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {
	        String s = "<script type='text/javascript'>"
	                 + "alert('" + msg + "');"
	                 + "location.href='" + url + "';"
	                 + "</script>";
	        response.getWriter().print(s);
	    }

}
