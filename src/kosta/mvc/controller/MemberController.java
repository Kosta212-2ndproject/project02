package kosta.mvc.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.MemberDTO;
import kosta.mvc.dto.QuestionDTO;
import kosta.mvc.dto.ReviewDTO;
import kosta.mvc.service.MemberService;
import kosta.mvc.service.MemberServiceImpl;
import kosta.mvc.service.QuestionService;
import kosta.mvc.service.QuestionServiceImpl;
import kosta.mvc.service.ReviewService;
import kosta.mvc.service.ReviewServiceImpl;

public class MemberController implements Controller {
	
	private MemberService memberService = new MemberServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private ReviewService reviewService = new ReviewServiceImpl();

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
		session.setAttribute("userPhone", userHp);
		session.setAttribute("userEmail", userEmail);

		ModelAndView mv = new ModelAndView("index.jsp", true);
		return mv;
	}
	
	/**
	 * 로그아웃
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 모든 세션의 정보 만료시키기
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new ModelAndView("index.jsp", true);
	}

	/**
	 * 회원정보조회
	 */
	public ModelAndView readMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String nowId = (String)session.getAttribute("userId");
		
		System.out.println(nowId);
		
		MemberDTO memberDTO = memberService.readMemberInfo(nowId);
		
		request.setAttribute("member", memberDTO); // 뷰로 전달될 데이터 -> ${member}
		
		// 데이터를 가지고 가므로 forward 방식 사용! false
		ModelAndView mv = new ModelAndView("member_detail.jsp", false);
		return mv;
	}
	
	/**
	 * 회원정보수정
	 */
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userId");
		String userName = request.getParameter("userName");
		String userHp = request.getParameter("userHp");
		String userZipcode = request.getParameter("userZipcode");
		String userAddr = request.getParameter("userAddr");
		String userAddrDetail = request.getParameter("userAddrDetail");
		String userEmail=request.getParameter("userEmail");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		String userRegDate = request.getParameter("userRegDate");
		int userBuyCount = Integer.parseInt(request.getParameter("userBuyCount"));
		
		MemberDTO memberDTO = new MemberDTO(userId, userName, "1234", userHp, userZipcode, userAddr, userAddrDetail, userEmail, userBirth, userGender, 1, userRegDate, userBuyCount);
		
		memberService.updateMember(memberDTO);
		
		memberDTO = memberService.readMemberInfo(userId);
		request.setAttribute("member", memberDTO);
		
		// 데이터를 가지고 가므로 forward 방식 사용! false
		ModelAndView mv = new ModelAndView("member_detail.jsp", false);
		return mv;
	}
	
	/**
	 * 회원탈퇴
	 */
	public ModelAndView leaveMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userId");
		
		memberService.leaveMember(userId);
		session.invalidate();
		
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * 회원리뷰조회
	 */
	public ModelAndView memberReview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String userId = (String) request.getSession().getAttribute("userId");
		System.out.println(userId);
	
		List<ReviewDTO> review = reviewService.selectByUserId(userId);

		request.setAttribute("review", review);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member_review.jsp");
		return mv;
	}
	
	/**
	 * 회원질문조회
	 */
	public ModelAndView memberQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String userId = (String) request.getSession().getAttribute("userId");
		System.out.println(userId);
		
		List<QuestionDTO> question = questionService.selectByUserId(userId);

		request.setAttribute("question", question);
		
		ModelAndView mv = new ModelAndView();

		mv.setViewName("member_question.jsp");
		return mv;
	}
}
