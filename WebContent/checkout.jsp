<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
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

   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   <script src="js/zipCode.js"></script>
</head>
<body>

<div class="wrap">
   <div class="container">
      <div class="row">
         <div class="col-md-6 d-flex align-items-center">
            <p class="mb-0 phone pl-md-2">
               <a href="#" class="mr-2"><span class="fa fa-phone mr-1"></span> +00 1234 567</a>
               <a href="#"><span class="fa fa-paper-plane mr-1"></span> youremail@email.com</a>
            </p>
         </div>
         <div class="col-md-6 d-flex justify-content-md-end">
            <div class="social-media mr-4">
               <p class="mb-0 d-flex">
                  <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"><i
                        class="sr-only">Facebook</i></span></a>
                  <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"><i
                        class="sr-only">Twitter</i></span></a>
                  <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"><i
                        class="sr-only">Instagram</i></span></a>
                  <a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-dribbble"><i
                        class="sr-only">Dribbble</i></span></a>
               </p>
            </div>
            <div class="reg">
               <p class="mb-0"><a href="#" class="mr-2">Sign Up</a> <a href="#">Log In</a></p>
            </div>
         </div>
      </div>
   </div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
   <div class="container">
      <a class="navbar-brand" href="index.html">Liquor <span>store</span></a>
      <div class="order-lg-last btn-group">
         <a href="#" class="btn-cart dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true"
            aria-expanded="false">
            <span class="flaticon-shopping-bag"></span>
            <div class="d-flex justify-content-center align-items-center"><small>3</small></div>
         </a>
         <div class="dropdown-menu dropdown-menu-right">
            <div class="dropdown-item d-flex align-items-start" href="#">
               <div class="img" style="background-image: url(images/prod-1.jpg);"></div>
               <div class="text pl-3">
                  <h4>Bacardi 151</h4>
                  <p class="mb-0"><a href="#" class="price">$25.99</a><span class="quantity ml-3">Quantity: 01</span>
                  </p>
               </div>
            </div>
            <div class="dropdown-item d-flex align-items-start" href="#">
               <div class="img" style="background-image: url(images/prod-2.jpg);"></div>
               <div class="text pl-3">
                  <h4>Jim Beam Kentucky Straight</h4>
                  <p class="mb-0"><a href="#" class="price">$30.89</a><span class="quantity ml-3">Quantity: 02</span>
                  </p>
               </div>
            </div>
            <div class="dropdown-item d-flex align-items-start" href="#">
               <div class="img" style="background-image: url(images/prod-3.jpg);"></div>
               <div class="text pl-3">
                  <h4>Citadelle</h4>
                  <p class="mb-0"><a href="#" class="price">$22.50</a><span class="quantity ml-3">Quantity: 01</span>
                  </p>
               </div>
            </div>
            <a class="dropdown-item text-center btn-link d-block w-100" href="cart.html">
               View All
               <span class="ion-ios-arrow-round-forward"></span>
            </a>
         </div>
      </div>

      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
              aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
         <span class="oi oi-menu"></span> Menu
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
         <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a href="index.html" class="nav-link">Home</a></li>
            <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
            <li class="nav-item dropdown active">
               <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true"
                  aria-expanded="false">Products</a>
               <div class="dropdown-menu" aria-labelledby="dropdown04">
                  <a class="dropdown-item" href="product.html">Products</a>
                  <a class="dropdown-item" href="product-single.html">Single Product</a>
                  <a class="dropdown-item" href="cart.html">Cart</a>
                  <a class="dropdown-item" href="checkout.jsp">Checkout</a>
               </div>
            </li>
            <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
            <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
         </ul>
      </div>
   </div>
</nav>
<!-- END nav -->

<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');"
         data-stellar-background-ratio="0.5">
   <div class="overlay"></div>
   <div class="container">
      <div class="row no-gutters slider-text align-items-end justify-content-center">
         <div class="col-md-9 ftco-animate mb-5 text-center">
            <p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.html">Home <i class="fa fa-chevron-right"></i></a></span>
               <span>Checkout <i class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">주문/결제</h2>
         </div>
      </div>
   </div>
</section>


<%
   request.setCharacterEncoding("UTF-8");

   String prodId = request.getParameter("prodId");
   String imgUrl = request.getParameter("imgUrl");
   String name = request.getParameter("name");
   String nameTag = request.getParameter("nameEng");
   int price = Integer.parseInt(request.getParameter("price"));
   int dbQty = Integer.parseInt(request.getParameter("dbQty"));
   int qty = Integer.parseInt(request.getParameter("userInputQty"));

   int totalPrice = price * qty;

   System.out.println(prodId);
%>
<!-- 장바구니 카트 -->
<section class="ftco-intro">
   <div class="container">
      <div class="row">
         <div class="table-borderless">
            <table class="table">
               <thead class="thead-primary">
               <tr>
                  <th>상품이미지</th>
                  <th>상품이름</th>
                  <th>가격</th>
                  <th>수량</th>
                  <th>총가격</th>
                  <th>&nbsp;</th>
               </tr>
               </thead>
               <tbody>
               <tr class="alert" role="alert">
                  <td>
                     <div class="img"><img src="<%=imgUrl%>" width="80" height="100" /> </div>
                  </td>
                  <td>
                     <div class="email">
                        <span><%= name %></span>
                        <span><%= nameTag %></span>
                     </div>
                  </td>
                  <td><fmt:formatNumber value="<%= price %>" pattern="#,###원"/></td>

                  <td class="quantity">
                     <div class="input-group">
                        <input type="text" class="quantity form-control-plaintext" value="<%=qty%>개" readonly/>
                     </div>
                  </td>
                  <td><fmt:formatNumber value="<%= totalPrice %>" pattern="#,###원"/></td>
               </tr>
               </tbody>
            </table>
         </div>
      </div>
   </div>
</section>

<section class="ftco-section">
   <div class="container">
      <div class="row justify-content-center">
         <div class="col-md-12 ftco-animate">
            <form action="#" class="billing-form">
               <h3 class="mb-4 billing-heading">결제 세부 정보</h3>
               <div class="row align-items-end">

                  <div class="col-md-6">
                     <div class="form-group">
                        <label for="firstname">수령인</label>
                        <input type="text" class="form-control" placeholder="">
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group">
                        <label for="emailaddress">휴대폰 번호</label>
                        <input type="text" class="form-control" placeholder="" id="phoneNum">
                     </div>
                  </div>
                  <div class="w-100"></div>
                  <div class="col-md-10">
                     <div class="form-group">
                        <label for="postcodezip">우편번호</label>
                        <input type="text" class="form-control" id="post-code" readonly>
                     </div>
                  </div>
                  <div class="col-md-2">
                     <div class="form-group">
                        <a href="#" class="btn btn-outline-primary py-3 px-md-5" onclick="DaumPostCodeFunc()">찾기</a>
                     </div>
                  </div>


                  <div class="w-100"></div>
                  <div class="col-md-6">
                     <div class="form-group">
                        <label for="streetaddress">배송지 주소</label>
                        <input type="text" class="form-control" id="address" readonly>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="form-group">
                        <input type="text" class="form-control" id="extraAddress" readonly>
                     </div>
                  </div>

                  <div class="w-100"></div>
                  <div class="col-md-12">
                     <div class="form-group">
                        <label for="phone">상세 주소</label>
                        <input type="text" class="form-control" placeholder="" id="detail-address">
                     </div>
                  </div>

                  <div class="w-100"></div>
                  <div class="col-md-12">
                     <label for="country">배송 메모</label>
                     <div class="select-wrap">
                        <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                        <select name="" id="" class="form-control">
                           <option value="">배송 전에 미리 연락 바랍니다.</option>
                           <option value="">부재시 경비실에 맡겨 주세요.</option>
                           <option value="">부재시 전화 주시거나 문자 남겨 주세요.</option>
                        </select>
                     </div>
                  </div>

                  <div class="w-100"></div>
                  <div class="col-md-12">
                     <div class="form-group mt-4">
                        <div class="radio">
                           <label><input type="radio" name="optradio"> 주소를 등록하시겠습니까? &nbsp;</label>
                           <a class="btn btn-outline-secondary py-2 px-3" name="address-insert">등록</a>
                        </div>
                     </div>

                  </div>
               </div>
            </form><!-- END -->


            <div class="row mt-5 pt-3 d-flex">
               <div class="col-md-6 d-flex">
                  <div class="cart-detail cart-total p-3 p-md-4">
                     <h3 class="billing-heading mb-4">장바구니</h3>
                     <p class="d-flex">
                        <span>상품 금액</span>
                        <span><fmt:formatNumber value="<%= price %>" pattern="#,###원"/></span>
                     </p>
                     <p class="d-flex">
                        <span>배송비</span>
                        <span>&nbsp;&nbsp;<fmt:formatNumber value="2000" pattern="#,###원"/></span>
                     </p>
<%--                     <p class="d-flex">--%>
<%--                        <span>할인 금액</span>--%>
<%--                        <span>3,000원</span>--%>
<%--                     </p>--%>
                     <hr>
                     <p class="d-flex total-price">
                        <span>총 금액</span>
                        <span><fmt:formatNumber value="<%= totalPrice+2000 %>" pattern="#,###원"/></span>
                     </p>
                  </div>
               </div>
               <div class="col-md-6">
                  <div class="cart-detail p-3 p-md-4">
                     <h3 class="billing-heading mb-4">주문</h3>
                     <div class="form-group">
                        <div class="col-md-12" id="check_payment">
                           <div class="radio">
                              <label><input type="radio" name="optradio" class="mr-2" id="card" value="card"> 신용카드</label>
                           </div>

                           <div class="radio">
                              <label><input type="radio" name="optradio" class="mr-2" id="phone" value="phone"> 휴대폰 결제</label>
                           </div>

                           <div class="radio">
                              <label><input type="radio" name="optradio" class="mr-2" id="cultureland" value="cultureland"> 문화상품권</label>
                           </div>
                        </div>
                     </div>

                     <div class="form-group">
                        <div class="col-md-12">
                           <div class="checkbox">
                              <label><input type="checkbox" value="" class="mr-2" name="agree"> 결제 이용 약관을 읽고 동의합니다.</label>
                           </div>
                        </div>
                     </div>
                     <p><a class="btn btn-primary py-3 px-4" id="payment">결제하기</a></p>
                  </div>
               </div>
            </div>
         </div> <!-- .col-md-8 -->
      </div>
   </div>
</section>

<footer class="ftco-footer">
   <div class="container">
      <div class="row mb-5">
         <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4">
               <h2 class="ftco-heading-2 logo"><a href="#">Liquor <span>Store</span></a></h2>
               <p>Far far away, behind the word mountains, far from the countries.</p>
               <ul class="ftco-footer-social list-unstyled mt-2">
                  <li class="ftco-animate"><a href="#"><span class="fa fa-twitter"></span></a></li>
                  <li class="ftco-animate"><a href="#"><span class="fa fa-facebook"></span></a></li>
                  <li class="ftco-animate"><a href="#"><span class="fa fa-instagram"></span></a></li>
               </ul>
            </div>
         </div>
         <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
               <h2 class="ftco-heading-2">My Accounts</h2>
               <ul class="list-unstyled">
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>My Account</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Register</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Log In</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>My Order</a></li>
               </ul>
            </div>
         </div>
         <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
               <h2 class="ftco-heading-2">Information</h2>
               <ul class="list-unstyled">
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>About us</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Catalog</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Contact us</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Term &amp; Conditions</a></li>
               </ul>
            </div>
         </div>
         <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4">
               <h2 class="ftco-heading-2">Quick Link</h2>
               <ul class="list-unstyled">
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>New User</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Help Center</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Report Spam</a></li>
                  <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Faq's</a></li>
               </ul>
            </div>
         </div>
         <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4">
               <h2 class="ftco-heading-2">Have a Questions?</h2>
               <div class="block-23 mb-3">
                  <ul>
                     <li><span class="icon fa fa-map marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span>
                     </li>
                     <li><a href="#"><span class="icon fa fa-phone"></span><span class="text">+2 392 3929 210</span></a>
                     </li>
                     <li><a href="#"><span class="icon fa fa-paper-plane pr-4"></span><span class="text">info@yourdomain.com</span></a>
                     </li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="container-fluid px-0 py-5 bg-black">
      <div class="container">
         <div class="row">
            <div class="col-md-12">

               <p class="mb-0" style="color: rgba(255,255,255,.5);">
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                  Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                  All rights reserved | This template is made with <i class="fa fa-heart color-danger"
                                                                      aria-hidden="true"></i> by <a
                     href="https://colorlib.com" target="_blank">Colorlib.com</a>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>
         </div>
      </div>
   </div>
</footer>


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
<script src="js/checkoutJS.js"></script>

</body>
</html>