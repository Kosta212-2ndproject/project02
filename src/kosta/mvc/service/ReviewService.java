package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.NoticeDTO;
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
	   * 리뷰번호에 해당하는 리 검색
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  ReviewDTO selectReview(int reviewId, boolean flag) throws SQLException;
	  
	  
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
