package jin.spring.board.dao;

import java.util.List;

import jin.spring.board.dto.BoardDTO;

public interface BoardDAO {
// 	게시글 등록
//	BoardDTO는 데이터 전달용 객체
	public void insert(BoardDTO boardDTO) throws Exception;

//	게시글 목록 조회
	public List<BoardDTO> list() throws Exception;
	
//	게시글 상세 조회
	public BoardDTO select(int bdNum) throws Exception;

}
