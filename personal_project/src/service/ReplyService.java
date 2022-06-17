package service;

import java.util.List;

import domain.Reply;

public interface ReplyService {
		// 댓글 목록
		public List<Reply> list(Long bno);
		
		// 댓글 상세
		public Reply get(Long rno);
		
		// 댓글 작성
		public void register(Reply reply);
		
		// 댓글 수정(글 내용 수정, 시간을 현재시간으로)
		public void modify(Reply reply);
		
		// 댓글 삭제
		public void remove(Long rno);
}
