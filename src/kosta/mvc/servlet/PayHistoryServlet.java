package kosta.mvc.servlet;

import com.google.gson.Gson;
//import com.siot.IamportRestHttpClientJava.response.IamportResponse;
//import com.siot.IamportRestHttpClientJava.response.Payment;
import com.google.gson.GsonBuilder;
import kosta.mvc.IamportClient;
import kosta.mvc.response.IamportResponse;
import kosta.mvc.response.Payment;
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
import java.util.ArrayList;


@WebServlet(name = "PayHistoryServlet", value = "/payHistory")
public class PayHistoryServlet extends HttpServlet {
   IamportClient client;


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

      String api_key = "7617961756514293";
      String api_secret = "696tEA3mga5eMf0kRvvgMsBaCgoyLrTRA0leAoBRyH6kX6FPCa6pDHzfXYNJpHBZHWeikQ9SyfdvmSlZ";

//      System.out.println(paymentState);

      try {

         String id = request.getParameter("option"); // status
         int page = Integer.parseInt(request.getParameter("buttonOption"));
         client = new IamportClient(api_key, api_secret);
         IamportResponse<PaymentAll> paymentAll = client.selectAll(id, page,15);

         //Payment payment = paymentAll.getResponse().getList().get(0);

         //System.out.println(payment.getApplyNum());

         //Gson gson = new GsonBuilder().create();

         JSONArray arr = JSONArray.fromObject(paymentAll.getResponse().getList());
         JSONObject obj = JSONObject.fromObject(paymentAll.getResponse());

         //System.out.println(gson.toJson(payment.getResponse()));
         //System.out.println(payment);
         PrintWriter out = response.getWriter();
         //out.println(arr);
         out.println(obj);

      } catch (Exception e) {
         e.printStackTrace();
      }

//      try {
//         client = new IamportClient(api_key, api_secret);
//         IamportResponse<Payment> payment = client.paymentByImpUid(impUid);
//
//         String resImpUid = payment.getResponse().getImpUid();
//         String resMerchantUid = payment.getResponse().getMerchantUid();
//         String resStatus = payment.getResponse().getStatus();
//         String resCardName = payment.getResponse().getCardName();
//         String resCardNumber = payment.getResponse().getCardNumber();
//         int resCardQuota = payment.getResponse().getCardQuota();
//         int resPayPrice = ((BigDecimal)payment.getResponse().getAmount()).intValue();
//
//         String cardQuota = String.valueOf(resCardQuota);
//
//
//         switch (resStatus) {
//            case "paid":
//               resStatus = "결제완료";
//               break;
//         }
//
//         if(resCardQuota == 0) {
//            cardQuota = "일시불";
//         } else {
//            cardQuota += "개월";
//         }
//
//         System.out.println("resImpUid: " + resImpUid);
//         System.out.println("resMerchantUid: " + resMerchantUid);
//         System.out.println("resStatus: " + resStatus);
//         System.out.println("resCardName: " + resCardName);
//         System.out.println("resCardNumber: " + resCardNumber);
//         System.out.println("resCardQuota: " + resCardQuota);
//         System.out.println("resPayPrice: " + resPayPrice);
//
//         System.out.println("cardQuota: " + cardQuota);
//
//         PaymentHistoryDTO dto = new PaymentHistoryDTO(resImpUid, resMerchantUid, resStatus, resCardNumber, resCardName, cardQuota, resPayPrice);
//
//         System.out.println(dto);   // dto 객체
//
//         PaymentHistoryDAO dao = new PaymentHistoryDAOImpl();
//         int result = dao.insert(dto);
//         System.out.println(result);
//
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
   }
}
