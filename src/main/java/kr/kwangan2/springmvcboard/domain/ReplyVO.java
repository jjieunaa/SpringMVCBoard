package kr.kwangan2.springmvcboard.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ReplyVO {
	
	private Long rno;
	private Long bno;	
	private String reply;
	private String replyer;
	private Date replydate;
	private Date updatedate;
	
	public ReplyVO() {		
	}
	
	public ReplyVO(Long bno, String reply, String replyer) {
		this.bno = bno;
		this.reply = reply;
		this.replyer = replyer;
	}
	
}	// class
