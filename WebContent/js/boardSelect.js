/**
 * BoardSelect for Admin
 */


	$(document).ready(function() {
		//Q&A Board
			$(document).on("click","#v-pills-1-tab", function(){ 
				//alert(11)				
				$.ajax({
	   			 		url:"${path}/boardSelectAll" , // 서버요청주소  
	   			 		type: "post", //method방식 = 전송방식(get, post, put, delete)
	   			 		dataType: "json", //서버가 응답해주는 데이터의 타입(html, text, xml, json 중의 한개)
	   		     		//data: {prodId : "${prod.prodId}" } ,  //서버에게 보낼 parameter정보 
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
								str += "<td><a href='front?key=question&methodName=selectByQuestionNum&qNum="+questionDTO.qNum+"&prodId="+questionDTO.prodId+"'>" + questionDTO.qTitle + "</td>"
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
	   			   			$("#minjooAll").html(str)
	   							
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
