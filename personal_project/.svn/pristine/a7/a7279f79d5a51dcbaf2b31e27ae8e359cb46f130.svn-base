package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;
import service.MemberServiceImpl;
import utils.Const;
import utils.Util;

@WebServlet("/member/join")
public class Join extends HttpServlet{
	MemberService memberService = MemberServiceImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(Const.member("join")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = Util.getParam(req, Member.class);
		System.out.println(req.getParameter("id"));
		System.out.println(member);
		memberService.register(member);
		
		
		resp.sendRedirect(req.getContextPath() + "/common/index");
		
	}
	
}
