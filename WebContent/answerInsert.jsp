<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common/header.jsp" />
<link rel="stylesheet" href="css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		

	if ( f.aContent.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.aContent.focus();
		return false;
	}
	
	
    return true;
}
</SCRIPT>
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
						<span class="mr-2"><a href="index.jsp">Home <i
								class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a
							href="front?key=notice&methodName=select">Q & A <i
								class="fa fa-chevron-right"></i></a></span> <span>Answer Single <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Answer Upload</h2>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<br>
	
	
<!-- review update form  -->

      <form name="writeForm" method="post" action="front?key=question&methodName=answerInsert" 
  		onSubmit='return checkValid()' class="p-5 bg-light">
        <div class="comment-form-wrap pt-5">
                <h3 class="mb-5">Post a Answer</h3>
  				
  				<!-- 나중에 session 으로 ID check 해야 할 부분  -->	
                  <%-- <div class="form-group">
                    <label for="name">User ID </label>
                    <input type="text" name="userId"class="form-control" id="name" value="${review.userId}" readonly>
                  </div> --%>
                  
                  
                  <div class="form-group">
                    <label for="title"> Question No.</label>
                    <input type="text" name="qNum" class="form-control" id="qNum" value="${question.qNum}" readonly>
                  </div>
                 
                  <div class="form-group">
                    <label for="message">Contents *</label>
                    <textarea name="aContent" id="aContent" cols="30" rows="10" class="form-control"></textarea>
                  </div>
                  <div class="form-group">
                    <input type="submit" value="Post Answer" class="btn py-3 px-4 btn-primary">
                    <input type="reset" value="reset" class="btn py-3 px-4 btn-primary">
                  </div>
					
					
					
  					<input type="hidden" name="prodId" value="${question.prodId}"/>
  					<input type="hidden" name="aAnsId" value="admin"/>
              </div>
            </form>
	
	
	
	
	

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

</body>
<jsp:include page="common/footer.jsp" />
</html>