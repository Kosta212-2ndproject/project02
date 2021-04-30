package kosta.mvc.servlet;

import com.siot.IamportRestHttpClientJava.request.CancelData;
import kosta.mvc.IamportClient;
import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dao.ProductDAO;
import kosta.mvc.dao.ProductDAOImpl;
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
   ProductDAO productDAO = new ProductDAOImpl();
   OrderDAO orderDAO = new OrderDAOImpl();

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

         /**
          * 관리자가 취소를 누르면 사용자가 구매했던 수량만큼 다시 재고량에 더해줘야 한다.
          * 1. 문제점: 지금 쿠폰테이블이랑 연결되어있기에  주문상세에 있는 수량을 가져 올 수가 있다. (서로 연결되어있기 때문에)
          * 2. 문제점 해결방안:  원래가격*수량 + 배송비(2000원) = 총가격
          * 해결방안 조건 1) 해당하는 상품 아이디의 수량 1개일때 가격을 알아온다.
          *            2) 사용자가 구매한 총금액의 가격을 알아온다.
          *            로직: (총가격-배송비) / 상품의 원래가격 = 수량
          */

         if (payment != null) {
            long productId = Long.parseLong(orderNo); // order 테이블에 있는 주문 id

            int orderNoSplit = Integer.parseInt(orderNo.substring(0, 5)); // product 테이블에 들어있는 상품id
            System.out.println(orderNoSplit);
            System.out.println(productId);

            int totalPrice = orderDAO.selectByOrderIdPrice(productId);   // order 테이블에 있는 결제된 총금액 가져오기
            System.out.println("getPrice: " + totalPrice);

            int originPrice = productDAO.selectByOriginPrice(orderNoSplit); // product 테이블에 들어있는 상품가격
            System.out.println("originPrice: " + originPrice);

            int getQty = (totalPrice - 2000) / originPrice;
            System.out.println("getQty: " + getQty + "개");

            int deleteResult = orderDAO.deleteOrder(productId);
            System.out.println("deleteResult: (" + deleteResult + ") 삭제했습니다.");

            if(deleteResult == 1) {
               int qtyPlusResult = orderDAO.updateQtyPlus(orderNoSplit, getQty);   // 삭제가 되었을 떄 상품테이블에 있는 재고량을 구매자가 산만큼 다시 추가한다.
               System.out.println("qtyPlusResult: " + qtyPlusResult);
               System.out.println("결제취소가 되어 " + getQty + "개 만큼 다시 재고량을 추가했습니다.");
            }

         }

         PrintWriter out = response.getWriter();
         out.println(payment);

      } catch (Exception e) {
         e.printStackTrace();
      }


   }
}
