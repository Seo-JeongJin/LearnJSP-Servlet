package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie2")
public class CookieTest2Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie[] list = req.getCookies(); // 현재 서버에서 클라이언트에 전송된 쿠키를 모두 읽어 들여 Cookie 타입의 list 배열로 받음
		for (int i=0; list!=null && i<list.length; i++) {
			out.println(list[i].getName()+":"+list[i].getValue()+"<br>"); // 쿠키의 이름과 값 출력
		}
		out.close();
	}
}
