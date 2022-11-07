package kr.kwangan2.springmvcboard.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService replyService;
	
	// @Test
	/*
	public void testListReplyVO() {
		List<ReplyVO> list = replyService.listReplyVO();
		assertNotNull(list);
		log.info(list);
	}
	*/
	
	// @Test
	/*
	public void testReplyVOListCount() {
		int result = replyService.replyVOListCount(8L);
		log.info(result);
	}
	*/
	
	// @Test
	/*
	public void testInsertReplyVO() {
		ReplyVO replyVO = new ReplyVO(8L, "new 댓글", "new 댓글 작성자");	
		int result = replyService.insertReplyVO(replyVO);
		assertTrue(result>0);
		log.info(result);
	}
	*/
	
	// @Test
	/*
	public void testSelectReplyVO() {
		ReplyVO replyVO = replyService.selectReplyVO(8L);
		assertNotNull(replyVO);
		log.info(replyVO);
	}
	*/
	
	// @Test
	/*
	public void testDeleteReplyVO() {
		int result = replyService.deleteReplyVO(2L);
		assertNotNull(result > 0);
		log.info(result);
	}
	*/
	
	// @Test
	/*
	public void testUpdateReplyVO() {
		ReplyVO replyVO = new ReplyVO(8L, "update 댓글", "update 댓글 작성자");
		replyVO.setRno(8L);
		int result = replyService.updateReplyVO(replyVO);
		assertNotNull(result > 0);
		log.info(result);
	}
	*/
	
	// @Test
	/*
	public void testList2() {
		Criteria criteria = new Criteria(1, 5);
		
		List<ReplyVO> replies = replyService.listReplyVO(criteria, 8L);
		
		replies.forEach(reply -> log.info(reply));
	}
	*/
	
}	// class
