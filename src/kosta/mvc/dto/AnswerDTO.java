package kosta.mvc.dto;

public class AnswerDTO {
	private int aNum;
	private int qNum;
	private String aContent;
	private String aAnsId;
	private String aRegdate;
	
	public AnswerDTO() {}
	public AnswerDTO(int aNum, int qNum, String aContent, String aAnsId, String aRegdate) {
		super();
		this.aNum = aNum;
		this.qNum = qNum;
		this.aContent = aContent;
		this.aAnsId = aAnsId;
		this.aRegdate = aRegdate;
	}
	
	public int getaNum() {
		return aNum;
	}
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public String getaAnsId() {
		return aAnsId;
	}
	public void setaAnsId(String aAnsId) {
		this.aAnsId = aAnsId;
	}
	public String getaRegdate() {
		return aRegdate;
	}
	public void setaRegdate(String aRegdate) {
		this.aRegdate = aRegdate;
	}
	
	
	
}
