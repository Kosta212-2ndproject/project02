package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.MemberDTO;
import kosta.mvc.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {
	
	public int insertMember(MemberDTO memberDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = "INSERT INTO USERLIST(USER_ID, USER_NAME, USER_PW, USER_HP, USER_EMAIL, USER_BIRTH, USER_GENDER, USER_STATE, USER_REGDATE, USER_BUYCOUNT) "
				+ "VALUES(?, ?, '1234', ?, ?, ?, ?, 1, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 0)";
		
		System.out.println("DAO userId : "+memberDTO.getUserId());

		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memberDTO.getUserId());
			ps.setString(2, memberDTO.getUserName());
			ps.setString(3, memberDTO.getUserHp());
			ps.setString(4, memberDTO.getUserEmail());
			ps.setString(5, memberDTO.getUserBirth());
			ps.setString(6, memberDTO.getUserGender());
			
			result = ps.executeUpdate();
			
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	public MemberDTO readMemberInfo(String nowId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		MemberDTO memberDTO = null;
		String sql = "SELECT USER_ID, USER_NAME, USER_PW, USER_HP, USER_ZIPCODE, USER_ADDR, USER_ADDRDETAIL, USER_EMAIL, USER_BIRTH, USER_GENDER, USER_STATE, USER_REGDATE, USER_BUYCOUNT "
				+ "FROM USERLIST WHERE USER_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nowId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString(1);
				String userName = rs.getString(2);
				String userPw = rs.getString(3);
				String userHp = rs.getString(4);
				String userZipcode = rs.getString(5);
				String userAddr = rs.getString(6);
				String userAddrDetail = rs.getString(7);
				String userEmail = rs.getString(8);
				String userBirth = rs.getString(9);
				String userGender = rs.getString(10);
				int userState = rs.getInt(11);
				String userRegDate = rs.getString(12);
				int userBuyCount = rs.getInt(13);
				
				memberDTO = new MemberDTO(userId, userName, userPw, userHp, userZipcode, userAddr, userAddrDetail, 
						userEmail, userBirth, userGender, userState, userRegDate, userBuyCount);
				
				System.out.println(userRegDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return memberDTO;
	}
	
	public List<MemberDTO> printAllMember() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		String sql = "SELECT USER_ID, USER_NAME, USER_PW, USER_HP, USER_ZIPCODE, USER_ADDR, USER_ADDRDETAIL, USER_EMAIL, USER_BIRTH, USER_GENDER, USER_STATE, USER_REGDATE, USER_BUYCOUNT FROM USERLIST";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String userId = rs.getString(1);
				String userName = rs.getString(2);
				String userPw = rs.getString(3);
				String userHp = rs.getString(4);
				String userZipcode = rs.getString(5);
				String userAddr = rs.getString(6);
				String userAddrDetail = rs.getString(7);
				String userEmail = rs.getString(8);
				String userBirth = rs.getString(9);
				String userGender = rs.getString(10);
				int userState = rs.getInt(11);
				String userRegDate = rs.getString(12);
				int userBuyCount = rs.getInt(13);
				
				MemberDTO memberDTO = new MemberDTO(userId, userName, userPw, userHp, userZipcode, userAddr, userAddrDetail, 
						userEmail, userBirth, userGender, userState, userRegDate, userBuyCount);
				
				memberList.add(memberDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return memberList;
	}
	
	public int updateMember(MemberDTO nowMemberDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = "INSERT INTO USERLIST(USER_ID, USER_NAME, USER_PW, USER_HP, USER_ZIPCODE, USER_ADDR, USER_ADDRDETAIL, USER_EMAIL, USER_BIRTH, USER_GENDER, USER_STATE, USER_REGDATE, USER_BUYCOUNT) "
				+ "VALUES(?, ?, '1234', ?, ?, ?, ?, ?, ?, ?, 1, ?, ?)";
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			result = deleteMember(con, nowMemberDTO);
			
			if(result==0) {
				con.rollback();
				throw new SQLException("회원이 없습니다");
			}
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nowMemberDTO.getUserId());
			ps.setString(2, nowMemberDTO.getUserName());
			ps.setString(3, nowMemberDTO.getUserHp());
			ps.setString(4, nowMemberDTO.getUserZipcode());
			ps.setString(5, nowMemberDTO.getUserAddr());
			ps.setString(6, nowMemberDTO.getUserAddrDetail());
			ps.setString(7, nowMemberDTO.getUserEmail());
			ps.setString(8, nowMemberDTO.getUserBirth());
			ps.setString(9, nowMemberDTO.getUserGender());
			ps.setString(10, nowMemberDTO.getUserRegDate());
			ps.setInt(11, nowMemberDTO.getUserBuyCount());
			
			result = ps.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public boolean isMember(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		boolean result = false;
		String sql = "SELECT * FROM USERLIST WHERE USER_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	
	public int deleteMember(Connection con, MemberDTO nowMemberDTO) {
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = "DELETE FROM USERLIST WHERE USER_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nowMemberDTO.getUserId());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	@Override
	public int leaveMember(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;
		String sql = "delete userlist where USER_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}
}
