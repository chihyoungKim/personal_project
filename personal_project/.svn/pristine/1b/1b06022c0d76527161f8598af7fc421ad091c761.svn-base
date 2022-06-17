package controller.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;
import service.MemberServiceImpl;
import utils.Util;

@WebServlet("/member/secession")
public class Secession extends HttpServlet{
	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Member member = Util.getParam(req, Member.class);
		
		memberService.remove(member.getId());
		resp.sendRedirect("logout");
	}
	
}
