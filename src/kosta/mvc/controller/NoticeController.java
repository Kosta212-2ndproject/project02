package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dto.NoticeDTO;
import kosta.mvc.service.NoticeService;
import kosta.mvc.service.NoticeServiceImpl;

public class NoticeController implements Controller {

	private NoticeService nService = new NoticeServiceImpl();
	@Override
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception  {
		List<NoticeDTO> noticeList = nService.selectAll();
		for(NoticeDTO ndto:noticeList) {
			System.out.println(ndto);
		}
		request.setAttribute("noticeList", noticeList); //${requestScope.noiceList}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/notice.jsp");
		
		return mv;
	}

//	public ModelAndView selectByNoticeNum(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		
//		String noticeNum = request.getParameter("modelNum"); //front쪽을 잘 확인해서 넘어오는 값 연결해주는 그 이름을 잘 확인할 것!
//		Electronics elec = elecService.selectByModelnum(modelNum, true);//조회수 증가 
//		
//		request.setAttribute("elec", elec);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("elec/read.jsp");
//		
//				
//		return mv;
//		
//	}
	
	
	@Override
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	
	

}
