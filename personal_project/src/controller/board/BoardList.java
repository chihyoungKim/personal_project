package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Criteria;
import domain.PageDto;
import service.BoardService;
import service.BoardServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import utils.Const;

@WebServlet("/board/list")
public class BoardList extends HttpServlet{
	
	BoardService boardService = BoardServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		req.setAttribute("boards", boardService.list(criteria));
		req.setAttribute("page", new PageDto(boardService.count(criteria), criteria));
		
		if(criteria.getCategory() < 3) {
			req.getRequestDispatcher(Const.board("list")).forward(req, resp);
		}
		else {
			
			req.getRequestDispatcher(Const.board("gallery")).forward(req, resp);
		}
		
	}
}
