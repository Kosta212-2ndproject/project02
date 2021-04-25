package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.CartDTO;

public interface CartDAO {
	
	
	/**
	 * 회원별 카트 조회
	 */
	List<CartDTO> selectCartByUserId(String userId) throws SQLException;
	
	/**
	 * 상품 카트에 추가
	 */
	int insertCart(CartDTO cartDTO) throws SQLException;
	
	/**
	 * 카트에서 상품 삭제
	 */
	int deleteCart(int cartId) throws SQLException;
	
	/**
	 * 카트 수량 업데이트
	 */
	int update(int cartId, int cartQTY) throws SQLException;
	
}
