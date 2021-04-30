package kosta.mvc.servlet;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dto.OrderDTO;
import kosta.mvc.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderInsertServlet", value = "/orderInsert")
public class OrderInsertServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html; charset=UTF-8");

//      String prodId = request.getParameter("orderNum");
      Long prodId = new Long(request.getParameter("orderNum"));
      String userId = request.getParameter("userId");
      int orderPrice = Integer.parseInt(request.getParameter("orderPrice"));
      String addr = request.getParameter("addr");
      String zipCode = request.getParameter("zipCode");
      String userName = request.getParameter("orderName");
      String orderShipNo = "80809";
      String payTime = request.getParameter("payTime");

      System.out.println("prodId: " + prodId);
      System.out.println("userId: " + userId);
      System.out.println("orderPrice: " + orderPrice);
      System.out.println("addr: " + addr);
      System.out.println("zipCode: " + zipCode);
      System.out.println("userName: " + userName);
      System.out.println("payTime: " + payTime);


      OrderDAO dao = new OrderDAOImpl();
      OrderDTO dto = new OrderDTO(prodId, userId, orderPrice, addr, zipCode, orderShipNo, userName);

      try {
         int result = dao.insertOrder(dto);
         PrintWriter out = response.getWriter();
         out.println(result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
