package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ProductDTO;

public interface ProductDAO {
		
	/**
	 * 상품 검색 (pageNo = 페이지수, category = 검색어 또는 검색카테고리, order = 정렬항목, values=
	 * 검색어,검색카테고리의 실제값)
	 */
	List<ProductDTO> selectAll(int pageNo, String category, String order, String values) throws SQLException;
	
	/**
	 * 상품재고에 따른 매진임박
	 */
	List<ProductDTO> selectAllByQty() throws SQLException;
	
	/**
	 * 상품상세 조회
	 */
	ProductDTO selectByProductDetail(int prodId) throws SQLException;

	/**
	 * 상품등록
	 * 
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 */
	int insertProduct(ProductDTO productDTO) throws SQLException;

	/**
	 * 상품번호에 해당하는 상품 삭제
	 * 
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 */
	int deleteProduct(int prodId) throws SQLException;

	/**
	 * 상품 수정
	 * 
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	int updateProduct(ProductDTO productDTO) throws SQLException;
}
