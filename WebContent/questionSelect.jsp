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
						<span class="mr-2"><a href="index.jsp">Home <i
								class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a
							href="front?key=notice&methodName=select">Q & A <i
								class="fa fa-chevron-right"></i></a></span> <span>Q & A List <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Q & A List </h2>
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
              <a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Select Menu</a>

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
              	<h2>Welcome to Admin's Menu</h2>
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
		//Q&A Board
			$(document).on("click","#v-pills-2-tab", function(){ 
				//alert(11)				
				$.ajax({
	   			 		url:"${path}/boardSelectAll" , // 서버요청주소  
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
	   			   			$("#minjooAll").html(str)
	   							
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