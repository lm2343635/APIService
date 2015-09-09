package edu.nefu.api.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTestServlet
 */
@WebServlet("/SessionTestServlet")
public class SessionTestServlet extends HttpServlet {
	public static final String FALG="SESSION_FLAG";
	
	private static final long serialVersionUID = 1L;
	private String task;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		task=request.getParameter("task");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		switch (task) {
		case "setValue":
			session.setAttribute(FALG, request.getParameter("value"));
			response.getWriter().print(true);
			break;
		case "getValue":
			String value=(String)session.getAttribute(FALG);
			response.getWriter().print(value);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
