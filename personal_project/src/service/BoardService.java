package service;

import java.util.List;

import domain.Board;
import domain.Criteria;
import domain.Package;


public interface BoardService {
	
		// 글전체 목록
		public List<Board> list(Criteria cri);
		
		// 글 상세
		public Board get(Long bno);
		
		// 글 작성
		public void register(Board board);
		
		// 글 수정
		public void modify(Board board);
		
		// 글 삭제
		public void remove(Long bno);
		
		// 글 개수
		public int count(Criteria cri);
		
		// 지금바로여행가능지역 홍보
		public List<Board> whenever();
		
		// 패키지 세부정보
		public Package getPackInfo(Long bno);
		public void setPackInfo(Package pack);
		
}
