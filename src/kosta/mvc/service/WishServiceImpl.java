package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.WishDAO;
import kosta.mvc.dao.WishDAOImpl;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.dto.WishDTO;

public class WishServiceImpl implements WishService {
	private WishDAO wishDAO = new WishDAOImpl();
	
	@Override
	public List<ProductDTO> selectWishByUserId(String userId) throws SQLException {
		
		List<ProductDTO> listAll = wishDAO.selectWishByUserId(userId);
		
		return listAll;
	}

	@Override
	public void insertWish(String userId, int prodId) throws SQLException {
		int result = wishDAO.insertWish(userId, prodId);
		if(result == 0) throw new SQLException("찜 등록 실패");
		
	}

	@Override
	public void deleteWish(int wishId) throws SQLException {
		int result = wishDAO.deleteWish(wishId);

	}

	@Override
	public List<WishDTO> selectWish(String userId) throws SQLException {
		List<WishDTO> listWish = wishDAO.selectWish(userId);
		return listWish;
	}

	/*
	@Override
	public WishDTO searchWishByProdName(String prodName) throws SQLException {
		WishDTO wish = wishDAO.selectWishByUserId(prodName);
		if(wish ==null) {
			throw new SQLException("찜한 상품이 아닙니다.");
		}
		
		return wish;
	}*/

	@Override
	public void duplicateWish(String userId, int prodId) throws SQLException {
		int result = wishDAO.duplicateWish(userId, prodId);
		if(result==1) throw new SQLException("이미 찜한 상품입니다.");
		
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
