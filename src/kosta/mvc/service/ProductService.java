package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ProductDTO;

public interface ProductService {
	
	/**
	 * 상품 검색 메소드 호출
	 */
	List<ProductDTO> selectAll(int pageNo, String category, String order, String values) throws SQLException;
	
	/**
	 * 상품 매진 상품 검색 메소드 호출
	 */
	List<ProductDTO> selectAllByQty() throws SQLException;
	
	/**
	 * ProductDAOImpl의 상품 상세 조회 메소드 호출
	 */
	ProductDTO selectByProductDetail(int prodId) throws SQLException;

	/**
	 * ProductDAOImpl의 상품등록 메소드 호출
	 */
	void insertProduct(ProductDTO productDTO) throws SQLException;

	/**
	 * ProductDAOImpl의 상품삭제 메소드 호출
	 */
	void deleteProduct(int prodId) throws SQLException;

	/**
	 * ProductDAOImpl의 상품수정 메소드 호출
	 */
	void updateProduct(ProductDTO productDTO) throws SQLException;

}
