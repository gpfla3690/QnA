package qna.service;

import org.apache.ibatis.session.SqlSession;

import qna.config.SessionFactory;
import qna.dao.QuestionDao;
import qna.vo.Question;

public class QuestionService {
	
	private QuestionDao questionDao;
	private SqlSession sqlSession;
	
	public QuestionService() {
		SqlSession session = SessionFactory.getSession();
		questionDao = session.getMapper(QuestionDao.class);
	}
	
	public void save(String title, String body) {
		
		Question question = new Question(title, body); 
		questionDao.save(question);
		
		sqlSession.commit();
		sqlSession.close();
		
		
	}

}
