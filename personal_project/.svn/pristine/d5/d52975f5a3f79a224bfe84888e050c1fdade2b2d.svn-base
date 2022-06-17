package service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.Member;
import lombok.extern.log4j.Log4j;

@Log4j
public class MemberServiceTests {
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Test
	public void testExist() {
		assertNotNull(memberService);
	}
	
	@Test
	public void testLogin() {
		Member member = new Member();
		member.setId("javaboy");
		member.setPw("1234");
		
		log.info(memberService.login(member));
	}
	
	
	@Test
	public void testRegister() {
		Member member = new Member();
		member.setId("javaboy22");
		member.setPw("1234");
		
		memberService.register(member);
		
		log.info(memberService.login(member));
	}
	
	@Test
	public void testGet() {
		String id = "javaboy22";
		
		log.info(memberService.get(id));
	}

	@Test
	public void testRemove() {
		String id = "javaboy22";
		log.info(memberService.get(id));
		
		memberService.remove(id);
		
		log.info(memberService.get(id));
	}
	
	
	@Test
	public void testFindBy() {
		String email = "hyeong901@naver.com";
		
		log.info(memberService.findBy(email));
	}
	
	@Test
	public void testModify() {
		Member member = memberService.get("test");
		log.info(member);
		member.setName("테스트맨24");
		
		log.info(member);
		
		memberService.modify(member);
		
		member = memberService.get("test");
		log.info(member);
		
	}
	
	@Test
	public void testUpdateAuth() {
		Member member = memberService.get("test");
		
		log.info(member.getAuth());
		
		member.setAuth("0");
		memberService.updateAuth(member);
		
		member = memberService.get("test");
		log.info(member.getAuth());
	}
	
	@Test
	public void testUpdateAuthToken() {
		Member member = memberService.get("test");
		
		log.info(member.getAuthToken());
		
		member.setAuthToken("dfqv2312222");
		memberService.updateAuthToken(member);
		
		member = memberService.get("test");
		log.info(member.getAuthToken());
	}
	
}
