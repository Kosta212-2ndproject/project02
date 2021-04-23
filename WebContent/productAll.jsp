<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="common/header.jsp"/>

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
  </head>
<body>


	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp">Home <i class="fa fa-chevron-right"></i></a></span> <span>Products <i class="fa fa-chevron-right"></i></span></p>
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
					
					<div class="row mb-4">
						<div class="col-md-12 d-flex justify-content-between align-items-center">
							<h4 class="product-select">Select Types of Products</h4>
							<form action="#">
							<select name = "types">
							<option value="0">선택없음</option>
							<option value="1">인기순</option>
							<option value="2">신제품순</option>
							<option value="3">별점순</option>
							<option value="4">가격순▲</option>
							<option value="5">가격순▼</option>
							</select>
							<input type="submit" value="선택">
						</form>
						</div>
						</div>
						
						
						
						<div class="row">
							<c:choose>
    							<c:when test="${empty requestScope.listAll}"><!--  requesScope에 저장해야 하는 이름이 list -->
									<p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
								</c:when>
								<c:otherwise>
								<c:forEach items="${requestScope.listAll}" var="prodDto">
							<div class="col-md-4 d-flex">
							
								<div class="product ftco-animate">
								
									<div class="img d-flex align-items-center justify-content-center" style="background-image: url('${prodDto.prodImgUrl}');">
										<div class="desc">
											<p class="meta-prod d-flex">
												<a href="#" class="d-flex align-items-center justify-content-center"><span class="flaticon-shopping-bag"></span></a>
												<a href="#" class="d-flex align-items-center justify-content-center"><span class="flaticon-heart"></span></a>
												<a href="${path}/front?key=prod&methodName=selectByProductDetail&prodId=${prodDto.prodId}" class="d-flex align-items-center justify-content-center"><span class="flaticon-visibility"></span></a>
											</p>
										</div>
									</div>
									<div class="text text-center">
										<span class="category">${prodDto.prodType}</span>
										<h2>${prodDto.prodName}</h2>
										<h3>${prodDto.prodNameEng}</h3>
										<span class="price"><fmt:formatNumber value="${prodDto.prodPrice}" pattern="#,###원"/></span>
									</div>
									
								</div>
								
							</div>
							</c:forEach>
									</c:otherwise>
  								</c:choose>
						</div>
						
						
						
						
						
						
						<div class="row mt-6">
		          <div class="col text-center">
		            <div class="block-27">
		              <ul>
		                <li><a href="#">&lt;</a></li>
		                <li class="active"><span>1</span></li>
		                <li><a href="#">2</a></li>
		                <li><a href="#">3</a></li>
		                <li><a href="#">4</a></li>
		                <li><a href="#">5</a></li>
		                <li><a href="#">6</a></li>
		                <li><a href="#">&gt;</a></li>
		              </ul>
		            </div>
		          </div>
		        </div>
					</div>
					
					
    							
								
					
					<div class="col-md-3">
					
						<div class="sidebar-box ftco-animate">
              <div class="categories">
                <h3>국가별 상품</h3>
                <ul class="p-0">
                	<li><a href="productAll.jsp">전체상품</a></li>
                	<li><a href="${path}/front?key=prod&methodName=selectByProductDetail&prodNation=${NationDto.prodNation}">${NationDto.prodNation} <span class="fa fa-chevron-right"></span></a></li>
	             
                </ul>
              </div>
              
            </div>
      
			
            
            <div class="sidebar-box ftco-animate">
              <h3>Recent Blog</h3>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" style="background-image: url(images/image_1.jpg);"></a>
                <div class="text">
                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
                  <div class="meta">
                    <div><a href="#"><span class="fa fa-calendar"></span> Apr. 18, 2020</a></div>
                    <div><a href="#"><span class="fa fa-comment"></span> 19</a></div>
                  </div>
                </div>
              </div>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" style="background-image: url(images/image_2.jpg);"></a>
                <div class="text">
                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
                  <div class="meta">
                    <div><a href="#"><span class="fa fa-calendar"></span> Apr. 18, 2020</a></div>
                    <div><a href="#"><span class="fa fa-comment"></span> 19</a></div>
                  </div>
                </div>
              </div>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" style="background-image: url(images/image_3.jpg);"></a>
                <div class="text">
                  <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
                  <div class="meta">
                    <div><a href="#"><span class="fa fa-calendar"></span> Apr. 18, 2020</a></div>
                    <div><a href="#"><span class="fa fa-comment"></span> 19</a></div>
                  </div>
                </div>
              </div>
              
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
  
</body>
</html>
<jsp:include page="common/footer.jsp"/>