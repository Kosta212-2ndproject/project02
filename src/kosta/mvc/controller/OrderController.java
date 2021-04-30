package kosta.mvc.controller;

import kosta.mvc.service.OrderService;
import kosta.mvc.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderController implements Controller{
   private OrderService orderService = new OrderServiceImpl();

   @Override
   public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
      return null;
   }

   public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
//      String userId = (String) request.getSession().getAttribute("userId");
      String userId = request.getParameter("userId");
      int productId = Integer.parseInt(request.getParameter("prodId"));

      String prodTotalPrice = request.getParameter("prodTotalPrice");
      String userName = request.getParameter("userName");
      String phoneNumber = request.getParameter("phoneNumber");
      String postCode = request.getParameter("postCode");
      String address = request.getParameter("address");
      String extraAddress = request.getParameter("extraAddress");
      String detailAddress = request.getParameter("detailAddress");
      String baesongMemo = request.getParameter("selectOptionMemo");

      System.out.println("prodTotalPrice: " + prodTotalPrice);
      System.out.println("userName: " + userName);
      System.out.println("phoneNumber: " + phoneNumber);
      System.out.println("postCode: " + postCode);
      System.out.println("address: " + address);
      System.out.println("extraAddress: " + extraAddress);
      System.out.println("detailAddress: " + detailAddress);
      System.out.println("baesongMemo: " + baesongMemo);

//      orderService.insertOrder(d);

      ModelAndView mv = new ModelAndView();
      mv.setViewName("orderLine.jsp");


      return mv;
   }
}
