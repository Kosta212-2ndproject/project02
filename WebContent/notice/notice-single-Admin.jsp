<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/headerAdmin.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<link rel="stylesheet" href="../css/animate.css">

<link rel="stylesheet" href="../css/owl.carousel.min.css">
<link rel="stylesheet" href="../css/owl.theme.default.min.css">
<link rel="stylesheet" href="../css/magnific-popup.css">

<link rel="stylesheet" href="../css/flaticon.css">
<link rel="stylesheet" href="../css/style.css">
<SCRIPT>
	function checkValid() {
		var f = window.document.searchForm;

		if (f.keyWord.value == "") {
			alert("검색어를 입력해 주세요.");
			f.keyWord.focus();
			return false;
		}
		return true;
	}
</SCRIPT>
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
								class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a
							href="front?key=notice&methodName=selectAdmin">Notice <i
								class="fa fa-chevron-right"></i></a></span> <span>Notice Single <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Notice Single</h2>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 ftco-animate">
					<p>
						<img src="${nDTO.nImage}" alt="" class="img-fluid">
						
						<!-- <img src="${nDTO.nImage}" alt="" class="img-fluid"> -->
						
					</p>
					<h2 class="mb-3">${nDTO.nTitle}</h2>
					<p>${nDTO.nContent}</p>
					<p>
					
					<div class="row justify-content-center">
						<div class="col-md-4">
							<a
								href="${path}/front?key=notice&methodName=selectByNoticeNumAdmin&nNum=${nDTO.nNum}"
								class="btn btn-primary d-block"> Notice Update & Delete <span
								class="fa fa-long-arrow-right"></span>
							</a>
						</div>
					</div>
					<br> <br> 





					<div class="about-author d-flex p-4 bg-light">
						<div class="bio mr-5">
							<img src="images/wineeditor.png" width="300" height="300" alt="Image placeholder"
								class="img-fluid mb-4">
						</div>
						<div class="desc">
							<h3> Victor Hugo </h3>
							<p>God made only water, but man made wine.</p>
							<h3> Charles Baudelaire </h3>
							<p>Drink wine, drink poetry, drink virtue.</p>
							<h5> Whatever you choose,<br> you are always right.</h5>
						</div>
					</div>


				</div>
				<!-- .col-md-8 -->
				<div class="col-lg-4 sidebar pl-lg-5 ftco-animate">
					<div class="sidebar-box">
							<form name="searchForm" action="front" method="post" onSubmit='return checkValid()' class="search-form">
							<div class="form-group">
								<span class="fa fa-search"></span> 
								<input type="text" class="form-control" name="values" placeholder="상품명 | 국가">
								<input type="hidden" name="key" value="prod">
								<input type="hidden" name="methodName" value="selectAll">
								<input type="hidden" name="category" value="keyWord">
							</div>
						</form>
					</div>
					<div class="sidebar-box ftco-animate">
						<div class="categories">
							<h3>Services</h3>
							<li><a href="front?key=prod&methodName=selectAll">Shop <span
									class="fa fa-chevron-right"></span></a></li>
							<li><a href="front?key=notice&methodName=selectAdmin">Notice <span
									class="fa fa-chevron-right"></span></a></li>
							
						</div>
					</div>

					<div><h4>highly recommended</h4></div><br>
					<div id="minjooRecentNotice" class="sidebar-box ftco-animate fadeInUp ftco-animated">
<!-- loop -->						


<!-- loop -->						
						
					</div>

					<div class="sidebar-box ftco-animate">
						<h3>Tag Cloud</h3>
						<div class="tagcloud">
							<a href="#" class="tag-cloud-link">Red</a> <a href="#"
								class="tag-cloud-link">White</a> <a href="#"
								class="tag-cloud-link">Sparkling</a> <a href="#"
								class="tag-cloud-link">wine</a> <a href="#"
								class="tag-cloud-link">France</a> <a href="#"
								class="tag-cloud-link">Spain</a> <a href="#"
								class="tag-cloud-link">Germany</a>
						</div>
					</div>

				</div>

			</div>
		</div>
	</section>
	<!-- .section -->



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
		 				
											
						str +=`<div class="block-21 mb-4 d-flex">`;
						str += "<a class='blog-img mr-4' style='background-image: url("+notice.nImage+");'></a>";
						str += `<div class="text"><h5 class="heading">`;
						str += "<a href='front?key=notice&methodName=selectByNoticeNum&nNum="+notice.nNum+"'>"+notice.nTitle+"</a>";
						str += `</h5>`;
						str += `<div class="meta"><div>`;
						str += "<a href='#'><span class='fa fa-calendar'></span>"+notice.nRegdate+"</a>";
						str += `</div><div>`;
						str += `<a href="#"><span class="fa fa-user"></span> Admin</a>`
						str += `</div>`;
						str += `<div>`;
						str += "<a href='#'><span class='fa fa-eye'></span>"+notice.nViewCount+"</a>";
						str += `</div></div></div></div>`;
						
						
						
		 			});//end of each
		 			
		 			$("#minjooRecentNotice").html(str); 
		 		},
		 		error: function(err){
   				 	alert(err+"발생했어요^^")
   			 	} //
		});//end of ajax
})//end of function
</script>

</body>
</html>
<jsp:include page="../common/footerAdmin.jsp" />