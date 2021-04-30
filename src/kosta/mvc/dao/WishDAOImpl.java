package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.WishDTO;
import kosta.mvc.util.DbUtil;

public class WishDAOImpl implements WishDAO {
	
	Properties proFile = new Properties();

	
	
	@Override
	public List<ProductDTO> selectWishByUserId(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		ProductDTO wish = null;
		List<ProductDTO> listAll = new ArrayList<ProductDTO>();

		String sql="select prod_img_url, prod_name, prod_name_en, prod_price, prod_id, prod_qty from product where prod_id in (select prod_id from wish where user_id = ?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String prodImgUrl = rs.getString("prod_img_url");
				String prodName = rs.getString("prod_name");
				String prodNameEng = rs.getString("prod_name_en");
				int  prodPrice = rs.getInt("prod_price");
				int prodId = rs.getInt("prod_id");
				int prodQty= rs.getInt("prod_qty");
				
			    ProductDTO productDTO= new ProductDTO(prodImgUrl, prodName, prodNameEng, prodPrice, prodId , prodQty);
			    listAll.add(productDTO);
				
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return listAll;
	}
	
	@Override
	public int insertWish(String userId, int prodId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into wish values(wish_id_seq.nextval,?, ? )";
		
		int result =0;
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
	public int deleteWish(int wishId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="delete from wish where prod_id=?";
				
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, wishId);
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	

	@Override
	public List<WishDTO> selectWish(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		WishDTO wish = null;
		List<WishDTO> wishList = new ArrayList<WishDTO>();

		String sql="select prod_img_url, prod_name, prod_name_en, prod_price, prod_id from product where prod_id in (select prod_id from wish where user_id = ?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				String prodImgUrl = rs.getString("prod_img_url");
				String prodName = rs.getString("prod_name");
				String prodNameEng = rs.getString("prod_name_en");
				int prodId = rs.getInt("prod_id");
				
			    WishDTO wishDTO= new WishDTO(prodImgUrl, prodName, prodNameEng, prodId);
			    wishList.add(wishDTO);
				
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return wishList;
	}

	@Override
	public int selectWishByProdName(String prodName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		
		String keyWord = "%" + prodName + "%";
		
		String sql="select count(*) from wish w join product p on w.prod_id=p.prod_id where prod_name like ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, keyWord);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public WishDTO searchWishByProdName(String prodName) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		WishDTO wish = null;
		String keyWord = "%" + prodName + "%";
		String sql="select * from wish w join product p on w.prod_id=p.prod_id where prod_name || upper(prod_name_en) like upper(?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, keyWord);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int wishId = rs.getInt("wish_id");
				String userId = rs.getString("user_id");
				int prodId = rs.getInt("prod_id");
				keyWord = rs.getString("prod_name");
				
				
				wish = new WishDTO(wishId, userId, prodId, keyWord);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return wish;
	}

	@Override
	public int duplicateWish(String userId, int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "select * from wish where user_id = ? and prod_id=?";
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
