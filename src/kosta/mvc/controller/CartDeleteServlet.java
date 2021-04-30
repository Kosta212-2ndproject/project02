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


/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/cartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		try {
			CartDAO dao = new CartDAOImpl();
			int result = dao.deleteCart(cartId);
			out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
