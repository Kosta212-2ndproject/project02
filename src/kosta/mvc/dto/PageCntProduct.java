package kosta.mvc.dto;

public class PageCntProduct {
	private static int pageCnt; //총페이지 수Math.ceil(전체레코드수 /pagesize) 
	public static  int pagesize = 15;// 한 페이지 당 5개 출력물
	public static int pageNo=1;
	public  int blockcount=5;
	
	//String keyField;
	
	public  PageCntProduct() {
		super();
	}

	public PageCntProduct(int pageCnt) {
		super();
		this.pageCnt = pageCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public static int getPagesize() {
		return pagesize;
	}

	public static void setPagesize(int pagesize) {
		PageCntProduct.pagesize = pagesize;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		PageCntProduct.pageNo = pageNo;
	}

	public int getBlockcount() {
		return blockcount;
	}

	public void setBlockcount(int blockcount) {
		this.blockcount = blockcount;
	}

	
}
