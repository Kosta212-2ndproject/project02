package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.QuestionDTO;


public interface QuestionDAO {

	/**
	  * ���� ��ü �˻� 
	  * */
	  List<QuestionDTO> selectAll() throws SQLException;
	  
	  /**
	   * ��ǰ��ȣ�� �ش��ϴ� question �˻�
	   * */
	  QuestionDTO selectByModelNum(String prodId) throws SQLException;
	  
	  /**
	   * ȸ�����̵� �ش��ϴ� question �˻�
	   * */
	  QuestionDTO selectByUserId(String userId) throws SQLException;
	  
	  /**
	   * ������ȣ�� �ش��ϴ� question �˻�
	   * */
	  QuestionDTO selectByUserId(int qNum) throws SQLException;
	  
	  
	  /**
	   * question ���
	   * @return : 1-��ϼ��� , 0 - ��Ͻ���
	   * */
	  int insert(QuestionDTO question) throws SQLException;
	  
	  /**
	   * ������ȣ�� �ش��ϴ� question ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(int qNum) throws SQLException;
	  
	   /**
	    * ��ǰ��ȣ�� �ش��ϴ� question ����
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(QuestionDTO question) throws SQLException;
}
