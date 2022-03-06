package qna.app.container;

import java.util.ArrayList;
import java.util.List;

import qna.app.components.Component;
import qna.app.configuration.SessionFactory;
import qna.app.dao.QuestionDao;
import qna.web.controller.QuestionController;
import qna.web.service.QuestionService;

public class AppContainer {
	
	private static List<Component> componentContainer;
	
	public static QuestionDao questionDao;
	
	public static QuestionController questionController;
	public static QuestionService questionService;
	
	
	public static void componentAssemble() {
		
		componentContainer = new ArrayList<>();
		
		questionDao = SessionFactory.getSession().getMapper(QuestionDao.class);
		
		questionController = addComponent(new QuestionController());
		
	}
	
	private static <T> T addComponent(Component component) {
		
		componentContainer.add(component);
		
		return (T) component;
		
	}
	
	
	

}
