package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.WishDTO;
import kosta.mvc.service.WishService;
import kosta.mvc.service.WishServiceImpl;

public class WishController implements Controller {

	private WishService wishService = new WishServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}
	
	/**
	 * 회원별 관심조회
	 */
	public ModelAndView selectWishByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		
		List<WishDTO> wishList = wishService.selectWishByUserId(userId);
		
		request.setAttribute("wishList", wishList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/wish.jsp");
		return mv;
	
	}
	
	
	/**
	 * 상품 찜에 추가
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 받기 -> dto로 만든다
		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100; // 100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String wishId = m.getParameter("wish_id");
		String userId = m.getParameter("user_id");
		String prodId = m.getParameter("prod_id");
		
		WishDTO wish = new WishDTO(Integer.parseInt(wishId), userId, Integer.parseInt(prodId));
		
		
		wishService.insertWish(wish);
		
		ModelAndView mv = new ModelAndView("front", true);
		
		return mv;
	}
	
	/**
	 * 찜에서 상품 삭제
	 */
	public ModelAndView sendDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String wishId = request.getParameter("wishId");
		
				
		wishService.deleteWish(Integer.parseInt(wishId));
		
		ModelAndView mv = new ModelAndView("front",true);
		
		return mv;
	}
	
	/**
	 * 전체 찜 리스트
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// service를 호출
		List<WishDTO> wishList = wishService.selectWishList();
		request.setAttribute("wishList", wishList); // ${requestScope.list} 사용가능
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/wish.jsp");
		
		return mv;
	}
	
	
	/**
	 * 상품별 관심조회
	 */
	public ModelAndView selectWishByProdName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodName = request.getParameter("prodName");
		
		List<WishDTO> wishList = wishService.searchWishByProdName(prodName);
		
		request.setAttribute("wishList", wishList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/wish.jsp");
		return mv;
	
	}

}
