<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common/header.jsp" />
<link rel="stylesheet" href="css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.updateForm;
		
	if ( f.reviewTitle.value == "") {
	    alert( "제목을 입력해 주세요." );
	    f.model_num.focus();
		return false;
    }
	if ( f.reviewContent.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.model_name.focus();
		return false;
	}
	if ( f.reviewStarScope.value == "" ) {
		alert( "별점을 입력해 주세요." );
		f.price.focus();
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
							href="front?key=notice&methodName=select">Review <i
								class="fa fa-chevron-right"></i></a></span> <span>Review Single <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">Review Upload</h2>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<br>
 <form name="writeForm" method="post" action="front?key=review&methodName=insert" 
  onSubmit='return checkValid()' enctype="multipart/form-data">
<!-- 
아래문장으로 전송하면, post방식으로 전송이 되고, 현재 파일업로드 때문에 enctype="multipart/form-data" 으로 설정돼 있기 때문에 
request로 값을 받을 수가 없다. (MultipartRequest로 받아야 한다.) 
그런데, Controller 로 가기 전에 Controller를 찾기 위해서 DispatcherServlet 에서 request로 두 개의 값을 받고 있기 때문에 
key, methodName 은 get방식으로 별도로 전송해야 한다.
<input type="hidden" name="key" value = "elec" /> 
<input type="hidden" name="methodName" value = "insert" /> 
 -->
<table align="center" cellpadding="5" cellspacing="2" width="600" border="1" >

    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b> 후기등록 </b></font></p>
        </td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="reviewTitle" size="30"></span></b></td>
    </tr>
    
       <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">내용</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<textarea name="reviewContent" cols="50" rows="10"></textarea></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">별점</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="reviewStarScope" size="30"></span></b></td>
    </tr>
    
     <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">*파일첨부</span></b></p>
        </td>
        <td width="450" height="20">
        	<b><span style="font-size:9pt;">   
        		 <input type="file" name="reviewImgUrl" maxlength="60" size="40">
        	   </span></b>
        </td>
    </tr>
    
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;"><input type=submit value=글쓰기> 
        <input type=reset value=다시쓰기></span></b></td>
    </tr>
</table>

</form>
<p>
		<br> <br> <br> <br>
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

</body>
<jsp:include page="common/footer.jsp" />
</html>