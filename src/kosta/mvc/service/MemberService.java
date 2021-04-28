package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dto.MemberDTO;

public interface MemberService {
	/**
	 * 회원가입
	 */
	void insertMember(MemberDTO memberDTO) throws SQLException;
}
