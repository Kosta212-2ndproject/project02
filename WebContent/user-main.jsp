<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
</head>
<body>

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('images/bg_2.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="index.jsp">Home <i class="fa fa-chevron-right"></i></a></span> 
						<span class="mr-2"><a href="front?key=user&methodName=select">My Page 
						<i class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">My Page</h2>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
    		<div class="row mt-5">
    		
          		<div class="col-md-12 nav-link-wrap">
            	<div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
<!-- Tabmenu  -->
              <a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true"> My Page</a>

           	 <a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">Reviews </a>

             <a class="nav-link ftco-animate mr-lg-1" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Questions</a>
             
             <!-- <a class="nav-link ftco-animate mr-lg-1" id="v-pills-4-tab" data-toggle="pill" href="#v-pills-4" role="tab" aria-controls="v-pills-4" aria-selected="false">By Keyword</a>  -->
            </div>
          </div>
          
          
          
          <div class="col-md-12 tab-wrap">
            <div class="tab-content bg-light" id="v-pills-tabContent">
<!-- 1번째 탭메뉴의 contents All -->
              <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
              	<div class="p-4" ><br><br>
              	<h2 style="text-align: center;">Welcome to ${userId}'s MyPage</h2>
              	<br><br>

					 <div class="text-center">
							<img src="images/wineeditor.png" width="600" height="400" align="middle" alt="Image placeholder"
								class="img-fluid mb-4">
					 </div> 
				<div class="text-center">
							<div>
							<p>Drink wine, drink poetry, drink virtue.</p>
							<h5> Whatever you choose, you are always right.</h5>
							</div>
						</div> 
					<br><br>

              	
              	</div>
              </div>
<!-- 2번째 탭메뉴의 contents  -->
              <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
              	<div class="p-4" id="minjooReviewAll">

	             </div>
              </div>			

<!-- 3번째 탭메뉴의 contents  -->

              <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
              	<div class="p-4" id="minjooQuestionAll">

	             </div>
              </div>			
              </div>
            </div>
            
            
          </div>
        </div>
 <!--  -->

		<div class="row mt-6">
			<div class="col-md-13 tab-wrap">
				<div class="tab-content bg-light" id="v-pills-tabContent2"></div>
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
			var sessionId = "<%=session.getAttribute("userId")%>"
			$.ajax({
   			 url:"${path}/reviewSelectByUser" , // 서버요청주소
   			 type: "post", //method방식 = 전송방식(get, post, put, delete)
   			 dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
   		     data: {userId : "${userId}" } ,  //서버에게 보낼 parameter정보 
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
					str += "<td><a href='front?key=review&methodName=selectByReviewId&reviewId="+item.reviewId+"&prodId="+item.prodId+"'>" + item.reviewTitle + "</td>"
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
				$("#minjooReviewAll").html(str);// 해당영역 안에 추가되는 것 , 덮어쓰기됨  
				
				
   			 } , //성공했을때 함수
   			 error: function(err){
   				 alert(err+"발생했어요^^")
   			 } //오류발생했을때 함수 
   			 
   		 });//ajax끝
			
		})//end of on		
		
	})//end of ready

</script> 
	
	
	
	<script type="text/javascript">
	$(document).ready(function() {
		//Q&A Board
			$(document).on("click","#v-pills-3-tab", function(){ 
				var sessionId = "<%=session.getAttribute("userId")%>"		
				$.ajax({
	   			 		url:"${path}/questionSelectByUser" , // 서버요청주소   
	   			 		type: "post", //method방식 = 전송방식(get, post, put, delete)
	   			 		dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
	   		     		//data: {prodId : "${prod.prodId}" } ,  //서버에게 보낼 parameter정보 
	   			 		success : function(result){
	   			   		//alert(result)
	   			   		var str="<table><tr>";
	   			   		str += "<th> No. </th>";
						str += "<th> ID </th>";
						str += "<th> Category </th>";
						str += "<th> Title </th>";
						str += "<th> Date </th>";
						str += "<th> public | private </th>";	
						str += "</tr>"
   							$.each(result, function(index , questionDTO){
			   				//alert(questionDTO.qNum +"," + questionDTO.answerList)
								str += "<tr>"
								str += "<td>"+ questionDTO.qNum +"</td>"
								str += "<td>"+ questionDTO.userId +"</td>"
								str += "<td>"+ questionDTO.qField +"</td>"
								str += "<td><a href='front?key=question&methodName=selectByQuestionNum&qNum="+questionDTO.qNum+"&prodId="+questionDTO.prodId+"'>" + questionDTO.qTitle + "</td>"
								str += "<td>"+ questionDTO.qRegdate +"</td>"
								if(questionDTO.qShowstatus == '0'){
									str += "<td id='securityCheck'><img src='images/security.png' width='20' height='20'/></td>"	
								}else{
									str += "<td id='securityCheck'><img src='images/public.svg' width='20' height='20'/></td>"	
								}
								str += "</tr>"
			   					
			   					$.each(questionDTO.answerList, function(index, answerDTO) {
			   					  		
									str += "<tr>"
									str += "<td>" + answerDTO.aNum + "</td>"
									str += "<td>" + answerDTO.aAnsId + "</td>"
									str += "<td>" + questionDTO.qField + " 답변</td>"
									str += "<td><a href='front?key=question&methodName=selectByAnswerNum&aNum="+answerDTO.aNum+"&qNum="+questionDTO.qNum+"'><img src='images/reply.jpeg' width='20' height='20'/>" + questionDTO.qTitle + "</td>"
									str += "<td>" + answerDTO.aRegdate + "</td>"
									if(questionDTO.qShowstatus == '0'){
									str += "<td id='securityCheck'><img src='images/security.png' width='20' height='20'/></td>"	
									}else{
									str += "<td id='securityCheck'><img src='images/public.svg' width='20' height='20'/></td>"	
									}
									str += "</tr>"
									str += "<tr>"
									
								})//end of 2nd each
			   			
			   							
							})//end of 1st each
	   			   			$("#minjooQuestionAll").html(str)
	   							
	   			 		}, //성공했을때 함수
	   			 		error: function(err){
	   				 	alert(err+"발생했어요^^")
	   			 		} //오류발생했을때 함수 
				});//ajax끝
	   			 
	   		}); // end of on
	   		 
	})//end of ready
	</script>	
	
	

</body>
<jsp:include page="common/footerAdmin.jsp" />