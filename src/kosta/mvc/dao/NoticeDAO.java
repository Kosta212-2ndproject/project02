package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.NoticeDTO;

public interface NoticeDAO {

	/**
	  * 공지글 전체 검색 
	  * */
	  List<NoticeDTO> selectAll() throws SQLException;
	  
	  /**
	   * 특정키워드에 해당하는 공지글 검색
	   * */
	  List<NoticeDTO> selectByKeyword(String keyword) throws SQLException;
	  
	  
	  /**
	   * 공지글번호에 해당하는 공지글 검색
	   * */
	  NoticeDTO selectByNoticeNum(int nNum) throws SQLException;
	  
	  
	  /**
	   * 공지글 등록
	   * @return : 1-등록성공 , 0 - 등록실패
	   * */
	  int insert(NoticeDTO notice) throws SQLException;
	  
	  
	  /**
	   * 공지글번호 해당하는 공지글 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(int nNum) throws SQLException;
	  
	   /**
	    * 공지글 해당하는 공지글 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(NoticeDTO notice) throws SQLException;
}
