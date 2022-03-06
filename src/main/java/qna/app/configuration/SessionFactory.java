package qna.app.configuration;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	
	static SqlSessionFactory sqlSessionFactory = null;

	static {
		
		String path = "myBatisConfig.xml"; 
		InputStream inputStream = null; 
		
		try {
			inputStream = Resources.getResourceAsStream(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public static SqlSession getSession() {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		return session;
	}
	
	
}
