package kosta.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 사용자 요청이 진입하는 FrontController의 역할
 */
@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;
	private Map<String, Class<?>> clzMap;
	
	@Override
	public void init() throws ServletException {
		map = (Map<String, Controller>)super.getServletContext().getAttribute("map");
		clzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("clzMap");
	}
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		map = (Map<String, Controller>)config.getServletContext().getAttribute("map");
//		clzMap = (Map<String, Class<?>>)super.getServletContext().getAttribute("clzMap");
//	}
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("frontController 요청 완료!!");
		
		String key = request.getParameter("key"); // user 또는 elec
		String methodName = request.getParameter("methodName");
		
		try {
			if(key==null || key.equals("")) {
				key = "elec";
			}
			
			if(methodName==null || methodName.equals("")) {
				methodName = "select";
			}
			
			Class<?> clz = clzMap.get(key);
			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			Controller controller = map.get(key);
			
			ModelAndView mv = (ModelAndView)method.invoke(controller, request, response); // 특정 XxxController의 메소드가 호출된다! 
			
			if(mv.isRedirect()) { // redirect 방식인지 묻는 것
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage()); // view 페이지에서 ${errorMsg}
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

}
