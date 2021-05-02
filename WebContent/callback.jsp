<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>네이버로그인</title>
<script src="js/jquery-3.6.0.min.js"></script>
</head>
  <body>
	<%
			String naverCode = "";
			String name = "";
			String email = "";
			String gender = "";
			String birthday = "";
			String age = "";
			String birthyear = "";
			String mobile = "";
			String birth = "";
	
			String clientId = "02aCnvQyzJ_ywbAK8xrZ";//애플리케이션 클라이언트 아이디값";
			String clientSecret = "0lBeAhGWLC";//애플리케이션 클라이언트 시크릿값";
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			String redirectURI = URLEncoder.encode("http://localhost:8001/callback.jsp", "UTF-8");
			
			String apiURL;
			apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
			apiURL += "client_id=" + clientId;
			apiURL += "&client_secret=" + clientSecret;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
			
			String access_token = "";
			String refresh_token = "";
			System.out.println("apiURL=" + apiURL + "\n");
			
			try {
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				BufferedReader br;
				System.out.print("responseCode=" + responseCode + "\n");
				
				if (responseCode == 200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				
				String inputLine;
				StringBuffer res = new StringBuffer();
				
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				
				br.close();
				
				if (responseCode == 200) {
					System.out.println(res.toString() + "\n");
					JSONParser parsing = new JSONParser();
					Object obj = parsing.parse(res.toString());
					JSONObject jsonObj = (JSONObject)obj;
						        
					access_token = (String)jsonObj.get("access_token");
					refresh_token = (String)jsonObj.get("refresh_token");
					// 여기까지하면 response 리다이렉트하는 페이지에서 토큰값을 볼 수 있음
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			
			if(access_token != null) { // access_token을 잘 받아왔다면
				try {
					String apiurl = "https://openapi.naver.com/v1/nid/me";
					String token = access_token;
					String header = "Bearer " + token;
					URL url = new URL(apiurl);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("Authorization", header);
					int responseCode = con.getResponseCode();
					BufferedReader br;
					
					if (responseCode == 200) { // 정상 호출
						br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					} else { // 에러 발생
						br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					}
					
					String inputLine;
					StringBuffer res = new StringBuffer();
					
					while ((inputLine = br.readLine()) != null) {
						res.append(inputLine);
					}
					
					br.close();
					
					JSONParser parsing = new JSONParser();
					Object obj = parsing.parse(res.toString());
					JSONObject jsonObj = (JSONObject)obj;
					JSONObject resObj = (JSONObject)jsonObj.get("response");
					 
					//왼쪽 변수 이름은 원하는 대로 정하면 된다. 
					//단, 우측의 get()안에 들어가는 값은 와인색 상자 안의 값을 그대로 적어주어야 한다.
					naverCode = (String)resObj.get("id");
					name = (String)resObj.get("name");
					email = (String)resObj.get("email");
					gender = (String)resObj.get("gender");
					birthday = (String)resObj.get("birthday");
					age = (String)resObj.get("age");
					birthyear = (String)resObj.get("birthyear");
					mobile = (String)resObj.get("mobile");
					
					birth = birthyear + "-" + birthday;
					
					System.out.println("naverCode : " + naverCode + "\n");
					System.out.println("name : " + name + "\n");
					System.out.println("email : " + email + "\n");
					System.out.println("gender : " + gender + "\n");
					System.out.println("birthday : " + birthday + "\n");
					System.out.println("age : " + age + "\n");
					System.out.println("birthyear : " + birthyear + "\n");
					System.out.println("mobile : " + mobile + "\n");
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	%>
	
<form action="front" method="post" name="fr">
	<input type="hidden" name="naverCode" value=<%=naverCode %>>
	<input type="hidden" name="name" value="<%=name %>>">
	<input type="hidden" name="email" value="<%=email %>">
	<input type="hidden" name="gender" value="<%=gender %>">
	<input type="hidden" name="birth" value="<%=birth %>">
	<input type="hidden" name="mobile" value="<%=mobile %>">
	<input type="hidden" name="birthyear" value="<%=birthyear %>">
	<input type=hidden name="key" value="member">
	<input type=hidden name="methodName" value="insertMember">
</form>
<script type="text/javascript">
    
    document.fr.submit();

/* 	$(document).ready(function() {
		
		$("#user_form").submit();
		alert(1);
	}); */

</script>
</body>
</html>