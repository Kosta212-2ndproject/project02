package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.NoticeDTO;

public interface NoticeDAO {

	/**
	  * ������ ��ü �˻� 
	  * */
	  List<NoticeDTO> selectAll() throws SQLException;
	  
	  /**
	   * Ư��Ű���忡 �ش��ϴ� ������ �˻�
	   * */
	  List<NoticeDTO> selectByKeyword(String keyword) throws SQLException;
	  
	  
	  /**
	   * �����۹�ȣ�� �ش��ϴ� ������ �˻�
	   * */
	  NoticeDTO selectByNoticeNum(int nNum) throws SQLException;
	  
	  
	  /**
	   * ������ ���
	   * @return : 1-��ϼ��� , 0 - ��Ͻ���
	   * */
	  int insert(NoticeDTO notice) throws SQLException;
	  
	  
	  /**
	   * �����۹�ȣ �ش��ϴ� ������ ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(int nNum) throws SQLException;
	  
	   /**
	    * ������ �ش��ϴ� ������ ����
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(NoticeDTO notice) throws SQLException;
}
