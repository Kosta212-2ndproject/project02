package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

/**
 * 서버가 start 될 때 생성해야 할 객체들을 미리 생성해서 map에 저장한 후
 * application영역에 저장
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		// 외부의 ~.properties 파일을 로딩해서 key와 value를 분리한다
		ServletContext application = sce.getServletContext();
		String fileName = application.getInitParameter("fileName"); // actionMapping
		
		Map<String, Controller> map = new HashMap<String, Controller>();
		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
		
		ResourceBundle rb = ResourceBundle.getBundle(fileName); // properties의 확장자는 생략한다 -> web.xml 문서에서 생략함
		
		try {
			for(String key : rb.keySet()) {
				String value = rb.getString(key);
				
				// value를 객체로 만들기
				Class<?> className = Class.forName(value);
				Controller controller = (Controller)className.getDeclaredConstructor().newInstance();

				System.out.println(key + ", " + value + ", " + controller + ", " + className);
				
				// 만들어진 객체를 map에 저장한다
				map.put(key, controller);
				clzMap.put(key, className);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		// webApplication 영역에서 어디서든지 사용할 수 있도록 application영역에 map을 저장한다.
		application.setAttribute("map", map);
		application.setAttribute("clzMap", clzMap);
		application.setAttribute("path", application.getContextPath()); // ${path}
		
	}
}
