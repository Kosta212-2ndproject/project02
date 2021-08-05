<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="common/headerAdmin.jsp" />

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

<script type="text/javascript">
	$(function() {
		$("#dismiss").click(function() {
			confirm("해당 회원을 정말 탈퇴시키시겠습니까?");
			//alert($(this).parent.prev.value());
			
		})
	});
</script>

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
			<div class="row justify-content-center">
				
				<!-- 본문 내용 -->
				<div class="col-xl-13">
					<table class="table">
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>E-Mail</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>가입일</th>
						</tr>
						<c:choose>
							<c:when test="${empty requestScope.memberList}">
								<tr>
									<td colspan="11">
										가입한 회원 목록이 없습니다.
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.memberList}" var="member">
									<tr>
										<td>${member.userId}</td>
										<td>${member.userName}</td>
										<td>${member.userHp}</td>
										<td>${member.userEmail}</td>
										<td>${member.userBirth}</td>
										<td>${member.userGender}</td>
										<td>${member.userRegDate}</td>
									</tr>
									<tr class="detail_${member.userId}">
										<th><button class="btn btn-primary" id="dismiss">탈퇴</button></th>
										<th>우편번호</th>
										<th colspan="3" style="text-align: center;">주소</th>
										<th colspan="2">상세주소</th>
									</tr>
									<tr class="detail_${member.userId}">
										<td></td>
										<td>${member.userZipcode}</td>
										<td colspan="3">${member.userAddr}</td>
										<td colspan="2">${member.userAddrDetail}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
				
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
<jsp:include page="common/footerAdmin.jsp" />
