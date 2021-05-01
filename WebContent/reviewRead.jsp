<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
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

<script type="text/javascript">
    function sendUpdate(){
    	document.requestForm.methodName.value ="updateForm";
    	document.requestForm.submit();
    }

    function sendDelete(){
    	
    	document.requestForm.methodName.value ="delete";
    	document.requestForm.submit();
    }
    
</script>

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
							href="front?key=notice&methodName=select">Review <i
								class="fa fa-chevron-right"></i></a></span> <span>Review Single <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Review Single</h2>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<br>
	
	
<!--  리뷰 내용  -->
              <div class="comment-form-wrap pt-5">
                
                
                <form name="requestForm" method=post action="${path}/front" class="p-5 bg-light">
                
                  <div class="form-group">
<!-- review image and text -->
				<div class="about-author d-flex p-4 bg-light">
					<div class="bio mr-5">
						<img src="${review.reviewImgUrl}" alt="Image placeholder"
							class="img-fluid mb-4">
					</div>
					<div class="desc">
					<label for="userId">User ID </label>
						<h3>${review.userId}</h3>
						<hr>
						<c:forEach var="i" begin="1" end="${review.reviewStarScope}">
							<i class="fa fa-star"></i>
						</c:forEach><span>${review.reviewStarScope}.0</span>
						<hr>
					<label for="reviewRegdate">Date </label>
						<h3>${review.reviewRegdate}</h3>
						<hr>
					 <label for="reviewTitle">Title </label>
						<h3>${review.reviewTitle}</h3>
						<hr>
					 <label for="reviewContent">Contents </label>
						<h3>${review.reviewContent }</h3>
						
					</div>
				</div>

                    <input type=hidden name="prodId" value="${review.prodId}"> 
                    <input type=hidden name="reviewId" value="${review.reviewId}"> 
					<input type=hidden name="key" value="review"> 
					<input type=hidden name="methodName"> 
					
					<c:set var="id" value="${userId}"/>
					<c:set var="reviewId" value="${review.reviewId}"/>
					<c:if test="${id eq reviewId}">
						<input type=button value="edit" onClick="sendUpdate()" class="btn py-3 px-4 btn-primary"> 
						<input type=button value="delete" onClick="sendDelete()" class="btn py-3 px-4 btn-primary">
                    </c:if>
                    
                <%--<%
                    	String userId = (String)request.getSession().getAttribute("userId");
                    	if(userId.equals("${review.reviewId}")){
                    %>
					
						<input type=button value="edit" onClick="sendUpdate()" class="btn py-3 px-4 btn-primary"> 
						<input type=button value="delete" onClick="sendDelete()" class="btn py-3 px-4 btn-primary">
						
					<%
                    	}
					%>	 --%>
                  </div>

                </form>
                
                
              </div>

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