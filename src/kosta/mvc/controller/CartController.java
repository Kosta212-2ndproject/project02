package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dao.CartDAOImpl;
import kosta.mvc.dto.CartDTO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.service.CartService;
import kosta.mvc.service.CartServiceImpl;
import kosta.mvc.service.ProductService;
import kosta.mvc.service.ProductServiceImpl;

public class CartController implements Controller {
	private CartService cartService = new CartServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	
	
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
		String pi = request.getParameter("prodId");
		 if(pi !=null && !pi.equals("")) {
			 request.setAttribute("prodId", pi);
		 }
		
		//int prodPrice = Integer.parseInt(request.getParameter("prodPrice"));

		List<ProductDTO> list = cartService.selectCartByUserId(userId);
		int total=0;
		int totalPrice=0;
		for(ProductDTO dto:list) {
			total += (dto.getProdPrice());
			totalPrice += total;
		}
		System.out.println("totalPrice = " + totalPrice);
		System.out.println("total = " + total);
		
		//CartDTO cart = cartService.selectCartByUserId(userId); 
		
		//request.setAttribute("product", product);
		//request.setAttribute("userId", userId);
		//request.setAttribute("prodId", prodId);
		//request.setAttribute("cart", cart);
		//request.setAttribute("prodPrice", prodPrice);
		
		request.setAttribute("listAll", list);
		request.setAttribute("total", total);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart.jsp");
		return mv;
	}
	
	/**
	 * 카트 등록
	 */
	public ModelAndView insertCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//상품검색과 카트등록을 위한 pk값 받아오기
		String userId = (String) request.getSession().getAttribute("userId");
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		
		//카트등록을 위해 상품 검색해오기 : 그럴필요없음 검색이따로있어서, 카트테이블은 prodId만 있어도 카트등록이 가능하기 때문
		//ProductDTO product = productService.selectByProductDetail(Integer.parseInt(request.getParameter("prodId")));
		
		//등록전에 userID가 prodId에 대한 장바구나기 있는지를 먼저 검색해보고 없으면등록, 있으면 ㄹ 수량ㅇ만 변경한다.
		cartService.duplicateCart(userId, prodId);
		
		//카트등록을 위한 메소드 불러오기
		cartService.insertCart(userId, prodId);
		
		//상품 목록을 가져오기
		//List<ProductDTO> list = cartService.selectCartByUserId(userId);
		
		
		//request.setAttribute("listAll", list);
		//request.setAttribute("prodId", prodId);
		//cart.jsp에서 출력할 내용( 장바구니에 담은 상품이미지,상품이름,가겨,)
		
		//ModelAndView mv = new ModelAndView("cart.jsp", true);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=cart&methodName=selectCartByUserId&userId="+userId+"&prodId="+prodId); //${productDTO}
		mv.setRedirect(true);
		
		return mv;
		
	}
	
	
	
	/**
	 * 카트 삭제
	 */
	public ModelAndView deleteCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//int cartId = Integer.parseInt(request.getParameter("cartId"));
		String userId = (String) request.getSession().getAttribute("userId");
		int prodId = Integer.parseInt(request.getParameter("prodId"));
		
		cartService.deleteCart(prodId);
		
		List<ProductDTO> list = cartService.selectCartByUserId(userId);
		
		
		request.setAttribute("listAll", list);
		
		request.getAttribute("prodId");
		//request.setAttribute("cartId", cartId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart.jsp");
		
		return mv;
	}

	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 카트 업데이트
	 */
	
}
