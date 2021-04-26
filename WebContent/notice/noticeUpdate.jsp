<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
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

<SCRIPT>
function checkValid() {
	var f = window.document.updateForm;
	if ( f.nTitle.value == "" ) {
		alert("제목을 입력해 주세요." );
		f.nTitle.focus();
		return false;
	}
	if ( f.nContent.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.nContent.focus();
		return false;
	}
	
    
}
</SCRIPT>

</HEAD>

<BODY>
 <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="index.jsp">Home <i class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a href="front?key=notice&methodName=select">Notice <i class="fa fa-chevron-right"></i></a></span> <span>Notice Single <i class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">Notice Upload</h2>
          </div>
        </div>
      </div>
    </section>
<br>
<br>
<br>
<br>

	<form name=updateForm method=post
		action="${path}/front?key=notice&methodName=update&nNum=${nDTO.nNum}"
		onSubmit="return checkValid()" enctype="multipart/form-data">
		<input type="hidden" name="key" value="notice"> <input
			type="hidden" name="methodName" value="update"> <input
			type='hidden' name='nNum' value="${nDTO.nNum}">
		<table align="center" cellpadding="5" cellspacing="1" width="600"
			border="1">
			<tr>
				<td width="1220" height="20" colspan="2" bgcolor="#00cc00">
					<p align="center">
						<font color="white" size="3"><b> 게시물 수정하기</b></font>
					</p>
				</td>
			</tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">제 목 </span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type=text name="nTitle"
							size="30" value="${nDTO.nTitle}"></span></b></td>
			</tr>


			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">내 용 </span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <textarea name="nContent"
								cols="50" rows="10">${nDTO.nContent}</textarea></span></b></td>
			</tr>
			        <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">카테고리 </span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type="radio" name="nField" value="0" size="30" checked="checked">공지   
		<input type="radio" name="nField" value="1" size="30">이벤트   
		<input type="radio" name="nField" value="2" size="30">FAQ    
		</span></b></td>
    </tr>
			<tr>
				<td width="150" height="20">
					<p align="right">
						<b><span style="font-size: 9pt;">*파일첨부</span></b>
					</p>
				</td>
				<td width="450" height="20"><b><span
						style="font-size: 9pt;"> <input type="file" name="nImage"
							maxlength="60" size="40" value="${nDTO.nImage}">
					</span></b></td>
			</tr>
			<tr>
				<td width="450" height="20" colspan="2" align="center"><b><span
						style="font-size: 9pt;"> <input type="submit" value="수정하기">
							<input type="reset" value="다시쓰기"></span></b></td>
			</tr>
		</table>
	</form>
	<p>
<br>
<br>
<br>
<br>
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
<jsp:include page="../common/footer.jsp"/>