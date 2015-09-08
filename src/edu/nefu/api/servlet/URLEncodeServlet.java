package edu.nefu.api.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLEncodeServlet
 */
@WebServlet("/URLEncodeServlet")
public class URLEncodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String task;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URLEncodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		task=request.getParameter("task");
		String enc=request.getParameter("enc");
		request.setCharacterEncoding(enc);
		response.setCharacterEncoding(enc);
		switch (task) {
		case "encode":
			String url=request.getParameter("url");
			String encode=URLEncoder.encode(url, enc);
			response.getWriter().print(encode);
			break;
		case "decode":
			
			break;
		default:
			break;
		}
	}

}
