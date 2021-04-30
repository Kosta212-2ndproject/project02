<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="common/headerAdmin.jsp" />

<HTML>
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


<SCRIPT>
	function checkValid() {
		var f = window.document.updateForm;
		if (f.prodName.value == "") {
			alert("상품이름을 입력해 주세요.");
			f.prodName.focus();
			return false;
		}
		if (f.prodNameEng.value == "") {
			alert("상품이름을 입력해 주세요.");
			f.prodNameEng.focus();
			return false;
		}
		if (f.prodPrice.value == "") {
			alert("가격을 입력해 주세요.");
			f.prodPrice.focus();
			return false;
		}
		if (f.prodNation.value == "") {
			alert("Nation을 선택해 주세요.");
			f.prodNation.focus();
			return false;
		}
		if (f.prodWinery.value == "") {
			alert("Winery를 입력해 주세요.");
			f.prodWinery.focus();
			return false;
		}
		if (f.prodWineryEng.value == "") {
			alert("Winery를 입력해 주세요.");
			f.prodWineryEng.focus();
			return false;
		}
		if (f.prodVatage.value == "") {
			alert("Vinatage를 입력해 주세요.");
			f.prodVatage.focus();
			return false;
		}
		if (f.prodAlcohol.value == "") {
			alert("Alcohol을 입력해 주세요.");
			f.prodAlcohol.focus();
			return false;
		}
		if (f.prodSweet.value == "") {
			alert("Sweet을 입력해 주세요.");
			f.prodSweet.focus();
			return false;
		}
		if (f.prodQty.value == "") {
			alert("재고를 입력해 주세요.");
			f.prodQty.focus();
			return false;
		}
		if (f.prodDetail.value == "") {
			alert("상세설명을 입력해 주세요.");
			f.prodDetail.focus();
			return false;
		}
		if (f.prodTaste.value == "") {
			alert("Taste을 입력해 주세요.");
			f.prodTaste.focus();
			return false;
		}
		if (f.prodMach.value == "") {
			alert("Food Matching을 입력해 주세요.");
			f.prodMach.focus();
			return false;
		}
	}
</SCRIPT>

</HEAD>

<BODY>


	<form name=updateForm method=post action="${path}/front" onSubmit="return checkValid()">
		<input type="hidden" name="key" value="prod">
		<input type="hidden" name="methodName" value="updateProduct">
		<input type='hidden' name='prodId' value="${prod.prodId}">

		<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div class="row no-gutters slider-text align-items-end justify-content-center">
					<div class="col-md-9 ftco-animate mb-5 text-center">
						<p class="breadcrumbs mb-0">
							<span class="mr-2"><a href="indexAdmin.jsp">
									Home <i class="fa fa-chevron-right"></i>
								</a></span> <span><a href="productMange.jsp">
									상품관리 <i class="fa fa-chevron-right"></i>
								</a></span> <span>Products Single <i class="fa fa-chevron-right"></i></span>
						</p>
						<h2 class="mb-0 bread">상품 수정하기</h2>
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
						<h3>
							Name:
							<input type=text name="prodName" size="17" value="${prod.prodName}">
							<br>NameEng:
							<input type=text name="prodNameEng" size="20" value="${prod.prodNameEng}">
						</h3>
						

						<p class="price">
							<span style="font-size: 15pt">Price : <input type=text name="prodPrice" size="5" value="${prod.prodPrice}">원
							</span>
						</p>
						<p>
							Type : <b> <input type="radio" name="prodType" value="${prod.prodType}" checked>${prod.prodType}&nbsp;&emsp; <input type="radio" name="prodType" value="Red">Red&nbsp; <input type="radio" name="prodType" value="Sparkling">Sparkling&nbsp; <input type="radio" name="prodType" value="White">White&nbsp;
							</b> <br> <br> Nation : <b><select name="prodNation">
									<option value="">--선택없음--</option>
									<option value="France(프랑스)">프랑스</option>
									<option value="Chile(칠레)">칠레</option>
									<option value="Italy(이탈리아)">이탈리아</option>
									<option value="Argentina(아르헨티나)">아르헨티나</option>
									<option value="Australia(호주)">호주</option>
									<option value="Spain(스페인)">스페인</option>
									<option value="U.S.A(미국)">미국</option>
									<option value="Germany(독일)">독일</option>
									<option value="New Zealand(뉴질랜드)">뉴질랜드</option>
								</select></b> <br> <br> Winery : <b><input type=text name="prodWinery" size="10" value="${prod.prodWinery}"> / <input type=text name="prodWineryEng" size="15" value="${prod.prodWineryEng}"></b> <br> <br>Vintage : <b><input type=text name="prodVatage" size="5" value="${prod.prodVatage}"></b> <br> <br>Alcohol : <b><input type=text name="prodAlcohol" size="5" value="${prod.prodAlcohol}"></b><br> <br> Sweet : <b><input type=text name="prodSweet" size="5" value="${prod.prodSweet}"></b>

						</p>
						<div class="row mt-4">
							<div class="input-group col-md-6 d-flex mb-3"></div>
							<div class="w-100"></div>
							<div class="col-md-12">
								<p style="color: #000;">
									재고 :
									<input type=text name="prodQty" size="5" value="${prod.prodQty}">
									piece available
								</p>
							</div>
						</div>
						<p>
							<input type="submit" value="수정하기" class="btn btn-primary py-3 px-5 mr-2">
							<input type="reset" value="다시쓰기" class="btn btn-primary py-3 px-5">
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
									<p>
										<textarea name="prodDetail" cols="120" rows="15">${prod.prodDetail}</textarea>
									</p>

								</div>
							</div>

							<div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
								<div class="p-4">
									<h3 class="mb-4">Taste / Food Matching</h3>
									<p>
									<h5>Taste :</h5>
									<textarea name="prodTaste" cols="120" rows="10">${prod.prodTaste}</textarea>
									<br> <br>
									<h5>Food matching :</h5>
									<textarea name="prodMach" cols="120" rows="1">${prod.prodMach}</textarea>
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

	</form>
	<hr>
	<div align=right>
		<span style="font-size: 9pt;">&lt;<a href="${path}/front?key=prod&methodName=selectAllByAdmin">리스트로 돌아가기</a>&gt;
		</span>
	</div>



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




