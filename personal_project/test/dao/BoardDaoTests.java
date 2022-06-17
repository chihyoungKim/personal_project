package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Board;
import domain.Criteria;
import domain.Package;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDaoTests {
	BoardDao boardDao = BoardDao.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(boardDao);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		assertNotNull(boardDao.list(cri));
		boardDao.list(cri).forEach(log::info);
	}
	
	@Test
	public void testGet() {
		Long bno = 65L;
		log.info(boardDao.get(bno));
	}
	
	@Test
	public void testCount() {
		Criteria cri = new Criteria();
		log.info(boardDao.count(cri));
		cri.setCategory(2);
		log.info(boardDao.count(cri));
		cri.setCategory(3);
		log.info(boardDao.count(cri));
	}
	
	@Test
	public void testRegister() {
		Board board = new Board();
		board.setTitle("title test");
		board.setContent("content test");
		board.setWriter("javaboy");
		
		boardDao.register(board);
		log.info(boardDao.get(board.getBno()));
	}
	
	@Test
	public void testModify() {
		Board board = new Board();
		board.setBno(81L);
		board.setTitle("modify title");
		board.setContent("modify content");
		
		boardDao.modify(board);
		log.info(boardDao.get(board.getBno()));
	}
	
	@Test
	public void testRemove() {
		Long bno = 81L;
		log.info(boardDao.get(bno));
		boardDao.remove(bno);
		log.info(boardDao.get(bno));
		
	}
	
	@Test
	public void testWhenever() {
		boardDao.whenever().forEach(log::info);
	}
	
	@Test
	public void testGetPackInfo() {
		Long bno = 66L;
		log.info(boardDao.getPackInfo(bno));
	}
	
	
	@Test
	public void testSetPackInfo() {
		Package pack = new Package();
		pack.setBno(65L);
		pack.setCity("푸켓");
		pack.setRefund("환불 불가");
		pack.setTime("2박3일");
		pack.setPrice(200000L);
		
		boardDao.setPackInfo(pack);
		log.info(boardDao.getPackInfo(65L));
	}
	
	
}
