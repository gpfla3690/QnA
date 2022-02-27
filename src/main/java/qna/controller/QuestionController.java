package qna.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.util.RequestFactory;

@WebServlet("/question/add")
public class QuestionController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response);
		
		factory.forwardToJsp("usr/question/add");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response);
		
		HttpServletRequest req = factory.getReq();
		
		String title = req.getParameter("title").toString();
		String body = req.getParameter("body").toString();
		
		System.out.println(title);
		System.out.println(body);
		
	}

}
