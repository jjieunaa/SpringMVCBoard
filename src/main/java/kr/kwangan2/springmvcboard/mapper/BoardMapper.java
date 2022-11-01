package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;

public interface BoardMapper {
	
	// @Select(" select * from board where bno>0 ")
	public List<BoardVO> boardVOList();
	
	public List<BoardVO> boardVOList(Criteria criteria);	// 오버로딩
	
	public int boardVOListCount(Criteria criteria);
	
	public int insertBoardVO(BoardVO boardVO);
	
	public int insertBoardVOSelectKey(BoardVO boardVO);
	
	public BoardVO selectBoardVO(Long bno);
	
	public int deleteBoardVO(Long bno);
	
	public int updateBoardVO(BoardVO boardVO);
	
}
