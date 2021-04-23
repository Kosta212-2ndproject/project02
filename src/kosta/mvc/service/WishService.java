package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.dto.WishDTO;

public interface WishService {

	/**
	 * 회원별 관심조회
	 */
	List<WishDTO> selectWishByUserId(String userId) throws SQLException;
	
	/**
	 *  상품 찜에 추가
	 */
	void insertWish(WishDTO wishDTO) throws SQLException;
	
	/**
	 *  찜에서 상품 삭제
	 */
	void deleteWish(int wishId) throws SQLException;
	
	/**
	 * 전체 관심리스트
	 */
	List<WishDTO> selectWishList() throws SQLException;
	
	/**
	 * 관심 등록된 상품 체크
	 */
	/*public boolean hasProdId(UserDTO userDTO, int prodId) throws SQLException;*/
	
	/**
	 * 상품별 관심 리스트 보기
	 */
	List<WishDTO> searchWishByProdName(String prodName) throws SQLException;
	
	
	
}
