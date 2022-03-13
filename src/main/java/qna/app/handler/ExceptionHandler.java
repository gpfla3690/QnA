package qna.app.handler;

import qna.app.util.AppRequest;

public class ExceptionHandler implements Handler{

	@Override
	public void handlerRepuest(AppRequest appRequest) {
		appRequest.render("error/error");
		
	}

}
