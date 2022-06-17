package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Package {
	private Long pno;
	private Long bno;
	private String city;
	private String time;
	private String refund;
	private Long price;

}
