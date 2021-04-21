package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.AnswerDTO;

public interface AnswerDAO {
	/**
	  * ������ȣ�� ���� �亯�� �˻��ϱ�
	  * */
	  List<AnswerDTO> selectByQNum(int qNum) throws SQLException;
	  
	  /**
	   * ������ ���̵�� �亯 �˻�
	   * */
	  List<AnswerDTO> selectByUserId(String userId) throws SQLException;
	  
	  /**
	   * �亯��ȣ�� �ش��ϴ� �亯 �˻�
	   * */
	  AnswerDTO selectByANum(int aNum) throws SQLException;
	  
	  
	  /**
	   * �亯 ���
	   * @return : 1-��ϼ��� , 0 - ��Ͻ���
	   * */
	  int insert(AnswerDTO answer) throws SQLException;
	  
	  /**
	   * �亯��ȣ�� �ش��ϴ� �亯 ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(int aNum) throws SQLException;
	  
	   /**
	    * �亯��ȣ�� �ش��ϴ� �亯 ����
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(AnswerDTO question) throws SQLException;
}
