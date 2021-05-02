<%@page import="kosta.mvc.dao.NoticeDAOImpl"%>
<%@page import="kosta.mvc.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<title>Liquor Store</title>
<meta charset="UTF-8">
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
<link rel="stylesheet" href="../css/pagingstyle.css">

<script type="text/javascript">
	function sendUpdate() {
		document.requestForm.methodName.value = "uploadForm";
		document.requestForm.submit();
	}

	function sendDelete() {

		document.requestForm.methodName.value = "delete";
		document.requestForm.submit();
	}
</script>
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
								class="fa fa-chevron-right"></i></a></span> <span>Notice <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Notice</h2>
				</div>
			</div>
		</div>
	</section>

	<!-- contents -->


	<section class="ftco-section">
		<div class="container">
			<div class="row d-flex">
				<c:choose>
					<c:when test="${empty requestScope.noticeList}">
						<!--  requesScope에 저장해야 하는 이름이 list -->
					</c:when>
					<c:otherwise>
						<c:forEach items="${requestScope.noticeList}" var="notice"
							varStatus="state">
							<div class="col-lg-6 d-flex align-items-stretch ftco-animate">
								<div class="blog-entry d-md-flex">
									<a
										href="front?key=notice&methodName=selectByNoticeNumforUser&nNum=${notice.nNum}"
										class="block-20 img"
										style="background-image: url('${notice.nImage}');"> </a>
									<div class="text p-4 bg-light">
										<div class="meta">
											<p>
												<span class="fa fa-calendar"></span> ${notice.nRegdate}
											</p>
										</div>
										<h3 class="heading mb-3">
											<a
												href="front?key=notice&methodName=selectByNoticeNum&nNum=${notice.nNum}">
												${notice.nTitle}</a>
										</h3>
										<p>${notice.nContent}</p>
										<a href="#" class="btn-custom">views ${notice.nViewCount}
											<span class="fa fa-eye"></span>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</div>

		</div>

	</section>

<!-- 페이징처리 -->
					<jsp:useBean class="kosta.mvc.paging.PageCnt" id="p" /> 
					<!-- 블럭당 -->
					<div class="row mt-6">
						<div class="col text-center">
							<div class="block-27">
								<c:set var="doneLoop" value="false" />
								<c:set var="temp" value="${(pageNo-1) % p.blockcount}" />
								<!-- (1-1)%2   , (2-1)%2    1 , (3-1)%2  0 -->
								<c:set var="startPage" value="${pageNo - temp}" />
								<!--   1- 1 -->


								<ul>
									<c:if test="${(startPage-p.blockcount) > 0}">
										<li><a href="front?key=notice&methodName=select&pageNo=${startPage-1}">&lt;</a></li>
									</c:if>

									<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'>
										<c:if test="${(i-1)>=p.pageCnt}">
											<c:set var="doneLoop" value="true" />
										</c:if>
										<c:if test="${not doneLoop}">
											<li class="${i==pageNo? 'active':page}"><a href="${path}/front?key=notice&methodName=select&pageNo=${i}">${i}</a></li>
										</c:if>

									</c:forEach>
									<c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
										<li><a href="front?key=notice&methodName=select&pageNo=${startPage+p.blockcount}">&gt;</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
 <!-- 페이징처리 -->

	<div class="row mt-5">
		<div class="col text-center">
			<div class="block-27">
				<ul>

			<%-- 		
					<div class="row justify-content-center">
						<div class="col-md-4">
							<a href="${path}/front?key=notice&methodName=uploadForm"
								class="btn btn-primary d-block"> Notice Upload <span
								class="fa fa-long-arrow-right"></span>
							</a>
						</div>
					</div> --%>
					<br>
					<br>
					<br>
				</ul>
			</div>
		</div>
	</div>



	<!-- contents -->




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
</html>
<jsp:include page="../common/footer.jsp" />