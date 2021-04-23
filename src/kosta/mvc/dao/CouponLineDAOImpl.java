package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.CouponLineDTO;
import kosta.mvc.util.DbUtil;

public class CouponLineDAOImpl implements CouponLineDAO {

	@Override
	public List<CouponLineDTO> selectAllCoupons() throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<CouponLineDTO> list = new ArrayList<CouponLineDTO>();
		
		String sql="select * from couponline join coupon using(cpon_num) order by cpon_enddate";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int cponUseNum = rs.getInt("cponUseNum");
				int cponNum = rs.getInt("cponNum");
				String userId = rs.getString("userId");
				int cponUseState = rs.getInt("cponUseState");
				String cponRegDate = rs.getString("cponRegDate");
				String cponEndDate = rs.getString("cponEndDate");
			
				CouponLineDTO coupon = new CouponLineDTO(cponUseNum, cponNum, userId, cponUseState, cponRegDate, cponEndDate, cponEndDate, cponUseState);
			
				list.add(coupon);
							
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		
		return list;
	}

	@Override
	public int createCoupon(CouponLineDTO couponDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;		
		String sql = "insert into couponline values(cpon_use_num_seq.currval,?,?,?,?,?)";
		
		int result=0;
		try {
			
			con=DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, couponDTO.getCponNum());
			ps.setString(2, couponDTO.getUserId());
			ps.setInt(3, couponDTO.getCponUseState());
			ps.setString(4, couponDTO.getCponRegDate());
			ps.setString(5, couponDTO.getCponEndDate());
			
			result = ps.executeUpdate();
		
		}finally {
			DbUtil.dbClose(ps, con);
		}
	
		
		return result;
	}

	@Override
	public int updateCoupon(CouponLineDTO couponDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update couponline set cpon_use_state=? where cpon_num=?";
		try {
			con = DbUtil.getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, couponDTO.getCponUseState());
			ps.setInt(2, couponDTO.getCponNum());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public CouponLineDTO selectBycponName(String cponName) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		CouponLineDTO coupon=null;
		
		String keyWord = "%" + cponName + "%";

		
		String sql="select * from couponline cl join coupon c on cl.cpon_num=c.cpon_num where cpon_name like ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, keyWord);
			
			
			rs= ps.executeQuery();
			
			
			if(rs.next()) {
				coupon= new CouponLineDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		
		return coupon;
	}

	@Override
	public CouponLineDTO selectBycponDcPercent(double cponDcPercent) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		CouponLineDTO coupon=null;
		
		String sql="select * from couponline where cpon_dc_percent=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, cponDcPercent);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				coupon= new CouponLineDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6));
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return coupon;
	}

}
