package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Member;
import service.MemberService;
import service.MemberServiceImpl;


@WebServlet("/member/findMember")
public class FindMember extends HttpServlet{
	MemberService memberService = MemberServiceImpl.getInstance();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		resp.setContentType("text/plain; charset=utf-8");
		if(id != null) {
			resp.getWriter().print(memberService.get(id) != null ? "1" : "");
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		System.out.println(name);
		System.out.println(email);
		resp.setContentType("text/plain; charset=utf-8");
		
		if(name != null) {
			if(email != null) {
				Member member = memberService.findBy(email);
				resp.getWriter().print(member.getName().equals(name) ? "" : "1");
			}
		}
		else if(email != null) {
			resp.getWriter().print(memberService.findBy(email) != null ? "1" : "");
		}
	}

}
