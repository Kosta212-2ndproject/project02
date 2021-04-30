package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.AnswerDTO;
import kosta.mvc.dto.QuestionDTO;

public interface QuestionService {

	/**
	 * 질문 전체 검색
	 */
	List<QuestionDTO> selectAll() throws SQLException;

	/**
	 * 
	 * 질문 + 답변 전체 검색
	 */
	List<QuestionDTO> boardAnswerSelectAll() throws SQLException;

	/**
	 * 키워드 검색
	 */
	List<QuestionDTO> boardSelectByKeyword(String keyWord) throws SQLException;

	/**
	 * 상품번호에 해당하는 question 검색
	 */
	List<QuestionDTO> selectByProdId(int prodId) throws SQLException;

	/**
	 * 회원아이디 해당하는 question 검색
	 */
	List<QuestionDTO> selectByUserId(String userId) throws SQLException;

	/**
	 * 질문번호에 해당하는 question 검색
	 */
	QuestionDTO selectByQNum(int qNum) throws SQLException;

	/**
	 * question 등록
	 * 
	 * @return : 1-등록성공 , 0 - 등록실패
	 */
	void insert(QuestionDTO question) throws SQLException;

	/**
	 * 질문번호에 해당하는 question 삭제
	 * 
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 */
	void delete(int qNum) throws SQLException;

	/**
	 * 상품번호에 해당하는 question 수정
	 * 
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	void update(QuestionDTO question) throws SQLException;

	/**
	 * 부모글에 대한(질문) 답변 등록하기
	 */
	int answerBoardInsert(AnswerDTO answer) throws SQLException;

	/**
	 * 부모글에 대한(질문) 답변 정보검색
	 */
	QuestionDTO answerSelectByBoardNo(int qNum) throws SQLException;

}
