<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="common/headerAdmin.jsp" />

<HEAD>
<title>ㅉ ㅏ ㄴ</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style.css">

<SCRIPT>
	function sendUpdate() {
		document.requestForm.methodName.value = "updateForm";
		document.requestForm.submit();
	}

	function sendDelete() {

		document.requestForm.methodName.value = "delete";
		document.requestForm.submit();
	}
</SCRIPT>



</HEAD>
<body>

	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="indexAdmin.jsp">
								Home <i class="fa fa-chevron-right"></i>
							</a></span> <span><a href="${path}/front?key=prod&methodName=selectAllByAdmin">
								상품관리 <i class="fa fa-chevron-right"></i>
							</a></span> </span>
					</p>
					<h2 class="mb-0 bread">Products Single</h2>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 mb-5 ftco-animate">
					<a href="${prod.prodImgUrl}" class="image-popup ">
						<img src="${prod.prodImgUrl}" class="img-fluid" alt="Colorlib Template">
					</a>
				</div>
				<div class="col-lg-6 product-details pl-md-5 ftco-animate">
					<h3>${requestScope.prod.prodName}${requestScope.prod.prodNameEng}</h3>
					<br>
					<p class="price">
						<span><fmt:formatNumber value="${prod.prodPrice}" pattern="#,###원" /></span>
					</p>
					<p>
						Type : <b>${prod.prodType}</b> <br>
						<br> Nation : <b>${prod.prodNation}</b> <br>
						<br> Winery : <b>${prod.prodWinery} / ${prod.prodWineryEng}</b> <br>
						<br>Vintage : <b>${prod.prodVatage}</b><br>
						<br>Alcohol : <b>${prod.prodAlcohol}</b><br>
						<br> Sweet : <b>${prod.prodSweet}</b>

					</p>
					<div class="row mt-4">
						<div class="input-group col-md-6 d-flex mb-3"></div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<p style="color: #000;">재고 : <span style="color: red; font-size:25px">${prod.prodQty} </span> 개&emsp;&emsp; 배송비 : 2500원</p>
						</div>
					</div>
					<p>
						<a href="front?key=prod&methodName=updateForm&prodId=${prod.prodId}" class="btn btn-primary py-3 px-5 mr-2">수정하기</a>
						<a href="front?key=prod&methodName=deleteProduct&prodId=${prod.prodId}" class="btn btn-primary py-3 px-5 mr-2">삭제하기</a>
						<input type="button" value="전체List" class="btn btn-primary py-3 px-5 mr-2" onClick="location.href='front?key=prod&methodName=selectAllByAdmin'">
					</p>
				</div>
			</div>




			<div class="row mt-5">
				<div class="col-md-12 nav-link-wrap">
					<div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Description</a>

						<a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">Taste/Food Matching </a>

						

					</div>
				</div>

				<div class="col-md-12 tab-wrap">

					<div class="tab-content bg-light" id="v-pills-tabContent">

						<div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
							<div class="p-4">
								<h3 class="mb-4">${requestScope.prod.prodName}${requestScope.prod.prodNameEng}</h3>
								<p>${prod.prodDetail}</p>
							</div>
						</div>

						<div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
							<div class="p-4">
								<h3 class="mb-4">Taste / Food Matching</h3>
								<p>
									Taste : ${prod.prodTaste} <br>
									<br> Food matching : ${prod.prodMach}
								</p>
							</div>
						</div>
						<div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-day-3-tab">
							
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
	<script src="js/main.js"></script>
	
	
</body>
</html>
<jsp:include page="common/footerAdmin.jsp" />




