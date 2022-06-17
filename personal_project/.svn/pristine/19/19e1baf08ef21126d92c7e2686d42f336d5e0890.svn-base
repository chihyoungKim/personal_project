package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttachDao;
import domain.Board;
import domain.Criteria;
import domain.Package;
import service.BoardService;
import service.BoardServiceImpl;
import utils.Const;

@WebServlet("/board/get")
public class Get extends HttpServlet{
	BoardService boardService = BoardServiceImpl.getInstance();
	AttachDao attachDao = AttachDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.parseLong(req.getParameter("bno"));
		
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
		
		Board board = boardService.get(bno);
		board.setAttachs(attachDao.list(bno));
		Package pack = boardService.getPackInfo(bno);
		req.setAttribute("pack", pack);
		req.setAttribute("board", board);
		req.setAttribute("cri", criteria);
		req.getRequestDispatcher(Const.board("get")).forward(req, resp);
		
	}
}
