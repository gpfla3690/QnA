package qna.web.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import qna.app.components.Service;
import qna.app.configuration.SessionFactory;
import qna.app.container.AppContainer;
import qna.app.dao.QuestionDao;
import qna.web.repository.QuestionRepository;
import qna.web.vo.Question;

public class QuestionService implements Service{
	
	private QuestionRepository questionRepository;
	
	@Override
	public void autoWried() {
		this.questionRepository = AppContainer.questionRepository;
	}
	
	
	public void save(String title, String body) {
		questionRepository.save(title, body);
	}


	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	

}
