package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.WishDAO;
import kosta.mvc.dao.WishDAOImpl;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.dto.WishDTO;

public class WishServiceImpl implements WishService {
	private WishDAO wishDAO = new WishDAOImpl();
	
	@Override
	public List<WishDTO> selectWishByUserId(String userId) throws SQLException {
		
		List<WishDTO> wishList = wishDAO.selectWishByUserId(userId);
		if(wishList ==null || wishList.size()==0) {
			throw new SQLException("찜한 상품이 없습니다.");
		}
		
		return wishList;
	}

	@Override
	public void insertWish(WishDTO wishDTO) throws SQLException {
		int result = wishDAO.insertWish(wishDTO);
		if(result == 0) {
			throw new SQLException("찜 등록 실패");
		}
	}

	@Override
	public void deleteWish(int wishId) throws SQLException {
		int result = wishDAO.deleteWish(wishId);
		if(result == 0) {
			throw new SQLException("찜 번호["+wishId+"가 존재하지 않습니다.");
		}

	}

	@Override
	public List<WishDTO> selectWishList() throws SQLException {
		List<WishDTO> wishList = wishDAO.selectWishList();
		if(wishList ==null || wishList.size()==0) {
			throw new SQLException("찜한 상품이 없습니다.");
		}
		return wishList;
	}

	@Override
	public List<WishDTO> searchWishByProdName(String prodName) throws SQLException {
		List<WishDTO> wishList = wishDAO.selectWishByUserId(prodName);
		if(wishList ==null || wishList.size()==0) {
			throw new SQLException("찜한 상품이 아닙니다.");
		}
		
		return wishList;
	}

	/*@Override
	public boolean hasProdId(UserDTO userDTO, int prodId) throws SQLException {
		List<WishDTO> list = wishDAO.selectWishByUserId(userDTO.getUserId());
		for(WishDTO wishDTO : list) {
			if(wishDTO.getProdId()==prodId) {
				throw new SQLException("이미 찜한 상품입니다.");
			}
		}
		
		return false;
	}*/

}
