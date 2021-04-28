package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.NoticeDTO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.ReviewDTO;
import kosta.mvc.service.ProductService;
import kosta.mvc.service.ProductServiceImpl;
import kosta.mvc.service.ReviewService;
import kosta.mvc.service.ReviewServiceImpl;

public class ReviewController implements Controller {

	private ReviewService reviewService = new ReviewServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	
//	
//	public ModelAndView selectByProdId(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException, Exception {
//		String saveDir = request.getServletContext().getRealPath("/save");//★
//		String encoding = "UTF-8";
//		int maxSize = 1024*1024*100;//100MB
//		
//		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
//		String prodId = m.getParameter("prodId");
//		
//		List<ReviewDTO> reviewList = reviewService.selectByProdId(prodId);
//		for(ReviewDTO dto:reviewList) {
//			System.out.println(dto);
//		}
//		request.setAttribute("reviewListByprodId", reviewList); //${requestScope.reviewListByprodId}
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("reviewSelect.jsp");
//		
//		return mv;
	
	
//		
//	}
	
	/**
	 * reviewId로 검색하기 
	 * */
	public ModelAndView selectByReviewId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
//		String saveDir = request.getServletContext().getRealPath("/save");//★
//		String encoding = "UTF-8";
//		int maxSize = 1024*1024*100;//100MB
//		
//		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
//		String reviewId = m.getParameter("reviewId");
		String reviewId =request.getParameter("reviewId");
		
		ReviewDTO review = reviewService.selectReview(Integer.parseInt(reviewId), true);
		request.setAttribute("review", review); //${requestScope.review}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reviewRead.jsp");
		
		return mv;
	
	
		
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String saveDir = request.getServletContext().getRealPath("/save");//★
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;//100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		/*
		 * 나중에 세션연결되면 수정해야 할 부분 
		 * 상품아이디, 유저아이디, 오더넘버 조인해서 컨트롤 /dao 부분 수정해야 함.
		 * 
		 * 
		 * */
		
		
//		String prodId = m.getParameter("prodId");
		String prodId = "37197";
//		String userId = m.getParameter("userId");
		String userId = "kim";
		
//		String oNum = m.getParameter("oNum");
		String oNum = "50524";
		String reviewTitle = m.getParameter("reviewTitle");
		String reviewContent = m.getParameter("reviewContent");
		String reviewStarScope = m.getParameter("reviewStarScope");
		//String reviewImgUrl = m.getParameter("reviewImgUrl");
		
		//file관련을 null 혀옹임 입력 안해도 됨
		
		ReviewDTO review = new ReviewDTO(0, Integer.parseInt(prodId), userId, 
				Integer.parseInt(oNum), reviewTitle, reviewContent, 
				Integer.parseInt(reviewStarScope), null, null,0);
		
				
		
		//파일 첨부가 되었다면, 
		if(m.getFilesystemName("reviewImgUrl") != null) {//뭔가 첨부가 되었다면
			review.setReviewImgUrl(request.getContextPath()+"/save/"+m.getFilesystemName("reviewImgUrl"));
			
		
		}
		
		reviewService.insert(review);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		
		return mv;
		
		
	}
	
	
	
	
	
	
	
	/**
	 * review 수정하는 form
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
//		String userId = request.getParameter("userId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		String prodId = request.getParameter("prodId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String reviewId = request.getParameter("reviewId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		
		
		 ReviewDTO review = reviewService.selectReview(Integer.parseInt(reviewId), false);
//		
//		for(ReviewDTO reviewDTO :reviewList) {
//			if(reviewDTO.getProdId() == Integer.parseInt(prodId)) {
//				ReviewDTO review = new 
//			}
//		}
		request.setAttribute("review", review); //${review}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reviewUpdate.jsp");
		
				
		return mv;
		
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		
		String saveDir = request.getServletContext().getRealPath("/save");//★
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;//100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		
		String prodId = m.getParameter("prodId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String reviewId = m.getParameter("reviewId"); 
		String userId = m.getParameter("userId"); 
		String reviewTitle = m.getParameter("reviewTitle");
		String reviewStarScope = m.getParameter("reviewStarScope"); 
		String reviewRegdate = m.getParameter("reviewRegdate"); 
		
		String reviewImgUrlOrigin = m.getParameter("reviewImgUrlOrigin"); 
		String reviewContent = m.getParameter("reviewContent");
		String reviewVcount = m.getParameter("reviewVcount"); 
		
		ReviewDTO review = new ReviewDTO(Integer.parseInt(reviewId), Integer.parseInt(prodId), userId, 
				0, reviewTitle, reviewContent, Integer.parseInt(reviewStarScope), reviewRegdate, null, Integer.parseInt(reviewVcount));
				
		//파일 첨부가 되었다면, 
		if(m.getFilesystemName("reviewImgUrl") != null) {//뭔가 첨부가 되었다면
			review.setReviewImgUrl(request.getContextPath()+"/save/"+m.getFilesystemName("reviewImgUrl")); 
			
		}else {
			review = new ReviewDTO(Integer.parseInt(reviewId), Integer.parseInt(prodId), userId, 
					0, reviewTitle, reviewContent, Integer.parseInt(reviewStarScope), 
					reviewRegdate, reviewImgUrlOrigin, Integer.parseInt(reviewVcount));
		}
	
		reviewService.update(review);
		request.setAttribute("review", review);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reviewRead.jsp");
		return mv;
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String reviewId = request.getParameter("reviewId");
		reviewService.delete(Integer.parseInt(reviewId));
		

		String prodId = request.getParameter("prodId");
		
		ProductDTO prod = productService.selectByProductDetail(Integer.parseInt(prodId));
		
		request.setAttribute("prod", prod);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-single.jsp");
		return mv;	
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
