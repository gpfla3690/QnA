package qna.web.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
