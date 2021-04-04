package com.daytwo.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


@WebServlet("/kakao.do")
public class KakaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		String code = request.getParameter("code");
		String access_token = "";
		String refresh_token = ""; 
		String token = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(token);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//post 요청을위해 setDoOutput = true
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
			StringBuffer apiURL = new StringBuffer();
			apiURL.append("grant_type=authorization_code");
			apiURL.append("&client_id=6147ede2fee67c7e4d0316a0ef4cb677");
			apiURL.append("&redirect_uri=http://localhost:8787/Semi_login/kakao.do");
			apiURL.append("&code=" + code);
			
			bw.write(apiURL.toString());
			bw.flush();
			
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.println("responseCode : " + responseCode);
			
			if(responseCode == 200) { //정상호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { //에러발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String inputLine;
			StringBuffer res = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			
			if(responseCode == 200) {
				System.out.println("String res :" + res.toString());
				
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());
				JSONObject jsonObj = (JSONObject)obj;
				
				access_token = (String)jsonObj.get("access_token");
				refresh_token = (String)jsonObj.get("refresh_token");
				
				String header = "Bearer " + access_token;
				String apiurl = "https://kauth.kakao.com/v2/user/me";
				
				Map<String, String> requestHeaders = new HashMap<>();
				requestHeaders.put("Authorization", header);
				String responseBody = get(apiurl, requestHeaders);
				
				System.out.println("Rb : " + responseBody);
			}
			
			
		}  catch (Exception e) {
			e.printStackTrace();
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
