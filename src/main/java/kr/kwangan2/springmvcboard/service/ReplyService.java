package kr.kwangan2.springmvcboard.service;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageDTO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;

public interface ReplyService {
	
	public ReplyPageDTO listReplyVO(Criteria criteria, Long bno);
		
	public int replyVOListCount(Long bno);
	
	public ReplyVO selectReplyVO(Long rno);
	
	public int insertReplyVO(ReplyVO replyVO);
	
	public int updateReplyVO(ReplyVO replyVO);
	
	public int deleteReplyVO(Long rno);

}
