package jin.spring.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import jin.spring.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;

//이 클래스가 DAO 역할을 한다는 걸 Spring이 인식해서 빈으로 자동 등록
@Repository
//final 또는 @NonNull 필드를 초기화하는 생성자를 Lombok이 자동 생성
@RequiredArgsConstructor
public class BoardDAOImp implements BoardDAO {
//	final로 선언-> 실행 시점에 스프링이 의존성 주입함
	private final SqlSessionTemplate sqlSessionTemplate;

//	게시글 등록
	@Override
	public void insert(BoardDTO boardDTO) throws Exception {
		/*
		 * XML 매퍼 파일에서 namespace="jin.spring.board"와 id="insert"에 해당하는 SQL 쿼리를 실행
		 */
		sqlSessionTemplate.insert("jin.spring.board.insert", boardDTO);
	}

//	게시글 목록 조회
	@Override
	public List<BoardDTO> list() throws Exception {
		return sqlSessionTemplate.selectList("jin.spring.board.list");

	}

//	게시글 상세 조회
	@Override
	public BoardDTO select(int bdNum) throws Exception {
		return sqlSessionTemplate.selectOne("jin.spring.board.select", bdNum);
	}

//	게시글 수정
	@Override
	public void update(BoardDTO boardDTO) throws Exception {
		sqlSessionTemplate.update("jin.spring.board.update", boardDTO);
	}

//	게시글 삭제
	@Override
	public void delete(int bdNum) throws Exception {
		sqlSessionTemplate.delete("jin.spring.board.delete", bdNum);
	}

}
