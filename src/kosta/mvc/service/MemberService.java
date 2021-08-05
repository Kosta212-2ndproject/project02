package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.MemberDTO;

public interface MemberService {
	/**
	 * 회원가입
	 */
	void insertMember(MemberDTO memberDTO) throws SQLException;
	
	/**
	 * 회원가입 여부 확인
	 */
	boolean isMember(String userId) throws SQLException;
	
	/**
	 * 회원정보조회
	 */
	MemberDTO readMemberInfo(String nowId);
	
	/**
	 * 회원정보수정
	 */
	void updateMember(MemberDTO memberDTO) throws SQLException;
	
	/**
	 * 회원탈퇴
	 */
	void leaveMember(String userId) throws SQLException;
	
	/**
	 * 회원목록조회
	 */
	List<MemberDTO> memberSelectAll() throws SQLException;
}
