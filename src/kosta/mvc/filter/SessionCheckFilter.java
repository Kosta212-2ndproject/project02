package kosta.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 자료실에 접근하기전에 세션유무 체크하기
 */

public class SessionCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사전처리
		String key = request.getParameter("key");
		if(key==null || key.equals("elec")) {
			// 자료실 접근 -> 세션 유무 체크!
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			
			// 세션 안의 인증된 사용자 정보를 찾아서 세션이 있는지 찾아야 한다. -> userController에서 loginUser, loginName를 받았었지!
			if(session.getAttribute("loginUser")==null) {
				req.setAttribute("errorMsg", "로그인 후 이용해주십시오");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				
				return; // 함수 빠져나가기. if문이 실행된 뒤 chain이 호출되면 안됨.
			}
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
