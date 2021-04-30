package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.CartDTO;
import kosta.mvc.dto.ProductDTO;

public interface CartDAO {
	
	
	/**
	 * 회원별 카트 조회
	 */
	List<ProductDTO> selectCartByUserId( String userId) throws SQLException;
	
	/**
	 * 상품 카트에 추가
	 */
	int insertCart(String userId, int prodId) throws SQLException;
	
	/**
	 * 카트에서 상품 삭제
	 */
	int deleteCart(int prodId) throws SQLException;
	
	/**
	 * 카트 수량 업데이트
	 */
	int update(int cartId, int cartQTY) throws SQLException;
	
	/**
	 * 카트 상품 중복 체크
	 */
	int duplicateCart(String userId, int prodId) throws SQLException;
}
