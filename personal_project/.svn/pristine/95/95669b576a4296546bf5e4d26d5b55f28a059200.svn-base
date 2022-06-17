package service;

import dao.BoardDao;
import dao.MemberDao;
import dao.ReplyDao;
import domain.Member;

public class MemberServiceImpl implements MemberService{
	
	private static final MemberService memberService = new MemberServiceImpl();
	
	private MemberServiceImpl() {}
	
	public static MemberService getInstance() {
		return memberService;
	}
	
	private MemberDao memberDao = MemberDao.getInstance();
	private BoardDao boardDao = BoardDao.getInstance();
	private ReplyDao replyDao = ReplyDao.getInstance();
	
	@Override
	public Member login(Member member) {
		return memberDao.login(member.getId(), member.getPw());
	}
	
	@Override
	public void register(Member member) {
		memberDao.register(member);
	}

	@Override
	public void remove(String id) {
		replyDao.modifyNullByWriter(id);
		boardDao.modifyNullByWriter(id);
		memberDao.remove(id);
	}
	
	public Member get(String id) {
		return memberDao.get(id);
	}
	
	public Member findBy(String email) {
		return memberDao.findBy(email);
	}

	@Override
	public void modify(Member member) {
		memberDao.modify(member);
	}

	@Override
	public void updateAuth(Member member) {
		memberDao.updateAuth(member);
	}

	@Override
	public void updateAuthToken(Member member) {
		memberDao.updateAuthToken(member);
	}
	
	
	
}
