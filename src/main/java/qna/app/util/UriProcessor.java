package qna.app.util;

import lombok.Getter;

@Getter
public class UriProcessor {
							
	private String requestUri; 
	
	private boolean isIndex = false;
	
	private boolean isValid = false;
	
	private String ControllerCode = "";
	
	private int targetIndex = 0;
	
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
				this.isValid = true;
			}catch(Exception e) {
				this.targetIndex = 0;
			}
		} else if(splitUri.length >= 5) {
			
			try {
				this.targetIndex = Integer.parseInt(splitUri[4]);
				this.isValid = true;
			}catch(Exception e) {
				this.targetIndex = 0;
				this.isValid = false;
			}
			
		}
		
		
	}
	
	

}
