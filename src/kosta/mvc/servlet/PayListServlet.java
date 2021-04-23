package kosta.mvc.servlet;

//import com.siot.IamportRestHttpClientJava.response.IamportResponse;
//import com.siot.IamportRestHttpClientJava.response.Payment;

import kosta.mvc.IamportClient;
import kosta.mvc.dao.PaymentHistoryDAO;
import kosta.mvc.dao.PaymentHistoryDAOImpl;
import kosta.mvc.dao.ProductDAO;
import kosta.mvc.dao.ProductDAOImpl;
import kosta.mvc.dto.PaymentHistoryDTO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.response.IamportResponse;
import kosta.mvc.response.Payment;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "PayListServlet", value = "/payList")
public class PayListServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.setContentType("text/html; charset=UTF-8");
      // service -> dao 호출
      PaymentHistoryDAO dao = new PaymentHistoryDAOImpl();
      List<PaymentHistoryDTO> list = dao.selectAll();

      // list를 javascript 해석할 수 있는 json형태로 변환!!
      JSONArray arr = JSONArray.fromObject(list);
      PrintWriter out = response.getWriter();
      out.println(arr);
   }
}
