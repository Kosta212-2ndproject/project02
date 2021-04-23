package kosta.mvc.dto;

public class WishDTO {
	private int wishId;
	private String userId;
	private int prodId;
	
	private String prodName;
	
	public WishDTO() {}

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
	
	
	
}
