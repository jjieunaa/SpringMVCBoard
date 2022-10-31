package kr.kwangan2.springmvcboard.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService boardService;
	
	@Test
	public void testExist() {
		log.info(boardService);
		assertNotNull(boardService);
	}
	
	@Test
	public void testInsertBoardVO() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("Service 제목");
		boardVO.setContent("Service 내용");
		boardVO.setWriter("Service 작성자");
		
		boardService.insertBoardVO(boardVO);
		log.info("생성된 게시물 번호: " + boardVO.getBno());
	}
	
	@Test
	public void testBoardVOList() {
		boardService.boardVOList().forEach(boardVO -> log.info(boardVO));
	}
	
	@Test
	public void testSelectBoardVO() {
		log.info(boardService.selectBoardVO(1L));
	}
	
	@Test
	public void testDeleteBoardVO() {
		boardService.deleteBoardVO(18L);
	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setBno(19L);
		boardVO.setTitle("Service 수정 제목");
		boardVO.setContent("Service 수정 내용");
		boardVO.setWriter("Service 수정 작성자");
		
		boardService.updateBoardVO(boardVO);
		log.info("수정된 게시물 번호: " + boardVO.getBno());
	}

}
