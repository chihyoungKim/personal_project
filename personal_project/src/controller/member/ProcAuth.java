package controller.member;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.BoardDao;
import dao.MemberDao;
import domain.Member;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/member/ProcAuth")
public class ProcAuth extends HttpServlet{
	MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String authToken = req.getParameter("authToken");
		String id = req.getParameter("id");
		
		String msg = "";
		Member member = memberService.get(id);
		member.setAuth(BCrypt.checkpw(member.getAuthToken(), authToken) ? "1" : "0");
		memberService.updateAuth(member);
		if(member.getAuth().equals("1")) {
			msg = "이메일 인증 완료";
		}
		else {
			msg = "이메일 인증 실패";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("href", req.getContextPath() + "/common/index");
		req.getRequestDispatcher("/WEB-INF/jsp/common/msg.jsp").forward(req, resp);
	}
	
}
