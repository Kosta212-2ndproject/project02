<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="common/header.jsp" />

<%
	request.setCharacterEncoding("UTF-8");
   String prodId = request.getParameter("prodId");

%>

<!DOCTYPE html>
<html>
<head>
<title>ㅉ ㅏ ㄴ</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/review.css">

<style type="text/css">
#qContent {
	box-sizing: border-box;
	resize: none;
	background-color: white;
}
</style>
<script type="text/javascript">

    		function setThumbnail(event) {
    			var reader = new FileReader();
    			reader.onload = function(event) {
    				var img = document.createElement("img");
    				img.setAttribute("width","50");
    				img.setAttribute("height","50");
    				img.setAttribute("src", event.target.result);

    				document.querySelector("div#image_container").appendChild(img);
    			};
    			reader.readAsDataURL(event.target.files[0]);
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
						<span class="mr-2"><a href="index.jsp"> Home <i
								class="fa fa-chevron-right"></i>
						</a></span> <span><a href="product.html"> Products <i
								class="fa fa-chevron-right"></i>
						</a></span> <span>Products Single <i class="fa fa-chevron-right"></i></span>
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
					<a href="${prod.prodImgUrl}" class="image-popup "> <img
						src="${prod.prodImgUrl}" class="img-fluid" alt="Colorlib Template">
					</a>
				</div>
				<div class="col-lg-6 product-details pl-md-5 ftco-animate">
					<h3>${requestScope.prod.prodName}${requestScope.prod.prodNameEng}</h3>
					<div class="rating d-flex">
						<p class="text-left mr-4">
							<a href="#" class="mr-2">5.0</a> <a href="#"> <span
								class="fa fa-star"></span>
							</a> <a href="#"> <span class="fa fa-star"></span>
							</a> <a href="#"> <span class="fa fa-star"></span>
							</a> <a href="#"> <span class="fa fa-star"></span>
							</a> <a href="#"> <span class="fa fa-star"></span>
							</a>
						</p>
						<p class="text-left mr-4">
							<a href="#" class="mr-2" style="color: #000;"> 100 <span
								style="color: #bbb;">Rating</span>
							</a>
						</p>
						<p class="text-left">
							<a href="#" class="mr-2" style="color: #000;"> 500 <span
								style="color: #bbb;">Sold</span>
							</a>
						</p>
					</div>
					<p class="price">
						<span><fmt:formatNumber value="${prod.prodPrice}"
								pattern="#,###원" /></span>
					</p>
					<p>
						Type : <b>${prod.prodType}</b> <br> <br> Nation : <b>${prod.prodNation}</b>
						<br> <br> Winery : <b>${prod.prodWinery} /
							${prod.prodWineryEng}</b> <br> <br>Vintage : <b>${prod.prodVatage}</b><br>
						<br>Alcohol : <b>${prod.prodAlcohol}</b><br> <br>
						Sweet : <b>${prod.prodSweet}</b>
					</p>
					<div class="row mt-4">
						<div class="input-group col-md-6 d-flex mb-3">
							<span class="input-group-btn mr-2">
								<button type="button" class="quantity-left-minus btn"
									data-type="minus" data-field="">
									<i class="fa fa-minus"></i>
								</button>
							</span> <input type="text" id="qty" name="qty"
								class="quantity form-control input-number" value="1" min="1"
								max="100" readonly> <span class="input-group-btn ml-2">
								<button type="button" class="quantity-right-plus btn"
									data-type="plus" data-field="">
									<i class="fa fa-plus"></i>
								</button>
							</span>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<p style="color: #000;">
								<input type="text" class="text-center" id="prodQty" value="${prod.prodQty}"/> piece available
							</p>
						</div>
					</div>
					<p>
						<a href="cart.html" class="btn btn-primary py-3 px-5 mr-2">Add
							to Cart</a> <a href="#" name="buyNow" class="btn btn-primary py-3 px-5">Buy
							now</a>
					</p>

					<form action="checkout.jsp" id="checkout" method="post">
						<input type="hidden" name="prodId" value="<%= prodId %>"/>
						<input type="hidden" name="imgUrl" value="${prod.prodImgUrl}"/>
						<input type="hidden" name="name" value="${prod.prodName}"/>
						<input type="hidden" name="nameEng" value="${prod.prodNameEng}"/>
						<input type="hidden" name="price" value="${prod.prodPrice}"/>
						<input type="hidden" name="dbQty" value="${prod.prodQty}"/>
						<input type="hidden" name="userInputQty" value=""/>
					</form>
				</div>
			</div>


<!-- minjoo  /class="row mt-5"-->


    		<div class="row mt-5">
          <div class="col-md-12 nav-link-wrap">
            <div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist" aria-orientation="vertical">
<!-- Tabmenu  -->
              <a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill" href="#v-pills-1" role="tab" aria-controls="v-pills-1" aria-selected="true">Description</a>

              <a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2" role="tab" aria-controls="v-pills-2" aria-selected="false">Taste/Food Matching </a>

             <a class="nav-link ftco-animate mr-lg-1" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Reviews</a>

             <a class="nav-link ftco-animate mr-lg-1" id="v-pills-4-tab" data-toggle="pill" href="#v-pills-4" role="tab" aria-controls="v-pills-4" aria-selected="false">Q & A</a>

             <a class="nav-link ftco-animate" id="v-pills-5-tab" data-toggle="pill" href="#v-pills-5" role="tab" aria-controls="v-pills-5" aria-selected="false">Q & A Board</a>


            </div>
          </div>
          
          <div class="col-md-12 tab-wrap">
            
            <div class="tab-content bg-light" id="v-pills-tabContent">
<!-- 1번째 탭메뉴의 contents  -->
              <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
              	<div class="p-4">
	              	<h3 class="mb-4">${requestScope.prod.prodName} ${requestScope.prod.prodNameEng}</h3>
	              	<p>${prod.prodDetail}</p>
              	</div>
              </div>
<!-- 2번째 탭메뉴의 contents  -->
              <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
              	<div class="p-4">
	              	<h3 class="mb-4">Taste / Food Matching</h3>
	              	<p>Taste : ${prod.prodTaste} <br><br>
	              	Food matching : ${prod.prodMach}</p>
	             </div>
              </div>
<!-- 3번째 탭메뉴의 contents /review -->
						<div class="tab-pane fade" id="v-pills-3" role="tabpanel"
							aria-labelledby="v-pills-day-3-tab">
							<div class="row p-4">
								<div class="col-md-12" id="minjoo"></div>
							</div>
						</div>

<!-- 4번째 탭메뉴의 contents /Question Form -->
              <div class="tab-pane fade" id="v-pills-4" role="tabpanel" aria-labelledby="v-pills-day-4-tab">
              	<div class="row p-4">
						   	<!-- 	<div class="col-md-8"> -->
						   			 <!-- <h3 class="mb-4">23 Reviews</h3>  -->
						   		<!-- </div> -->

						<!-- 질문등록  영역  -->
						   	<!-- 	<div class="col-md-4"> -->

								 <!--   	<div class="col-lg-6"> -->
							<div class="review_box">
								<h4>Post a question</h4>
								<form class="row contact_form" name="uploadForm"
								action="${path}/front?key=question&methodName=insert" method="post"
								onSubmit='return checkValid()' enctype="multipart/form-data" id="contactForm" novalidate="novalidate">
									<input type="hidden" name="prodId" value="${prod.prodId}"/>

									<div class="col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="qTitle" name="qTitle" placeholder="Title">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
												<fieldset>
													<legend>Category</legend>

													<input type="radio" id="product" name="qField" value="상품">
													<label for="product"> 상품 문의 </label><br />
													<input type="radio" id="order" name="qField" value="주문">
													<label for="order">	주문 문의 </label><br />
													<input type="radio" id="delivery" name="qField" value="배송">
													<label for="delivery"> 배송 문의 </label>
												</fieldset>
											</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
												<fieldset>
													<legend> 공개 / 비공개 </legend>
													<input type="radio" id="product" name="qShowstatus" value="0">
													<label for="product"> 비공개 </label><br />
													<input type="radio" id="order" name="qShowstatus" value="1">
													<label for="order">	공개 </label><br />
												</fieldset>
											</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="file" class="form-control" id="qFiles" name="qFiles"
											id="image" accept="image/*" onchange="setThumbnail(event);" placeholder="Upload file">
											<div id="image_container"></div>
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<textarea  data-autoresize rows="2" class="wrap"  name="qContent" id="qContent" rows="1" placeholder="Message"></textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="btn submit_btn">Submit Now</button>
									</div>
								</form>
							</div>
					<!-- 	</div> -->
						   	<!-- 	</div> -->
				</div>
              </div>

<!-- 5번째 탭메뉴의 contents / Q&A Board -->

                <div class="tab-pane fade" id="v-pills-5" role="tabpanel" aria-labelledby="v-pills-day-5-tab">
              	<div class="row p-4">
							<div class="col-md-12" id="minjoo2">
							</div>



<!-- end of 5th -->

				</div>
              </div>
            </div>
          </div>
        </div>


        <div class="row mt-6">
        <div class="col-md-13 tab-wrap">
        	<div class="tab-content bg-light" id="v-pills-tabContent2">



				</div>
			</div>
        </div>

    	</div>
    </section>
    
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


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

<script>
    $(document).ready(function () {

			$("[name=buyNow]").click(function () {
				//alert(1)
				alert(  $("[name=qty]").val() );

				$("[name=userInputQty]").val($("[name=qty]").val());
				$("#checkout").submit();
			});

			var quantitiy = 0;

			$('.quantity-right-plus').click(function (e) {

				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('[name=qty]').val());

				if (quantity == $("#prodQty").val()) {
					$('.quantity-right-plus').prop('disabled', true);
				} else {
					$('[name=qty]').val(quantity + 1);
				}

			});

        $('.quantity-left-minus').click(function (e) {
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('[name=qty]').val());

            // If is not undefined

            // Increment
            if (quantity <= 1) {
                alert(quantity + "개 이상부터 구매하실 수 있습니다.");
            } else {
                $('[name=qty]').val(quantity - 1);
            }

        });
    });
</script>


</body>
</html>
<jsp:include page="common/footer.jsp"/>