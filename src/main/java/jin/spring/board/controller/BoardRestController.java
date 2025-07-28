package jin.spring.board.controller;


import java.util.Collections;
import java.util.Map;

import org.apache.catalina.loader.ResourceEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jin.spring.board.dto.BoardDTO;
import jin.spring.board.service.BoardService;
import lombok.RequiredArgsConstructor;

// JSON 형식의 데이터 응답을 하는 컨트롤러
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")  // 공통 prefix로 API 명확하게
public class BoardRestController {
	private static Logger logger = LoggerFactory.getLogger(BoardRestController.class); 

//	스프링이 인터페이스 구현체를 찾아서 주입함 
	private final BoardService boardService;

//	게시글 등록
//	produces: 서버가 보내는 응답의 Content-Type 헤더를 지정
//	 application/json; charset=UTF-8로 한글을 포함한 JSON 응답임을 알려줌
	@PostMapping(value = "/BoardInsert", produces = "application/json; charset=UTF-8")
//	@RequestBody BoardDTO boardDTO: JSON 형태로 받은 데이터를 BoardDTO 객체에 자동 매핑
//	-> Jackson 라이브러리 필요
//	Map<String, String> 타입을 반환
	public Map<String, String> insert(@RequestBody BoardDTO boardDTO) throws Exception {
		logger.info("게시글 등록");
		
//		Service 계층으로 DTO를 넘겨서 DB에 저장하도록 처리
		boardService.boardInsert(boardDTO);
		
//		스프링이 이 Map을 JSON으로 변환하여 클라이언트에 보냄
		return Collections.singletonMap("message", "게시글 등록 성공");
	}
	
}
