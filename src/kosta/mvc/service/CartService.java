package kosta.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ProductDTO;

public interface CartService {
	/**
	 * 카트 조회(회원별)
	 */
	List<ProductDTO>  selectCartByUserId(String userId) throws SQLException;
	
	/**
	 * 상품 카트에 추가
	 */
	
	void insertCart(String userId, int prodId) throws SQLException;
	
	/**
	 * 카트에서 상품 삭제
	 */
	
	void deleteCart(int prodId) throws SQLException;
	
	/**
	 * 카트 수량 수정
	 */
	void updateCart(int cartId, int cartQty) throws SQLException;
	
	
	/**
	 * 카트 중복 확인
	 */
	
	void duplicateCart(String userId, int prodId) throws SQLException;
}
