package qna.web.controller;

import java.util.List;

import qna.app.components.Controller;
import qna.app.container.AppContainer;
import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;
import qna.web.service.QuestionService;
import qna.web.vo.Question;

public class QuestionController implements Controller{
	
	private QuestionService questionService;

	@Override
	public void autoWried() {
		questionService = AppContainer.questionService;
		
	}

	@Override
	public void getMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		switch( uriProcessor.getRequestUri() ) {
			
			case "/qna/questions/add":
				showWrite(appReq);
				break;
			case "/qna/questions":
				showList(appReq);
				break;
		
		}
		
	}

	@Override
	public void postMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		switch( uriProcessor.getRequestUri() ) {
		
			case "/qna/questions/add":
				doWrite(appReq);
				break;
		}
		
	}


	public void showList(AppRequest appRequest) {
		
		List<Question> questions = questionService.findAll();
		
		appRequest.addAttribute("questions", questions);
		appRequest.render("usr/question/list");
		
	}
	
	
	public void showWrite(AppRequest appRequest) {
		appRequest.render("usr/question/add");
	}
	
	public void doWrite(AppRequest appRequest) {
		
		questionService.save(
				appRequest.getAttribute("title", String.class),
				appRequest.getAttribute("body", String.class)
				);
		
		appRequest.render("redirect:/");
		
	}
	
	

	
}
