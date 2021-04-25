package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.dto.CartDTO;
import kosta.mvc.util.DbUtil;

public class CartDAOImpl implements CartDAO {
	Properties proFile = new Properties();

	public CartDAOImpl() {
		try {
			//(현 프로젝트 런타임될때 즉 서버에서 실행될때 classes폴더를 동적으로 가져와서 경로를설정해야한다).
			//proFile.load(new FileInputStream("dbQuery.properties"));//오류발생
			
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			
			String str = proFile.getProperty("query.select");
			System.out.println("str = " + str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<CartDTO> selectCartByUserId(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<CartDTO> cartList = new ArrayList<>();
		CartDTO cart = null;
		
		String sql="select * from cart where user_id=? ";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int cartId = rs.getInt("cartId");
				int cartQty = rs.getInt("cartQty");
				userId = rs.getString("userId");
				int  prodId = rs.getInt("prodId");
				
				cart = new CartDTO(cartId, cartQty, userId, prodId);
				cartList.add(cart);
			
			}	

		}finally {
			DbUtil.dbClose(rs, ps, con);
			
		}
		return cartList;
	}
	
	

	@Override
	public int deleteCart(int cartId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete Cart where cart_id=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartId);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}



	@Override
	public int insertCart(CartDTO cartDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into Cart values(CART_ID_SEQ.CURRVAL,?,?,?)"; 
		
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cartDTO.getCartQty());
			ps.setString(2, cartDTO.getUserId());
			ps.setInt(3, cartDTO.getProdId());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}


	@Override
	public int update(int cartId, int cartQty) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update cart set cart_qty = ? where cart_id = ?";
		try {
			con=DbUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, cartQty);
			ps.setInt(2, cartId);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
