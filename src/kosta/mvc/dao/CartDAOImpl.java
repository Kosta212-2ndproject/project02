package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.dto.CartDTO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.util.DbUtil;

public class CartDAOImpl implements CartDAO {
	Properties proFile = new Properties();

	public CartDAOImpl() {
		try {
			//(현 프로젝트 런타임될때 즉 서버에서 실행될때 classes폴더를 동적으로 가져와서 경로를설정해야한다).
			//proFile.load(new FileInputStream("dbQuery.properties"));//오류발생
			
			//proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
			
			String str = proFile.getProperty("query.select");
			System.out.println("str = " + str);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<ProductDTO> selectCartByUserId(String userId) throws SQLException {
		PreparedStatement ps =null;
		ResultSet rs =null;
		Connection con=null;
		ProductDTO cart = null;
		List<ProductDTO>  listAll = new ArrayList<ProductDTO>();
		String sql="select prod_img_url, prod_name, prod_name_en, prod_price, prod_id, prod_qty from product where prod_id in (select prod_id from cart where user_id = ?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				String prodImgUrl = rs.getString("prod_img_url");
				String prodName = rs.getString("prod_name");
				String prodNameEng = rs.getString("prod_name_en");
				int  prodPrice = rs.getInt("prod_price");
				int prodId = rs.getInt("prod_id");
				int prodQty = rs.getInt("prod_qty");
				
			    ProductDTO productDTO= new ProductDTO(prodImgUrl, prodName, prodNameEng, prodPrice, prodId, prodQty);
			    listAll.add(productDTO);
			}	

		}finally {
			DbUtil.dbClose(rs, ps, con);
			
		}
		return listAll;
	}
	
	

	@Override
	public int deleteCart(int prodId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete from cart where prod_id=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodId);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}



	@Override
	public int insertCart(String userId, int prodId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into Cart values(CART_ID_SEQ.nextval,1,?,?)"; 
		
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, prodId);
			
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


	@Override
	public int duplicateCart(String userId, int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "select * from cart where user_id = ? and prod_id=?";
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, prodId);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose( ps, con);
		}
		return result;
	}

}
