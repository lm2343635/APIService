package com.xwkj.api.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xwkj.api.service.WechaterManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/WechaterServlet")
public class WechaterServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4060998895478970097L;
	private static final String API_KEY="MIBxtjgyfkHTZLOwEFUbdh6";
	private String task;
	private WechaterManager wechaterManager;

	public WechaterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		task=request.getParameter("task");
		String key=request.getParameter("key");
		if(!key.equals(API_KEY)) {
			response.getWriter().println("API Key is wrong!");
			return;
		}
		WebApplicationContext context= WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		wechaterManager=(WechaterManager)context.getBean("wechaterManager");
		switch (task) {
		case "randomGet":
			randomGet(request, response);
			break;
		case "addByOfficialAccount":
			addByOfficialAccount(request, response);
			break;
		default:
			break;
		}
	}

	private void addByOfficialAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String appid=request.getParameter("appid");
		String appsecret=request.getParameter("appsecret");
		int added=wechaterManager.addByOfficialAccount(appid, appsecret);
		JSONObject result=new JSONObject();
		result.put("added", added);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(result.toString());
	}

	private void randomGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int limit=Integer.parseInt(request.getParameter("limit"));
		JSONArray wechaters=JSONArray.fromObject(wechaterManager.random(limit));
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(wechaters.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
