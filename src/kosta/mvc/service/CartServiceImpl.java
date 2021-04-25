package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.CartDAO;
import kosta.mvc.dao.CartDAOImpl;
import kosta.mvc.dto.CartDTO;

public class CartServiceImpl implements CartService {
	private CartDAO cartDAO = new CartDAOImpl();
	
	@Override
	public List<CartDTO> selectCartByUserId(String userId) throws SQLException {
		List<CartDTO> cartList = cartDAO.selectCartByUserId(userId);
		if(cartList ==null || cartList.size()==0) {
			throw new SQLException("검색된 카트 정보가 없습니다.");
		}
		
		return cartList;
	}

	@Override
	public void insertCart(CartDTO cartDTO) throws SQLException {
		int result = cartDAO.insertCart(cartDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void deleteCart(int cartId) throws SQLException {
		if(cartDAO.deleteCart(cartId)==0) {
			throw new SQLException("삭제되지 않았습니다.");
		}

	}

	@Override
	public void updateCart(int cartId, int cartQty) throws SQLException {
		int result = cartDAO.update(cartId, cartQty);
		if(result==0)throw new SQLException("업데이트되지 않았습니다.");
	}

}
