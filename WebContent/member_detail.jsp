<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="common/header.jsp" />

<!DOCTYPE html>
<html>

<head>
<title>ㅉ ㅏ ㄴ</title>
<meta charset="UTF-8">
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

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="js/zipCode.js"></script>

</head>

<body>
	<!-- 헤더영역 -->
	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_member_detail.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp"> Home <i class="fa fa-chevron-right"></i></a></span> <span>MyPage <i class="fa fa-chevron-right"></i></span></p>
					<h2 class="mb-0 bread">회원정보</h2>
				</div>
			</div>
		</div>
	</section>
	
	<!-- 본문 -->
	<section class="ftco-section">
		<div class="container">
			<div class="row">
				
				<!-- 본문 내용 -->
				<div class="col-md-9">
					
					<!-- 본문 타이틀 -->
					<div class="row mb-4">
						<!--
 						<div class="col-md-12 d-flex justify-content-between align-items-center">
							<h3 class="product-select">회원정보</h4>
						</div> 
						-->
					</div>
					
					<!-- 본문 내용 -->
					<div class="row mb-3">
						<form name="member_form" method="post" action="front" class="billing-form">
							<input type=hidden name="key" value="member">
							<input type=hidden name="methodName" value="updateMember">
							<input type="hidden" name="userBirth" value="${member.userBirth}">
							<input type="hidden" name="userGender" value="${member.userGender}">
							
							<h3 class="mb-4 billing-heading">회원정보</h3>
							<div class="row align-items-end">
								<div class="col-md-11">
									<div class="form-group">
										<label for="userName">이름</label> 
										<input type="text" class="form-control" name="userName" value="${member.userName}">
									</div>
								</div>
								
								<div class="col-md-11">
									<div class="form-group">
										<label for="userHp">전화번호</label> 
										<input type="text" class="form-control" name="userHp" value="${member.userHp}">
									</div>
								</div>
								
								<div class="col-md-11">
									<div class="form-group">
										<label for="userEmail">E-Mail</label> 
										<input type="text" class="form-control" name="userEmail" value="${member.userEmail}">
									</div>
								</div>
								
								<div class="w-100"></div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="postcodezip">우편번호</label> 
										<input type="text" class="form-control" id="post-code" name="userZipcode" value="${member.userZipcode}" readonly>
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										<a href="#" class="btn btn-primary py-3 px-4" onclick="DaumPostCodeFunc()">찾기</a>
									</div>
								</div>

								<div class="w-100"></div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="streetaddress">최근 배송지</label>
										<input type="text" class="form-control" id="address" name="userAddr" value="${member.userAddr}" readonly>
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<input type="text" class="form-control" id="extraAddress" readonly>
									</div>
								</div>

								<div class="w-100"></div>
								<div class="col-md-11">
									<div class="form-group">
										<label for="phone">상세 주소</label>
										<input type="text" class="form-control" id="detail-address" name="userAddrDetail" value="${member.userAddrDetail}">
									</div>
								</div>
								
								<div class="w-100"></div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="userRegDate">가입일</label>
										<input type="text" class="form-control" name="userRegDate" value="${member.userRegDate}" readonly>
									</div>
								</div>
								<div class="col-md-5">
									<div class="form-group">
										<label for="userBuyCount">누적구매수</label>
										<input type="text" class="form-control" name="userBuyCount" value="${member.userBuyCount}" readonly>
									</div>
								</div>
								
								<div class="w-100"></div>
								<div class="col-md-12">
									<div class="form-group mt-4">
										<div class="radio">
											<a class="btn btn-primary py-2 px-3" href="javascript:member_form.submit();">정보 수정하기</a>
										</div>
									</div>

								</div>
							</div>
						</form>
						<!-- END -->
					</div>
					
					<!-- 본문 하단 -->
					<div class="row mt-5">
					</div>
				</div>
				
				<!-- 사이드바 내용 -->
				<div class="col-md-3">
					<div class="sidebar-box ftco-animate">
						<div class="categories">
							<h3>Member Menu</h3>
							<ul class="p-0">
								<li><a href="front?key=member&methodName=readMemberInfo">회원정보 <span class="fa fa-chevron-right"></span></a></li>
								<li><a href="#">주문내역 <span class="fa fa-chevron-right"></span></a></li>
								<li><a href="front?key=member&methodName=memberReview">리뷰목록 <span class="fa fa-chevron-right"></span></a></li>
								<li><a href="front?key=member&methodName=memberQuestion">질문목록 <span class="fa fa-chevron-right"></span></a></li>
								<li><a href="member_leave.jsp">회원탈퇴 <span class="fa fa-chevron-right"></span></a></li>
							</ul>
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
	<script src="js/main.js"></script></body>

</body>
</html>
<jsp:include page="common/footer.jsp" />
