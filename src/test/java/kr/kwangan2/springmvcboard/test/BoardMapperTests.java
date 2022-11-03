package kr.kwangan2.springmvcboard.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	/*
	@Test
	public void testBoardVOList() {
		mapper.boardVOList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsertBoardVO() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("신 제목");
		boardVO.setContent("신 내용");
		boardVO.setWriter("신 작성자");
		
		mapper.insertBoardVO(boardVO);
		
		log.info(boardVO);
	}
	
	@Test
	public void testBoardVOSelectKey() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setTitle("신 제목 SK");
		boardVO.setContent("신 내용 SK");
		boardVO.setWriter("신 작성자 SK");
		
		mapper.insertBoardVOSelectKey(boardVO);
		
		log.info(boardVO);
	}
	
	@Test
	public void testSelectBoardVO() {
		BoardVO boardVO = mapper.selectBoardVO(5L);
		
		log.info(boardVO);
	}
	
	@Test
	public void testDeleteBoardVO() {
		int result = mapper.deleteBoardVO(3L);
		log.info(result);
	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setBno(6L);
		boardVO.setTitle("수정된 제목");
		boardVO.setContent("수정된 내용");;
		boardVO.setWriter("수정된 작성자");
		
		int count = mapper.updateBoardVO(boardVO);
		log.info(count);
	}
	*/
	
	@Test
	public void testPaging() {
		Criteria criteria = new Criteria();
		
		// 10개씩 3페이지
		criteria.setPageNum(3);
		criteria.setAmount(10);
		
		List<BoardVO> list = mapper.boardVOList(criteria);
		list.forEach(board -> log.info(board));
	}
}
