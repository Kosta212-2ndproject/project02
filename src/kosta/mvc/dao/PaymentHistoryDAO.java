package kosta.mvc.dao;

import kosta.mvc.dto.PaymentHistoryDTO;

import java.util.List;

public interface PaymentHistoryDAO {

   /**
    * 주문번호에 해당하는 결제내역 추가하기
    * */
   int insert(PaymentHistoryDTO paymentHistoryDTO);

   /**
    * 전체 PaymentHistoryDTO 검색하기
    * */
   List<PaymentHistoryDTO> selectAll();
}
