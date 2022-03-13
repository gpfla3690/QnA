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
		
		String requestUri = uriProcessor.getRequestUri();
		int targetIndex = uriProcessor.getTargetIndex();
		
		switch( uriProcessor.getActionCode() ) {
		
			case "detail":
				requestUri = "/qna/questions/detail";
				break;
			case "delete":
				requestUri = "/qna/questions/delete";
				break;
			case "modify":
				requestUri = "/qna/questions/modify";
				break;
		}
		
		
		switch( requestUri ) {
			
			case "/qna/questions/add":
				showWrite(appReq);
				break;
			case "/qna/questions":
				showList(appReq);
				break;
			case "/qna/questions/modify":
				showModify(appReq, targetIndex);
				break;
		}
		
	}

	@Override
	public void postMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		String requestUri = uriProcessor.getRequestUri();
		
		switch( uriProcessor.getActionCode() ) {
		
			case "detail":
				requestUri = "/qna/questions/detail";
				break;
			case "modify":
				requestUri = "/qna/questions/modify";
				break;
	}
	
				
		
		switch( requestUri ) {
		
			case "/qna/questions/add":
				doWrite(appReq);
				break;
			case "/qna/questons/modify":
				doModify(appReq);
				break;
		}
		
	}
	
	
	public void showModify(AppRequest appRequest, int targetIndex) {
		
		try {
		
		Question findQuestion = questionService.findById(targetIndex);
		appRequest.addAttribute("question", findQuestion);
		appRequest.render("usr/question/modify");
		
		} catch(Exception e) {
			appRequest.alertRedirect("/qna/questions", e.getMessage());
		}
	}
	
	public void doModify(AppRequest appRequest) {
		
		// 바꾼 데이터
		int id = Integer.parseInt(appRequest.getAttribute("id", String.class))
		String title = appRequest.getAttribute("title", String.class);
		String body = appRequest.getAttribute("body", String.class);
				
		try {
		
		Question findQuestion = questionService.findById(id);
		
		findQuestion.setTitle(title);
		findQuestion.setBody(body);
		
		questionService.modify(findQuestion);
		
		appRequest.alertRedirect("/qna/questions/" + id, "성공적으로 수정 되었습니다.");
		} catch(Exception e) {
			appRequest.alertRedirect("/qna/questions", e.getMessage());
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
