package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.ReviewDTO;



public interface ReviewDAO {

	/**
	  * review ��ü �˻� 
	  * */
	  List<ReviewDTO> selectAll() throws SQLException;
	  
	  /**
	   * ��ǰ��ȣ�� �ش��ϴ� review �˻�
	   * */
	  ReviewDTO selectByModelNum(String prodId) throws SQLException;
	  
	  /**
	   * userId �ش��ϴ� review �˻�
	   * */
	  ReviewDTO selectByUserId(String userId) throws SQLException;
	  
	  /**
	   * ��ȸ���� �����ϴ� ���
	   * update Electronics set readnum = readnum + 1 where model_num=?
	   * */
	  int increamentByReadnum(String prodId) throws SQLException;
	  
	  
	  /**
	   * review ���
	   * @return : 1-��ϼ��� , 0 - ��Ͻ���
	   * */
	  int insert(ReviewDTO review) throws SQLException;
	  
	  /**
	   * ��ǰ��ȣ�� �ش��ϴ� review ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(String prodId) throws SQLException;
	  
	   /**
	    * ��ǰ��ȣ�� �ش��ϴ� review ����
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(ReviewDTO review) throws SQLException;
}
