package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.WishDTO;
import kosta.mvc.service.ProductService;
import kosta.mvc.service.ProductServiceImpl;
import kosta.mvc.service.WishService;
import kosta.mvc.service.WishServiceImpl;

public class WishController implements Controller {

	private WishService wishService = new WishServiceImpl();
	private ProductService productService = new ProductServiceImpl();

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}
	
	/**
	 * 회원별 관심조회
	 */
	public ModelAndView selectWishByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String pi = request.getParameter("prodId");
		if(pi !=null && !pi.equals("")) {
			request.setAttribute("prodId", pi);
		}
		
		List<ProductDTO> list = wishService.selectWishByUserId(userId);
		
		request.setAttribute("listAll", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("wish.jsp");
		return mv;
	
	}
	
	
	/**
	 * 상품 찜에 추가
	 */
	public ModelAndView insertWish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String wishId =  (String) request.getSession().getAttribute("wishId");
		String userId = (String) request.getSession().getAttribute("userId");
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		
		//등록전에 userID가 prodId에 대한 찜이 있는지를 먼저 검색해보고 없으면등록, 있으면 에러처리
		wishService.duplicateWish(userId, prodId);
		
		//위시등록을 위한 메소드 불러오기
		wishService.insertWish(userId, prodId);
		
		//상품 목록을 가져오기
		List<ProductDTO> list = wishService.selectWishByUserId(userId);

		request.setAttribute("listAll", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=wish&methodName=selectWishByUserId&userId="+userId+"&prodId="+prodId);
		mv.setRedirect(true);
		
		return mv;
	}
	
	/**
	 * 찜에서 상품 삭제
	 */
	public ModelAndView deleteWish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		
				
		wishService.deleteWish(prodId);
		
		List<ProductDTO> list = wishService.selectWishByUserId(userId);
		
		request.setAttribute("listAll", list);
		
		request.getAttribute("prodId");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("wish.jsp");
		
		return mv;
	}
	
	/**
	 * 전체 찜 리스트
	 */
	public ModelAndView selectWish(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String pi = request.getParameter("prodId");
		if(pi !=null && !pi.equals("")) {
			request.setAttribute("prodId", pi);
		}
		
		List<WishDTO> wishList = wishService.selectWish(userId);
		
		request.setAttribute("listWish", wishList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productAll.jsp");
		return mv;
	}
	
	
	/**
	 * 상품별 관심조회
	 */
	public ModelAndView selectWishByProdName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodName = request.getParameter("prodName");
		
		//WishDTO wishList = wishService.searchWishByProdName(prodName);
		
		//request.setAttribute("wishList", wishList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/wish.jsp");
		return mv;
	
	}

	@Override
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
