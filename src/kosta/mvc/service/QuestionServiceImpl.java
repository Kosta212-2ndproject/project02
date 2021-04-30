package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.QuestionDAO;
import kosta.mvc.dao.QuestionDAOImpl;
import kosta.mvc.dto.AnswerDTO;
import kosta.mvc.dto.QuestionDTO;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDAO qDAO = new QuestionDAOImpl();
	@Override
	public List<QuestionDTO> selectAll() throws SQLException {
		List<QuestionDTO> list = qDAO.selectAll();
		return list;
	}

	@Override
	public List<QuestionDTO> selectByProdId(int prodId) throws SQLException {
		List<QuestionDTO> list = qDAO.selectByProdId(prodId);
		return list;
	}

	@Override
	public List<QuestionDTO> selectByUserId(String userId) throws SQLException {
		List<QuestionDTO> list = qDAO.selectByUserId(userId);
		return list;
	}

	@Override
	public QuestionDTO selectByQNum(int qNum) throws SQLException {
		QuestionDTO question = qDAO.selectByQNum(qNum);
		if(question == null) {
			throw new SQLException("정보를 검색하지 못했습니다.");
		}
		return question;
	}

	@Override
	public void insert(QuestionDTO question) throws SQLException {
		int res = qDAO.insert(question);
		if(res == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}

	@Override
	public void delete(int qNum) throws SQLException {
		int res = qDAO.delete(qNum);
		if(res == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}

	@Override
	public void update(QuestionDTO question) throws SQLException {
		int res = qDAO.update(question);
		if(res == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}

	@Override
	public List<QuestionDTO> boardAnswerSelectAll() throws SQLException {
		List<QuestionDTO> list = qDAO.boardAnswerSelectAll();
		return list;
	}

	@Override
	public List<QuestionDTO> boardSelectByKeyword(String keyWord) throws SQLException {
		List<QuestionDTO> list = qDAO.boardSelectByKeyword(keyWord);
		return list;
	}

	@Override
	public int answerBoardInsert(AnswerDTO answer) throws SQLException {
		int res = qDAO.answerBoardInsert(answer);
		if(res == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}
		return res;
	}

	@Override
	public QuestionDTO answerSelectByBoardNo(int qNum) throws SQLException {
		QuestionDTO qDTO = qDAO.answerSelectByBoardNo(qNum);
		if(qDTO==null) {
			throw new SQLException("정보를 검색하지 못했습니다");
		}
		return qDTO;
	}

}
