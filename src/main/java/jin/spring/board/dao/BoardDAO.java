package jin.spring.board.dao;

import jin.spring.board.dto.BoardDTO;

public interface BoardDAO {
// 	게시글 등록
//	BoardDTO는 데이터 전달용 객체
	public void insert(BoardDTO boardDTO) throws Exception;
}
