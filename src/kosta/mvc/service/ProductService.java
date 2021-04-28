package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ProductDTO;

public interface ProductService {
	/**
	 * ProductDAOImpl의 상품 전체 검색 메소드 호출(User)
	 */
	List<ProductDTO> selectAll() throws SQLException;

	/**
	 * paging처리 상품 전체 검색 메소드 호출
	 */
	List<ProductDTO> selectAll(int pageNo) throws SQLException;

	/**
	 * ProductDAOImpl의 상품키워드에 해당하는 상품 검색 메소드 호출
	 */
	List<ProductDTO> selectByModelKeyword(String keyword) throws SQLException;

	/**
	 * ProductDAOImpl의 국가에 해당하는 상품 검색 메소드 호출
	 */
	List<ProductDTO> selectByNation(String prodNation) throws SQLException;

	/**
	 * ProductDAOImpl의 종류에 해당하는 상품 검색 메소드 호출
	 */
	List<ProductDTO> selectByType(String prodType) throws SQLException;

	/**
	 * ProductDAOImpl의 가격에 해당하는 상품 검색 메소드 호출
	 */
	List<ProductDTO> selectByPrice(String prodPrice) throws SQLException;

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
