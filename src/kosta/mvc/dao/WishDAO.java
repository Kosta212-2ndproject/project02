package kosta.mvc.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.WishDTO;


public interface WishDAO {
	/**
	 * 회원별 관심 조회
	 */
	List<ProductDTO> selectWishByUserId(String userId) throws SQLException;
	
	/**
	 * 상품 찜에 추가
	 */
	int insertWish(String userId, int prodId) throws SQLException;
	
	/**
	 * 찜에서 상품 삭제
	 */
	int deleteWish(int wishId) throws SQLException;
	
	/**
	 * 전체 관심리스트 
	 */
	
	List<WishDTO> selectWish(String userId) throws SQLException;
	
	/**
	 * 상품별 관심 검색
	 */
	WishDTO searchWishByProdName(String prodName) throws SQLException;
	
	/**
	 * 상품별 관심수 조회
	 */
	int selectWishByProdName(String prodName) throws SQLException;
	
	/**
	 * 찜 상품 중복 체크
	 */
	int duplicateWish(String userId, int prodId) throws SQLException;
	
	
	
	
}
