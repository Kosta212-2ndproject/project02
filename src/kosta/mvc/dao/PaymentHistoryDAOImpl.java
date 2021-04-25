package kosta.mvc.dao;

import kosta.mvc.dto.PaymentHistoryDTO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentHistoryDAOImpl implements PaymentHistoryDAO {

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
         System.out.println(result);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DbUtil.dbClose(ps, con);
      }
      return result;
   }

   @Override
   public List<PaymentHistoryDTO> selectAll() {
//      Connection con = null;
//      PreparedStatement ps = null;
//      ResultSet rs = null;
//      List<PaymentHistoryDTO> list = new ArrayList<>();
//      try {
//         con = DbUtil.getConnection();
//         ps = con.prepareStatement("select * from payment order by pay_price");
//         rs = ps.executeQuery();
//         while (rs.next()) {
//            list.add(new PaymentHistoryDTO(
//                  rs.getString(1),
//                  rs.getString(2),
//                  rs.getString(3),
//                  rs.getString(4),
//                  rs.getString(5),
//                  rs.(6),
//                  rs.getInt(7)
//            ));
//         }
//
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         DbUtil.dbClose(rs, ps, con);
//      }
//      return list;

      return null;
   }
}
