package qna.app.dao;

import java.util.List;

import qna.web.vo.Question;

public interface QuestionDao {
	
	void save(Question question);
	
	List<Question> findAll();
	
	Question findById(int id);
	
	void modify(Question question);
	

}
