<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html>
<html lang="en">
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

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
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
								class="fa fa-chevron-right"></i></a></span> <span>Wish <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">My Wish</h2>
				</div>
			</div>
		</div>
	</section>

	<%
	request.getSession();

	String userId = "cha";
	session.setAttribute("userId", userId);
	%>

	<%--
   request.setCharacterEncoding("UTF-8");

   String imgUrl = request.getParameter("imgUrl");
   String name = request.getParameter("name");
   String nameTag = request.getParameter("nameEng");
   int price = Integer.parseInt(request.getParameter("price"));
   int dbQty = Integer.parseInt(request.getParameter("dbQty"));
   int qty = Integer.parseInt(request.getParameter("userInputQty"));

   int totalPrice = price * qty;

--%>



	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="table-wrap">
					<table class="table">
						<thead class="thead-primary">
							<tr>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>Product</th>
								<th>Price</th>
								<th>Cart</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
						</thead>

						<c:choose>
							<c:when test="${empty requestScope.listAll}">
								<tr>
									<td colspan="10" class="table-data">
										<p align="center">
											<b> <span style="font-size: 9pt;">등록된 상품이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:set var="prodDto " />

								<c:forEach items="${requestScope.listAll}" var="prodDto" >
									<tbody>
										<tr class="alert" role="alert">
											<td><label class="checkbox-wrap checkbox-primary">
													<input type="checkbox" checked> <span
													class="checkmark"></span>
											</label></td>
											<td>
												<div class="img">
													<img src="${prodDto.prodImgUrl}" width="80" height="100" />
												</div>
											</td>
											<td>
												<div class="email">
													<span>${prodDto.prodName}</span> <span>${prodDto.prodNameEng}</span>
												</div>
											</td>
											<td><fmt:formatNumber value="${prodDto.prodPrice}"
													pattern="#,###원" /></td>
											<td>
												<div class="cart">
													<p><a href="${path}/front?key=cart&methodName=insertCart&prodId=${prodDto.prodId}" name="buyNow" class="btn btn-primary py-3 px-2">카트담기</a></p>
												</div>
											</td>
											<td><span style="color: red;" class="fa fa-close"
												data-dismiss="alert"
												onclick="location.href='${path}/front?key=wish&methodName=deleteWish&prodId=${prodDto.prodId}'"
												aria-hidden="true" aria-label="Close"></span></td>
										</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>





						</tbody>
					</table>
				</div>
			</div>
			
			<div class="row justify-content-end">
				<div class="col col-lg-5 col-md-6 mt-5 cart-wrap ftco-animate">
				<form action="front" method="get">
				<input type="hidden" name="prod" value="prodId"/>
				<input type=hidden name="insertCart" value="prodId"/> 
					<p><a href="cart.jsp" name="buyNow" class="btn btn-primary py-3 px-5">장바구니</a></p>
				</form>
				</div>
			</div>
		</div>
	</section>




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
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
	<script src="js/main.js"></script>

	
</body>
</html>
<jsp:include page="common/footer.jsp" />