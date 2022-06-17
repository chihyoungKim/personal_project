package service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Reply;
import lombok.extern.log4j.Log4j;

@Log4j
public class ReplyServiceTests {
	ReplyService replyService = ReplyServiceImpl.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(replyService);
	}
	
	@Test
	public void testList() {
		Long bno = 17L;
		
		replyService.list(bno).forEach(log::info);
	}
	
	@Test
	public void testRegister() {
		Reply reply = new Reply();
		reply.setBno(15L);
		reply.setContent("content");
		reply.setWriter("test");
		
		replyService.register(reply);
		
		replyService.list(15L).forEach(log::info);
	}
	
	@Test
	public void testGet() {
		Long rno = 102L;
		
		log.info(replyService.get(rno));
		
	}
	
	@Test
	public void testModify() {
		Reply reply = new Reply();
		reply.setBno(102L);
		reply.setContent("modify content");
		
		log.info(replyService.get(102L));
	}
	
	@Test
	public void testRemove() {
		Long rno = 102L;
		
		replyService.remove(rno);
		
		log.info(replyService.get(rno));
	}
}
