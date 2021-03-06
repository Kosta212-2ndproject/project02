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

import kosta.mvc.dao.ReviewDAO;
import kosta.mvc.dao.ReviewDAOImpl;
import kosta.mvc.dto.ReviewDTO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class ReviewSelectByUser
 */
@WebServlet("/reviewSelectByUser")
public class ReviewSelectByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  response.setContentType("text/html;charset=UTF-8");
		  ReviewDAO	review = new ReviewDAOImpl();
		  String userId = (String) request.getSession().getAttribute("userId");
		  
	      List<ReviewDTO> list =null;
		try {
			list = review.selectByUserId(userId);

		      // list를 javascript 해석할 수 있는 json형태로 변환!!
		      JSONArray arr = JSONArray.fromObject(list);
		      PrintWriter out = response.getWriter();
		      out.println(arr);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
