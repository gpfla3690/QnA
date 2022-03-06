package qna.web.service;

import org.apache.ibatis.session.SqlSession;

import qna.app.components.Service;
import qna.app.configuration.SessionFactory;
import qna.app.dao.QuestionDao;
import qna.web.vo.Question;

public class QuestionService implements Service{
	
	private QuestionDao questionDao;
	private SqlSession sqlSession;
	
	public QuestionService() {
		SqlSession session = SessionFactory.getSession();
		questionDao = session.getMapper(QuestionDao.class);
		
		this.sqlSession = session;
	}
	
	public void save(String title, String body) {
		
		Question question = new Question(title, body); 
		questionDao.save(question);
		
		sqlSession.commit();
		
		
	}

	@Override
	public void autoWried() {
		// TODO Auto-generated method stub
		
	}

}
