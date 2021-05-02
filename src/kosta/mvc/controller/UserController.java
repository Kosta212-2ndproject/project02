package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.QuestionDTO;
import kosta.mvc.dto.ReviewDTO;
import kosta.mvc.service.AnswerService;
import kosta.mvc.service.AnswerServiceImpl;
import kosta.mvc.service.ProductService;
import kosta.mvc.service.ProductServiceImpl;
import kosta.mvc.service.QuestionService;
import kosta.mvc.service.QuestionServiceImpl;
import kosta.mvc.service.ReviewService;
import kosta.mvc.service.ReviewServiceImpl;

public class UserController implements Controller {
	private QuestionService questionService = new QuestionServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	private ReviewService reviewService = new ReviewServiceImpl();
	private AnswerService answerService = new AnswerServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * MyPage 클릭시 나오는 화면 
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		String userId = (String) request.getSession().getAttribute("userId");
		System.out.println(userId);
		
		
		List<QuestionDTO> question = questionService.selectByUserId(userId);
		List<ReviewDTO> review = reviewService.selectByUserId(userId);
//		ProductDTO prod = productService.selectByProductDetail(Integer.parseInt(prodId));
//		request.setAttribute("prod", prod);
		request.setAttribute("review", review);
		request.setAttribute("question", question);
		
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("front?key=prod&methodName=selectByProductDetail&prodId="+prodId);
//		mv.setRedirect(true);
		mv.setViewName("user-main.jsp");
		return mv;
		
	}
	
	
	
	
	
	

}
