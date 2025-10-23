package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet{
//	ServletContext sc;
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		sc = config.getServletContext();
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		ServletContext sc = this.getServletContext(); // 현재 서블릿이 속한 웹 애플리케이션의 ServletContext 주솟값을 추출
		String location = sc.getInitParameter("contextConfig"); // web.xml 에서 <context-param> 을 찾아 contextConfig란 이름을 가지고 있는 <param-name>의 <param-value> 값을 반환
		out.print("location : " + location);
//		out.print("Context : " + sc);
		out.close();
	}
}
