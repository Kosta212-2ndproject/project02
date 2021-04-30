package kosta.mvc.dto;

public class ReviewDTO {

	private int reviewId;
	private int prodId;
	private String userId;
	private int oNum;
	private String reviewTitle;
	private String reviewContent;
	private int reviewStarScope;
	private String reviewRegdate;
	private String reviewImgUrl;
	private int reviewVcount;
	
	public ReviewDTO() {}
	public ReviewDTO(int reviewId, int prodId, String userId, int oNum, String reviewTitle, String reviewContent,
			int reviewStarScope, String reviewRegdate, String reviewImgUrl, int reviewVcount) {
		super();
		this.reviewId = reviewId;
		this.prodId = prodId;
		this.userId = userId;
		this.oNum = oNum;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewStarScope = reviewStarScope;
		this.reviewRegdate = reviewRegdate;
		this.reviewImgUrl = reviewImgUrl;
		this.reviewVcount = reviewVcount;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getoNum() {
		return oNum;
	}
	public void setoNum(int oNum) {
		this.oNum = oNum;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewStarScope() {
		return reviewStarScope;
	}
	public void setReviewStarScope(int reviewStarScope) {
		this.reviewStarScope = reviewStarScope;
	}
	public String getReviewRegdate() {
		return reviewRegdate;
	}
	public void setReviewRegdate(String reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}
	public String getReviewImgUrl() {
		return reviewImgUrl;
	}
	public void setReviewImgUrl(String reviewImgUrl) {
		this.reviewImgUrl = reviewImgUrl;
	}
	public int getReviewVcount() {
		return reviewVcount;
	}
	public void setReviewVcount(int reviewVcount) {
		this.reviewVcount = reviewVcount;
	}
	
	
	
}
