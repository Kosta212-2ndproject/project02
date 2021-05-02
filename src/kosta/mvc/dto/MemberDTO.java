package kosta.mvc.dto;

public class MemberDTO {
	private String userId;
	private String userName;
	private String userPw;
	private String userHp;
	private String userZipcode;
	private String userAddr;
	private String userAddrDetail;
	private String userEmail;
	private String userBirth;
	private String userGender;
	private int userState;
	private String userRegDate;
	private int userBuyCount;
	
	public MemberDTO() {}

	public MemberDTO(String userId, String userZipcode, String userAddr, String userAddrDetail) {
		this.userId = userId;
		this.userZipcode = userZipcode;
		this.userAddr = userAddr;
		this.userAddrDetail = userAddrDetail;
	}

	public MemberDTO(String userId, String userName, String userPw, String userHp, String userEmail, String userBirth,
						  String userGender, int userState, String userRegDate, int userBuyCount) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
		this.userHp = userHp;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userGender = userGender;
		this.userState = userState;
		this.userRegDate = userRegDate;
		this.userBuyCount = userBuyCount;
	}
	public MemberDTO(String userId, String userName, String userPw, String userHp, String userZipcode, String userAddr,
			String userAddrDetail, String userEmail, String userBirth, String userGender, int userState,
			String userRegDate, int userBuyCount) {
		this(userId, userName, userPw, userHp, userEmail, userBirth, userGender, userState, userRegDate, userBuyCount);
		this.userZipcode = userZipcode;
		this.userAddr = userAddr;
		this.userAddrDetail = userAddrDetail;

	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserHp() {
		return userHp;
	}
	public void setUserHp(String userHp) {
		this.userHp = userHp;
	}
	public String getUserZipcode() {
		return userZipcode;
	}
	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserAddrDetail() {
		return userAddrDetail;
	}
	public void setUserAddrDetail(String userAddrDetail) {
		this.userAddrDetail = userAddrDetail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public String getUserRegDate() {
		return userRegDate;
	}
	public void setUserRegDate(String userRegDate) {
		this.userRegDate = userRegDate;
	}
	public int getUserBuyCount() {
		return userBuyCount;
	}
	public void setUserBuyCount(int userBuyCount) {
		this.userBuyCount = userBuyCount;
	}
}
