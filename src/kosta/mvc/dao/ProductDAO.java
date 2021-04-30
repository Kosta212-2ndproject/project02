package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ProductDTO;

public interface ProductDAO {
	 /**
	  * 상품 전체 검색
	  * */
	  List<ProductDTO> selectAll() throws SQLException;
	  
	  /**
	   * 상품키워드에 해당하는 상품 검색
	   * */
	  List<ProductDTO> selectByModelKeyword(String keyword) throws SQLException;
	  
	  /**
	   * 국가에 해당하는 상품 검색 
	   * */
	  List<ProductDTO> selectByNation(String prodNation) throws SQLException;
	  
	  
	  /**
	   * 종류에 해당하는 상품 검색
	   * */
	  List<ProductDTO> selectByType(String prodType) throws SQLException;
	  
	  /**
	   * 가격에 해당하는 상품 검색
	   * */
	  List<ProductDTO> selectByPrice(int prodPrice) throws SQLException;
	  
	  /**
	   * 상품상세 조회
	   * */
	  ProductDTO selectByProductDetail(int prodId) throws SQLException;
	    
	  
	  /**
		 * 상품등록
		 * @return : 1-삽입성공 , 0 - 삽입실패
		 * */
	  int insertProduct(ProductDTO productDTO) throws SQLException;
	  
	  /**
	   * 상품번호에 해당하는 상품 삭제
	   * @return : 1-삭제성공 , 0 - 삭제실패
	   * */
	  int deleteProduct(int prodId) throws SQLException;
	  
	  /**
	    * 상품 수정
	    * @return : 1-수정성공 , 0 - 수정실패
	    * */
	  int updateProduct(ProductDTO productDTO) throws SQLException;

	/**
	 * 상품 금액 가져오기
	 */
	int selectByOriginPrice(int prodId) throws SQLException;

}
