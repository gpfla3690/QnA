package qna.app.util;

public class UriProcessor {
							
	private String uri; 
	
	public UriProcessor(String uri) {
		this.uri = uri;
	}
	
	public String getControllerCode() {
		
		try {
			
			String[] splitedUri = uri.split("/"); 
			
			String controllerCode = splitedUri[1];
			
			switch(controllerCode){
				
				case "question":
					return controllerCode;
				
				default:
					throw new IllegalArgumentException("올바른 요청이 아닙니다.");
			}
		
		}catch(Exception e) {
			throw new IllegalArgumentException("올바른 요청이 아닙니다.");
		}
			
	}
	
	public String getProcessCode() {
		
		try {
			
			String[] splitedUri = uri.split("/");
		
			String processCode = splitedUri[2];
			
			return processCode;
			
		}catch(Exception e) {
			
			throw new IllegalArgumentException("올바른 요청이 아닙니다.");
			
		}
		
	}

}
