package kosta.mvc.servlet;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dto.OrderDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CartOrderServlet", value = "/cartOrderServlet")
public class CartOrderServlet extends HttpServlet {
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
       long payTime = Long.parseLong(request.getParameter("payTime"));

       // UNIX Timestamp -> 날짜로 변환
       Date date = new java.util.Date(payTime*1000L);
       SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+9"));
       String formattedDate = sdf.format(date);

       System.out.println("prodId: " + prodId);
       System.out.println("userId: " + userId);
       System.out.println("orderPrice: " + orderPrice);
       System.out.println("addr: " + addr);
       System.out.println("zipCode: " + zipCode);
       System.out.println("userName: " + userName);
       System.out.println("formattedDate: " + formattedDate);


       OrderDAO dao = new OrderDAOImpl();
       OrderDTO dto = new OrderDTO(prodId, userId, formattedDate, orderPrice, addr, zipCode, orderShipNo, userName);

       try {
           int result = dao.insertOrder(dto);
           PrintWriter out = response.getWriter();
           out.println(result);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
