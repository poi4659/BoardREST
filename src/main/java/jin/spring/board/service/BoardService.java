package jin.spring.board.service;

import java.util.List;

import jin.spring.board.dto.BoardDTO;

public interface BoardService {
// 	게시글 등록
//	BoardDTO는 데이터 전달용 객체
	public void boardInsert(BoardDTO boardDTO) throws Exception;
	
//	게시글 목록 조회
	public List<BoardDTO> boardList() throws Exception;

//	게시글 상세 조회
	public BoardDTO boardSelect(int bdNum) throws Exception;

}
