package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.QuestionDTO;


public interface QuestionDAO {

	/**
	  * 질문 전체 검색 
	  * */
	  List<QuestionDTO> selectAll() throws SQLException;
	  
	  /**
	   * 상품번호에 해당하는 question 검색
	   * */
	  QuestionDTO selectByModelNum(String prodId) throws SQLException;
	  
	  /**
	   * 회원아이디 해당하는 question 검색
	   * */
	  QuestionDTO selectByUserId(String userId) throws SQLException;
	  
	  /**
	   * 질문번호에 해당하는 question 검색
	   * */
	  QuestionDTO selectByUserId(int qNum) throws SQLException;
	  
	  
	  /**
	   * question 등록
	   * @return : 1-등록성공 , 0 - 등록실패
	   * */
	  int insert(QuestionDTO question) throws SQLException;
	  
	  /**
	   * 질문번호에 해당하는 question 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(int qNum) throws SQLException;
	  
	   /**
	    * 상품번호에 해당하는 question 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(QuestionDTO question) throws SQLException;
}
