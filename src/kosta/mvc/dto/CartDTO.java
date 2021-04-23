package kosta.mvc.dto;

public class CartDTO {
	private int cartId;
	private int cartQty;
	private String userId;
	private int prodId;
	
	public CartDTO() {}

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
	
	
	

}
