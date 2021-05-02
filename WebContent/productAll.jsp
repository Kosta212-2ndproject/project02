<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
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

<SCRIPT>
	function checkValid1() {
		var f = window.document.optionForm;

		if (f.order.value == "0") {
			alert("선택해 주세요.");
			f.order.focus();
			return false;
		}
		return true;
	}
</SCRIPT>

</head>
<body>


	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/wineproduct.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="index.jsp">
								Home <i class="fa fa-chevron-right"></i>
							</a></span> <span>Shop <i class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Products</h2>
				</div>
			</div>
		</div>
	</section>
	<!-- contents -->
	
	



	<section class="ftco-section">
		<div class="container">

			<div class="row">
				<div class="col-md-9">
					<h3>Popular</h3>
					<div class="row">
						<c:choose>
							<c:when test="${empty requestScope.listQty}">
								<!--  requesScope에 저장해야 하는 이름이 list -->
								<p align="center">
									<b><span style="font-size: 9pt;">매진임박 상품이 없습니다.</span></b>
								</p>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.listQty}" var="prodDtoQty">
									<div class="col-md-4 d-flex">

										<div class="product ftco-animate">

											<div class="img d-flex align-items-center justify-content-center" style= "background-image: url('${prodDtoQty.prodImgUrl}'); background-size: contain; height:200px">
												<div class="desc">
													<p class="meta-prod d-flex">
														<a href="#" class="d-flex align-items-center justify-content-center">
															<span class="flaticon-shopping-bag"></span>
														</a>
														<a href="#" class="d-flex align-items-center justify-content-center">
															<span class="flaticon-heart"></span>
														</a>
														<a href="${path}/front?key=prod&methodName=selectByProductDetail&prodId=${prodDtoQty.prodId}" class="d-flex align-items-center justify-content-center">
															<span class="flaticon-visibility"></span>
														</a>
													</p>
												</div>
											</div>
											<div class="text text-center">
												<span class="seller">품절 임박!!</span>
												<span class="category">${prodDtoQty.prodType}</span>
												<h5>${prodDtoQty.prodName}</h5>
												<span class="price"><fmt:formatNumber value="${prodDtoQty.prodPrice}" pattern="#,###원" /></span>
											</div>

										</div>

									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="row mb-4">
						<div class="col-md-12 d-flex justify-content-between align-items-center">
							<h4 class="product-select">Select Types of Products</h4>
							<form name="optionForm" action="front" method="post" onSubmit='return checkValid1()'>
								<input type="hidden" name="key" value="prod">
								<input type="hidden" name="methodName" value="selectAll">
								<input type="hidden" name="category" value="${category}">
								<input type="hidden" name="values" value="${values}">
								<select name="order" id="order">
									<option value="0">선택없음</option>
									<option value="newProduct">신제품순</option>
									<option value="priceHigh">가격순▲</option>
									<option value="priceLow">가격순▼</option>
								</select>
								<input type="submit" value="선택">
							</form>
						</div>
					</div>
					<script type="text/javascript">
						$(function() {
							if ("${order}" != "") {
								$("#order").val("${order}")
							}
						})
					</script>
					
					
					


					<div class="row">
						<c:choose>
							<c:when test="${empty requestScope.listAll}">
								<!--  requesScope에 저장해야 하는 이름이 list -->
								<p align="center">
									<b><span style="font-size: 9pt;">등록된 상품이 없습니다.</span></b>
								</p>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.listAll}" var="prodDto">
									<div class="col-md-4 d-flex">

										<div class="product ftco-animate">

											<div class="img d-flex align-items-center justify-content-center" style="background-image: url('${prodDto.prodImgUrl}'); background-size: contain;">
												<div class="desc">
													<p class="meta-prod d-flex">
														<a href="${path}/front?key=cart&methodName=insertCart&prodId=${prodDto.prodId}" class="d-flex align-items-center justify-content-center">
															<span class="flaticon-shopping-bag"></span>
														</a>
														<a href="${path}/front?key=wish&methodName=insertWish&prodId=${prodDto.prodId}" class="d-flex align-items-center justify-content-center">
															<span class="flaticon-heart"></span>
														</a>
														<a href="${path}/front?key=prod&methodName=selectByProductDetail&prodId=${prodDto.prodId}" class="d-flex align-items-center justify-content-center">
															<span class="flaticon-visibility"></span>
														</a>
													</p>
												</div>
											</div>
											<jsp:useBean id="now" class="java.util.Date" />
											<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />
											<fmt:parseDate value="${today}" pattern="yyyy-MM-dd" var="now"/>
											<fmt:parseDate value="${prodDto.prodRegdate}" pattern="yyyy-MM-dd" var="write_dt"/>
											<fmt:parseNumber value="${write_dt.time / (1000*60*60*24)}}" integerOnly="true" var="pdate"></fmt:parseNumber>
											<fmt:parseNumber value="${now.time / (1000*60*60*24)}}" integerOnly="true" var="nowdate"></fmt:parseNumber>
											<div class="text text-center">
											
												<c:if test="${nowdate - pdate <= 365}">
												<span class="new">New</span>
												</c:if>
												<c:if test="${prodDto.prodQty == 0}">
												<span class="sale">품절</span>
												</c:if>
												<c:if test="${prodDto.prodPrice <= 20000}">
												<span class="seller">초특가</span>
												</c:if>
												
												<span class="category">${prodDto.prodType}</span>
												<h2>${prodDto.prodName}</h2>
												<h3>${prodDto.prodNameEng}</h3>
												<span class="price"><fmt:formatNumber value="${prodDto.prodPrice}" pattern="#,###원" /></span>
											</div>
										</div>

									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>





					<!-- 페이징처리 -->
					<jsp:useBean class="kosta.mvc.dto.PageCntProduct" id="p" />
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
										<li><a href="front?key=prod&methodName=selectAll&pageNo=${startPage-1}&category=${category}&values=${values}&order=${order}">&lt;</a></li>
									</c:if>

									<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'>
										<c:if test="${(i-1)>=p.pageCnt}">
											<c:set var="doneLoop" value="true" />
										</c:if>
										<c:if test="${not doneLoop}">
											<li class="${i==pageNo? 'active' :page}" ><a href="${path}/front?key=prod&methodName=selectAll&pageNo=${i}&category=${category}&values=${values}&order=${order}">${i}</a></li>
										</c:if>

									</c:forEach>
									<c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
										<li><a href="front?key=prod&methodName=selectAll&pageNo=${startPage+p.blockcount}&category=${category}&values=${values}&order=${order}">&gt;</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>








				<script src="jquery-3.6.0.min.js" type="text/javascript"></script>
				<script>
					$(document)
							.ready(
									function() {
										$('p.menus')
												.mouseout(
														function() {
															$("div.menuitems'")
																	.slideUp(
																			"slow");
															$('li')
																	.css(
																			{
																				backgroundImage : "src=down.png"
																			});
														});

										$('p.menus')
												.mouseover(
														function() {
															$(this)
																	.css(
																			{
																				'background-image' : "url(down.png)",
																				'background-repeat' : "no-repeat",
																				'background-position' : "right"
																			})
																	.next(
																			"div.menuitems")
																	.slideDown(
																			500)
																	.siblings(
																			"div.menuitems")
																	.slideUp(
																			"slow");
															$(this)
																	.siblings()
																	.css(
																			{
																				backgroundImage : "src=down.png"
																			});
														});
									});
				</script>
				
				<script> $(function(){ 
					var $win = $(window); 
					var top = $(window).scrollTop();   
					var speed = 500; 
					var easing = 'linear';  
					var $layer = $('.float_sidebar');
					var layerTopOffset = 0;  
					$layer.css('position', 'relative').css('z-index', '1');
					
					
					if (top > 50 ) 
						$win.scrollTop(layerTopOffset+top); 
					else 
						$win.scrollTop(0); 
					
					$(window).scroll(function(){ 
						yPosition = $win.scrollTop() - 400; 
						if (yPosition < 460) 
						{ 
							yPosition = 0; 
						} 
						$layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false}); 
						}); 
					}); 
				</script>


				


				<div class="col-md-3">
					<div class ="float_sidebar" >
					
					<div class="sidebar-box ftco-animate">

						<a href="front?key=prod&methodName=selectAll">전체상품</a>


						<p class="menus">국가별</p>

						<div class="menuitems">
							<ul>
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=France&category=prodNation">프랑스</a>
								&ensp;
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Chile&category=prodNation">칠레</a>
								<br>
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Italy&category=prodNation">이탈리아</a>
								&ensp;
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Argentina&category=prodNation">아르헨티나</a>
								<br>
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Australia&category=prodNation">호주</a>
								&ensp;
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Spain&category=prodNation">스페인</a>
								&ensp;
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=U.S.A&category=prodNation">미국</a>
								<br>
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Germany&category=prodNation">독일</a>
								&ensp;
								<span class="fa fa-globe"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=New Zealand&category=prodNation">뉴질랜드</a>
							</ul>

						</div>


						<p class="menus">종류별</p>
						<div class="menuitems">
							<ul>
								<span class="fa fa-glass"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Red&category=prodType">Red</a>
								&ensp;
								<span class="fa fa-glass"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=Sparkling&category=prodType">Sparkling</a>
								<br>
								<span class="fa fa-glass"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=White&category=prodType">White</a>
							</ul>
						</div>

						<p class="menus">가격대별</p>
						<div class="menuitems">
							<ul>
								<span class="fa fa-krw"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=cheap&category=prodPrice">50,000 이하</a>
								<br>
								<span class="fa fa-krw"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=middle&category=prodPrice">50,000~100,000</a>
								<br>
								<span class="fa fa-krw"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=expensive&category=prodPrice">100,000~ 200,000</a>
								<br>
								<span class="fa fa-krw"></span>&ensp;
								<a href="front?key=prod&methodName=selectAll&values=luxury&category=prodPrice">200,000 이상</a>
							</ul>
						</div>

					</div>
					

      
      		<div class="sidebar-box ftco-animate">
      		   <h3><a href="${path}/front?key=wish&methodName=selectWishByUserId&userId=${userId}">Wish List</a></h3>
      		<form action="front" method="post">
      		<input type="hidden" name="key" value="wish">
      		<input type="hidden" name="methodName" value="selectWishByUserId">
      		<c:choose>
              <c:when test="${empty requestScope.listWish}">
              			<p align="center"><b><span style="font-size:9pt;">찜한 상품이 없습니다.</span></b></p>
              </c:when>
              <c:otherwise>
				<c:forEach items="${requestScope.listWish}" var="wishDto" varStatus="status">
					<div class="block-21 mb-4 d-flex">
						<a class="blog-img mr-4"
							style="background-image: url('${wishDto.prodImgUrl}');"></a>
						<div class="text">
							<h3 class="heading">
								<a href="${path}/front?key=prod&methodName=selectByProductDetail&prodId=${wishDto.prodId}">${wishDto.prodName} ${wishDto.prodNameEng}</a>
							</h3>
							<div class="meta">
							</div>
						</div>
					</div>

				</c:forEach>
              </c:otherwise>
              </c:choose>
      		</form>
              </div>
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
<jsp:include page="common/footer.jsp" />