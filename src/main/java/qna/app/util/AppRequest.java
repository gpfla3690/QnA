package qna.app.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;

@Data
public class AppRequest {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	public String getReqUri() {
		return this.req.getRequestURI();
	}
	
	public String getMethod() {
		return this.req.getMethod();
	}
	
	
	
	public AppRequest(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		this.req = req;
		this.resp = resp;
		
	}
	
	public void forwardToJsp(String path) {
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/" + path + ".jsp");
				
		try {
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void redirectToJsp(String path) {
		
		try {
			resp.sendRedirect(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
