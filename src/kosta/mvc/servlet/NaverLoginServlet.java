package kosta.mvc.servlet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class NaverLoginController
 */
@WebServlet("/callback")
public class NaverLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 네이버 로그인 처리 컨트롤러. 여기서 처리한다!!
		String clientId = "02aCnvQyzJ_ywbAK8xrZ";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "0lBeAhGWLC";//애플리케이션 클라이언트 시크릿값";
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http://localhost:80/naver/callback.jsp", "UTF-8");
		String apiURL;
		
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    
	    String access_token = "";
	    String refresh_token = "";
	    
	    //System.out.println("apiURL="+apiURL);
	    
	    PrintWriter out = response.getWriter();
	    
		if (access_token != null) { // access_token을 잘 받아왔다면
			try {
				String apiurl = "https://openapi.naver.com/v1/nid/me";
				URL url = new URL(apiurl);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				//con.setRequestProperty("Authorization", "header");
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
				System.out.println(responseCode);

				if (responseCode == 200) {
					JSONParser parsing = new JSONParser();
					Object obj = parsing.parse(res.toString());
					JSONObject jsonObj = (JSONObject)obj;
					JSONObject resObj = (JSONObject)jsonObj.get("response");
					
					String naverCode = (String)resObj.get("id");
					String email = (String)resObj.get("email");
					String name = (String)resObj.get("name");
					//String nickName = (String)resObj.get("nickname");
					
					System.out.println(naverCode + email + name);
					out.println(naverCode + email + name);
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
