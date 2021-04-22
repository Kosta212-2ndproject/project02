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
 * 서버가 start될 때 생성해야 할 객체들을 미리 생성해서 Map에 저장한 후 
 * application영역에 저장한다. 
 * 
 * */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	//외부의 ~.properties 파일을 로딩해서 key와 value를 분리한다.
    	//IO이용하는 방법 
    	//ResourceBundle 방법
    	ServletContext application = sce.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	
    	//key 는 같게 들어감.
    	Map<String, Controller> map = new HashMap<String, Controller>();
    	//메서드를 접근하기위한 또다른 Map
    	Map<String, Class<?>> clsMap = new HashMap<String, Class<?>>();
    			
    	ResourceBundle rb = ResourceBundle.getBundle(fileName); //확장자를 생략(리소스번들을 properties 파일 불러오는 전용이라) / 경로를 initParam 으로 전달하는 걸 권장 -> contextParam
    	
    	try {
    		for(String key:rb.keySet()) {
    			String value = rb.getString(key);
    			Class<?> className = Class.forName(value);
    			Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
//    			Controller controller = (Controller)(Class.forName(value).getDeclaredConstructor().newInstance());
    			
    			//분리된 value를 객체로 만든다.
    			//Controller controller = (Controller)Class.forName(value).newInstance();
    			//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
    			System.out.println(key + " : "+ value + " : "+ controller);
    			
    			//만들어진 객체를 map에 저장한다 
    			map.put(key, controller);
    			clsMap.put(key, className);
    		}
    	}catch(Exception e) {
    		
    	}
    	
    	
    	//webApplication 영역에서 어디서든지 사용할 수 있도록 application 영역에 map을 저장한다.
    	application.setAttribute("map", map);
    	application.setAttribute("clzMap", clsMap);
    	application.setAttribute("path", application.getContextPath()); //${path}
    	
    	
    
    }
	
}
