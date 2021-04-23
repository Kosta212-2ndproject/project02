package kosta.mvc.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import kosta.mvc.dto.CartDTO;
import kosta.mvc.dto.ProductDTO;

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
	
}
