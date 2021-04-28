package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ReviewDTO;



public interface ReviewDAO {

	/**
	  * review 전체 검색 
	  * */
	  List<ReviewDTO> selectAll() throws SQLException;
	  
	  /**
	   * reviewNum  검색 
	   * */
	  ReviewDTO selectReview(int reviewId) throws SQLException;
	  
	  /**
	   * 상품번호에 해당하는 review 검색
	   * */
	  List<ReviewDTO> selectByProdId(String prodId) throws SQLException;
	  
	  /**
	   * userId 해당하는 review 검색
	   * */
	  List<ReviewDTO> selectByUserId(String userId) throws SQLException;
	  
	  /**
	   * 상품번호에 해당하는 review 총 count 검색
	   * */
	  int selectByProdIdCnt(String prodId) throws SQLException; 
	  
	  /**
	   * 조회수를 증가하는 기능
	   * update Electronics set readnum = readnum + 1 where model_num=?
	   * */
	  int increamentByReadnum(String prodId) throws SQLException;
	  
	  
	  /**
	   * review 등록
	   * @return : 1-등록성공 , 0 - 등록실패
	   * */
	  int insert(ReviewDTO review) throws SQLException;
	  
	  /**
	   * review번호에 해당하는 review 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int delete(int reviewId) throws SQLException;
	  
	   /**
	    * 상품번호에 해당하는 review 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int update(ReviewDTO review) throws SQLException;
}
