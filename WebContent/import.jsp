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
   <script src="js/importJS.js"></script>

   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
<%--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.0/moment.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.39.0/js/tempusdominus-bootstrap-4.min.js" integrity="sha512-k6/Bkb8Fxf/c1Tkyl39yJwcOZ1P4cRrJu77p83zJjN2Z55prbFHxPs9vN7q3l3+tSMGPDdoH51AEU8Vgo1cgAA==" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.39.0/css/tempusdominus-bootstrap-4.min.css" integrity="sha512-3JRrEUwaCkFUBLK1N8HehwQgu8e23jTH4np5NHOmQOobuC4ROQxFwFgBLTnhcnQRMs84muMh0PnnwXlPq5MGjg==" crossorigin="anonymous" />


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


<!-- 결제 기간 date -->
<div class="container">
   <div class="row">
      <div class="col-sm-6">
         <input type="text" class="form-control datetimepicker-input" id="datetimepicker5" data-toggle="datetimepicker" data-target="#datetimepicker5"/>
      </div>
      <script type="text/javascript">
          $(function () {
              $('#datetimepicker5').datetimepicker();
          });
      </script>
   </div>
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
                              <label class="col-md-4 custom-control-label" for="awesomeness"
                                     style="font: 15px sans-serif">환불
                                 사유</label>
                              <div class="col-md8">
                           <textarea id="cancel_reason" name="cancel_reason"
                                     class="form-control" style="font: 13px sans-serif">환불사유를 입력해주세요.</textarea>
                              </div>
                           </div>
                           <div class="form-group">
                              <label class="col-md-4 custom-control-label" for="awesomeness"
                                     style="font: 15px sans-serif">결제
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
               <button type="button" class="btn btn-secondary" data-dismiss="modal" style="font: 13px sans-serif">아니요.
                  그냥
                  두겠습니다.
               </button>
               <button type="button" id="modal_btn_cancel" class="btn btn-primary" style="font: 13px sans-serif">네.
                  취소해주세요.
               </button>
            </div>
         </div>
      </div>
   </div>
</body>
</html>
