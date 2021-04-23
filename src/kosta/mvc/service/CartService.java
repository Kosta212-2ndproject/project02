package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.CartDTO;

public interface CartService {
	/**
	 * 카트 조회(회원별)
	 */
	List<CartDTO> selectCartByUserId(String userId) throws SQLException;
	
	/**
	 * 상품 카트에 추가
	 */
	
	void insertCart(CartDTO cartDTO) throws SQLException;
	
	/**
	 * 카트에서 상품 삭제
	 */
	
	void deleteCart(int cartId) throws SQLException;
	
}
