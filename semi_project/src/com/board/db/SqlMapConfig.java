package com.board.db;

import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
		// SqlSessionFactory import 하려면 lib 에 mybatis-jar 파일 넣어줘야 가능.
		private SqlSessionFactory sqlSessionFactory;
		
		public SqlSessionFactory getSqlSessionFactory() {
			
			String resource="com/board/db/config.xml";
			Reader reader = null;
			
			try {
				reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
											
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return sqlSessionFactory;
		}
}
