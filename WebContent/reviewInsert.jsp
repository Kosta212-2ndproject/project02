<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<SCRIPT language=javascript>
function checkValid() {
    var f = window.document.writeForm;
		
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
</body>
</html>