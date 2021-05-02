<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>  
   


	<div class="hero-wrap" style="background-image: url('images/jjan.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-8 ftco-animate d-flex align-items-end">
					<div class="text w-100 text-center">
						<h1 class="mb-4">
							Our <span>JJAN</span> for Good <span>Moments</span>.
						</h1>
						<p>
							<a href="front?key=prod&methodName=selectAll"  class="btn btn-primary py-2 px-4">Shop Now</a>
							<a href="#" class="btn btn-white btn-outline-white py-2 px-4">Read more</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-intro">
		<div class="container">
			<div class="row no-gutters">
				<div class="col-md-4 d-flex">
					<div class="intro d-lg-flex w-100 ftco-animate">
						<div class="icon">
							<span class="fa fa-users"></span>
						</div>
						<div class="text">
							<h2>Member & Board</h2>
							<p>최수빈  Member<br>&nbsp;/&nbsp;로그인, 회원관리<br>
							<br>조민주 Board<br>&nbsp;/&nbsp;Q&A, Review, 공지</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 d-flex">
					<div class="intro color-2 d-lg-flex w-100 ftco-animate">
						<div class="icon">
							<span class="fa fa-shopping-cart"></span>
						</div>
						<div class="text">
							<h2>Shopping</h2>
							<p>차영우 Cart&Wish<br>&nbsp;/&nbsp;장바구니, 좋아요<br><br>서정우 Product<br>&nbsp;/&nbsp;상품검색, 관리</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 d-flex">
					<div class="intro color-1 d-lg-flex w-100 ftco-animate">
						<div class="icon">
							<span class="fa fa-money"></span>
						</div>
						<div class="text">
							<h2>Payment</h2>
							<p>김승원 Payment<br>&nbsp;/&nbsp;상품주문, 결제</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section ftco-no-pb">
		<div class="container">
			<div class="row">
				<div class="col-md-6 img img-3 d-flex justify-content-center align-items-center" style="background-image: url(images/image_5.jpg);"></div>
				<div class="col-md-6 wrap-about pl-md-5 ftco-animate py-5">
					<div class="heading-section">
						<span class="subheading">Since 2021</span>

						<h2 class="mb-4" align = "center">Our JJAN for Good Moments</h2>

						<p align = "center">&nbsp;&nbsp;JJAN은 전세계의 와인과 최고의 명품 와인부터 가성비의 와인까지<br>다양한 포트폴리오를 구성하고 있습니다.</p>
						<p style = "font-size: 17px; font: bold" align = "center">"와인이 있는 곳에는 슬픔과 걱정이 날아간다." <br> - 파스퇴르 - <br>"와인은 세상에서 가장 고상한 것이다. "<br> 
						- 헤밍웨이 -  </p>
						<p class="year" align = "center">

							<strong class="number" data-number="107">0</strong> <span>개의 다양한 와인을 즐겨보세요</span>
						</p>
					</div>

				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-no-pb">
		<div class="container">
			<div class="row">
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img" OnClick="location.href ='front?key=prod&methodName=selectAll&values=Red&category=prodType'"  style="background-image: url(images/red.jpg); cursor:pointer;"></div>
						<h3>Red</h3>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img" OnClick="location.href ='front?key=prod&methodName=selectAll&values=Sparkling&category=prodType'"  style="background-image: url(images/sparkling.jpg); cursor:pointer;"></div>
						<h3>Sparkling</h3>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img" OnClick="location.href ='front?key=prod&methodName=selectAll&values=White&category=prodType'"  style="background-image: url(images/white.jpg); cursor:pointer;"></div>
						<h3>White</h3>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img" OnClick="location.href ='front?key=prod&methodName=selectAll&values=cheap&category=prodPrice'"  style="background-image: url(images/cheap.jpg); cursor:pointer;"></div>
						<h3>Economical</h3>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img" OnClick="location.href ='front?key=prod&methodName=selectAll&values=luxury&category=prodPrice'"  style="background-image: url(images/premium.jpg); cursor:pointer;"></div>
						<h3>Premium</h3>
					</div>
				</div>
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img" OnClick="location.href ='front?key=prod&methodName=selectAll'"  style="background-image: url(images/morewine.jpg); cursor:pointer;"></div>
						<h3>More</h3>
					</div>
				</div>

			</div>
		</div>
	</section>
	<br>
	
	<!-- minjoo /review start -->

    <section class="ftco-section testimony-section img" style="background-image: url(images/bg_4.jpg);">
    	<div class="overlay"></div>
      <div class="container">
      
        <div class="row justify-content-center mb-5">
          <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
          	<span class="subheading">Best reviews</span>
            <h2 class="mb-3">Happy Clients</h2>
          </div>
        </div>
<!-- loop -->        
       <div class="row ftco-animate">
          <div class="col-md-12">
            <div class="carousel-testimony owl-carousel ftco-owl">
            
<!-- contents -->            
              <div class="item" id="minjoobestreview">
                  </div> 
                </div> 
              </div>
<!-- contents -->          
            </div>
          </div>
        </div>
        
      </div>
    </section>
<!-- minjoo review end -->

<!-- minjoo // recent notice //start -->		
    <section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center mb-5">
          <div class="col-md-7 heading-section text-center ftco-animate">
          	<span class="subheading">Notice</span>
            <h2>Recent Notice</h2>
          </div>
        </div>
        
        <div class="row d-flex" id="minjooRecent">
   
       
        </div>
      </div>
    </section>	

<!-- minjoo // recent notice //end -->		
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
	<script src="js/main.js"></script>

<script type="text/javascript">

$(function () {
	
		$.ajax({
				url:"${path}/recentNotice" , // 서버요청주소 
		 		type: "post", //method방식 = 전송방식(get, post, put, delete)
		 		dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
		 		success : function(result){
					//alert(result)
					let str ="";
		 			$.each(result, function(i, notice) {
		 				//alert(notice.nNum +" , "+ notice.nImage +" , "+ notice.nRegdate)
		 				
						str += `<div class="col-lg-6 d-flex align-items-stretch ftco-animate fadeInUp ftco-animated">`;
						str += `<div class="blog-entry d-md-flex">`;
						str += "<a href='front?key=notice&methodName=selectByNoticeNumforUser&nNum="+notice.nNum+"' class='block-20 img' style='background-image: url("+notice.nImage+");'> </a>";
						str += `<div class="text p-4 bg-light">`;
						str += `<div class="meta">`;
						str += `<p>`;
						str += "<span class='fa fa-calendar'></span>"+notice.nRegdate;
						str += `</p>`;
						str += `</div>`;
						str += `<h3 class="heading mb-3">`;
						str += "<a href='front?key=notice&methodName=selectByNoticeNum&nNum="+notice.nNum+"'>"+notice.nTitle+"</a>";
						str += `</h3>`;
						str += "<p>"+notice.nContent+"</p>";
						str += `<a href="#" class="btn-custom">views  `;
						str +=  notice.nViewCount+"  <span class='fa fa-eye'></span>";
						str += `</a></div></div></div>`;
		 				
		 				
		 			});//end of each
		 			
		 			$("#minjooRecent").html(str); 
		 		},
		 		error: function(err){
   				 	alert(err+"발생했어요^^")
   			 	} //
		});//end of ajax
})//end of function



</script>
<script type="text/javascript">

$(function () {
	
		$.ajax({
				url:"${path}/bestReview" , // 서버요청주소 
		 		type: "post", //method방식 = 전송방식(get, post, put, delete)
		 		dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
		 		success : function(result){
					//alert(result)
					 let str ="";
		 			$.each(result, function(i, review) {
		 				//alert(notice.nNum +" , "+ notice.nImage +" , "+ notice.nRegdate)
		 				
		 				
		 			str += `<div class="testimony-wrap py-4">`;
		 			str += `<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></div>`;
		 			str += `<div class="text">`;
		 			str += `<div class="d-flex align-items-center">`;
		 			str += "<div class='user-img' style='background-image: url("+review.reviewImgUrl+");'></div>";
		 			str += `<div class="pl-3">`
		 			str += "<p class='mb-4'>"+review.reviewContent+"</p>";
		 			//str += `<p class="name">Roger Scott</p>
		 			str += "<span class='position'>"+review.userId+"</span>";
		 			//str += `</div></div></div>`;
		 			str += `</div></div></div></div>`;
		 				
		 				
		 			});//end of each 
		 			
		 			$(".owl-stage-outer").html(str); 
		 		},
		 		error: function(err){
   				 	alert(err+"발생했어요^^")
   			 	} //
		});//end of ajax
})//end of function



</script>

</body>
</html>
<jsp:include page="common/footer.jsp" />