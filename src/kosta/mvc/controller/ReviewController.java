package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.ReviewDTO;
import kosta.mvc.service.ReviewService;
import kosta.mvc.service.ReviewServiceImpl;

public class ReviewController implements Controller {

	private ReviewService reviewService = new ReviewServiceImpl();
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		String saveDir = request.getServletContext().getRealPath("/save");//★
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;//100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
//		String prodId = m.getParameter("prodId");
		String prodId = "45732";
//		String userId = m.getParameter("userId");
		String userId = "choi";
		
//		String oNum = m.getParameter("oNum");
		String oNum = "37197";
		String reviewTitle = m.getParameter("reviewTitle");
		String reviewContent = m.getParameter("reviewContent");
		String reviewStarScope = m.getParameter("reviewStarScope");
		String reviewImgUrl = m.getParameter("reviewImgUrl");
		
		//file관련을 null 혀옹임 입력 안해도 됨
		
		ReviewDTO review = new ReviewDTO(0, Integer.parseInt(prodId), userId, 
				Integer.parseInt(oNum), reviewTitle, reviewContent, 
				Integer.parseInt(reviewStarScope), null, reviewImgUrl,0);
		
				
		
		//파일 첨부가 되었다면, 
		if(m.getFilesystemName("file") != null) {//뭔가 첨부가 되었다면
			review.setReviewImgUrl(m.getFilesystemName("file"));
			
		
		}
		
		reviewService.insert(review);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review2.jsp");
		
		return mv;
		
		
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
