package kosta.mvc.service;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dto.OrderDTO;
import kosta.mvc.dto.OrderLineDTO;

import java.sql.SQLException;

public class OrderServiceImpl implements OrderService{
   private OrderDAO orderDAO = new OrderDAOImpl();

   @Override
   public void insertOrder(OrderDTO orderDTO) throws SQLException {
      int result = orderDAO.insertOrder(orderDTO);
      if(result == 0) throw new SQLException("등록되지 않았습니다.");
   }


   @Override
   public void insertOrderLine(OrderLineDTO orderLineDTO) throws SQLException {
      int result = orderDAO.insertOrderLine(orderLineDTO);
      if(result == 0) throw new SQLException("등록되지 않았습니다.");
   }
}
