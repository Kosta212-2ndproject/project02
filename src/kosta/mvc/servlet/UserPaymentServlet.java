package kosta.mvc.servlet;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserPaymentServlet", value = "/userPayment")
public class UserPaymentServlet extends HttpServlet {

   OrderDAO orderDAO = new OrderDAOImpl();


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



   }

}
