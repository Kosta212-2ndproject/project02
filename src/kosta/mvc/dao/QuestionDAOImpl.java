package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.QuestionDTO;
import kosta.mvc.util.DbUtil;

public class QuestionDAOImpl implements QuestionDAO {

	@Override
	public List<QuestionDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		String sql = "select * from QUESTION order by Q_REGDATE desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int qNum = rs.getInt(1);
				String userId = rs.getString(2);
				int prodId = rs.getInt(3);
				String qField = rs.getString(4);
				String qTitle = rs.getString(5);
				String qContent = rs.getString(6);
				String qFiles = rs.getString(7);
				String qRegdate = rs.getString(8);
				int qShowstatus = rs.getInt(9);
				
				QuestionDTO question = new QuestionDTO(qNum, userId, prodId, qField, qTitle, qContent, qFiles, qRegdate, qShowstatus);
						
				list.add(question);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<QuestionDTO> selectByProdId(int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		String sql = "select * from QUESTION where PROD_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int qNum = rs.getInt(1);
				String userId = rs.getString(2);
				prodId = rs.getInt(3);
				String qField = rs.getString(4);
				String qTitle = rs.getString(5);
				String qContent = rs.getString(6);
				String qFiles = rs.getString(7);
				String qRegdate = rs.getString(8);
				int qShowstatus = rs.getInt(9);
				
				QuestionDTO question = new QuestionDTO(qNum, userId, prodId, qField, qTitle, qContent, qFiles, qRegdate, qShowstatus);
						
				list.add(question);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<QuestionDTO> selectByUserId(String userId) throws SQLException {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		String sql = "select * from QUESTION where USER_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int qNum = rs.getInt(1);
				userId = rs.getString(2);
				int prodId = rs.getInt(3);
				String qField = rs.getString(4);
				String qTitle = rs.getString(5);
				String qContent = rs.getString(6);
				String qFiles = rs.getString(7);
				String qRegdate = rs.getString(8);
				int qShowstatus = rs.getInt(9);
				
				QuestionDTO question = new QuestionDTO(qNum, userId, prodId, qField, qTitle, qContent, qFiles, qRegdate, qShowstatus);
						
				list.add(question);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public QuestionDTO selectByQNum(int qNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		QuestionDTO qDTO = null;
		String sql = "select * from QUESTION where Q_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qNum);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				qNum = rs.getInt(1);
				String userId = rs.getString(2);
				int prodId = rs.getInt(3);
				String qField = rs.getString(4);
				String qTitle = rs.getString(5);
				String qContent = rs.getString(6);
				String qFiles = rs.getString(7);
				String qRegdate = rs.getString(8);
				int qShowstatus = rs.getInt(9);
				
				qDTO = new QuestionDTO(qNum, userId, prodId, qField, qTitle, qContent, qFiles, qRegdate, qShowstatus);
						
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return qDTO;
	}

	@Override
	public int insert(QuestionDTO question) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		//총9개컬럼 중 7개
		String sql = "insert into QUESTION values(Q_NUM_SEQ.NEXTVAL,?,?,?,?,?,?,sysdate,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, question.getUserId());
			ps.setInt(2, question.getProdId());
			ps.setString(3, question.getqField());
			ps.setString(4, question.getqTitle());
			ps.setString(5, question.getqContent());
			ps.setString(6, question.getqFiles());
			ps.setInt(7, question.getqShowstatus());
			
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

	@Override
	public int delete(int qNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "delete QUESTION where Q_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qNum);
			
			res = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return res;
	}

	@Override
	public int update(QuestionDTO question) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "update QUESTION set Q_FIELD=?,Q_TITLE=?,Q_CONTENT=?, Q_FILES=?, Q_SHOWSTATUS=? where Q_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, question.getqField());
			ps.setString(2, question.getqTitle());
			ps.setString(3, question.getqContent());
			ps.setString(4, question.getqContent());
			ps.setString(5, question.getqFiles());
			ps.setInt(6, question.getqShowstatus());
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

}
