package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;


import kosta.mvc.dao.CartDAO;
import kosta.mvc.dao.CartDAOImpl;
import kosta.mvc.dto.ProductDTO;

public class CartServiceImpl implements CartService {
	private CartDAO cartDAO = new CartDAOImpl();
	
	@Override
	public List<ProductDTO> selectCartByUserId( String userId) throws SQLException {
		List<ProductDTO> listAll = cartDAO.selectCartByUserId(userId);
		return listAll;
	}

	@Override
	public void insertCart(String userId, int prodId) throws SQLException {
		int result = cartDAO.insertCart(userId, prodId);
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void deleteCart(int prodId) throws SQLException {
		int result = cartDAO.deleteCart(prodId);
	}

	

	@Override
	public void updateCart(int cartId, int cartQty) throws SQLException {
		int result = cartDAO.update(cartId, cartQty);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
	}

	@Override
	public void duplicateCart(String userId, int prodId) throws SQLException{
		
		int result = cartDAO.duplicateCart(userId, prodId);
		if(result==1) throw new SQLException("이미 카트에 등록된 상품입니다.");
	}
}
