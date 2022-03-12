package qna.web.repository;

import qna.app.components.Repository;
import qna.app.container.AppContainer;
import qna.app.dao.QuestionDao;

public class QuestionRepository implements Repository{
	
	private QuestionDao questionDao;

	@Override
	public void autoWried() {
		questionDao = AppContainer.questionDao;
		
	}

}
