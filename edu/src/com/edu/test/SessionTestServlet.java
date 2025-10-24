package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String param = req.getParameter("p");
		String msg = null;
		HttpSession session = null;
		
		// getSession(); -> 기존 세션 객체가 있는지 없는지를 기준으로 있으면 기존 객체를 반환하고 없다면 true는 새로운 객체 생성, false는 null 반환
		// -> default 값이 getSession(true); 임
		
		if (param.equals("create")) {
			session = req.getSession();
			if (session.isNew()) { // 세션 객체가 새로 생성되어 반환된 세션 객체인지, 기존의 세션 객체가 반환된 것인지 확인
				msg = "새로운 세션 객체가 생성됨";
			} else {
				msg = "기존의 세션 객체가 리턴됨";
			}
		} else if (param.equals("delete")) {
			session = req.getSession(false); // 기존의 세션 객체를 찾아서 반환, 만약 브라우저가 보낸 요청에 유효한 세션 ID가 없다면 새로운 세션을 만들지 않고 null 을 반환
			if (session != null) {
				session.invalidate();
				msg = "세션 객체 삭제 작업 완료";
			} else {
				msg = "삭제할 세션 존재하지 않음";
			}
		} else if (param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "메세지입니다."); // msg 라는 이름의 "메세지입니다." 라는 String 객체를 등록
			msg = "세션 객체에 데이터 등록 완료";
		} else if (param.equals("get")) {
			session = req.getSession(false);
			if (session != null) {
				String str = (String) session.getAttribute("msg"); // 세션에 msg 이름으로 등록된 데이터를 추출하여 String 타입으로 타입 변경
				msg = str;
			} else {
				msg = "데이터를 추출할 세션 객체 존재하지 않음";
			}
		} else if (param.equals("remove")) {
			session = req.getSession(false);
			if (session != null) {
				session.removeAttribute("msg"); // msg 라고 등록된 객체 삭제
				msg = "세션 객체의 데이터 삭제 완료";
			} else {
				msg = "데이터를 삭제할 세션 객체 존재하지 않음";
			}
		} else if (param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "새로운 메세지입니다.");
			msg = "세션 객체에 데이터 등록 완료";
		}
		out.print("처리 결과 : " + msg);
		out.close();
	}

}
