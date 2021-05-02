<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="common/headerAdmin.jsp" />
<!DOCTYPE html>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,800" rel="stylesheet" />
    <link href="css/main.css" rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="../css/animate.css">

<link rel="stylesheet" href="../css/owl.carousel.min.css">
<link rel="stylesheet" href="../css/owl.theme.default.min.css">
<link rel="stylesheet" href="../css/magnific-popup.css">

<link rel="stylesheet" href="../css/flaticon.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="css/review.css">

</HEAD>

<BODY>
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('images/bg_2.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="indexAdmin.jsp">Home <i
								class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a
							href="front?key=notice&methodName=selectAllforAdmin">Review <i
								class="fa fa-chevron-right"></i></a></span> <span>Review List <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Review List </h2>
				</div>
			</div>
		</div>
	</section>
<br>
<!-- Q&A List start -->
<!--  <div class="s005">
      <form>
        <fieldset>
          <div class="inner-form">
            <div class="input-field">
              <input class="form-control" id="choices-text-preset-values" type="text" placeholder="Type to search..." />
              <br><button class="btn-search" type="button" style="text-align: center;">search </button>
            </div>
          </div>
        </fieldset>
      </form>
    </div> -->

	<section class="ftco-section">
		<div class="container">
    		<div class="row mt-5">
    		
          		<div class="col-md-12 nav-link-wrap">
            	<div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
<!-- Tabmenu  -->
              <a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true"> Menu</a>

           	 <a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">All </a>

             <!--<a class="nav-link ftco-animate mr-lg-1" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">By Category</a>
             
             <a class="nav-link ftco-animate mr-lg-1" id="v-pills-4-tab" data-toggle="pill" href="#v-pills-4" role="tab" aria-controls="v-pills-4" aria-selected="false">By Keyword</a> -->
            </div>
          </div>
          
          
          
          <div class="col-md-12 tab-wrap">
            <div class="tab-content bg-light" id="v-pills-tabContent">
<!-- 1번째 탭메뉴의 contents All -->
              <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
              	<div class="p-4" >
              	<h2 style="text-align: center;">Welcome to Admin's Menu</h2>
              	</div>
              </div>
<!-- 2번째 탭메뉴의 contents  -->
              <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
              	<div class="p-4" id="minjooAll">

	             </div>
              </div>			
              </div>
            </div>
          </div>
        </div>
 <!--  -->       
        
        <div class="row mt-6">
        <div class="col-md-13 tab-wrap">
        	<div class="tab-content bg-light" id="v-pills-tabContent2">
        
      					  
							
				</div>			
			</div>
        </div>
        
    	</div>
    </section>
    
    
  














<!-- Q&A List end -->


	<p>
		<br> <br> <br> <br>
		<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
	<%-- <script src="${path}/js/boardSelect.js"></script> --%>
	<script type="text/javascript">

	$(document).ready(function() {
		
		
		///////////////////////////////////////////////////
	 	
		//alert("${prod.prodId}")
		//var isRun=false;
		$(document).on("click","#v-pills-2-tab", function(){
			//alert(22)
				/* if(isRun){
					//alert("processing...");
					return;
				}
				isRun = true; */
			$.ajax({
   			 url:"${path}/reviewSelectAll" , // 서버요청주소
   			 type: "post", //method방식 = 전송방식(get, post, put, delete)
   			 dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
   			 success : function(result){
   				let str = "<table id='table'><tr>";
   				str += "<th> 회원아이디 </th>";
   				str += "<th> 제목 </th>";
   				str += "<th> 내용 </th>";
   				str += "<th> 별점 </th>";
   				str += "<th> 등록일 </th>";
   				//str += "<th> 사진 </th>";
   				str += "<th> 조회수 </th>";
				$.each(result, function(index, item) {
					str += "<tr>"
					str += "<td>" + item.userId + "</td>"
					str += "<td><a href='front?key=review&methodName=selectByReviewId&reviewId="+item.reviewId+"&prodId="+item.prodId+"&reviewUserId="+item.userId+"'>" + item.reviewTitle + "</td>"
					str += "<td>" + item.reviewContent + "</td>"
					str += "<td>" + item.reviewStarScope + "</td>"
					str += "<td>" + item.reviewRegdate + "</td>"
					//str += "<td><img width='175' height='200' src='"+item.reviewImgUrl+"'></td>";
					str += "<td>" + item.reviewVcount + "</td>"
					//str += "<td><input type='button' value='delete'/></td>"
					str += "</tr>"
				});
				str += "</table>"

				
				//겹치는 css클래스 명이 있을 경우 , id 를 줘서 unique 하게 처리하면 됨 
				//브라우저에서 지원하는 소스코드 활용해서 css 적용해보면서 할 것!  
				//->미리 어떤식으로 적용되는지 확인 후, 실제 코드에서 변경해 주면됨 
				//$(".col-md-7").after(str);//형제노드로추가되는 것. 
				$("#minjooAll").html(str);// 해당영역 안에 추가되는 것 , 덮어쓰기됨  
				
				
   			 } , //성공했을때 함수
   			 error: function(err){
   				 alert(err+"발생했어요^^")
   			 } //오류발생했을때 함수 
   			 
   		 });//ajax끝
			
		})//end of on		
		
	})//end of ready
	</script>	
	
	

</body>
<jsp:include page="common/footerAdmin.jsp" />