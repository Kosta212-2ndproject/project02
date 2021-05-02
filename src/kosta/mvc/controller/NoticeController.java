package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.NoticeDTO;
import kosta.mvc.service.NoticeService;
import kosta.mvc.service.NoticeServiceImpl;

public class NoticeController implements Controller {

	private NoticeService nService = new NoticeServiceImpl();
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		String pageNo = request.getParameter("pageNo");
		
		 if(pageNo==null || pageNo.equals("")) {
			  pageNo="1";
		  }
		List<NoticeDTO> noticeList = nService.selectAll(Integer.parseInt(pageNo));
//		List<NoticeDTO> noticeList = nService.selectAll();
		for(NoticeDTO ndto:noticeList) {
			System.out.println(ndto);
		}
		request.setAttribute("noticeList", noticeList); //${requestScope.noiceList}
		request.setAttribute("pageNo", pageNo); //${requestScope.noiceList}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/notice.jsp");
		
		return mv;
	}
	
	/**
	 * select notice for Admin
	 * */
	public ModelAndView selectAdmin(HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		
		String pageNo = request.getParameter("pageNo");
		
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		List<NoticeDTO> noticeList = nService.selectAll(Integer.parseInt(pageNo));
//		List<NoticeDTO> noticeList = nService.selectAll();
		for(NoticeDTO ndto:noticeList) {
			System.out.println(ndto);
		}
		request.setAttribute("noticeList", noticeList); //${requestScope.noiceList}
		request.setAttribute("pageNo", pageNo); //${requestScope.noiceList}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeAdmin.jsp");
		
		return mv;
	}

	/**
	 * 관리자를 위한 공지상세 페이
	 * */
	public ModelAndView selectByNoticeNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String nNum = request.getParameter("nNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		Electronics elec = elecService.selectByModelnum(modelNum, true);//조회수 증가 
		
		NoticeDTO nDTO = nService.selectByNoticeNum(Integer.parseInt(nNum), true);
		request.setAttribute("nDTO", nDTO); //${nDTO}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/notice-single-Admin.jsp");
		
				
		return mv;
		
	}
	
	/**
	 * 회원을 위한 공지상세 페이지 
	 * */
	public ModelAndView selectByNoticeNumforUser(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String nNum = request.getParameter("nNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		Electronics elec = elecService.selectByModelnum(modelNum, true);//조회수 증가 
		
		NoticeDTO nDTO = nService.selectByNoticeNum(Integer.parseInt(nNum), true);
		request.setAttribute("nDTO", nDTO); //${nDTO}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/notice-single.jsp");
		
		
		return mv;
		
	}
	
	/**
	 * 관리자 입장에서 공지글 자세히 보기 
	 * */
	public ModelAndView selectByNoticeNumAdmin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String nNum = request.getParameter("nNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		Electronics elec = elecService.selectByModelnum(modelNum, true);//조회수 증가 
		
		NoticeDTO nDTO = nService.selectByNoticeNum(Integer.parseInt(nNum), true);
		request.setAttribute("nDTO", nDTO); //${nDTO}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeSingleAdmin.jsp");
		
				
		return mv;
		
	}
	
	/**
	 * 공지글 수정하는 form
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String nNum = request.getParameter("nNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		
//		Electronics elec = elecService.selectByModelnum(modelNum, true);//조회수 증가 
		
		NoticeDTO nDTO = nService.selectByNoticeNum(Integer.parseInt(nNum), false);
		request.setAttribute("nDTO", nDTO); //${nDTO}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeUpdate.jsp");
		
				
		return mv;
		
	}
	
	/**
	 * 공지글 등록하는 form
	 * */
	public ModelAndView uploadForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeUpload.jsp");
		
				
		return mv;
		
	}
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		String saveDir = request.getServletContext().getRealPath("/save");//★
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;//100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		
		String nTitle = m.getParameter("nTitle"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String nContent = m.getParameter("nContent"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String nField = m.getParameter("nField"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		
			
		NoticeDTO notice = new NoticeDTO(0, nTitle, nContent, null, null, 0, Integer.parseInt(nField));
		
		
		//파일 첨부가 되었다면, 
		if(m.getFilesystemName("nImage") != null) {//뭔가 첨부가 되었다면
			notice.setnImage(request.getContextPath()+"/save/"+m.getFilesystemName("nImage")); 
			
		}
	
		nService.insert(notice);
		request.setAttribute("nDTO", notice);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front?key=notice&methodName=selectAdmin");
		mv.setRedirect(true);
		//mv.setViewName("notice/noticeSingleAdmin.jsp");
		return mv;
		
	}

	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		
		String saveDir = request.getServletContext().getRealPath("/save");//★
		String encoding = "UTF-8";
		int maxSize = 1024*1024*100;//100MB
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		
		
		String nNum = m.getParameter("nNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String nTitle = m.getParameter("nTitle"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String nContent = m.getParameter("nContent"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		String nField = m.getParameter("nField"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
		//String nImage = m.getParameter("nImage");
		String nImageOrigin = m.getParameter("nImageOrigin");
		
		NoticeDTO notice = new NoticeDTO(Integer.parseInt(nNum), nTitle, nContent, null, null, 0, Integer.parseInt(nField));
		
		
		
		//파일 첨부가 되었다면, 
		if(m.getFilesystemName("nImage") != null) {//뭔가 첨부가 되었다면
			notice.setnImage(m.getFilesystemName("nImage")); 
			
		}else {
			notice = new NoticeDTO(Integer.parseInt(nNum), nTitle, nContent, nImageOrigin, null, 0, Integer.parseInt(nField));
		}
		nService.update(notice);
		
		
		notice = nService.selectByNoticeNum(Integer.parseInt(nNum), false);
		request.setAttribute("nDTO", notice);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeSingleAdmin.jsp");
		return mv;
				
	}

	/**
	 * Admin notice delete
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		String nNum = request.getParameter("nNum");
	
		nService.delete(Integer.parseInt(nNum));
		List<NoticeDTO> noticeList = nService.selectAll();
		request.setAttribute("noticeList", noticeList);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeAdmin.jsp");
		return mv;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
