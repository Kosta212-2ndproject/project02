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
				+ "VALUES(?, ?, '1234', ?, ?, ?, ?, 1, SYSDATE, 0)";
		
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
		String sql = "SELECT * FROM USERLIST WHERE USER_ID=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nowId);
			
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
		String sql = "SELECT * FROM USERLIST";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
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
		String sql = "INSERT INTO USERLIST(USER_ID, USER_NAME, USER_PW, USER_HP, USER_EMAIL, USER_BIRTH, USER_GENDER, USER_STATE, USER_REGDATE, USER_BUYCOUNT) "
				+ "VALUES(?, ?, '1234', ?, ?, ?, ?, 1, SYSDATE, 0)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, nowMemberDTO.getUserId());
			ps.setString(2, nowMemberDTO.getUserName());
			ps.setString(3, nowMemberDTO.getUserHp());
			ps.setString(4, nowMemberDTO.getUserEmail());
			ps.setString(5, nowMemberDTO.getUserBirth());
			ps.setString(6, nowMemberDTO.getUserGender());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}
	
	public int deleteMember(Connection con, MemberDTO nowMemberDTO) {
		
		
	}
}
