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
								class="fa fa-chevron-right"></i></a></span> <span>Cart <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">My Cart</h2>
				</div>
			</div>
		</div>
	</section>




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
								<th>Quantity</th>
								<th>total</th>
								<th>&nbsp;</th>
							</tr>
						</thead>

						<c:choose>
							<c:when test="${empty requestScope.listAll}">
								<tr>
									<td colspan="10" class="table-data">
										<p align="center">
											<b> <span style="font-size: 9pt;">????????? ????????? ????????????.</span></b>
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
													<span>${prodDto.prodName} </span> <span>${prodDto.prodNameEng}</span>
												</div>
											</td>
											<td><fmt:formatNumber value="${prodDto.prodPrice}"
													pattern="#,###???" /></td>
											<td class="quantity">
											<div class="row mt-4">
												<div class="input-group col-md-10 d-flex mb-3">
													<span class="input-group-btn mr-2">
														<button type="button" class="quantity-left-minus btn" data-type="minus" data-field="" name="${prodDto.prodPrice}">
															<i class="fa fa-minus"></i>
														</button>
													</span> 
													<input type="text" id="qty" name="qty" size="20"
														class="quantity form-control input-number" value="1"
														min="1" max="100"> 
													<span class="input-group-btn ml-2">
														<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="" name="${prodDto.prodPrice}">
															<i class="fa fa-plus"></i>
														</button>
													</span>
												</div>
												<div class="w-100"></div>
												<div class="col-md-8">
													<p style="..."><input class="text center" id="prodDBQty" value="${prodDto.prodQty}"/>
													piece available</p>
												</div>
											</div>
											</td>
											<!-- ??? ?????? ??? ?????? -->
											<td><span name="productPerId" id="tp">${prodDto.prodPrice}</span>???</td>
											<td><span style="color: red;" class="fa fa-close"
												data-dismiss="alert"
												onclick="location.href='${path}/front?key=cart&methodName=deleteCart&prodId=${prodDto.prodId}'"
												aria-hidden="true" aria-label="Close"></span></td>
										</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>



						

						</tbody>
					</table>
					<form action="checkout.jsp" id="checkout" method="post">
						<input type="hidden" name="prodId" value="${listAll[0].prodId}"/>
						<input type="hidden" name="imgUrl" value="${listAll[0].prodImgUrl}"/>
						<input type="hidden" name="name" value="${listAll[0].prodName}"/>
						<input type="hidden" name="nameEng" value="${listAll[0].prodNameEng}"/>
						<input type="hidden" name="price" value="${listAll[0].prodPrice}"/>
						<input type="hidden" name="dbQty" value="${listAll[0].prodQty}"/>
						<input type="hidden" name="userInputQty" value=""/>
					
					</form>
					
				</div>
			</div>
			<div class="row justify-content-end"> 
				<div class="col col-lg-5 col-md-6 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>Cart Totals</h3>
						<p class="d-flex total-price">
							<span>Total</span> <span id="totalP" class="commaN">${total}</span>???
						</p>
					</div>
					<p><a href="#" name="buyNow" class="btn btn-primary py-3 px-5">????????????</a>
					
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

	<script>
	$(document).ready(function () {
		$("[name=buyNow]").click(function () {
			//alert(1)
			//alert( ${prod.prodPrice} );
			//alert(  $("[name=qty]").val() );
			$("[name=userInputQty]").val($("[name=qty]").val());
			$("#checkout").submit();
		});
		var quantitiy = 0;
		$('.quantity-right-plus').click(function (e) {
			e.preventDefault();
			// Get the field name
			var quantity = parseInt($('[name=qty]').val());
			let price = $(this).attr("name");
			let tot = (quantity+1)*price;
			if (quantity == $("#prodQty").val()) {
				$('.quantity-right-plus').prop('disabled', true);
			} else {
				$('[name=qty]').val(quantity + 1);
			}
			//alert(tot);
			$("#tp").text(tot);
			$('[name=productPerId]').val();
			
			//?????? ??????
			
			totalCal();
		});
		
		
    $('.quantity-left-minus').click(function (e) {
        // Stop acting like a button
        e.preventDefault();
        // Get the field name
        var quantity = parseInt($('[name=qty]').val());
        let price = $(this).attr("name");
		let tot = (quantity-1)*price;
        // If is not undefined
        // Increment
        if (quantity <= 1) {
            alert(quantity + "??? ???????????? ???????????? ??? ????????????.");
            $('[name=qty]').val(0);
        } else {
            $('[name=qty]').val(quantity - 1);
        }
        $("#tp").text(tot);
        $('[name=productPerId]').val();
        totalCal();
    });
    
    function totalCal(){
		var total=0;
		 $("[name=productPerId]").each(function(index, item){
			 //alert(index+" , "+ item); 
			 total+=parseInt($(this).text())
		 });
		 
		 $("#totalP").text(total);
		 
	}
	
	
	totalCal();
});
	</script>

</body>
</html>
<jsp:include page="common/footer.jsp" />