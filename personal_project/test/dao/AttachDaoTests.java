package dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import domain.Attach;
import lombok.extern.log4j.Log4j;

@Log4j
public class AttachDaoTests {
	
	AttachDao attachDao = AttachDao.getInstance();
	
	@Test
	public void testExists() {
		assertNotNull(attachDao);
		log.info(attachDao);
	}
	
	@Test
	public void testList() {
		List<Attach> list = attachDao.list(28L);
		List<Attach> list2 = attachDao.list(29L);
		System.out.println(list);
		System.out.println(list2);
		log.info(list);
		log.info(list2);
	}
	
	@Test
	public void testInsert() {
		Attach attach = new Attach();
		attach.setBno(28L);
		attach.setUuid("test1");
		attach.setOrigin("test1");
		attachDao.insert(attach);
		log.warn(attachDao.list(28L));
	}
	
	@Test
	public void testRemove() {
		Long bno = 28L;
		attachDao.remove(bno);
		System.out.println(attachDao.list(28L));
		log.info(attachDao.list(28L));
	}
	
}
