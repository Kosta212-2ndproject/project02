package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.dto.WishDTO;
import kosta.mvc.util.DbUtil;

public class WishDAOImpl implements WishDAO {
	
	Properties proFile = new Properties();

	
	
	@Override
	public List<WishDTO> selectWishByUserId(String userId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<WishDTO> wishList = new ArrayList<>();
		WishDTO wishDTO = null;
		String sql="select * from wish where user_id=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int wishId = rs.getInt("wish_id");
				userId = rs.getString("user_id");
				int prodId = rs.getInt("prod_id");
				
				wishDTO = new WishDTO(wishId, userId, prodId);
				wishList.add(wishDTO);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return wishList;
	}
	
	@Override
	public int insertWish(WishDTO wishDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into wish values(wish_id_seq.currval,?, ? )";
		
		int result =0;
		try {	
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, wishDTO.getUserId());
			ps.setInt(2, wishDTO.getProdId());
			
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
		String sql="delete from wish where wish_id=?";
				
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
	public List<WishDTO> selectWishList() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<WishDTO> wishList = new ArrayList<>();
		WishDTO wishDTO = null;
		String sql="select * from wish";
		
		try {
			
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				int wishId = rs.getInt("wish_id");
				String userId = rs.getString("user_id");
				int prodId = rs.getInt("prod_id");
				
				wishDTO = new WishDTO(wishId, userId, prodId);
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
	public List<WishDTO> searchWishByProdName(String prodName) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		List<WishDTO> wishList = new ArrayList<>();
		WishDTO wishDTO = null;
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
				
				
				wishDTO = new WishDTO(wishId, userId, prodId, keyWord);
				wishList.add(wishDTO);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return wishList;
	}
		
	

}
