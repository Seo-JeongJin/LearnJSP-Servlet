package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie1")
public class CookieTest1Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// 유효 시간 지정하지 않았으므로 디폴트 값인 -1로 지정 -> 음수 값이면 브라우저가 종료됨(완전히 다 꺼야함)과 동시에 서버로부터 전송받은 쿠키도 사라짐
		Cookie c1 = new Cookie("id", "guest"); // 쿠키 생성, name=id, value=guest
		c1.setPath("/"); // 경로를 루트로 지정함으로써 현재 웹 앱에 있는 모든 요청에 대하여 클라이언트 쪽의 쿠키가 전송되도록 함
		resp.addCookie(c1); // 쿠키를 클라이언트에 전송
		
		Cookie c2 = new Cookie("code", "0001");
		c2.setMaxAge(60*60*3); // 쿠키의 유효시간 3시간으로 설정
		c2.setPath("/");
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(60*60*24*10);
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.print("쿠키 전송 완료");
		out.close();
	}

}
