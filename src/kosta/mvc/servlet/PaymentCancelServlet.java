package kosta.mvc.servlet;

import com.siot.IamportRestHttpClientJava.request.CancelData;
import kosta.mvc.IamportClient;
import kosta.mvc.request.CancelDatas;
import kosta.mvc.response.IamportResponse;
import kosta.mvc.response.Payment;
import kosta.mvc.response.PaymentAll;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PaymentCancelServlet", value = "/paymentCancel")
public class PaymentCancelServlet extends HttpServlet {
   IamportClient client;


   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html; charset=UTF-8");

      String api_key = "7617961756514293";
      String api_secret = "696tEA3mga5eMf0kRvvgMsBaCgoyLrTRA0leAoBRyH6kX6FPCa6pDHzfXYNJpHBZHWeikQ9SyfdvmSlZ";

      try {

         String reason = request.getParameter("reason");
         String orderNo = request.getParameter("orderNo");

         System.out.println(reason);
         System.out.println(orderNo);

         client = new IamportClient(api_key, api_secret);

         CancelDatas cancelDatas = new CancelDatas(orderNo, reason);
         IamportResponse<Payment> payment = client.cancelPayment(cancelDatas);
         PrintWriter out = response.getWriter();
         out.println(payment);

      } catch (Exception e) {
         e.printStackTrace();
      }



   }
}
