package com.petshop.servlets.shared.feedback;

import java.io.IOException;

import com.petshop.hibernate.daos.FeedBackDAO;
import com.petshop.hibernate.entities.FeedBack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/danh-gia")
public class CreateFeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FeedBackDAO feedBackDAO;

  public CreateFeedBackServlet() {
  	super();
  	this.feedBackDAO = new FeedBackDAO();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/templates/shared/about.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String content = request.getParameter("content");
		
		FeedBack feedBack = new FeedBack();
		feedBack.setFullName(fullName);
		feedBack.setEmail(email);
		feedBack.setPhoneNumber(phoneNumber);
		feedBack.setAddress(address);
		feedBack.setContent(content);
		
		this.feedBackDAO.createFeedBack(feedBack);
		
		request.setAttribute("success_messages", new String[] { "Cảm ơn bạn đã đánh giá" });
		request.getRequestDispatcher("/WEB-INF/templates/shared/about.jsp").forward(request, response);
	}
}
