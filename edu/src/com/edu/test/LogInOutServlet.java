package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {
	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if (id.isEmpty() || pwd.isEmpty()) { // 두 조건 중 하나라도 참이면 결과가 참
			out.print("ID 또는 비밀번호를 입력해주세요.");
			return; // 종료
		}
		HttpSession session = req.getSession();
		if (session.isNew() || session.getAttribute("id") == null) { // isNew() 는 기존에 사용하던 세션 객체가 반환되면 false, 새로운 객체를 생성하여 반환하면 true -> true를 반환했다면 기존에 세션 객체가 없었다는 것이니 로그인 상태가 아니라는 것
			session.setAttribute("id", id);
			out.print("로그인을 완료하였습니다.");
		} else {
			out.print("현재 로그인 상태입니다.");
		}
	}
	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃 작업 완료하였습니다.");
		} else {
			out.print("현재 로그인 상태가 아닙니다.");
		}
		out.close();
	}
}
