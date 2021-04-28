package kosta.mvc.dto;

public class ProductDTO {
	private int prodId;
	private String prodName;
	private String prodNameEng;
	private String prodWinery;
	private String prodWineryEng;
	private String prodVatage;
	private String prodType;
	private String prodNation;
	private String prodAlcohol;
	private String prodSweet;
	private String prodImgUrl;
	private int prodPrice;
	private String prodMach;
	private String prodTaste;
	private String prodDetail;
	private int prodQty;
	private String prodRegdate;
	private int prodState;
	
	//페이지처리
	private int pageCnt;
	
	
	
	public ProductDTO() {}
	
	
	

	public ProductDTO(String prodName, String prodNameEng, String prodWinery, String prodWineryEng, String prodVatage,
			String prodType, String prodNation, String prodAlcohol, String prodSweet, int prodPrice, String prodMach,
			String prodTaste, String prodDetail, int prodQty) {
		super();
		this.prodName = prodName;
		this.prodNameEng = prodNameEng;
		this.prodWinery = prodWinery;
		this.prodWineryEng = prodWineryEng;
		this.prodVatage = prodVatage;
		this.prodType = prodType;
		this.prodNation = prodNation;
		this.prodAlcohol = prodAlcohol;
		this.prodSweet = prodSweet;
		this.prodPrice = prodPrice;
		this.prodMach = prodMach;
		this.prodTaste = prodTaste;
		this.prodDetail = prodDetail;
		this.prodQty = prodQty;
	}









	public ProductDTO(int prodId, String prodName, String prodNameEng, String prodWinery, String prodWineryEng, String prodVatage,
			String prodType, String prodNation, String prodAlcohol, String prodSweet, int prodPrice, String prodMach, String prodTaste, String prodDetail,
			int prodQty) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodNameEng = prodNameEng;
		this.prodWinery = prodWinery;
		this.prodWineryEng = prodWineryEng;
		this.prodVatage = prodVatage;
		this.prodType = prodType;
		this.prodNation = prodNation;
		this.prodAlcohol = prodAlcohol;
		this.prodSweet = prodSweet;
		this.prodPrice = prodPrice;
		this.prodMach = prodMach;
		this.prodTaste = prodTaste;
		this.prodDetail = prodDetail;
		this.prodQty = prodQty;
	}




	public ProductDTO(int prodId, String prodName, String prodNameEng, String prodWinery, String prodWineryEng,
			String prodVatage, String prodType, String prodNation, String prodAlcohol, String prodSweet,
			String prodImgUrl, int prodPrice, String prodMach, String prodTaste, String prodDetail, int prodQty,
			String prodRegdate, int prodState) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodNameEng = prodNameEng;
		this.prodWinery = prodWinery;
		this.prodWineryEng = prodWineryEng;
		this.prodVatage = prodVatage;
		this.prodType = prodType;
		this.prodNation = prodNation;
		this.prodAlcohol = prodAlcohol;
		this.prodSweet = prodSweet;
		this.prodImgUrl = prodImgUrl;
		this.prodPrice = prodPrice;
		this.prodMach = prodMach;
		this.prodTaste = prodTaste;
		this.prodDetail = prodDetail;
		this.prodQty = prodQty;
		this.prodRegdate = prodRegdate;
		this.prodState = prodState;
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


	public String getProdWinery() {
		return prodWinery;
	}


	public void setProdWinery(String prodWinery) {
		this.prodWinery = prodWinery;
	}


	public String getProdWineryEng() {
		return prodWineryEng;
	}


	public void setProdWineryEng(String prodWineryEng) {
		this.prodWineryEng = prodWineryEng;
	}


	public String getProdVatage() {
		return prodVatage;
	}


	public void setProdVatage(String prodVatage) {
		this.prodVatage = prodVatage;
	}


	public String getProdType() {
		return prodType;
	}


	public void setProdType(String prodType) {
		this.prodType = prodType;
	}


	public String getProdNation() {
		return prodNation;
	}


	public void setProdNation(String prodNation) {
		this.prodNation = prodNation;
	}


	public String getProdAlcohol() {
		return prodAlcohol;
	}


	public void setProdAlcohol(String prodAlcohol) {
		this.prodAlcohol = prodAlcohol;
	}


	public String getProdSweet() {
		return prodSweet;
	}


	public void setProdSweet(String prodSweet) {
		this.prodSweet = prodSweet;
	}


	public String getProdImgUrl() {
		return prodImgUrl;
	}


	public void setProdImgUrl(String prodImgUrl) {
		this.prodImgUrl = prodImgUrl;
	}


	public int getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}


	public String getProdMach() {
		return prodMach;
	}


	public void setProdMach(String prodMach) {
		this.prodMach = prodMach;
	}


	public String getProdTaste() {
		return prodTaste;
	}


	public void setProdTaste(String prodTaste) {
		this.prodTaste = prodTaste;
	}


	public String getProdDetail() {
		return prodDetail;
	}


	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}


	public int getProdQty() {
		return prodQty;
	}


	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}


	public String getProdRegdate() {
		return prodRegdate;
	}


	public void setProdRegdate(String prodRegdate) {
		this.prodRegdate = prodRegdate;
	}


	public int getProdState() {
		return prodState;
	}


	public void setProdState(int prodState) {
		this.prodState = prodState;
	}

	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	

	
	
	
	
	
	
}
