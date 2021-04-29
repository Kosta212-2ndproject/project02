package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.QuestionDTO;
import kosta.mvc.dto.ReviewDTO;
import kosta.mvc.service.ProductService;
import kosta.mvc.service.ProductServiceImpl;
import kosta.mvc.service.QuestionService;
import kosta.mvc.service.QuestionServiceImpl;
import kosta.mvc.service.ReviewService;
import kosta.mvc.service.ReviewServiceImpl;

public class QuestionController implements Controller {
	
	private QuestionService questionService = new QuestionServiceImpl();
	private ProductService productService = new ProductServiceImpl();
	private ReviewService reviewService = new ReviewServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 질문등록
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		String saveDir = request.getServletContext().getRealPath("/save");//★
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;//100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
//		 int qNum;
//		 int prodId;
//		 String userId;
//		 String qRegdate;

		//session 에서 가져와야
		 String userId = "kim";
		
		 String prodId = m.getParameter("prodId");
		 String qField = m.getParameter("qField");
		 String qTitle= m.getParameter("qTitle");
		 String qContent= m.getParameter("qContent");
//		 String qFiles= m.getParameter("qFiles");
		 String qShowstatus= m.getParameter("qShowstatus");
		 
		 System.out.println(prodId);
		 System.out.println(qField);
		 System.out.println(qTitle);
		 System.out.println(qContent);
		 System.out.println(qShowstatus);
		 
		 
		 QuestionDTO  question = new QuestionDTO(0, userId, Integer.parseInt(prodId), qField, qTitle, qContent, 
				 null, null, Integer.parseInt(qShowstatus));
		
		
		//파일 첨부가 되었다면, 
			if(m.getFilesystemName("qFiles") != null) {//뭔가 첨부가 되었다면
				question.setqFiles(request.getContextPath()+"/save/"+m.getFilesystemName("qFiles")); 
				
			}
		
			questionService.insert(question);
			ProductDTO prod = productService.selectByProductDetail(Integer.parseInt(prodId));
			List<ReviewDTO> review = reviewService.selectByProdId(Integer.parseInt(prodId));
			
			request.setAttribute("prod", prod);
			request.setAttribute("review", review);
			request.setAttribute("question", question);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("product-single.jsp");
			return mv;
	}
	
	
	/**
	 * 
	 * 질문번호로  질문 상세보기 
	 * selectByQuestionNum
	 * */
	public ModelAndView selectByQuestionNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

//		 int qNum;
//		 int prodId;
//		 String userId;
//		 String qRegdate;

		// session 에서 가져와야
		//String userId = "kim";

		String qNum = request.getParameter("qNum");
		System.out.println(qNum);

		QuestionDTO question = questionService.selectByQNum(Integer.parseInt(qNum));

		request.setAttribute("question", question);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("questionRead.jsp");
		return mv;

	}
	
	

	/**
	 * Question 수정하는 form
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
//		String userId = request.getParameter("userId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		String prodId = request.getParameter("prodId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String qNum = request.getParameter("qNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		
		
		QuestionDTO question = questionService.selectByQNum(Integer.parseInt(qNum));
		request.setAttribute("question", question); //${question}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("questionUpdate.jsp");
		
				
		return mv;
		
	}

	/**
	 * Question update
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub

		String saveDir = request.getServletContext().getRealPath("/save");// ★
		String encoding = "UTF-8";
		int maxSize = 1024 * 1024 * 100;// 100MB

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		String prodId = request.getParameter("prodId");
		String userId = request.getParameter("userId");
		String qRegdate = request.getParameter("qRegdate");

		String qNum = request.getParameter("qNum");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");
		String qFilesOrigin = request.getParameter("qFilesOrigin");
		String qShowstatus = request.getParameter("qShowstatus");

		QuestionDTO question = new QuestionDTO(Integer.parseInt(qNum), userId, Integer.parseInt(prodId), null, qTitle,
				qContent, null, qRegdate, Integer.parseInt(qShowstatus));

		// 파일 첨부가 되었다면,
		if (m.getFilesystemName("qFiles") != null) {// 뭔가 첨부가 되었다면
			question.setqFiles(request.getContextPath() + "/save/" + m.getFilesystemName("qFiles"));

		} else {
			question = new QuestionDTO(Integer.parseInt(qNum), userId, Integer.parseInt(prodId), null, qTitle, qContent,
					qFilesOrigin, qRegdate, Integer.parseInt(qShowstatus));
		}

		questionService.update(question);
		request.setAttribute("question", question);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("questionRead.jsp");
		return mv;
	}

}
