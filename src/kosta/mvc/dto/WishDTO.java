package kosta.mvc.dto;

public class WishDTO {
	private int wishId;
	private String userId;
	private int prodId;
	
	private String prodName;
	private String prodNameEng;
	private String prodImgUrl;
	
	public WishDTO() {}
	
	

	public WishDTO(String prodImgUrl, String prodName, String prodNameEng, int prodId) {
		super();
		this.prodImgUrl = prodImgUrl;
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodNameEng = prodNameEng;
		
	}



	public WishDTO(int wishId, String userId, int prodId, String prodName, String prodNameEng, String prodImgUrl) {
		super();
		this.wishId = wishId;
		this.userId = userId;
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodNameEng = prodNameEng;
		this.prodImgUrl = prodImgUrl;
	}



	public WishDTO(int wishId, String userId, int prodId) {
		super();
		this.wishId = wishId;
		this.userId = userId;
		this.prodId = prodId;
	}
	

	public WishDTO(int wishId, String userId, int prodId, String prodName) {
		super();
		this.wishId = wishId;
		this.userId = userId;
		this.prodId = prodId;
		this.prodName = prodName;
	}

	public int getWishId() {
		return wishId;
	}

	public void setWishId(int wishId) {
		this.wishId = wishId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



	public String getProdNameEng() {
		return prodNameEng;
	}



	public void setProdNameEng(String prodNameEng) {
		this.prodNameEng = prodNameEng;
	}



	public String getProdImgUrl() {
		return prodImgUrl;
	}



	public void setProdImgUrl(String prodImgUrl) {
		this.prodImgUrl = prodImgUrl;
	}
	
	
	
}
