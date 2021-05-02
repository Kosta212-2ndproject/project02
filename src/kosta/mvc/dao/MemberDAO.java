package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.MemberDTO;

public interface MemberDAO {
	
	/**
	 * 회원가입
	 *  : 로그인 api로 최초로 받아온 값을 등록
	 */
	int insertMember(MemberDTO memberDTO) throws SQLException;
	
	/**
	 * 회원정보조회
	 */
	MemberDTO readMemberInfo(String nowId);
	
	/**
	 * 회원정보수정
	 */
	int updateMember(MemberDTO memberDTO) throws SQLException;
	
	/**
	 * 관리자 : 전체 회원 조회
	 */
	List<MemberDTO> printAllMember();
	
	/**
	 * 회원가입 여부 체크
	 */
	boolean isMember(String userId) throws SQLException;
	
	/**
	 * 회원탈퇴
	 */
	int leaveMember(String userId) throws SQLException;
}
