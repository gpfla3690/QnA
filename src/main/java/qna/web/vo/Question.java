package qna.web.vo;

import java.time.LocalDateTime;

public class Question {
	
	private int id;
	
	private String title;
	private String body;
	
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	public Question(String title, String body) {
		
		this.title = title;
		this.body = body;
		
		regDate = LocalDateTime.now();
		updateDate = LocalDateTime.now();
		
	}

}
