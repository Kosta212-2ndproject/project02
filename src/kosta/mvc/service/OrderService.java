package kosta.mvc.service;

import kosta.mvc.dao.OrderDAO;
import kosta.mvc.dao.OrderDAOImpl;
import kosta.mvc.dto.OrderDTO;
import kosta.mvc.dto.OrderLineDTO;

import java.sql.SQLException;

public interface OrderService {

   void insertOrder(OrderDTO orderDTO) throws SQLException;
   void insertOrderLine(OrderLineDTO orderLineDTO) throws SQLException;
}
