<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>JJAN ㅉ ㅏ ㄴ </title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">

<SCRIPT>
	function checkValid() {
		var f = window.document.searchForm;

		if (f.keyWord.value == "") {
			alert("검색어를 입력해 주세요.");
			f.keyWord.focus();
			return false;
		}
		return true;
	}
</SCRIPT>

</head>
<body>

	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-md-6 d-flex align-items-center">
					<p class="mb-0 phone pl-md-2">
						<a href="#" class="mr-2">
							<span class="fa fa-phone mr-1"></span> +82 031 123 456
						</a>
						<a href="#">
							<span class="fa fa-paper-plane mr-1"></span> jjan212@naver.com
						</a>
					</p>
				</div>
					<div class="col-md-6 d-flex justify-content-md-end">
						<div class="social-media mr-4">
			    		<p class="mb-0 d-flex">
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
			    		</p>
		        </div>
		        <div class="reg">
		        	<p class="mb-0">
		        		<c:choose>
		        			<c:when test="${not empty userId}">
		        				<a href="${pageContext.request.contextPath}/front?key=member&methodName=logout">Logout</a>
		        			</c:when>
		        			<c:otherwise>
		        			<a href="${pageContext.request.contextPath}/login.jsp">log in</a>
		        		</c:otherwise>
		        		</c:choose>
		        	</p>
		        </div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">
				JJAN <span>ㅉ ㅏ ㄴ</span>
			</a>
			<div class="order-lg-last btn-group" id="ftco-nav">
				<a href="${path}/front?key=cart&methodName=selectCartByUserId&userId=${userId}" class="navbar-brand" ><span class="flaticon-shopping-bag" style="width:30px; font-size:20px;"></span></a><br>
      			<a href="${path}/front?key=wish&methodName=selectWishByUserId&userId=${userId}" class="navbar-brand"><span class="flaticon-heart" style="font-size:20px;"></span></a>
			</div>

			<form name="searchForm" action="front" method="post" onSubmit='return checkValid()'>
				<input class="input" type="text" name="values" placeholder="상품명 또는 국가 입력">
				<input type="hidden" name="key" value="prod">
				<input type="hidden" name="methodName" value="selectAll">
				<input type="hidden" name="category" value="keyWord">
				<input type="submit" value="검색">
			</form>

			

			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="index.jsp" class="nav-link">Home</a></li>
					<li class="nav-item active"><a href="front?key=prod&methodName=selectAll" class="nav-link">Shop</a>
					<li class="nav-item active"><a href="front?key=notice&methodName=select" class="nav-link">Notice</a></li>
					<c:if test="${not empty userId}">
						<li class="nav-item active"><a href="front?key=member&methodName=readMemberInfo" class="nav-link">MyPage</a></li>
					</c:if>

					<li class="nav-item active"><a href="contact.jsp" class="nav-link">Contact</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->



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
	<script src="js/main.js"></script>

</body>
</html>