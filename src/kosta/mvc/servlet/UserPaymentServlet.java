package kosta.mvc.servlet;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dao.QuestionDAO;
import kosta.mvc.dao.QuestionDAOImpl;
import kosta.mvc.dto.OrderDTO;
import kosta.mvc.dto.QuestionDTO;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserPaymentServlet", value = "/userPayment")
public class UserPaymentServlet extends HttpServlet {

   OrderDAO orderDAO = new OrderDAOImpl();


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html;charset=UTF-8");

      String userId = request.getParameter("userId");

      try {
         List<OrderDTO> orderDTOList = orderDAO.printAllOrders(userId);
         JSONArray arr = JSONArray.fromObject(orderDTOList);
         PrintWriter out = response.getWriter();
         out.println(arr);
         System.out.println("arr: " + arr);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

}
