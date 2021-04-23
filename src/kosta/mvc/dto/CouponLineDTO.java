package kosta.mvc.dto;


public class CouponLineDTO {
	private int cponUseNum;
	private int cponNum;
	private String userId;
	private int cponUseState;
	private String cponRegDate;
	private String cponEndDate;
	
	private String cponName;
	private double cponDcPrecent;
	
	
	public CouponLineDTO() {}
	
	
	
	public CouponLineDTO(int cponNum, int cponUseState) {
		super();
		this.cponNum = cponNum;
		this.cponUseState = cponUseState;
	}



	public CouponLineDTO(int cponUseNum, int cponNum, String userId, int cponUseState, String cponRegDate,
			String cponEndDate) {
		super();
		this.cponUseNum = cponUseNum;
		this.cponNum = cponNum;
		this.userId = userId;
		this.cponUseState = cponUseState;
		this.cponRegDate = cponRegDate;
		this.cponEndDate = cponEndDate;
	}


	public CouponLineDTO(int cponUseNum, int cponNum, String userId, int cponUseState, String cponRegDate,
			String cponEndDate, String cponName, double cponDcPrecent) {
		super();
		this.cponUseNum = cponUseNum;
		this.cponNum = cponNum;
		this.userId = userId;
		this.cponUseState = cponUseState;
		this.cponRegDate = cponRegDate;
		this.cponEndDate = cponEndDate;
		this.cponName = cponName;
		this.cponDcPrecent = cponDcPrecent;
	}

	public int getCponUseNum() {
		return cponUseNum;
	}

	public void setCponUseNum(int cponUseNum) {
		this.cponUseNum = cponUseNum;
	}

	public int getCponNum() {
		return cponNum;
	}

	public void setCponNum(int cponNum) {
		this.cponNum = cponNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCponUseState() {
		return cponUseState;
	}

	public void setCponUseState(int cponUseState) {
		this.cponUseState = cponUseState;
	}

	public String getCponRegDate() {
		return cponRegDate;
	}

	public void setCponRegDate(String cponRegDate) {
		this.cponRegDate = cponRegDate;
	}

	public String getCponEndDate() {
		return cponEndDate;
	}

	public void setCponEndDate(String cponEndDate) {
		this.cponEndDate = cponEndDate;
	}

	public String getCponName() {
		return cponName;
	}

	public void setCponName(String cponName) {
		this.cponName = cponName;
	}

	public double getCponDcPrecent() {
		return cponDcPrecent;
	}

	public void setCponDcPrecent(double cponDcPrecent) {
		this.cponDcPrecent = cponDcPrecent;
	}
	
	
	
}
