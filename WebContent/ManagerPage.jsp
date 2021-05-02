<%--
  Created by IntelliJ IDEA.
  User: kimseungwon
  Date: 2021/05/01
  Time: 11:11 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
   <script src="js/managerPage.js"></script>

   <!-- Theme JS -->
   <script src="js/blk-design-system.js"></script>
</head>

<script>
    $(document).ready(function () {

        //Get Green Time
        var date1 = new Date(new Date(new Date().toLocaleDateString()).getTime());
        var date2 = new Date(new Date(new Date().toLocaleDateString()).getTime()+24*60*60*1000-1);

        console.log(date1);
        console.log("moment: " + moment().format('YYYY-MM-DD 00:00:00'));

//
// //Format time 2018-06-06 00:00:00
// //If only the simple formatting becomes 2018-6-6 0:0:0, you need to use the trinocular operation to judge and add 0 to the appropriate place to complete the required format.
//         var startTime = date1.getFullYear() + "-" + ((date1.getMonth() + 1) < 10 ? "0" + (date1.getMonth() + 1):(date1.getMonth() + 1))+ "-" + (date1.getDate() < 10 ? "0" + date1.getDate():date1.getDate()) + " " + (date1.getHours()<10?"0"+date1.getHours():date1.getHours()) + ":" + (date1.getMinutes()<10?"0"+date1.getMinutes():date1.getMinutes()) + ":" + (date1.getSeconds()<10?"0"+date1.getSeconds():date1.getSeconds());


//Format time 2018-06-06 23:59:59
        var endTime = date2.getFullYear() + '-' + (date2.getMonth() + 1) + '-' + date2.getDate() + ' ' + date2.getHours() + ':' + date2.getMinutes() + ':' + date2.getSeconds()
        // console.log(startTime);
        // console.log(endTime);

        // let startTime = new Date();
        // let endTime = new Date();

        $('#startDate').datetimepicker({
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                up: "fa fa-chevron-up",
                down: "fa fa-chevron-down",
                previous: 'fa fa-chevron-left',
                next: 'fa fa-chevron-right',
                today: 'fa fa-screenshot',
                clear: 'fa fa-trash',
                close: 'fa fa-remove'
            },
            format: 'YYYY-MM-DD HH:MM:SS',
            defaultDate: moment().format('YYYY-MM-DD 00:00:00'),
        });

        $('#endDate').datetimepicker({
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                up: "fa fa-chevron-up",
                down: "fa fa-chevron-down",
                previous: 'fa fa-chevron-left',
                next: 'fa fa-chevron-right',
                today: 'fa fa-screenshot',
                clear: 'fa fa-trash',
                close: 'fa fa-remove'
            },
            format: 'YYYY-MM-DD HH:MM:SS',
            defaultDate: endTime,
        });
    });


    $('#myModal').modal();

</script>
<body onload="">
<%--<i class="fa fa-clock-o"></i>--%>
<h1 style="text-align: center; padding-top: 50px">결제 내역 조회</h1>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
   <div class="modal-dialog" role="document">
      <div class="modal-content">
         <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLabel">결제 취소</h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>
         <p/>
         <div class="modal-body">
            <label for="reasonTextarea"> <span style="font-size: 17px">환불 사유</span>
               <textarea id="cancel_reason" rows="3" cols="50" placeholder="환불 사유를 입력하세요."></textarea>
            </label>
            <p/>
            <div class="form-check form-check-radio">
               <label class="form-check-label">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                  <span style="color: black">전액 취소</span>
                  <span class="form-check-sign"></span>
               </label>
            </div>
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">아니요. 취소안할게요.</button>
            <button type="button" id="r_cancel_all" class="btn btn-primary" data-dismiss="modal">네. 취소하겠습니다.</button>
         </div>
      </div>
   </div>
</div>

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
      <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;가맹점 고유번호<br>&nbsp;&nbsp; 주문번호</th>
      <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;결제금액<br> &nbsp;&nbsp;(취소금액)</th>
      <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp; 구분<br>&nbsp;&nbsp; (클릭)</th>
      <th class="text-left" style="font-size: 15px">&nbsp;&nbsp;&nbsp;PG사<br>&nbsp;&nbsp;(상점아이디)</th>
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
<form action="" id="totalShow">

</form>

<%--<form action="" id="button-page">--%>
<%--</form>--%>

<!-- 페이지 버튼 -->
<nav aria-label="Page navigation example">
   <ul id="pageBtns" class="pagination justify-content-center">

   </ul>
</nav>

</body>
</html>
