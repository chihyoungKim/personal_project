package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttachDao;
import dao.BoardDao;
import domain.Attach;
import domain.Board;
import service.BoardService;
import service.BoardServiceImpl;
import utils.Const;

@WebServlet("/common/index")
public class Index extends HttpServlet{

	BoardService boardService = BoardServiceImpl.getInstance();
	AttachDao attachDao = AttachDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 카테고리5 게시글 중 조회수 제일 높은거 4개 메인화면에 보여주고싶다
		// boardDao에 메서드 whenever()로 조회수 제일 높은 4개의 게시글을 list형태로 반환
		// 이미지도 띄워야하니 attachs 붙여야한다.
		
		List<Board> list = boardService.whenever();
		
		req.setAttribute("boards", list);
		
		Board board = boardService.get(6L);
		board.setAttachs(attachDao.list(6L));
		req.setAttribute("singapore", board);
		board = boardService.get(7L);
		board.setAttachs(attachDao.list(7L));
		req.setAttribute("phuket", board);
		board = boardService.get(8L);
		board.setAttachs(attachDao.list(8L));
		req.setAttribute("bangkok", board);
		
		req.getRequestDispatcher(Const.common("index")).forward(req, resp);
	}
	
}
