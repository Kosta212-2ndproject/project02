package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kosta.mvc.dto.NoticeDTO;
import kosta.mvc.util.DbUtil;

public class NoticeDAOImpl implements NoticeDAO {
	
	/**
	 * 해당 테이블 총 데이터 개수 반환 
	 * */
	public int selectCnt() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int res=0;
		String sql = "select count(*) from NOTICE";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				res = rs.getInt(1);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return res;
	}


	public List<NoticeDTO> selectPage(int start, int end) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		String sql = "SELECT B.RNUM, B.N_NUM,B.N_TITLE,B.N_CONTENT,B.N_IMAGE,B.N_REGDATE,B.N_VIEWCOUNT,B.N_FIELD"
				+ "FROM("
				+ "SELECT ROWNUM AS RNUM,A.N_NUM, A.N_TITLE,A.N_CONTENT,A.N_IMAGE,A.N_REGDATE,A.N_VIEWCOUNT,A.N_FIELD"
				+ "FROM ("
				+ "    select N_NUM, N_TITLE,N_CONTENT,N_IMAGE,N_REGDATE,N_VIEWCOUNT,N_FIELD from NOTICE"
				+ "    order by N_REGDATE desc)"
				+ "    WHERE ROWNUM <= ?) B"
				+ "WHERE B.RNUM >=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int nNum = rs.getInt(1);
				String nTitle = rs.getString(2);
				String nContent = rs.getString(3);
				String nImage = rs.getString(4);
				String nRegdate = rs.getString(5);
				int nViewCount = rs.getInt(6);
				int nField= rs.getInt(7);
				
				NoticeDTO notice = new NoticeDTO(nNum, nTitle, nContent, nImage, nRegdate, nViewCount, nField);
				list.add(notice);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	@Override
	public List<NoticeDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		String sql = "select * from NOTICE order by N_REGDATE desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int nNum = rs.getInt(1);
				String nTitle = rs.getString(2);
				String nContent = rs.getString(3);
				String nImage = rs.getString(4);
				String nRegdate = rs.getString(5);
				int nViewCount = rs.getInt(6);
				int nField= rs.getInt(7);
				
				NoticeDTO notice = new NoticeDTO(nNum, nTitle, nContent, nImage, nRegdate, nViewCount, nField);
				list.add(notice);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<NoticeDTO> selectByKeyword(String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		String sql = "select * from NOTICE where N_TITLE like ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int nNum = rs.getInt(1);
				String nTitle = rs.getString(2);
				String nContent = rs.getString(3);
				String nImage = rs.getString(4);
				String nRegdate = rs.getString(5);
				int nViewCount = rs.getInt(6);
				int nField= rs.getInt(7);
				
				NoticeDTO notice = new NoticeDTO(nNum, nTitle, nContent, nImage, nRegdate, nViewCount, nField);
				list.add(notice);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public NoticeDTO selectByNoticeNum(int nNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		NoticeDTO nDTO = null;
		String sql = "select * from NOTICE where N_NUM = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, nNum);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				nNum = rs.getInt(1);
				String nTitle = rs.getString(2);
				String nContent = rs.getString(3);
				String nImage = rs.getString(4);
				String nRegdate = rs.getString(5);
				int nViewCount = rs.getInt(6);
				int nField= rs.getInt(7);
				
				nDTO = new NoticeDTO(nNum, nTitle, nContent, nImage, nRegdate, nViewCount, nField);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return nDTO;
	}

	@Override
	public int insert(NoticeDTO notice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "insert into NOTICE values(N_NUM_SEQ.NEXTVAL,?,?,?,sysdate,0,?)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, notice.getnTitle());
			ps.setString(2, notice.getnContent());
			ps.setString(3, notice.getnImage());
			ps.setInt(4, notice.getnField());
			
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return res;
	}

	@Override
	public int delete(int nNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "delete NOTICE where N_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, nNum);
			
			res = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return res;
	}

	@Override
	public int update(NoticeDTO notice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "update NOTICE set N_TITLE=?,N_CONTENT=?,N_IMAGE=?, N_FIELD=?, N_REGDATE=sysdate where N_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, notice.getnTitle());
			ps.setString(2, notice.getnContent());
			ps.setString(3, notice.getnImage());
			ps.setInt(4, notice.getnField());
			ps.setInt(5, notice.getnNum());
			
			res = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return res;
	}

	@Override
	public int increamentByReadnum(int nNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "update NOTICE set N_VIEWCOUNT = N_VIEWCOUNT+1 where N_NUM=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, nNum);
			res = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

}
