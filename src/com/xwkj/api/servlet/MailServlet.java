package com.xwkj.api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xwkj.common.util.MailService;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().print("Mail Service");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String to=request.getParameter("to");
		String from=request.getParameter("from");
		String smtpServer=request.getParameter("smtpServer");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		MailService service=new MailService();
		service.setTo(to);
		service.setFrom(from);
		service.setSmtpServer(smtpServer);
		service.setUsername(username);
		service.setPassword(password);
		service.setSubject(subject);
		service.setContent(content);
		if(service.send())
			response.getWriter().print(true);
		else
			response.getWriter().print(false);
	}

}
