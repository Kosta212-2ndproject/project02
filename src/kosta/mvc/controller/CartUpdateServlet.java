package kosta.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.dao.CartDAO;
import kosta.mvc.dao.CartDAOImpl;
import kosta.mvc.service.CartService;
import kosta.mvc.service.CartServiceImpl;


/**
 * Servlet implementation class CartUpdateServlet
 */
@WebServlet("/cartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		int cartQty = Integer.parseInt(request.getParameter("cartQty"));
		request.getParameter("cartQty");
		
		try {
			CartDAO dao = new CartDAOImpl();
			int result = dao.update(cartId, cartQty);
			
			PrintWriter out = response.getWriter();
			out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
