package qna.app.container;

import java.util.ArrayList;
import java.util.List;

import qna.app.components.Component;
import qna.app.configuration.SessionFactory;
import qna.app.dao.QuestionDao;
import qna.web.controller.QuestionController;
import qna.web.repository.QuestionRepository;
import qna.web.service.QuestionService;

public class AppContainer {
	
	private static List<Component> componentContainer;
	
	public static QuestionDao questionDao;
	
	public static QuestionController questionController;
	public static QuestionService questionService;
	public static QuestionRepository questionRepository;
	
	
	public static void componentAssemble() {
		
		componentContainer = new ArrayList<>();
		
		questionRepository = addComponent(new QuestionRepository());
		
		questionService = addComponent(new QuestionService());
		
		questionController = addComponent(new QuestionController());
		
		for( Component component : componentContainer) {
			
			component.autoWried();
			
		}
		
		
		
	}
	
	private static <T> T addComponent(Component component) {
		
		componentContainer.add(component);
		
		return (T) component;
		
	}
	
	
	

}
