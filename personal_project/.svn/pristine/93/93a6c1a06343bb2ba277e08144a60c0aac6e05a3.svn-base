package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Member;
import lombok.extern.log4j.Log4j;
@Log4j
public class MemberDaoTests {
	MemberDao memberDao = MemberDao.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(memberDao);
	}
	
	@Test
	public void testLogin() {
		String id = "javaboy";
		String pw = "1234";
		
		log.info(memberDao.login(id, pw));
	}
	
	@Test
	public void testRegister() {
		String id = "javaboy";
		String pw = "1234";
		
		Member member = memberDao.login(id, pw);
		
		member.setId("javaboy3");
		
		
		memberDao.register(member);
		
		log.info(memberDao.login("javaboy3", pw));
	}
	
	@Test
	public void testRemove() {
		String id = "javaboy3";
		
		memberDao.remove(id);
		
		log.info(memberDao.login(id, "1234"));
	}
	
	@Test
	public void testGet() {
		String id = "javaboy";
		
		log.info(memberDao.get(id));
	}
	
	@Test
	public void testFindBy() {
		String email = "hyeong901@naver.com";
		
		log.info(memberDao.findBy(email));
	}
	
	@Test
	public void testModify() {
		Member member = memberDao.get("test");
		log.info(member);
		member.setName("테스트맨23");
		
		log.info(member);
		
		memberDao.modify(member);
		
		member = memberDao.get("test");
		log.info(member);
		
	}
	
	@Test
	public void testUpdateAuth() {
		Member member = memberDao.get("test");
		
		log.info(member.getAuth());
		
		member.setAuth("1");
		memberDao.updateAuth(member);
		
		member = memberDao.get("test");
		log.info(member.getAuth());
	}
	
	@Test
	public void testUpdateAuthToken() {
		Member member = memberDao.get("test");
		
		log.info(member.getAuthToken());
		
		member.setAuthToken("dfqv231");
		memberDao.updateAuthToken(member);
		
		member = memberDao.get("test");
		log.info(member.getAuthToken());
	}
	
}
