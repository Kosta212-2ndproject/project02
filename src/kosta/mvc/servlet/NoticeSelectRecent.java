package kosta.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dao.NoticeDAO;
import kosta.mvc.dao.NoticeDAOImpl;
import kosta.mvc.dto.NoticeDTO;
import net.sf.json.JSONArray;

@WebServlet("/recentNotice")
public class NoticeSelectRecent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

		response.setContentType("text/html;charset=UTF-8");
		NoticeDAO dao = new NoticeDAOImpl();
		List<NoticeDTO> list = null;
		try {
			list = dao.getNoticeList(1);
			// list를 javascript 해석할 수 있는 json형태로 변환!!
			JSONArray arr = JSONArray.fromObject(list);
			PrintWriter out = response.getWriter();
			out.println(arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
