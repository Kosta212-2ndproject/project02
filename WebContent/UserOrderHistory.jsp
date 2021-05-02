<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="common/header.jsp" />

<!DOCTYPE html>
<html>

<head>
   <title>ㅉ ㅏ ㄴ</title>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
   <script src="js/managerPage.js"></script>

   <!-- Theme JS -->
   <script src="js/blk-design-system.js"></script>
</head>

<body>
<!-- 헤더영역 -->
<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_member_detail.jpg');" data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text align-items-end justify-content-center">
         <div class="col-md-9 ftco-animate mb-5 text-center">
            <p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp"> Home <i class="fa fa-chevron-right"></i></a></span> <span>회원정보 <i class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">회원정보</h2>
         </div>
      </div>
   </div>
</section>

<!-- 본문 -->
<section class="ftco-section">
   <div class="container">
      <div class="row">

         <!-- 본문 내용 -->
         <div class="col-md-9">

            <!-- 본문 타이틀 -->
            <div class="row mb-4">
               <!--
                <div class="col-md-12 d-flex justify-content-between align-items-center">
                  <h3 class="product-select">회원정보</h4>
               </div>
               -->
            </div>

            <!-- 본문 내용 -->
            <div class="row mb-3">
               <div class="container">
                  <div class="row">
                     <div class="col-md-12">
                        <div class="searchMenuBtn">
                           <select id="payState">
                              <option value="all">전체</option>
                              <option value="ready">미결제</option>
                              <option value="paid">결제완료</option>
                              <option value="failed">결제실패</option>
                              <option value="cancelled">결제취소</option>
                           </select>
                           &nbsp;&nbsp;&nbsp;
                           <input type="text" id="startDate" class="form-control datepicker" style="width: 300px; font-size: 16px"/>
                           &nbsp;&nbsp;
                           <input type="text" id="endDate" class="form-control datepicker" style="width: 300px; font-size: 16px"/>
                           &nbsp;&nbsp;&nbsp;
                           <button type="button" class="btn btn-primary" onclick="searchDateFunc(1)" style="font-size: 16px">검색
                           </button>
                        </div>
                     </div>
                  </div>
               </div>

               <!-- testTable -->
               <table class="table" id="cashListTable">
                  <thead>
                  <tr>
                     <th class="text-center" id="totalShowTable" width="100px" style="font-size: 14px">#</th>
                     <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;주문번호</th>
                     <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;결제금액</th>
                     <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;결제상태 </th>
                     <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;주문명</th>
                     <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;PG승인번호<br>&nbsp;&nbsp;(카드사승인번호)</th>
                     <th class="text-left" style="font-size: 15px; width: 100px">&nbsp;&nbsp;&nbsp;결제상세</th>
                     <th class="text-left" style="font-size: 15px;">&nbsp;&nbsp;&nbsp;주문명<br>&nbsp;&nbsp;구매자(이름/이메일/휴대폰/주소)</th>
                     <th class="text-left" style="font-size: 15px; width: 180px">&nbsp;&nbsp;&nbsp;결제시각</th>
                     <th class="text-left" style="font-size: 15px; width: 250px">&nbsp;&nbsp;&nbsp;상태</th>
                  </tr>
                  </thead>
                  <tbody>

                  </tbody>
               </table>

               <!-- 페이지 버튼 -->
               <nav aria-label="Page navigation example">
                  <ul id="pageBtns" class="pagination justify-content-center">

                  </ul>
               </nav>
               <!-- END -->
            </div>

            <!-- 본문 하단 -->
            <div class="row mt-5">
            </div>
         </div>

         <!-- 사이드바 내용 -->
         <div class="col-md-3">
            <div class="sidebar-box ftco-animate">
               <div class="categories">
                  <h3>Member Menu</h3>
                  <ul class="p-0">
                     <li><a href="front?key=member&methodName=readMemberInfo">회원정보 <span class="fa fa-chevron-right"></span></a></li>
                     <li><a href="UserOrderHistory.jsp">주문내역 <span class="fa fa-chevron-right"></span></a></li>
                     <li><a href="front?key=member&methodName=memberReview">리뷰목록 <span class="fa fa-chevron-right"></span></a></li>
                     <li><a href="front?key=member&methodName=memberQuestion">질문목록 <span class="fa fa-chevron-right"></span></a></li>
                     <li><a href="member_leave.jsp">회원탈퇴 <span class="fa fa-chevron-right"></span></a></li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>



<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
   <svg class="circular" width="48px" height="48px">
      <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee" />
      <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate-3.0.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.animateNumber.min.js"></script>
<script src="js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="js/google-map.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
<script src="js/main.js"></script></body>

</body>
</html>
<jsp:include page="common/footer.jsp" />
