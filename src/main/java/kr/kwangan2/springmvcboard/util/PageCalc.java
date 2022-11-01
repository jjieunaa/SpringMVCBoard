package kr.kwangan2.springmvcboard.util;

import kr.kwangan2.springmvcboard.domain.Criteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageCalc {
	
	private int total;				// 전체 게시물 수
	private int startPage;		// 블럭 내 시작 페이지 번호
	private int endPage;		// 블럭 내 끝 페이지 번호
	private boolean prev;		// 이전 블럭이 있는지 여부
	private boolean next;		// 다음 블럭이 있는지 여부
	
	private Criteria criteria;
	
	public PageCalc(Criteria criteria, int total) {
		this.criteria = criteria;
		this.total = total;
	}
	
	public PageCalc calcPage() {
		// 끝 페이지 번호 (단순히 한 블럭이 10개 페이지라 가정)
		this.endPage = (int) (Math.ceil(criteria.getPageNum() / 10.0)) * 10;
		// 시작 페이지 번호
		this.startPage = this.endPage - 9;
		// 실제 끝 페이지 번호 (만약 25페이지라면 3블럭은 21~25)
		int realEnd = (int) (Math.ceil((total * 1.0) / criteria.getAmount()));
		
		// 블럭 내에 10개 페이지가 안될 때 끝 페이지 번호 설정
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		return this;
	}
	
}	// class
