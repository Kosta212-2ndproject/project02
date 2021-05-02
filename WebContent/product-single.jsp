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
					<br>
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

							<p style="color: #000;">재고 : <span style="color: red; font-size:25px">${prod.prodQty} </span> 개&emsp;&emsp; 배송비 : 2500원</p>

						</div>
					</div>
					<p>
						<a href="${path}/front?key=cart&methodName=insertCart&prodId=${prod.prodId}" class="btn btn-primary py-3 px-5 mr-2">Add
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
			<c:if test="${not empty userId}">
             <a class="nav-link ftco-animate mr-lg-1" id="v-pills-3-tab" data-toggle="pill" href="#v-pills-3" role="tab" aria-controls="v-pills-3" aria-selected="false">Reviews</a>
			</c:if>
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
									<input type="hidden" name="userId" value="${session.userId}"/>

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
													<c:if test="${not empty userId}">
												<fieldset>
													<legend> 공개 / 비공개 </legend>
													<input type="radio" id="product" name="qShowstatus" value="0">
													<label for="product"> 비공개 </label><br />
													<input type="radio" id="order" name="qShowstatus" value="1">
													<label for="order">	공개 </label><br />
												</fieldset>
													</c:if>
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



  <script>
	$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
	});//end of ready
</script>	    

<script type="text/javascript">
	
	
	$(document).ready(function() {
		
		
		///////////////////////////////////////////////////
	 	
		//alert("${prod.prodId}")
		//var isRun=false;
		$(document).on("click","#v-pills-3-tab", function(){
			//alert(22)
			var sessionId = "<%=session.getAttribute("userId")%>"
			$.ajax({
   			 url:"${path}/reviewSelect" , // 서버요청주소
   			 type: "post", //method방식 = 전송방식(get, post, put, delete)
   			 dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
   		     data: {prodId : "${prod.prodId}"} ,  //서버에게 보낼 parameter정보 
   			 success : function(result){
   			   //alert(result)
   			  /* 	setTimeout(function () {
   			  		isRun = false;
				},10000000); */
   				let str = "<table id='table'><tr>";
   				str += "<th> 회원아이디 </th>";
   				str += "<th> 제목 </th>";
   				str += "<th> 내용 </th>";
   				str += "<th> 별점 </th>";
   				str += "<th> 등록일 </th>";
   				str += "<th> 사진 </th>";
   				str += "<th> 조회수 </th>";
				$.each(result, function(index, item) {
					str += "<tr>"
					str += "<td>" + item.userId + "</td>"
					if(sessionId != null){
						str += "<td><a href='front?key=review&methodName=selectByReviewId&reviewId="+item.reviewId+"&prodId="+item.prodId+"&reviewUserId="+item.userId+"'>" + item.reviewTitle + "</td>"
					}else{
						str += "<td>" + item.reviewTitle + "</td>"
					}
					str += "<td>" + item.reviewContent + "</td>"
					str += "<td>" + item.reviewStarScope + "</td>"
					str += "<td>" + item.reviewRegdate + "</td>"
					str += "<td><img width='175' height='200' src='"+item.reviewImgUrl+"'></td>";
					str += "<td>" + item.reviewVcount + "</td>"
					//str += "<td><input type='button' value='delete'/></td>"
					str += "</tr>"
				});
				str += "</table>"

				
				//겹치는 css클래스 명이 있을 경우 , id 를 줘서 unique 하게 처리하면 됨 
				//브라우저에서 지원하는 소스코드 활용해서 css 적용해보면서 할 것!  
				//->미리 어떤식으로 적용되는지 확인 후, 실제 코드에서 변경해 주면됨 
				//$(".col-md-7").after(str);//형제노드로추가되는 것. 
				$("#minjoo").html(str);// 해당영역 안에 추가되는 것 , 덮어쓰기됨  
				
				
   			 } , //성공했을때 함수
   			 error: function(err){
   				 alert(err+"발생했어요^^")
   			 } //오류발생했을때 함수 
   			 
   		 });//ajax끝
			
		})//end of on		
		
	})//end of ready

</script> 
<script type="text/javascript">

	$(document).ready(function() {
		//Q&A Board
		//alert("${prod.prodId}")
			$(document).on("click","#v-pills-5-tab", function(){ 
				var sessionId = "<%=session.getAttribute("userId")%>"
				//alert(sessionId)				
				$.ajax({
	   			 		url:"${path}/boardSelect" , // 서버요청주소 
	   			 		type: "post", //method방식 = 전송방식(get, post, put, delete)
	   			 		dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
	   		     		data: {prodId : "${prod.prodId}"} ,  //서버에게 보낼 parameter정보 
	   			 		success : function(result){
	   			   		//alert(result)
	   			   		var str="<table><tr>";
	   			   		str += "<th> No. </th>";
						str += "<th> ID </th>";
						str += "<th> Category </th>";
						str += "<th> Title </th>";
						str += "<th> Date </th>";
						str += "<th> public | private </th>";	
						str += "</tr>"
   							$.each(result, function(index , questionDTO){
			   				//alert(questionDTO.qNum +"," + questionDTO.answerList) 
								str += "<tr>"
								str += "<td>"+ questionDTO.qNum +"</td>"
								str += "<td>"+ questionDTO.userId +"</td>"
								str += "<td>"+ questionDTO.qField +"</td>"
								if(questionDTO.qShowstatus == '0'){
									if(sessionId == "203448231" || sessionId == questionDTO.userId){
										str += "<td><a href='front?key=question&methodName=selectByQuestionNum&qNum="+questionDTO.qNum+"&prodId="+questionDTO.prodId+"'>" + questionDTO.qTitle + "</td>"
										
									}else{
										str += "<td>" + questionDTO.qTitle + "</td>"
									}
								}else{
										str += "<td><a href='front?key=question&methodName=selectByQuestionNum&qNum="+questionDTO.qNum+"&prodId="+questionDTO.prodId+"'>" + questionDTO.qTitle + "</td>"
								}
								str += "<td>"+ questionDTO.qRegdate +"</td>"
								if(questionDTO.qShowstatus == '0'){
									str += "<td id='securityCheck'><img src='images/security.png' width='20' height='20'/></td>"	
								}else{
									str += "<td id='securityCheck'><img src='images/public.svg' width='20' height='20'/></td>"	
								}
								str += "</tr>"
			   					
			   					$.each(questionDTO.answerList, function(index, answerDTO) {
			   					  		
									str += "<tr>"
									str += "<td>" + answerDTO.aNum + "</td>"
									str += "<td>" + answerDTO.aAnsId + "</td>"
									str += "<td>" + questionDTO.qField + " 답변</td>"
									str += "<td><a href='front?key=question&methodName=selectByAnswerNum&aNum="+answerDTO.aNum+"&qNum="+questionDTO.qNum+"'><img src='images/reply.jpeg' width='20' height='20'/>" + questionDTO.qTitle + "</td>"
									str += "<td>" + answerDTO.aRegdate + "</td>"
									if(questionDTO.qShowstatus == '0'){
									str += "<td id='securityCheck'><img src='images/security.png' width='20' height='20'/></td>"	
									}else{
									str += "<td id='securityCheck'><img src='images/public.svg' width='20' height='20'/></td>"	
									}
									str += "</tr>"
									str += "<tr>"
									
								})//end of 2nd each
			   			
			   							
							})//end of 1st each
	   			   			$("#minjoo2").html(str)
	   							
	   			 		}, //성공했을때 함수
	   			 		error: function(err){
	   				 	alert(err+"발생했어요^^")
	   			 		} //오류발생했을때 함수 
				});//ajax끝
	   			 
	   		}); // end of on
	   		 
	   		 
	   		
	 		///////////////////////////////////////////////////
	 			 	
	 			 	jQuery.each(jQuery('textarea[data-autoresize]'), function() { 
	 			 		var offset = this.offsetHeight - this.clientHeight; 
	 			 		var resizeTextarea = function(el) { 
	 			 			jQuery(el).css('height', 'auto').css('height', el.scrollHeight + offset); }; 
	 			 			jQuery(this).on('keyup input', function() { 
	 			 				resizeTextarea(this); }).removeAttr('data-autoresize'); 
	 			 			});
	 		     
	 			 	///////////////////////////////////////////////////
		
	})//end of ready

</script>			 

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
				alert( ${prod.prodPrice} );
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