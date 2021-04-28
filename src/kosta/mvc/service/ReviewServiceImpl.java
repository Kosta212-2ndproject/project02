package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.ReviewDAO;
import kosta.mvc.dao.ReviewDAOImpl;
import kosta.mvc.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {

	private ReviewDAO rDAO = new ReviewDAOImpl();
	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		List<ReviewDTO> list = rDAO.selectAll();
		return list;
	}

	@Override
	public List<ReviewDTO> selectByProdId(String prodId) throws SQLException {
		List<ReviewDTO> list = rDAO.selectByProdId(prodId);
		return list;
	}

	@Override
	public List<ReviewDTO> selectByUserId(String userId) throws SQLException {
		List<ReviewDTO> list = rDAO.selectByUserId(userId);
		return list;
	}

	@Override
	public void insert(ReviewDTO review) throws SQLException {
		int res = rDAO.insert(review);
		if(res == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}

	@Override
	public void delete(int reviewId) throws SQLException {
		int res = rDAO.delete(reviewId);
		if(res == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}

	@Override
	public void update(ReviewDTO review) throws SQLException {
		int res = rDAO.update(review);
				
		if(res == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}
		
	}


	@Override
	public ReviewDTO selectReview(int reviewId) throws SQLException {
		ReviewDTO rDTO = rDAO.selectReview(reviewId);
		
		return rDTO;
	}

}
