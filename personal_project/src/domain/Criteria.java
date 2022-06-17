package domain;
//DTO

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor; nonnull이 아닌 필드를 빼고 생성자만듬

@Data @NoArgsConstructor @AllArgsConstructor
public class Criteria {
	private int pageNum = 1;
	private int amount = 10;
	private int category = 1;
	
	
	public String getParams2() {
		return getParams() + "&pageNum=" + pageNum;
	}
	public String getParams() {
		return "?amount=" + amount + "&category=" + category;
	}
}
