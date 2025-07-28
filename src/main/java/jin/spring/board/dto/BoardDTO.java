package jin.spring.board.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {	
	private int bdNum;
	private String bdTitle;
	private String bdContent;
	private String bdWriter;
	private Date bdRegdate;
}
