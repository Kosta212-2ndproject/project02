package kosta.mvc.servlet;

//import com.siot.IamportRestHttpClientJava.response.IamportResponse;
//import com.siot.IamportRestHttpClientJava.response.Payment;

import kosta.mvc.IamportClient;
import kosta.mvc.response.IamportResponse;
import kosta.mvc.response.PaymentAll;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "PaySearchDateServlet", value = "/paySearchDate")
public class PaySearchDateServlet extends HttpServlet {
   IamportClient client;


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      String api_key = "7617961756514293";
      String api_secret = "696tEA3mga5eMf0kRvvgMsBaCgoyLrTRA0leAoBRyH6kX6FPCa6pDHzfXYNJpHBZHWeikQ9SyfdvmSlZ";


      try {

         String id = request.getParameter("option"); // status
         int page = Integer.parseInt(request.getParameter("buttonOption"));
         long from = Long.parseLong(request.getParameter("startTime"));
         long to = Long.parseLong(request.getParameter("endTime"));

         client = new IamportClient(api_key, api_secret);
         IamportResponse<PaymentAll> paymentAll = client.selectDateSearch(id, page,5, from, to);

         JSONArray arr = JSONArray.fromObject(paymentAll.getResponse().getList());
         JSONObject obj = JSONObject.fromObject(paymentAll.getResponse());

         PrintWriter out = response.getWriter();

//         System.out.println(obj);
         out.println(obj);

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
