package service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domain.Attach;
import domain.Board;
import domain.Criteria;
import domain.Package;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardServiceTests {
	BoardService boardService = BoardServiceImpl.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(boardService);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<Board> list = boardService.list(cri);
		
		list.forEach(log::info);
		
		log.info("--------------------------------");
		cri.setCategory(5);
		list = boardService.list(cri);
		
		list.forEach(log::info);
	}
	
	@Test
	public void testGet() {
		Long bno = 69L;
		log.info(boardService.get(bno));
	}
	
	@Test
	public void testRegister() {
		Board board = new Board();
		board.setContent("test22");
		board.setTitle("test22");
		board.setWriter("javaboy");
		
		boardService.register(board);
		
		log.info(boardService.get(board.getBno()));
	}
	
	@Test
	public void testModify() {
		Board board = new Board();
		board.setContent("test24");
		board.setTitle("test24");
		board.setBno(84L);
		log.info(boardService.get(board.getBno()));
		
		boardService.modify(board);
		
		log.info(boardService.get(board.getBno()));
	}
	
	@Test
	public void testRemove() {
		Long bno = 84L;
		log.info(boardService.get(bno));
		
		boardService.remove(bno);
		
		log.info(boardService.get(bno));
	}
	
	@Test
	public void testCount() {
		Criteria cri = new Criteria();
		log.info(boardService.count(cri));
		cri.setCategory(4);
		log.info(boardService.count(cri));
	}
	
	@Test
	public void testWhenever() {
		boardService.whenever().forEach(log::info);
	}
	
	@Test
	public void testGetPackInfo() {
		Long bno = 69L;
		log.info(boardService.getPackInfo(bno));
	}
	
	
	@Test
	public void testSetPackInfo() {
		Package pack = new Package();
		pack.setBno(69L);
		pack.setCity("푸켓");
		pack.setRefund("환불 불가");
		pack.setTime("2박3일");
		pack.setPrice(200000L);
		
		boardService.setPackInfo(pack);
		log.info(boardService.getPackInfo(69L));
	}
	
	
}
