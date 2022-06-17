package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Reply;
import lombok.extern.log4j.Log4j;
@Log4j
public class ReplyDaoTests {
	ReplyDao replyDao = ReplyDao.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(replyDao);
	}
	
	@Test
	public void testList() {
		Long bno = 17L;
		
		replyDao.list(bno).forEach(log::info);
	}
	
	@Test
	public void testRegister() {
		Reply reply = new Reply();
		reply.setBno(15L);
		reply.setContent("content");
		reply.setWriter("test");
		
		replyDao.register(reply);
		
		replyDao.list(15L).forEach(log::info);
	}
	
	@Test
	public void testGet() {
		Long rno = 101L;
		
		log.info(replyDao.get(rno));
		
	}
	
	@Test
	public void testModify() {
		Reply reply = new Reply();
		reply.setBno(101L);
		reply.setContent("modify content");
		
		log.info(replyDao.get(101L));
	}
	
	@Test
	public void testRemove() {
		Long rno = 101L;
		
		replyDao.remove(rno);
		
		log.info(replyDao.get(rno));
	}
	
	
}
