package controller.reply;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import domain.Reply;
import service.ReplyService;
import service.ReplyServiceImpl;

@WebServlet("/reply")
public class ReplyController extends HttpServlet{
	
	private ReplyService replyService = ReplyServiceImpl.getInstance();
	private Gson gson = new Gson();
	
	//댓글 단일조회
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rno = Long.parseLong(req.getParameter("rno"));
		Reply reply = replyService.get(rno);
		
		
		resp.setContentType("application/json; charset=utf-8");
		resp.getWriter().print(gson.toJson(reply));
	}
	//댓글 전체조회
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String content = req.getParameter("content");
//		Long bno = Long.parseLong(req.getParameter("bno"));
//		String writer = req.getParameter("writer");
//		
//		Reply reply = new Reply(null, content, null, bno, writer);
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		System.out.println(reply);
		replyService.register(reply);
		
		resp.setContentType("text/plain; charset=utf-8");
		
	}
	//댓글 수정
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		
		replyService.modify(reply);
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter().print("두풋");
	}
	//댓글 삭제
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reply reply = gson.fromJson(req.getReader().readLine(), Reply.class);
		replyService.remove(reply.getRno());
		
		resp.setContentType("text/plain; charset=utf-8");
		resp.getWriter().print("두딜리트");
		
	}
}
