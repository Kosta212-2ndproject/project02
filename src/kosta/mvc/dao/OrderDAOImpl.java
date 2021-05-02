package kosta.mvc.dao;

import kosta.mvc.dto.*;
import kosta.mvc.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

   public int updateQty(int prodId, int qty) throws SQLException {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      String sql = "UPDATE PRODUCT SET PROD_QTY = prod_qty - ? WHERE prod_id = ?";

      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, qty);
         ps.setInt(2, prodId);

         result = ps.executeUpdate();

      } finally {
         DbUtil.dbClose(ps, con);
      }

      return result;
   }

   @Override
   public int deleteOrder(long proId) throws SQLException {

      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      String sql = "DELETE FROM ORDERT WHERE O_NO = ?";

      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setLong(1, proId);

         result = ps.executeUpdate();

      } finally {
         DbUtil.dbClose(ps, con);
      }

      return result;
   }

   @Override
   public int selectByOrderIdPrice(long prodId) throws SQLException {
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      int result = 0;
      String sql = "select O_PRICE from ORDERT where O_NO = ?";

      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setLong(1, prodId);
         rs = ps.executeQuery();
         if (rs.next()) {
            result = rs.getInt(1);
         }
      } finally {
         DbUtil.dbClose(rs, ps, con);
      }
      return result;
   }


   @Override
   public int updateQtyPlus(int prodId, int qty) throws SQLException {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      String sql = "UPDATE PRODUCT SET PROD_QTY = prod_qty + ? WHERE prod_id = ?";

      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, qty);
         ps.setInt(2, prodId);

         result = ps.executeUpdate();

      } finally {
         DbUtil.dbClose(ps, con);
      }

      return result;
   }

   @Override
   public int insert(PaymentHistoryDTO dto) {
      PreparedStatement ps = null;
      Connection con = null;
      int result = 0;
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement("insert into payment(pay_no, o_no, pay_status, pay_card_no, pay_card_name, pay_installmant_month, pay_price) values(?,?,?,?,?,?,?)");
         ps.setString(1, dto.getImpUid());
         ps.setString(2, dto.getMerchantUid());
         ps.setString(3, dto.getPayStatus());
         ps.setString(4, dto.getCardNumber());
         ps.setString(5, dto.getCardName());
         ps.setString(6, dto.getCardQuota());
         ps.setInt(7, dto.getPayPrice());
         result = ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DbUtil.dbClose(ps, con);
      }
      return result;
   }

   @Override
   public int insertOrder(OrderDTO orderDTO) throws SQLException {


      Connection con = null;
      PreparedStatement ps = null;
      String sql = "insert into ORDERT values (?, ?, TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?, ?, ?, 1000,0)";

      int result = 0;
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setLong(1, orderDTO.getOrderNo());
         ps.setString(2, orderDTO.getUserId());
         ps.setString(3, orderDTO.getOrderDate()); // 겟데이트
         ps.setInt(4, orderDTO.getOrderPrice());
         ps.setString(5, orderDTO.getOrderAddr());
         ps.setString(6, orderDTO.getOrderZipCode());
         ps.setString(7, orderDTO.getOrderShipNo());
         ps.setString(8, orderDTO.getOrderRecipientName());

         result = ps.executeUpdate();
      } finally {
         DbUtil.dbClose(ps, con);
      }

      return result;
   }

   @Override
   public int insertOrderLine(OrderLineDTO orderLineDTO) throws SQLException {


      Connection con = null;
      PreparedStatement ps = null;
      String sql = "";

      int result = 0;

      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
//         ps.setInt(1, prodId);

         result = ps.executeUpdate();
      } finally {
         DbUtil.dbClose(ps, con);
      }

      return result;
   }

   @Override
   public int updateAddress(MemberDTO memberDTO) throws SQLException {
      Connection con = null;
      PreparedStatement ps = null;
      int result = 0;
      String sql = "UPDATE USERLIST SET USER_ZIPCODE = ?, USER_ADDR = ?, USER_ADDRDETAIL = ? WHERE USER_ID = ?";

      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, memberDTO.getUserZipcode());
         ps.setString(2, memberDTO.getUserAddr());
         ps.setString(3, memberDTO.getUserAddrDetail());
         ps.setString(4, memberDTO.getUserId());

         result = ps.executeUpdate();

      } finally {
         DbUtil.dbClose(ps, con);
      }

      return result;
   }

}
