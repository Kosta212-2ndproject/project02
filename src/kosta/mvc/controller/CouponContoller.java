package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.CouponLineDTO;
import kosta.mvc.service.CouponService;
import kosta.mvc.service.CouponServiceImpl;

public class CouponContoller implements Controller {

	private CouponService couponService = new CouponServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 전체검색
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// service를 호출
		List<CouponLineDTO> couponList = couponService.selectAllCoupons();
		request.setAttribute("couponList", couponList); // ${requestScope.list} 사용가능
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/coupon.jsp");
		
		return mv;
	}
	
	/**
	 * 생성(발급)
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 받기 -> dto 만든다.
		String saveDir =request.getServletContext().getRealPath("/save");
		String encoding = "UTF-8";
		int maxSize= 1024*1024*100; //100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
	
		String cponUseNum = m.getParameter("cpon_use_num");
		String cponNum = m.getParameter("cpon_num");
		String userId = m.getParameter("user_id");
		String cponUseState = m.getParameter("cpon_use_state");
		String cponRegDate = m.getParameter("cpon_reg_date");
		String cponEndDate = m.getParameter("cpon_end_date");
		
		CouponLineDTO coupon = new CouponLineDTO(Integer.parseInt(cponUseNum), Integer.parseInt(cponNum), userId, Integer.parseInt(cponUseState), cponRegDate, cponEndDate);
		
		couponService.createCoupon(coupon);
		
		ModelAndView mv = new ModelAndView("front", true);
		
		return mv;
	}
	
	/**
	 * 쿠폰 수정을 위한 폼
	 */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cponNum = request.getParameter("cponNum");
		
		CouponLineDTO coupon = couponService.selectBycponName(cponNum); // false는 조회수 증가안함!!
		request.setAttribute("coupon", coupon);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/update.jsp");
		return mv;
	}
	
	/**
	 * 쿠폰 상태 업데이트
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String cponNum = request.getParameter("cpon_num");
		String cponUseState = request.getParameter("cpon_use_state");
		
		CouponLineDTO coupon = new CouponLineDTO(Integer.parseInt(cponNum), Integer.parseInt(cponUseState));
		
		
		// db에서 가져온걸 수정한 결과로 담아서 보내고, read 페이지에 보냄
		coupon = couponService.selectBycponName(cponNum);
		request.setAttribute("coupon", coupon);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/read.jsp");
		return mv;
	}
	
	
	/**
	 * 쿠폰명으로 검색
	 */
	public ModelAndView selectByCouponName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cponName = request.getParameter("cponName");
		
		CouponLineDTO couponList = couponService.selectBycponName(cponName);
				
		request.setAttribute("couponList", couponList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/coupon.jsp");
		return mv;
	
	}
	
	/**
	 * 할인율로 검색
	 */
	public ModelAndView selectByCouponDcPercent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cponDcPercent = request.getParameter("cponDcPercent");
		
		CouponLineDTO couponList = couponService.selectBycponDcPercent(Double.parseDouble(cponDcPercent));
				
		request.setAttribute("couponList", couponList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cart/coupon.jsp");
		return mv;
	
	}

}
