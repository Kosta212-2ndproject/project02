<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="common/headerAdmin.jsp" />

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
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="index.jsp">
								Home <i class="fa fa-chevron-right"></i>
							</a></span> <span>Products <i class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Products</h2>
				</div>
			</div>
		</div>
	</section>
	<!-- contents -->




	<caption><h1 align="center">상품 LIST</h1></caption>
	<span style="font-size:30pt; margin:20px"><a href="product-insert.jsp" class="btn btn-primary py-3 px-5 mr-2">상품등록</a></span>
	<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
	
	<colgroup>
		<col width="15%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">모델번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">모델이름</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">Vintage</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">원산지</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">재고</span></b></font></p>
        </td>
       
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.listAll}">
	   <tr>
        <td colspan="6">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.listAll}" var="prodDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${prodDto.prodId}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="${path}/front?key=prod&methodName=selectByProductDetailByAdmin&prodId=${prodDto.prodId}">
					  ${prodDto.prodName} / ${prodDto.prodNameEng}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${prodDto.prodPrice}"/>원</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${prodDto.prodVatage}년</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${prodDto.prodNation}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${prodDto.prodQty}"/> 개</span></p>
		        </td>
		        
		       
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>

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
										<li><a href="front?key=prod&methodName=selectAllByAdmin&pageNo=${startPage-1}">&lt;</a></li>
									</c:if>

									<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'>
										<c:if test="${(i-1)>=p.pageCnt}">
											<c:set var="doneLoop" value="true" />
										</c:if>
										<c:if test="${not doneLoop}">
											<a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=prod&methodName=selectAllByAdmin&pageNo=${i}">${i}</a>
										</c:if>

									</c:forEach>
									<c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
										<li><a href="front?key=prod&methodName=selectAllByAdmin&pageNo=${startPage+p.blockcount}">&gt;</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
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