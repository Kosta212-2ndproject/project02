package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.NoticeDAO;
import kosta.mvc.dao.NoticeDAOImpl;
import kosta.mvc.dto.NoticeDTO;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO nDAO = new NoticeDAOImpl();

	@Override
	public List<NoticeDTO> selectAll() throws SQLException {
		List<NoticeDTO> list = nDAO.selectAll();
		return list;
	}

	@Override
	public List<NoticeDTO> selectByKeyword(String keyword) throws SQLException {
		List<NoticeDTO> list = nDAO.selectByKeyword(keyword);
		return list;
	}

	@Override
	public NoticeDTO selectByNoticeNum(int nNum) throws SQLException {
		NoticeDTO notice = nDAO.selectByNoticeNum(nNum);
		if(notice == null) {
			throw new SQLException("정보를 검색하지 못했습니다.");
		}
		return notice;
	}

	@Override
	public void insert(NoticeDTO notice) throws SQLException {
		int res = nDAO.insert(notice);
		if(res == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}

	}

	@Override
	public void delete(int nNum) throws SQLException {
		int res = nDAO.delete(nNum);
		if(res == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}

	@Override
	public void update(NoticeDTO notice) throws SQLException {
		int res = nDAO.update(notice);
		if(res == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}

}
