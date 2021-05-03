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

</head>

<body>
	<!-- 헤더영역 -->
	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_member_detail.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp"> Home <i class="fa fa-chevron-right"></i></a></span> <span>MyPage <i class="fa fa-chevron-right"></i></span></p>
					<h2 class="mb-0 bread">회원탈퇴</h2>
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
						<div class="col-md-12 d-flex justify-content-between align-items-center">
							<h4 class="product-select">회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요</h4>
						</div>
					</div>
					
					<!-- 본문 내용 -->
					<div class="row">
						<ul>
							<li>이 서비스에서 탈퇴하셔도 네이버 이용약관은 철회되지 않습니다. 이용약관 철회는 네이버를 이용해주세요.</li>
							<li>탈퇴 후 가입한 정보는 1년간 보관됩니다.</li>
							<li>탈퇴 후에도 작성한 리뷰는 그대로 남아 있습니다.</li>
						</ul>
					</div>
					
					<!-- 본문 하단 -->
					<div class="row mt-5">
						<div class="col text-center">
							<a class="btn btn-primary py-2 px-3" id="confirm">탈퇴합니다</a>
						</div>
					</div>
				</div>
				
				<!-- 사이드바 내용 -->
				<div class="col-md-3">
					<div class="sidebar-box ftco-animate">
						<div class="categories">
							<h3>Member Menu</h3>
							<ul class="p-0">
								<li><a href="front?key=member&methodName=readMemberInfo">회원정보 <span class="fa fa-chevron-right"></span></a></li>
								<li><a href="UserOrderHistory.jsp">주문내역 <span class="fa fa-chevron-right"></span></a></li>
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
	
	<script type="text/javascript">
		$(function() {
			$("#confirm").click(function() {
				if(confirm("정말 탈퇴하시겠습니까?")) {
					location.href = "front?key=member&methodName=leaveMember";
				}
			})
		});
	</script>
</body>
</html>
<jsp:include page="common/footer.jsp" />
