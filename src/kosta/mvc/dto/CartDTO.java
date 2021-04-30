package kosta.mvc.dto;

public class CartDTO {
	private int cartId;
	private int cartQty;
	private String userId;
	private int prodId;
	
	private String prodImgUrl;
	private String prodName;
	private String prodNameEng;
	private int prodPrice;

	public CartDTO() {}

	public CartDTO(String prodImgUrl, String prodName, String prodNameEng, int prodPrice) {
		super();
		this.prodImgUrl = prodImgUrl;
		this.prodName = prodName;
		this.prodNameEng = prodNameEng;
		this.prodPrice = prodPrice;
	}




	public CartDTO(int cartId, int cartQty, String userId, int prodId) {
		super();
		this.cartId = cartId;
		this.cartQty = cartQty;
		this.userId = userId;
		this.prodId = prodId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
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




	public String getProdImgUrl() {
		return prodImgUrl;
	}




	public void setProdImgUrl(String prodImgUrl) {
		this.prodImgUrl = prodImgUrl;
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




	public int getProdPrice() {
		return prodPrice;
	}




	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
	

}
