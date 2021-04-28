package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	  * review 전체 검색 
	  * */
	  List<ReviewDTO> selectAll() throws SQLException;
	  
	  /**
	   * 상품번호에 해당하는 review 검색
	   * */
	  List<ReviewDTO> selectByProdId(String prodId) throws SQLException;
	  
	  /**
	   * userId 해당하는 review 검색
	   * */
	  List<ReviewDTO> selectByUserId(String userId) throws SQLException;
	  
	  
	  /**
	   * reviewId로 리뷰검색 
	   * */
	  ReviewDTO selectReview(int reviewId) throws SQLException;
	  /**
	   * review 등록
	   * @return : 1-등록성공 , 0 - 등록실패
	   * */
	  void insert(ReviewDTO review) throws SQLException;
	  
	  /**
	   * review번호에 해당하는 review 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  void delete(int reviewId) throws SQLException;
	  
	   /**
	    * 상품번호에 해당하는 review 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  void update(ReviewDTO review) throws SQLException;

}
