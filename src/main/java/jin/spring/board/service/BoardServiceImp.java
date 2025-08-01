package jin.spring.board.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import jin.spring.board.dao.BoardDAO;
import jin.spring.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;

//이 클래스가 서비스 역할임을 스프링에 알려서 자동 빈 등록
@Service
//final 필드를 초기화하는 생성자를 Lombok이 자동 생성
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService{
//	DAO를 주입받기 위한 필드, final로 선언해 변경 불가
//	실행 시점에 스프링이 의존성 주입함
	private final BoardDAO boardDAO;
	
//	게시글 등록
	@Override
	public void boardInsert(BoardDTO boardDTO) throws Exception {
		try {
//			DAO의 insert 메서드를 호출
			boardDAO.insert(boardDTO);
		} catch (DataIntegrityViolationException e) {
//			데이터 무결성 위반이 발생했을 때 던져지는 스프링의 예외
//			예외가 발생해도 프로그램이 강제 종료되지 않고, 예외 로그만 출력됨
			e.printStackTrace();
		}
	}

//	게시글 목록 조회
	@Override
	public List<BoardDTO> boardList() throws Exception {
		return boardDAO.list();
	}

//	게시글 상세 조회
	@Override
	public BoardDTO boardSelect(int bdNum) throws Exception {
		return boardDAO.select(bdNum);
	}

//	게시글 수정
	@Override
	public void boardUpdate(BoardDTO boardDTO) throws Exception {
		boardDAO.update(boardDTO);
	}

//	게시글 삭제
	@Override
	public void boardDelete(int bdNum) throws Exception {
		boardDAO.delete(bdNum);
	}
}

