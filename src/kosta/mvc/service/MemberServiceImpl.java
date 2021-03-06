package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.MemberDAO;
import kosta.mvc.dao.MemberDAOImpl;
import kosta.mvc.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO = new MemberDAOImpl();

	@Override
	public void insertMember(MemberDTO memberDTO) throws SQLException {
		int result = memberDAO.insertMember(memberDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다");
		// 로그인 api에서 인증이 되면 안되니까 여기서 에러띄워야할듯
	}

	@Override
	public boolean isMember(String userId) throws SQLException {
		boolean result = memberDAO.isMember(userId);
		return result;
	}

	@Override
	public MemberDTO readMemberInfo(String nowId) {
		MemberDTO memberDTO = memberDAO.readMemberInfo(nowId);
		return memberDTO;
	}

	@Override
	public void updateMember(MemberDTO memberDTO) throws SQLException {
		int result = memberDAO.updateMember(memberDTO);
		if(result==0) throw new SQLException("수정되지 않았습니다");
	}

	@Override
	public void leaveMember(String userId) throws SQLException {
		int result = memberDAO.leaveMember(userId);
		if(result==0) throw new SQLException("탈퇴되지 않았습니다. 운영자에게 문의 해 주세요.");
	}

	@Override
	public List<MemberDTO> memberSelectAll() throws SQLException {
		List<MemberDTO> memberList = memberDAO.printAllMember();
		return memberList;
	}

}
