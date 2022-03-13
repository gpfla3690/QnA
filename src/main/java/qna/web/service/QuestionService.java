package qna.web.service;

import java.util.List;
import java.util.NoSuchElementException;

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


	public Question findById(int id) {
		
		Question findById = questionRepository.findById(id);
		
		if( findById != null ) {
			return findById;
		}else {
			throw new NoSuchElementException("해당 질문은 존재하지 않습니다.");
		}
		
	}


	public void modify(Question question) {
		questionRepository.modify(question);
		
	}

	

}
