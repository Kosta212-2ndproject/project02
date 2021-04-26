<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Title</title>
   <style>
      .a {
         border: solid red 5px
      }

      span {
         width: 150px;
         color: red
      }

      input {
         border: solid gray 1px
      }

      table {
         width: 100%
      }

      th, td {
         border: 1px gray solid;
         text-align: center;
         padding: 3px
      }

      h2 {
         text-align: center
      }
   </style>
   <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
   <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

   <script type="text/javascript" src="js/importJS.js"></script>

   <script>
       function test() {

       }

   </script>
</head>
<body onload="">

<h2> 상품 리스트 ! </h2>
<table id="produectTable" cellspacing="0">
   <tr bgcolor="pink">
      <th>상품번호</th>
      <th>상품이름</th>
      <th>상품가격</th>
      <th>주문</th>
   </tr>
</table>

<hr>
<input type="button" value="결제내역">
<h2> 결제 내역! </h2>
<select name="" id="payState">
   <option value="ready">미결제</option>
   <option value="paid">결제완료</option>
   <option value="failed">결제실패</option>
   <option value="cancelled">환불취소</option>
</select>

<table id="cashListTable" cellspacing="0">
   <tr bgcolor="pink">
      <th>거래 고유번호</th>
      <th>주문번호</th>
      <th>결제상태</th>
      <th>카드 승인번호</th>
      <th>카드사명</th>
      <th>할부개월 수</th>
      <th>결제금액</th>
   </tr>
</table>
</body>
</html>
