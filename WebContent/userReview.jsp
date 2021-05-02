<%--
  Created by IntelliJ IDEA.
  User: kimseungwon
  Date: 2021/05/01
  Time: 11:11 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <title>Title</title>
   <style>
      /* 체크박스 정렬 */
      input[id="totalCancel"] {
         position: relative;
         top: 1.5px;
      }

      label textarea {
         vertical-align: top;
      }

      input[type=checkbox] {
         transform: scale(1.2);
      }

      table {
         color: white;
      }

      .searchMenuBtn input {
         /*float: left;*/
         display: table-cell
      }
   </style>
   <!-- Fonts -->
   <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,600,700,800" rel="stylesheet">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

   <!-- Icons -->
   <link href="css/nucleo-icons.css" rel="stylesheet">
   <link href="css/blk-design-system.css" rel="stylesheet">
   <link href="scss/blk-design-system.scss" rel="stylesheets">
   <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">

   <!-- Theme CSS -->
   <link type="text/css" href="css/blk-design-system.min.css" rel="stylesheet">

   <!-- Core -->
   <script src="js/moment.min.js"></script>
   <script src="js/jquery.min.js"></script>
   <script src="js/jquery.sharrre.min.js"></script>
   <script src="js/bootstrap-datetimepicker.js"></script>
   <%--   <script src="js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>--%>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/bootstrap-switch.js"></script>
   <script src="js/nouislider.min.js"></script>
   <script src="js/chartjs.min.js"></script>
   <script src="js/perfect-scrollbar.jquery.min.js"></script>
   <script src="js/userReview.js"></script>

   <!-- Theme JS -->
   <script src="js/blk-design-system.js"></script>
</head>

<script>


</script>
<body onload="">
<%--<i class="fa fa-clock-o"></i>--%>
<h1 style="text-align: center; padding-top: 50px">유저 결제 내역 조회</h1>

<input type="hidden" id="userId" value="<%= session.getAttribute("userId")%>">
<!-- testTable -->
<table class="table" id="cashListTable">
   <thead>
   <tr>
      <th class="text-center" id="totalShowTable" width="100px" style="font-size: 14px">주문번호</th>
      <th class="text-left" style="font-size: 15px">주문금액</th>
      <th class="text-left" style="font-size: 15px">결제상태 | 결제날짜</th>
      <th class="text-left" style="font-size: 15px">상품아이디: 상품이름</th>
      <th class="text-left" style="font-size: 15px">구매자이름</th>
      <th class="text-left" style="font-size: 15px">이메일</th>
      <th class="text-left" style="font-size: 15px">휴대폰</th>
      <th class="text-left" style="font-size: 15px">주소</th>
   </tr>
   </thead>
   <tbody>

   </tbody>
</table>

<%--<form action="" id="button-page">--%>
<%--</form>--%>

<!-- 페이지 버튼 -->
<nav aria-label="Page navigation example">
   <ul id="pageBtns" class="pagination justify-content-center">

   </ul>
</nav>

</body>
</html>
