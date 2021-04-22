package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.AnswerDTO;

public class AnswerServiceImpl implements AnswerService {

	@Override
	public List<AnswerDTO> selectByQNum(int qNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnswerDTO> selectByUserId(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnswerDTO selectByANum(int aNum, boolean flag) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AnswerDTO answer) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int aNum) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AnswerDTO answer) throws SQLException {
		// TODO Auto-generated method stub

	}

}
