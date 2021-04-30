package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.AnswerDTO;
import kosta.mvc.util.DbUtil;

public class AnswerDAOImpl implements AnswerDAO {

	@Override
	public List<AnswerDTO> selectByQNum(int qNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		String sql = "select * from ANSWER order by A_REGDATE desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int aNum = rs.getInt(1);
				qNum = rs.getInt(2);
				String aContent = rs.getString(3);
				String aAnsId = rs.getString(4);
				String aRegdate= rs.getString(5);
				AnswerDTO answer = new AnswerDTO(aNum, qNum, aContent, aAnsId, aRegdate);
				
				list.add(answer);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<AnswerDTO> selectByUserId(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AnswerDTO> list = new ArrayList<AnswerDTO>();
		String sql = "select * from ANSWER where A_ANSID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int aNum = rs.getInt(1);
				int qNum = rs.getInt(2);
				String aContent = rs.getString(3);
				String aAnsId = rs.getString(4);
				String aRegdate= rs.getString(5);
				AnswerDTO answer = new AnswerDTO(aNum, qNum, aContent, aAnsId, aRegdate);
				
				list.add(answer);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public AnswerDTO selectByANum(int aNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AnswerDTO aDTO = null;
		String sql = "select * from ANSWER where A_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, aNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				aNum = rs.getInt(1);
				int qNum = rs.getInt(2);
				String aContent = rs.getString(3);
				String aAnsId = rs.getString(4);
				String aRegdate= rs.getString(5);
				aDTO = new AnswerDTO(aNum, qNum, aContent, aAnsId, aRegdate);
				
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return aDTO;
	}

	@Override
	public int insert(AnswerDTO answer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		//총9개컬럼 중 7개
		String sql = "insert into ANSWER values(A_NUM_SEQ.NEXTVAL,?,?,?,sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, answer.getqNum());
			ps.setString(2, answer.getaContent());
			ps.setString(3, answer.getaAnsId());
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

	@Override
	public int delete(int aNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		//총9개컬럼 중 7개
		String sql = "delete ANSWER where A_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, aNum);
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

	@Override
	public int update(AnswerDTO answer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		//총9개컬럼 중 7개
		String sql = "update ANSWER set A_CONTENT=?,A_REGDATE=sysdate where A_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, answer.getaContent());
			ps.setInt(2, answer.getaNum());
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

}
