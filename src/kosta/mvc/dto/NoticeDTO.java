package kosta.mvc.dto;

public class NoticeDTO {

	private int nNum;
	private String nTitle;
	private String nContent;
	private String nImage;
	private String nRegdate;
	private int nViewCount;
	private int nField;
	
	public NoticeDTO() {}
	public NoticeDTO(int nNum, String nTitle, String nContent, String nImage, String nRegdate, int nViewCount,
			int nField) {
		super();
		this.nNum = nNum;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nImage = nImage;
		this.nRegdate = nRegdate;
		this.nViewCount = nViewCount;
		this.nField = nField;
	}
	
	public int getnNum() {
		return nNum;
	}
	public void setnNum(int nNum) {
		this.nNum = nNum;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnImage() {
		return nImage;
	}
	public void setnImage(String nImage) {
		this.nImage = nImage;
	}
	public String getnRegdate() {
		return nRegdate;
	}
	public void setnRegdate(String nRegdate) {
		this.nRegdate = nRegdate;
	}
	public int getnViewCount() {
		return nViewCount;
	}
	public void setnViewCount(int nViewCount) {
		this.nViewCount = nViewCount;
	}
	public int getnField() {
		return nField;
	}
	public void setnField(int nField) {
		this.nField = nField;
	}
	
	
}
