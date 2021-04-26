<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
    <title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../css/animate.css">
    
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">
    
    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/style.css">
    
    <script type="text/javascript">
    function sendUpdate(){
    	document.requestForm.methodName.value ="updateForm";
    	document.requestForm.submit();
    }

    function sendDelete(){
    	
    	document.requestForm.methodName.value ="delete";
    	document.requestForm.submit();
    }
    
    
    
    </script>
  </head>
  <body>
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp">Home <i class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a href="front?key=notice&methodName=select">Notice <i class="fa fa-chevron-right"></i></a></span> <span>Notice Single <i class="fa fa-chevron-right"></i></span></p>
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
						<img src="${nDTO.nImage}" alt="" class="img-fluid"/>
					</p>
					<h2 class="mb-3">${nDTO.nTitle}</h2>
					<p>${nDTO.nContent}</p>
					<p>
					

	<form name="requestForm" method=post action="${path}/front">
    </tr>
    
    
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="nNum" value="${nDTO.nNum}">
				<input type=hidden name="key" value="notice">
				<input type=hidden name="methodName">
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
    </form>

					<div class="about-author d-flex p-4 bg-light">
              <div class="bio mr-5">
                <img src="images/person_1.jpg" alt="Image placeholder"
								class="img-fluid mb-4">
              </div>
              <div class="desc">
                <h3>George Washington</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus itaque, autem necessitatibus voluptate quod mollitia delectus aut, sunt placeat nam vero culpa sapiente consectetur similique, inventore eos fugit cupiditate numquam!</p>
              </div>
            </div>



          </div> <!-- .col-md-8 -->
          <div class="col-lg-4 sidebar pl-lg-5 ftco-animate">
            <div class="sidebar-box">
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control"
									placeholder="Type a keyword and hit enter">
                </div>
              </form>
            </div>
            <div class="sidebar-box ftco-animate">
              <div class="categories">
                <h3>Services</h3>
                <li><a href="#">Relation Problem <span
									class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Couples Counseling <span
									class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Depression Treatment <span
									class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Family Problem <span
									class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Personal Problem <span
									class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Business Problem <span
									class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

            <div class="sidebar-box ftco-animate">
              <h3>highly recommended</h3>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4"
								style="background-image: url(images/image_1.jpg);"></a>
                <div class="text">
                  <h3 class="heading">
									<a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
								</h3>
                  <div class="meta">
                    <div>
										<a href="#"><span class="fa fa-calendar"></span> Apr. 18, 2020</a>
									</div>
                    <div>
										<a href="#"><span class="fa fa-user"></span> Admin</a>
									</div>
                    <div>
										<a href="#"><span class="fa fa-comment"></span> 19</a>
									</div>
                  </div>
                </div>
              </div>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4"
								style="background-image: url(images/image_2.jpg);"></a>
                <div class="text">
                  <h3 class="heading">
									<a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
								</h3>
                  <div class="meta">
                    <div>
										<a href="#"><span class="fa fa-calendar"></span> Apr. 18, 2020</a>
									</div>
                    <div>
										<a href="#"><span class="fa fa-user"></span> Admin</a>
									</div>
                    <div>
										<a href="#"><span class="fa fa-comment"></span> 19</a>
									</div>
                  </div>
                </div>
              </div>
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4"
								style="background-image: url(images/image_3.jpg);"></a>
                <div class="text">
                  <h3 class="heading">
									<a href="#">Even the all-powerful Pointing has no control about the blind texts</a>
								</h3>
                  <div class="meta">
                    <div>
										<a href="#"><span class="fa fa-calendar"></span> Apr. 18, 2020</a>
									</div>
                    <div>
										<a href="#"><span class="fa fa-user"></span> Admin</a>
									</div>
                    <div>
										<a href="#"><span class="fa fa-comment"></span> 19</a>
									</div>
                  </div>
                </div>
              </div>
            </div>

            <div class="sidebar-box ftco-animate">
              <h3>Tag Cloud</h3>
              <div class="tagcloud">
                <a href="#" class="tag-cloud-link">Red</a>
                <a href="#" class="tag-cloud-link">White</a>
                <a href="#" class="tag-cloud-link">Sparkling</a>
                <a href="#" class="tag-cloud-link">wine</a>
                <a href="#" class="tag-cloud-link">France</a>
                <a href="#" class="tag-cloud-link">Spain</a>
                <a href="#" class="tag-cloud-link">Germany</a>
              </div>
            </div>

          </div>

        </div>
      </div>
    </section> <!-- .section -->
    
  

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
  <script src="js/main.js"></script>
    
  </body>
</html>
<jsp:include page="../common/footer.jsp"/>