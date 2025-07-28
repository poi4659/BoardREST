package jin.spring.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import jin.spring.board.dto.BoardDTO;
import jin.spring.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private static Logger logger = LoggerFactory.getLogger(BoardController.class); 

//	스프링이 인터페이스 구현체를 찾아서 주입함 
	private final BoardService boardService;

//	게시글 등록 페이지
	@GetMapping("/BoardInsert")
	public String insert() {
//		게시글 등록 페이지로 이동
		return "./board/board_insert";
	}

//	게시글 등록
	@PostMapping("/BoardInsert")
//	사용자가 폼 전송->POST 요청->DTO에 자동 바인딩 
	public String insert(BoardDTO boardDTO) throws Exception{
		logger.info("게시글 등록");

//		서비스 호출
		boardService.boardInsert(boardDTO);
		
//		게시글 등록 후 게시글 등록 페이지로 리다이렉트
		return "redirect:/BoardInsert";
	}

}
