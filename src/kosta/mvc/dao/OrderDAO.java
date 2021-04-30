package kosta.mvc.dao;

import kosta.mvc.dto.OrderDTO;
import kosta.mvc.dto.OrderLineDTO;
import kosta.mvc.dto.PaymentHistoryDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

   /**
    * 상품 아이디에 해당하는 수량을 가져와 사용자가 구매한 수량만큼 빼기
    */
   int updateQty(int prodId, int qty) throws SQLException;

   /**
    * 상품 아이디에 해당하는 수량을 가져와 사용자가 구매한 수량만큼 더하기
    */
   int updateQtyPlus(int prodId, int qty) throws SQLException;

   /**
    * 주문번호에 해당하는 결제내역 추가하기
    * */
   int insert(PaymentHistoryDTO paymentHistoryDTO);

   /**
    * 결제가 완료되면 주문테이블에 내용 추가
    */
   int insertOrder(OrderDTO orderDTO) throws SQLException;


   int insertOrderLine(OrderLineDTO orderLineDTO) throws SQLException;
}
