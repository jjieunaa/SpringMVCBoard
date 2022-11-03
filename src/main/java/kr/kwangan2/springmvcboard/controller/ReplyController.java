package kr.kwangan2.springmvcboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.ano.Service;

@RestController
@RequestMapping("/replies/")
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService replyService;
	
	@PostMapping(
				value="/insert",
				consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
				produces = {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<String> insertReplyVO(@RequestBody ReplyVO replyVO) {
		int result = replyService.insertReplyVO(replyVO);
		return result==1
				?	new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	// insertReplyVO
	
	@GetMapping(
				value="/pages/{bno}/{page}",
				produces = {
						MediaType.APPLICATION_JSON_UTF8_VALUE,
						MediaType.APPLICATION_XML_VALUE
				}
			)
	public ResponseEntity<List<ReplyVO>> listReplyVO(
				@PathVariable("bno") Long bno,
				@PathVariable("page") int page
			) {		
		Criteria criteria = new Criteria(page, 10);
		
		return new ResponseEntity<>(replyService.listReplyVO(criteria, bno), HttpStatus.OK);	
	}	// listReplyVO
	
	@GetMapping(
				value="/{rno}",
				produces = {
						MediaType.APPLICATION_JSON_UTF8_VALUE,
						MediaType.APPLICATION_XML_VALUE
				}
			)
	public ResponseEntity<ReplyVO> selectReplyVO(
				@PathVariable("rno") Long rno
			) {
		return new ResponseEntity<>(replyService.selectReplyVO(rno), HttpStatus.OK);
	}	// selectReplyVO
	
	@DeleteMapping(
				value="/{rno}",
				produces = {MediaType.TEXT_PLAIN_VALUE}
			)
	public ResponseEntity<String> deleteReplyVO(
				@PathVariable("rno") Long rno
			) {
		return replyService.deleteReplyVO(rno) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	// deleteReplyVO
	
	@RequestMapping(
				value = "/{rno}",
				method = {RequestMethod.PUT, RequestMethod.PATCH},
				consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
				produces = {MediaType.TEXT_PLAIN_VALUE}				
			)
	public ResponseEntity<String> updateReplyVO(
				@RequestBody ReplyVO replyVO,
				@PathVariable("rno") Long rno
			) {
		return replyService.updateReplyVO(replyVO) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}	// updateReplyVO

}	// class
