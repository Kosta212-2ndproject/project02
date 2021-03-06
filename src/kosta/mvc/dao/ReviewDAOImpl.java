package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ReviewDTO;
import kosta.mvc.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select * from review order by REVIEW_REGDATE desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
//				ReviewDTO review = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), 
//						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
				ReviewDTO review = new ReviewDTO(rs.getInt("REVIEW_ID"), rs.getInt("PROD_ID"), rs.getString("USER_ID"), rs.getInt("O_NO"), 
						rs.getString("REVIEW_TITLE"), rs.getString("REVIEW_CONTENT"), rs.getInt("REVIEW_STAR_SCOPE"), 
						rs.getString("REVIEW_REGDATE"), rs.getString("REVIEW_IMG_URL"), rs.getInt("REVIEW_VCOUNT"));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ReviewDTO>  selectByProdId(int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select * from review where PROD_ID = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getInt("REVIEW_ID"), rs.getInt("PROD_ID"), rs.getString("USER_ID"), rs.getInt("O_NO"), 
						rs.getString("REVIEW_TITLE"), rs.getString("REVIEW_CONTENT"), rs.getInt("REVIEW_STAR_SCOPE"), 
						rs.getString("REVIEW_REGDATE"), rs.getString("REVIEW_IMG_URL"), rs.getInt("REVIEW_VCOUNT"));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	@Override
	public int selectByProdIdCnt(int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int res =0;
		String sql = "select count(*) from review where PROD_ID = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				res = rs.getInt(1);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return res;
	}

	@Override
	public List<ReviewDTO>  selectByUserId(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select * from review where USER_ID = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReviewDTO review = new ReviewDTO(rs.getInt("REVIEW_ID"), rs.getInt("PROD_ID"), rs.getString("USER_ID"), rs.getInt("O_NO"), 
						rs.getString("REVIEW_TITLE"), rs.getString("REVIEW_CONTENT"), rs.getInt("REVIEW_STAR_SCOPE"), 
						rs.getString("REVIEW_REGDATE"), rs.getString("REVIEW_IMG_URL"), rs.getInt("REVIEW_VCOUNT"));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int increamentByReadnum(int reviewId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "update review set REVIEW_VCOUNT = REVIEW_VCOUNT+1 where review_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewId);
			res = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

	@Override
	public int insert(ReviewDTO review) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		//???10?????????
		String sql = "insert into review values(REVIEW_ID_SEQ.NEXTVAL,?,?,?,?,?,?,sysdate,?,0)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, review.getProdId());
			ps.setString(2, review.getUserId());
			ps.setInt(3, review.getoNum());
			ps.setString(4, review.getReviewTitle());
			ps.setString(5, review.getReviewContent());
			ps.setInt(6, review.getReviewStarScope());
			ps.setString(7, review.getReviewImgUrl());
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

	@Override
	public int delete(int reviewId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "delete review where REVIEW_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewId);
			
			res = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return res;
	}

	@Override
	public int update(ReviewDTO review) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int res = 0;
		String sql = "update review set REVIEW_TITLE=?,REVIEW_CONTENT=?,REVIEW_STAR_SCOPE=?, REVIEW_IMG_URL=? where REVIEW_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, review.getReviewTitle());
			ps.setString(2, review.getReviewContent());
			ps.setInt(3, review.getReviewStarScope());
			ps.setString(4, review.getReviewImgUrl());
			ps.setInt(5, review.getReviewId());
			
			res = ps.executeUpdate();
			
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return res;
	}

	@Override
	public ReviewDTO selectReview(int reviewId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReviewDTO reviewDTO = null;
		String sql = "select * from review where REVIEW_ID=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
//				ReviewDTO review = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), 
//						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			  reviewDTO = new ReviewDTO(rs.getInt("REVIEW_ID"), rs.getInt("PROD_ID"), rs.getString("USER_ID"), rs.getInt("O_NO"), 
						rs.getString("REVIEW_TITLE"), rs.getString("REVIEW_CONTENT"), rs.getInt("REVIEW_STAR_SCOPE"), 
						rs.getString("REVIEW_REGDATE"), rs.getString("REVIEW_IMG_URL"), rs.getInt("REVIEW_VCOUNT"));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return reviewDTO;
	}

	/**
	 * ?????? ?????? ?????? 3??? select
	 * select rownum as rnum, A.user_id, A.review_title, A.review_content, A.review_star_scope, A.review_img_url from ( select user_id, review_title, review_content, review_star_scope, review_img_url from review order by review_star_scope desc) A where rownum between 1 and 3;
	 * */
	@Override
	public List<ReviewDTO> bestReviewselect() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		String sql = "select rownum as rnum, A.user_id, A.review_title, A.review_content, A.review_star_scope, A.review_img_url from ( select user_id, review_title, review_content, review_star_scope, review_img_url from review order by review_star_scope desc) A where rownum between 1 and 3";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
//				ReviewDTO review = new ReviewDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), 
//						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
				ReviewDTO review = new ReviewDTO(rs.getInt(1), rs.getString("USER_ID"), rs.getString("REVIEW_TITLE"), rs.getString("REVIEW_CONTENT"), rs.getInt("REVIEW_STAR_SCOPE"), rs.getString("REVIEW_IMG_URL"));
				list.add(review);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}


}
