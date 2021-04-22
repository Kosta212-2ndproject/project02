package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.AnswerDAO;
import kosta.mvc.dao.AnswerDAOImpl;
import kosta.mvc.dto.AnswerDTO;

public class AnswerServiceImpl implements AnswerService {
	private AnswerDAO aDAO = new AnswerDAOImpl();
	
	@Override
	public List<AnswerDTO> selectByQNum(int qNum) throws SQLException {
		List<AnswerDTO> list = aDAO.selectByQNum(qNum);
		return list;
	}

	@Override
	public List<AnswerDTO> selectByUserId(String userId) throws SQLException {
		List<AnswerDTO> list = aDAO.selectByUserId(userId);
		return list;
	}

	@Override
	public AnswerDTO selectByANum(int aNum) throws SQLException {
		AnswerDTO answer = aDAO.selectByANum(aNum);
		if(answer == null) {
			throw new SQLException("정보를 검색하지 못했습니다.");
		}
		return answer;
	}

	@Override
	public void insert(AnswerDTO answer) throws SQLException {

		int res = aDAO.insert(answer);
		if(res == 0) throw new SQLException("등록되지 않았습니다");
	}

	@Override
	public void delete(int aNum) throws SQLException {

		int res = aDAO.delete(aNum);
		if(res == 0) throw new SQLException("삭제되지 않았습니다");
	}

	@Override
	public void update(AnswerDTO answer) throws SQLException {
		int res = aDAO.update(answer);
		if(res == 0) throw new SQLException("수정되지 않았습니다");
	}

}
