package service;

import domain.Member;

public interface MemberService {
	//로그인
	Member login(Member member);
	
	//회원가입
	void register(Member memberVO);

	//탈퇴
	void remove(String id);
	
	Member get(String id);
	
	Member findBy(String email);

	void modify(Member member);

	void updateAuth(Member member);

	void updateAuthToken(Member member);
	
}
