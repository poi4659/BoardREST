package jin.spring.board.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.inject.Inject;
import jin.spring.board.dao.BoardDAO;
import jin.spring.board.dto.BoardDTO;

//JUnit 5에서 Mockito 기능을 사용하기 위해 필요
@ExtendWith(MockitoExtension.class)
public class BoardServiceMockTest {
//	테스트 대상은 구현체이기에 인터페이스 사용하지 않음
//	@Mock으로 만든 BoardDAO를 boardServiceImp에 자동 주입해줌
	@InjectMocks
	private BoardServiceImp boardServiceImp;
	
//	가짜 DAO 객체->진짜 DB 접근 안함
//	Mockito는 인터페이스의 가짜 구현체(프록시)를 자동으로 생성 가능: BoardDAOImp처럼 행동하는 객체가 생성됨
	@Mock
    private BoardDAO boardDAO;

    @Test
    public void testBoardInsert() throws Exception {
//    	테스트용 게시글 객체 생성
    	BoardDTO boardDTO = new BoardDTO();
    	boardDTO.setBdTitle("테스트 제목");
    	boardDTO.setBdWriter("테스트 작성자");
    	boardDTO.setBdContent("테스트 내용");
    	
//    	서비스 호출
    	boardServiceImp.boardInsert(boardDTO);
    	
//    	verify(): 특정 메서드가 호출되었는지 확인
//    	DAO의 insert()가 한 번 호출됐는지 확인
    	verify(boardDAO, times(1)).insert(boardDTO);
    }
}
