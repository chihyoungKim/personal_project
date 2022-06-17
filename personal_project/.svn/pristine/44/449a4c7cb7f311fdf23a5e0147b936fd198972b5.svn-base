package controller.board;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Board;
import domain.Criteria;
import domain.Member;
import service.BoardService;
import service.BoardServiceImpl;
import utils.Const;

@WebServlet("/board/modify")
public class Modify extends HttpServlet{
	private BoardService boardService = BoardServiceImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.parseLong(req.getParameter("bno"));
		Member member = (Member)(req.getSession().getAttribute("member"));
		if(member == null || !member.getId().equals(boardService.get(bno).getWriter())) {
			resp.sendRedirect(req.getContextPath() + "/board/list");
		}
		else {
			req.setAttribute("board", boardService.get(bno));
			req.getRequestDispatcher(Const.board("modify")).forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Long bno = Long.parseLong(req.getParameter("bno"));
		int category = Integer.parseInt(req.getParameter("category"));
		
		Criteria criteria = new Criteria();
		if(req.getParameter("pageNum") != null) {
			criteria.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		if(req.getParameter("amount") != null) {
			criteria.setAmount(Integer.parseInt(req.getParameter("amount")));
		}
		if(req.getParameter("category") != null) {
			criteria.setCategory(Integer.parseInt(req.getParameter("category")));
		}

		Board board = new Board(bno, title, content, category);
		
		boardService.modify(board);
		
		resp.sendRedirect(req.getContextPath() + "/board/list?" + criteria.getParams2());
		
	}
	
}
