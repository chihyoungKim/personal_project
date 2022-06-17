package domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Board {
	private Long bno;
	private String title;
	private String content;
	private int hitcount;
	private String regDate;
	private String writer;
	
	private int category;
	
	private List<Attach> attachs = new ArrayList<>();
	
	//등록
	public Board(String title, String content, String writer, int category) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.category = category;
	}

	//수정
	public Board(Long bno, String title, String content, int category) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.category = category;
	}
	
	//조회
	public Board(Long bno, String title, String content, int hitcount, String regDate, String writer, int category) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.hitcount = hitcount;
		this.regDate = regDate;
		this.writer = writer;
		this.category = category;
	}
	
}
