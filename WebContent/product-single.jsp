<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="common/header.jsp"/>

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

   <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

   <link rel="stylesheet" href="css/flaticon.css">
   <link rel="stylesheet" href="css/style.css">
   <script src="js/importJS.js"></script>
</head>
<body>

<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');"
         data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text align-items-end justify-content-center">
         <div class="col-md-9 ftco-animate mb-5 text-center">
            <p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp">Home <i class="fa fa-chevron-right"></i></a></span>
               <span><a href="product.html">Products <i class="fa fa-chevron-right"></i></a></span> <span>Products Single <i
                     class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">Products Single</h2>
         </div>
      </div>
   </div>
</section>

<section class="ftco-section">
   <div class="container">
      <div class="row">
         <div class="col-lg-6 mb-5 ftco-animate">
            <a href="${prod.prodImgUrl}" class="image-popup prod-img-bg"><img src="${prod.prodImgUrl}"
                                                                              class="img-fluid"
                                                                              alt="Colorlib Template"></a>
         </div>
         <div class="col-lg-6 product-details pl-md-5 ftco-animate">
            <h3>${requestScope.prod.prodName} ${requestScope.prod.prodNameEng}</h3>
            <div class="rating d-flex">
               <p class="text-left mr-4">
                  <a href="#" class="mr-2">5.0</a>
                  <a href="#"><span class="fa fa-star"></span></a>
                  <a href="#"><span class="fa fa-star"></span></a>
                  <a href="#"><span class="fa fa-star"></span></a>
                  <a href="#"><span class="fa fa-star"></span></a>
                  <a href="#"><span class="fa fa-star"></span></a>
               </p>
               <p class="text-left mr-4">
                  <a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Rating</span></a>
               </p>
               <p class="text-left">
                  <a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
               </p>
            </div>
            <p class="price"><span><fmt:formatNumber value="${prod.prodPrice}" pattern="#,###원"/></span></p>
            <p>Type : <b>${prod.prodType}</b> <br><br> Nation : <b>${prod.prodNation}</b> <br><br> Winery :
               <b>${prod.prodWinery} / ${prod.prodWineryEng}</b>
               <br><br>Vintage : <b>${prod.prodVatage}</b><br><br>Alcohol : <b>${prod.prodAlcohol}</b><br><br> Sweet
               :
               <b>${prod.prodSweet}</b></p>
            <div class="row mt-4">
               <div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
	                   <i class="fa fa-minus"></i>
	                	</button>
	            		</span>
                  <input type="text" name="qty" class="quantity form-control input-number"
                         value="1"
                         min="1" max="100" readonly>

                  <span class="input-group-btn ml-2">
	                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="fa fa-plus"></i>
	                 </button>
	             	</span>
               </div>
               <div class="w-100"></div>
               <div class="col-md-12">
                  <p style="color: #000;"><input type="text" id="prodQty" value="${prod.prodQty}"/> piece available</p>
               </div>
            </div>
            <p><a href="#" name="ordersCart" class="btn btn-primary py-3 px-5 mr-2">장바구니</a>
               <a href="#" name="buyNow" class="btn btn-primary py-3 px-5">구매하기</a>

            <form action="checkout.jsp" id="checkout" method="post">
               <input type="hidden" name="imgUrl" value="${prod.prodImgUrl}"/>
               <input type="hidden" name="name" value="${prod.prodName}"/>
               <input type="hidden" name="nameEng" value="${prod.prodNameEng}"/>
               <input type="hidden" name="price" value="${prod.prodPrice}"/>
               <input type="hidden" name="dbQty" value="${prod.prodQty}"/>
               <input type="hidden" name="userInputQty" value=""/>
            </form>

         </div>

      </div>
      <div class="row mt-5">
         <div class="col-md-12 nav-link-wrap">
            <div class="nav nav-pills d-flex text-center" id="v-pills-tab" role="tablist"
                 aria-orientation="vertical">
               <a class="nav-link ftco-animate active mr-lg-1" id="v-pills-1-tab" data-toggle="pill"
                  href="#v-pills-1"
                  role="tab" aria-controls="v-pills-1" aria-selected="true">Description</a>

               <a class="nav-link ftco-animate mr-lg-1" id="v-pills-2-tab" data-toggle="pill" href="#v-pills-2"
                  role="tab" aria-controls="v-pills-2" aria-selected="false">Taste/Food Matching </a>

               <a class="nav-link ftco-animate" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab"
                  aria-controls="v-pills-3" aria-selected="false">Reviews</a>

            </div>
         </div>

         <div class="col-md-12 tab-wrap">

            <div class="tab-content bg-light" id="v-pills-tabContent">

               <div class="tab-pane fade show active" id="v-pills-1" role="tabpanel" aria-labelledby="day-1-tab">
                  <div class="p-4">
                     <h3 class="mb-4">${requestScope.prod.prodName} ${requestScope.prod.prodNameEng}</h3>
                     <p>${prod.prodDetail}</p>
                  </div>
               </div>

               <div class="tab-pane fade" id="v-pills-2" role="tabpanel" aria-labelledby="v-pills-day-2-tab">
                  <div class="p-4">
                     <h3 class="mb-4">Taste / Food Matching</h3>
                     <p>Taste : ${prod.prodTaste} <br><br>
                        Food matching : ${prod.prodMach}</p>
                  </div>
               </div>
               <div class="tab-pane fade" id="v-pills-3" role="tabpanel" aria-labelledby="v-pills-day-3-tab">
                  <div class="row p-4">
                     <div class="col-md-7">
                        <h3 class="mb-4">23 Reviews</h3>
                        <div class="review">
                           <div class="user-img" style="background-image: url(images/person_1.jpg)"></div>
                           <div class="desc">
                              <h4>
                                 <span class="text-left">Jacob Webb</span>
                                 <span class="text-right">25 April 2020</span>
                              </h4>
                              <p class="star">
								   				<span>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
							   					</span>
                                 <span class="text-right"><a href="#" class="reply"><i
                                       class="icon-reply"></i></a></span>
                              </p>
                              <p>When she reached the first hills of the Italic Mountains, she had a last view back
                                 on
                                 the skyline of her hometown Bookmarksgrov</p>
                           </div>
                        </div>
                        <div class="review">
                           <div class="user-img" style="background-image: url(images/person_2.jpg)"></div>
                           <div class="desc">
                              <h4>
                                 <span class="text-left">Jacob Webb</span>
                                 <span class="text-right">25 April 2020</span>
                              </h4>
                              <p class="star">
								   				<span>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
							   					</span>
                                 <span class="text-right"><a href="#" class="reply"><i
                                       class="icon-reply"></i></a></span>
                              </p>
                              <p>When she reached the first hills of the Italic Mountains, she had a last view back
                                 on
                                 the skyline of her hometown Bookmarksgrov</p>
                           </div>
                        </div>
                        <div class="review">
                           <div class="user-img" style="background-image: url(images/person_3.jpg)"></div>
                           <div class="desc">
                              <h4>
                                 <span class="text-left">Jacob Webb</span>
                                 <span class="text-right">25 April 2020</span>
                              </h4>
                              <p class="star">
								   				<span>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
								   					<i class="fa fa-star"></i>
							   					</span>
                                 <span class="text-right"><a href="#" class="reply"><i
                                       class="icon-reply"></i></a></span>
                              </p>
                              <p>When she reached the first hills of the Italic Mountains, she had a last view back
                                 on
                                 the skyline of her hometown Bookmarksgrov</p>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-4">
                        <div class="rating-wrap">
                           <h3 class="mb-4">Give a Review</h3>
                           <p class="star">
							   				<span>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					(98%)
						   					</span>
                              <span>20 Reviews</span>
                           </p>
                           <p class="star">
							   				<span>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					(85%)
						   					</span>
                              <span>10 Reviews</span>
                           </p>
                           <p class="star">
							   				<span>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					(98%)
						   					</span>
                              <span>5 Reviews</span>
                           </p>
                           <p class="star">
							   				<span>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					(98%)
						   					</span>
                              <span>0 Reviews</span>
                           </p>
                           <p class="star">
							   				<span>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					<i class="fa fa-star"></i>
							   					(98%)
						   					</span>
                              <span>0 Reviews</span>
                           </p>
                        </div>
                     </div>
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
      <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
      <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/>
   </svg>
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

<script>
    $(document).ready(function () {


        $("[name=buyNow]").click(function () {
            //alert(1)
            // alert(  $("[name=qty]").val() );

            $("[name=userInputQty]").val($("[name=qty]").val());
            $("#checkout").submit();
        });

        var quantitiy = 0;

        $('.quantity-right-plus').click(function (e) {

            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('[name=qty]').val());

            if(quantity == $("#prodQty").val()) {
                $('.quantity-right-plus').prop('disabled', true);
            } else {
                $('[name=qty]').val(quantity + 1);
            }

            // If is not undefined


            // Increment
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
            }else {
                $('[name=qty]').val(quantity - 1);
            }

        });
    });
</script>


</body>
</html>
<jsp:include page="common/footer.jsp"/>