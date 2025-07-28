package jin.spring.board.service;

import jin.spring.board.dto.BoardDTO;

public interface BoardService {
// 	게시글 등록
//	BoardDTO는 데이터 전달용 객체
	public void boardInsert(BoardDTO boardDTO) throws Exception;
}
