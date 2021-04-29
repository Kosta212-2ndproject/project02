package kosta.mvc.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.MemberDTO;
import kosta.mvc.service.MemberService;
import kosta.mvc.service.MemberServiceImpl;

public class MemberController implements Controller {
	
	private MemberService memberService = new MemberServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}
	
	
	/**
	 * 회원가입
	 */
	public ModelAndView insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("naverCode");
		String userName=request.getParameter("name");
		String userEmail=request.getParameter("email");
		String userGender=request.getParameter("gender");
		String userBirth=request.getParameter("birth");
		String userHp=request.getParameter("mobile");
		
		//System.out.println("Controller userId : " + userId);
		
		MemberDTO memberDTO = new MemberDTO(userId, userName, "1234", userHp, userEmail, userBirth, userGender, 1, "SYSDATE", 0);
		
		if(memberService.isMember(userId)==false) {
			memberService.insertMember(memberDTO);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		session.setAttribute("userId", userId);
		
		ModelAndView mv = new ModelAndView("index.html", true);
		return mv;
	}
	
}
