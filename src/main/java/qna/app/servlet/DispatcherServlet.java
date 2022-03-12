package qna.app.servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.app.components.Controller;
import qna.app.container.AppContainer;
import qna.app.handler.ExceptionHandler;
import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;

@WebServlet("/qna/*")
public class DispatcherServlet extends HttpServlet {
	
	private ExceptionHandler exceptionHandler = new ExceptionHandler();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppRequest appRequest = new AppRequest(request, response);
		
		UriProcessor uriProcessor = new UriProcessor(appRequest.getReqUri());
		
		if( uriProcessor.isIndex() ) {
			appRequest.forwardToJsp("index");
		}
		
		if( !uriProcessor.isValid() || uriProcessor.getControllerCode().equals("")) {
			exceptionHandler.handlerRepuest(appRequest);
		}
		
		Controller findController = findController(uriProcessor.getControllerCode());
		
		switch(appRequest.getMethod()) {
		
		case "GET":
			findController.getMapping(appRequest, uriProcessor);
			break;
		case "POST":
			findController.postMapping(appRequest, uriProcessor);
			break;
		
		}
		
		
	}
	
	private Controller findController(String controllerCode) {
		
		switch( controllerCode ) {
		
			case "question":
				return AppContainer.questionController;
			default:
				return null;
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
