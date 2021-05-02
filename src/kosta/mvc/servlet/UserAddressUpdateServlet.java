package kosta.mvc.servlet;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dto.MemberDTO;
import kosta.mvc.dto.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UserAddressUpdateServlet", value = "/userAddressUpdate")
public class UserAddressUpdateServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html; charset=UTF-8");

      String userId = request.getParameter("userId");
      String userZipCode = request.getParameter("userZipCode");
      String userAddr = request.getParameter("userAddr");
      String userAddrDetail = request.getParameter("userAddrDetail");



      OrderDAO dao = new OrderDAOImpl();
      MemberDTO dto = new MemberDTO(userId, userZipCode, userAddr, userAddrDetail);

      try {
         int result = dao.updateAddress(dto);
         PrintWriter out = response.getWriter();
         out.println(result);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
