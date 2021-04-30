package kosta.mvc.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PayQtyPlusServlet", value = "/PayQtyPlusServlet")
public class PayQtyPlusServlet extends HttpServlet {


   /**
    * 관리자가 취소를 누르면 사용자가 구매했던 수량만큼 다시 재고량에 더해줘야 한다.
    * 1. 문제점: 지금 쿠폰테이블이랑 연결되어있기에  주문상세에 있는 수량을 가져 올 수가 있다. (서로 연결되어있기 때문에)
    * 2. 문제점 해결방안:  원래가격*수량 + 배송비(2000원) = 총가격
    * 해결방안 조건 1) 해당하는 상품 아이디의 수량 1개일때 가격을 알아온다.
    *            2) 사용자가 구매한 총금액의 가격을 알아온다.
    *            로직: (총가격-배송비) / 상품의 원래가격 = 수량
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

}
