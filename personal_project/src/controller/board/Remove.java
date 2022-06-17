package controller.board;

import java.io.IOException;

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

@WebServlet("/board/remove")
public class Remove extends HttpServlet{
	
	private BoardService boardService = BoardServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Criteria cri = new Criteria();
		if(req.getParameter("pageNum") != null) {
			cri.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
		}
		if(req.getParameter("amount") != null) {
			cri.setAmount(Integer.parseInt(req.getParameter("amount")));
		}
		if(req.getParameter("category") != null) {
			cri.setCategory(Integer.parseInt(req.getParameter("category")));
		}
		req.setAttribute("cri", cri);
		
		boardService.remove(Long.parseLong(req.getParameter("bno")));
		
		resp.sendRedirect(req.getContextPath() + "/board/list" + cri.getParams2());
		
	}
	
}
