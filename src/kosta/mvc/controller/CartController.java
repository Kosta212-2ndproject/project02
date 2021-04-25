package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.CartDTO;
import kosta.mvc.service.CartService;
import kosta.mvc.service.CartServiceImpl;

public class CartController implements Controller {
	private CartService cartService = new CartServiceImpl();
	

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 카트검색
	 */
	public ModelAndView selectCartByUserId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String userId = request.getParameter("userId");
		
		List<CartDTO> cartList = cartService.selectCartByUserId(userId); 
		request.setAttribute("cartList", cartList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/cart.jsp");
		return mv;
	}
	
	/**
	 * 카트 등록
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 받기 -> dto로 만든다
		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String cartId = m.getParameter("cart_id");
		String cartQty = m.getParameter("cart_qty");
		String userId = m.getParameter("user_id");
		String prodId = m.getParameter("prod_id");
		
		CartDTO cartDTO = new CartDTO(Integer.parseInt(cartId), Integer.parseInt(cartQty), userId, Integer.parseInt(prodId));
		
		cartService.insertCart(cartDTO);
		
		ModelAndView mv = new ModelAndView("front", true);
		return mv;
		
	}
	
	
	
	/**
	 * 카트 삭제
	 */
	public ModelAndView sendDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cartId = request.getParameter("cartId");
		
				
		cartService.deleteCart(Integer.parseInt(cartId));
		
		ModelAndView mv = new ModelAndView("front",true);
		
		return mv;
	}

	@Override
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 카트 업데이트
	 */
	
}
