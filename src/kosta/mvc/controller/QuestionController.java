package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.AnswerDTO;
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

public class QuestionController implements Controller {
	
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
	 * 질문 전체 보기 / 관리자 
	 * */
	public ModelAndView selectAllforAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

		List<QuestionDTO> question = questionService.selectAll();
		request.setAttribute("question", question);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("questionSelect.jsp");
		
		return mv;
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
		String userId = (String) request.getSession().getAttribute("userId");
		System.out.println(userId);
		 String prodId = m.getParameter("prodId");
		 String qField = m.getParameter("qField");
		 String qTitle= m.getParameter("qTitle");
		 String qContent= m.getParameter("qContent");
		 String qFiles= m.getParameter("qFiles");
		 String qShowstatus= m.getParameter("qShowstatus");
		 
		 QuestionDTO  question = new QuestionDTO(0, userId, Integer.parseInt(prodId), qField, qTitle, qContent, 
				 qFiles, null, Integer.parseInt(qShowstatus));
		
		
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
			mv.setViewName("front?key=prod&methodName=selectByProductDetail&prodId="+prodId);
			mv.setRedirect(true);
			//mv.setViewName("product-single.jsp");
			return mv;
	}
	
	
	/**
	 * 
	 * 질문번호로  질문 상세보기 
	 * selectByQuestionNum
	 * */
	public ModelAndView selectByQuestionNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

		response.setContentType("text/html;charset=UTF-8");
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
		response.setContentType("text/html;charset=UTF-8");


		String saveDir = request.getServletContext().getRealPath("/save");// ★
		String encoding = "UTF-8";
		int maxSize = 1024 * 1024 * 100;// 100MB

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		
		String qNum = m.getParameter("qNum");
		String userId = m.getParameter("userId");
		String prodId = m.getParameter("prodId");
		String qField = m.getParameter("qField");
		String qTitle = m.getParameter("qTitle");
		String qContent = m.getParameter("qContent");
//		String qFiles= m.getParameter("qFiles");
		String qRegdate = m.getParameter("qRegdate");
		String qShowstatus = m.getParameter("qShowstatus");
		
		String qFilesOrigin = m.getParameter("qFilesOrigin");

		QuestionDTO question = new QuestionDTO(Integer.parseInt(qNum), userId, Integer.parseInt(prodId), qField, qTitle, qContent,
				null, qRegdate, Integer.parseInt(qShowstatus));

		// 파일 첨부가 되었다면,
		if (m.getFilesystemName("qFiles") != null) {// 뭔가 첨부가 되었다면
			question.setqFiles(request.getContextPath() + "/save/" + m.getFilesystemName("qFiles"));

		} else {
			question = new QuestionDTO(Integer.parseInt(qNum), userId, Integer.parseInt(prodId), qField, qTitle, qContent,
					qFilesOrigin, qRegdate, Integer.parseInt(qShowstatus));
		}

		questionService.update(question);
		request.setAttribute("question", question);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("questionRead.jsp");
		return mv;
	}
	
	

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		response.setContentType("text/html;charset=UTF-8");

		String qNum = request.getParameter("qNum");
		questionService.delete(Integer.parseInt(qNum));
		

		String prodId = request.getParameter("prodId");
		
		ProductDTO prod = productService.selectByProductDetail(Integer.parseInt(prodId));
		List<ReviewDTO> review = reviewService.selectByProdId(Integer.parseInt(prodId));
		List<QuestionDTO> question = questionService.selectByProdId(Integer.parseInt(prodId));
		
		request.setAttribute("prod", prod);
		request.setAttribute("review", review);
		request.setAttribute("question", question);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-single.jsp");
		return mv;	
	}
	
	
	/**
	 * answer insertForm
	 * */
	public ModelAndView answerForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

		response.setContentType("text/html;charset=UTF-8");
//		String userId = request.getParameter("userId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		String prodId = request.getParameter("prodId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String qNum = request.getParameter("qNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String aAnsId = request.getParameter("aAnsId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String prodId = request.getParameter("prodId"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		
		QuestionDTO question = questionService.selectByQNum(Integer.parseInt(qNum));
		List<ReviewDTO> review = reviewService.selectByProdId(Integer.parseInt(prodId));
		
		request.setAttribute("question", question); //${question}
		request.setAttribute("review", review); //${question}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("answerInsert.jsp");
				
		return mv;
	}
	
	/**
	 * answer Insert
	 * */
	public ModelAndView answerInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		response.setContentType("text/html;charset=UTF-8");

		//session 에서 가져와야
			String qNum = request.getParameter("qNum");
			String aContent = request.getParameter("aContent");
			String aAnsId = request.getParameter("aAnsId");
			String prodId = request.getParameter("prodId");
		

			System.out.println(qNum);
			System.out.println(aContent);
			System.out.println(aAnsId);

		 
			AnswerDTO answer = new AnswerDTO(0, Integer.parseInt(qNum), aContent, aAnsId, null);
			questionService.answerBoardInsert(answer);
			
			ProductDTO prod = productService.selectByProductDetail(Integer.parseInt(prodId));
			List<ReviewDTO> review = reviewService.selectByProdId(Integer.parseInt(prodId));
			List<QuestionDTO> question = questionService.selectByProdId(Integer.parseInt(prodId));
			
			request.setAttribute("prod", prod);
			request.setAttribute("review", review);
			request.setAttribute("question", question);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("front?key=prod&methodName=selectByProductDetail&prodId="+prodId);
			mv.setRedirect(true);
			return mv;
	}
	

	/**
	 * 
	 * answer 번호로  답변 상세보기 
	 * selectByQuestionNum
	 * */
	public ModelAndView selectByAnswerNum(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		response.setContentType("text/html;charset=UTF-8");

		// session 에서 가져와야
		//String userId = "kim";

		String qNum = request.getParameter("qNum");
		String aNum = request.getParameter("aNum");
		System.out.println(qNum);
		System.out.println(aNum);

		QuestionDTO question = questionService.selectByQNum(Integer.parseInt(qNum));
		AnswerDTO answer = answerService.selectByANum(Integer.parseInt(aNum));
		request.setAttribute("question", question);
		request.setAttribute("answer", answer);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("answerRead.jsp");
		return mv;

	}


	
	/**
	 * 답변삭제 
	 * deleteAnswer
	 * */
	public ModelAndView deleteAnswer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		response.setContentType("text/html;charset=UTF-8");

		String qNum = request.getParameter("qNum");
		String aNum = request.getParameter("aNum");
		String prodId = request.getParameter("prodId");
		
		
		System.out.println("minjoo");
		System.out.println(qNum);
		System.out.println(aNum);
		System.out.println(prodId);
		answerService.delete(Integer.parseInt(aNum));
		

		
		ProductDTO prod = productService.selectByProductDetail(Integer.parseInt(prodId));
		List<ReviewDTO> review = reviewService.selectByProdId(Integer.parseInt(prodId));
		List<QuestionDTO> question = questionService.selectByProdId(Integer.parseInt(prodId));
		
		request.setAttribute("prod", prod);
		request.setAttribute("review", review);
		request.setAttribute("question", question);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-single.jsp");
		return mv;	
	}
	
	
}
