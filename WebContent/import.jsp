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
   <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
         rel="stylesheet">

   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

   <link rel="stylesheet" href="css/animate.css">

   <link rel="stylesheet" href="css/owl.carousel.min.css">
   <link rel="stylesheet" href="css/owl.theme.default.min.css">
   <link rel="stylesheet" href="css/magnific-popup.css">

   <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

   <link rel="stylesheet" href="css/flaticon.css">
   <link rel="stylesheet" href="css/style.css">

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
   <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
   <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script type="text/javascript" src="js/importJS.js"></script>

</head>
<body onload="payList(1)">
<h2> 결제 내역! </h2>
<select id="payState">
   <option value="all">전체</option>
   <option value="ready">미결제</option>
   <option value="paid">결제완료</option>
   <option value="failed">결제실패</option>
   <option value="cancelled">결제취소</option>
</select>
<div class="form-group"> <!-- Date input -->
   <label class="control-label" for="date">결제기간</label>
   <input  type="text" placeholder="click to show datepicker"  id="pickyDate"/>
</div>
<table id="cashListTable" cellspacing="0">
   <tr bgcolor="pink">
      <th>가맹점 고유번호</th>
      <th>주문번호</th>
      <th>결제상태</th>
      <th>카드 승인번호</th>
      <th>카드사명</th>
      <th>할부개월 수</th>
      <th>결제금액</th>
      <th>취소</th>
   </tr>
</table>

<form action="" id="button-page">
</form>

<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <h5 class="modal-title" id="staticBackdropLabel" style="font: 16px sans-serif">결제 취소</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
            </button>
         </div>

         <div class="modal-body">
            <div class="bootbox-body">
               <div class="row">
                  <div class="col-md-12">
                     <form id="cancel_form">
                        <div class="form-group">
                           <label class="col-md-4 custom-control-label" for="awesomeness" style="font: 15px sans-serif">환불
                              사유</label>
                           <div class="col-md8">
                           <textarea id="cancel_reason" name="cancel_reason"
                                     class="form-control" style="font: 13px sans-serif">환불사유를 입력해주세요.</textarea>
                           </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-4 custom-control-label" for="awesomeness" style="font: 15px sans-serif">결제
                              취소</label>
                           <div class="col-md8">
                              <div class="radio">
                                 <label for="r_cancel_all">
                                    <input type="radio" name="r_cancel_type" id="r_cancel_all" value="all"
                                           checked="checked" style="font: 13px sans-serif">전액취소
                                 </label>
                              </div>
                           </div>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>

         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal" style="font: 13px sans-serif">아니요. 그냥
               두겠습니다.
            </button>
            <button type="button" id="modal_btn_cancel" class="btn btn-primary" style="font: 13px sans-serif">네. 취소해주세요.
            </button>
         </div>
      </div>
   </div>
</div>
</body>
</html>
