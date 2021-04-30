package kosta.mvc.servlet;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayQtyMinServlet", value = "/payQty")
public class PayQtyMinServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html; charset=UTF-8");

      int prodId = Integer.parseInt(request.getParameter("prodId"));
      int qty = Integer.parseInt(request.getParameter("qty"));

      OrderDAO dao = new OrderDAOImpl();

      try {
         int result = dao.updateQty(prodId, qty);
         PrintWriter out = response.getWriter();
         out.println(result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
