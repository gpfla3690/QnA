package qna.app.util;

import lombok.Getter;

@Getter
public class UriProcessor {
							
	private String requestUri; 
	
	private boolean isIndex = false;
	
	private boolean isValid = false;
	
	private String ControllerCode = "";
	
	private String actionCode = "";
	
	private int targetIndex = 0;
	
	
	public void printCurrentStatus() {
		System.out.println("================");
		System.out.println("requestUri :" + requestUri);
		System.out.println("isIndex :" + isIndex);
		System.out.println("isValid :" + isValid);
		System.out.println("ControllerCode :" + ControllerCode);
		System.out.println("targetIndex :" + targetIndex);
		System.out.println("=================");
		
	}
	
	
	public UriProcessor(String requestUri) {
		
		this.requestUri = requestUri;
		
		if( requestUri.equals("/qna/") || requestUri.equals("/qna") ) {
			this.isIndex = true;
			this.isValid = true;
		}
		
		String[] splitUri = requestUri.split("/");
		
		if( splitUri.length >= 3 ) {
			
			switch(splitUri[2]) {
				case "questions":
				case "question":
					this.ControllerCode = "question";
					this.isValid = true;
					break;
				case "answers":
				case "answer":
					this.ControllerCode = "answers";
					this.isValid = true;
					break;
				default:
					this.ControllerCode = "";
					break;
			}
			
		}
		
		if( splitUri.length == 4 ) {
			
			try {
				this.targetIndex = Integer.parseInt(splitUri[3]);
				this.actionCode = "detail";
				this.isValid = true;
			}catch(Exception e) {
				this.actionCode = splitUri[3];
				this.targetIndex = 0;
			}
		} else if(splitUri.length >= 5) {
			
			try {
				this.targetIndex = Integer.parseInt(splitUri[4]);
				this.actionCode = splitUri[3];
				this.isValid = true;
			}catch(Exception e) {
				this.targetIndex = 0;
				this.actionCode = splitUri[3];
				this.isValid = false;
			}
			
		}
		
		
	}
	
	

}
