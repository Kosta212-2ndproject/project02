package kosta.mvc.dto;

public class QuestionDTO {

	//9개
	private int qNum;
	private String userId;
	private int prodId;
	private String qField;
	private String qTitle;
	private String qContent;
	private String qFiles;
	private String qRegdate;
	private int qShowstatus;
	
	public QuestionDTO() {}
	public QuestionDTO(int qNum, String userId, int prodId, String qField, String qTitle, String qContent,
			String qFiles, String qRegdate, int qShowstatus) {
		super();
		this.qNum = qNum;
		this.userId = userId;
		this.prodId = prodId;
		this.qField = qField;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qFiles = qFiles;
		this.qRegdate = qRegdate;
		this.qShowstatus = qShowstatus;
	}
	
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
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
	public String getqField() {
		return qField;
	}
	public void setqField(String qField) {
		this.qField = qField;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public String getqFiles() {
		return qFiles;
	}
	public void setqFiles(String qFiles) {
		this.qFiles = qFiles;
	}
	public String getqRegdate() {
		return qRegdate;
	}
	public void setqRegdate(String qRegdate) {
		this.qRegdate = qRegdate;
	}
	public int getqShowstatus() {
		return qShowstatus;
	}
	public void setqShowstatus(int qShowstatus) {
		this.qShowstatus = qShowstatus;
	}
	
	
}
