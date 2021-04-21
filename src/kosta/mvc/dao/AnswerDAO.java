package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.AnswerDTO;

public interface AnswerDAO {
	/**
	  * 질문번호에 대한 답변글 검색하기
	  * */
	  List<AnswerDTO> selectByQNum(int qNum) throws SQLException;
	  
	  /**
	   * 관리자 아이디로 답변 검색
	   * */
	  List<AnswerDTO> selectByUserId(String userId) throws SQLException;
	  
	  /**
	   * 답변번호에 해당하는 답변 검색
	   * */
	  AnswerDTO selectByANum(int aNum) throws SQLException;
	  
	  
	  /**
	   * 답변 등록
	   * @return : 1-등록성공 , 0 - 등록실패
	   * */
	  int insert(AnswerDTO answer) throws SQLException;
	  
	  /**
	   * 답변번호에 해당하는 답변 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(int aNum) throws SQLException;
	  
	   /**
	    * 답변번호에 해당하는 답변 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(AnswerDTO question) throws SQLException;
}
