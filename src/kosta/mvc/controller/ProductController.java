package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.service.ProductService;
import kosta.mvc.service.ProductServiceImpl;

/**
 * 상품관리 및 검색 Controller
 */
public class ProductController implements Controller {
	private ProductService prodService = new ProductServiceImpl();

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}

	// 상품검색 (user)
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		String category = request.getParameter("category"); // 값은 prodNation , prodType ,prodPrice,prodKeyword
		String values = request.getParameter("values");// category에 해당하는 값....
		String order = request.getParameter("order");

		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}

		List<ProductDTO> listAll = prodService.selectAll(Integer.parseInt(pageNo), category, order, values);

		request.setAttribute("listAll", listAll);

		request.setAttribute("pageNo", pageNo);
		request.setAttribute("category", category);
		request.setAttribute("values", values);
		request.setAttribute("order", order);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("productAll.jsp");
		return mv;
	}

	/**
	 * 상품전체 검색(admin)
	 */
	public ModelAndView selectAllByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");
		String category = request.getParameter("category"); // 값은 prodNation , prodType ,prodPrice,prodKeyword
		String values = request.getParameter("values");// category에 해당하는 값....
		String order = request.getParameter("order");

		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}

		List<ProductDTO> listAll = prodService.selectAll(Integer.parseInt(pageNo), category, order, values);

		request.setAttribute("listAll", listAll);

		request.setAttribute("pageNo", pageNo);
		request.setAttribute("category", category);
		request.setAttribute("values", values);
		request.setAttribute("order", order);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("productManage.jsp");
		return mv;
	}

	/**
	 * 상품상세 조회(user)
	 */
	public ModelAndView selectByProductDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String prodId = request.getParameter("prodId");

		ProductDTO prod = prodService.selectByProductDetail(Integer.parseInt(prodId));

		request.setAttribute("prod", prod);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("product-single.jsp");
		return mv;
	}

	/**
	 * 상품상세 조회(admin)
	 */
	public ModelAndView selectByProductDetailByAdmin(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String prodId = request.getParameter("prodId");

		ProductDTO prod = prodService.selectByProductDetail(Integer.parseInt(prodId));

		request.setAttribute("prod", prod);
		ModelAndView mv = new ModelAndView();

		mv.setViewName("product-single-admin.jsp");
		return mv;
	}

	/**
	 * 상품 등록
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전송된 데이터 받기 -> dto 만든다.
		String saveDir = request.getServletContext().getRealPath("/save");
		String encoding = "UTF-8";
		int maxSize = 1024 * 1024 * 100; // 100M

		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		String prodName = m.getParameter("prodName");
		String prodNameEng = m.getParameter("prodNameEng");
		String prodWinery = m.getParameter("prodWinery");
		String prodWineryEng = m.getParameter("prodWineryEng");
		String prodVatage = m.getParameter("prodVatage");
		String prodType = m.getParameter("prodType");
		String prodNation = m.getParameter("prodNation");
		String prodAlcohol = m.getParameter("prodAlcohol");
		String prodSweet = m.getParameter("prodSweet");
		String prodPrice = m.getParameter("prodPrice");
		String prodMach = m.getParameter("prodMach");
		String prodTaste = m.getParameter("prodTaste");
		String prodDetail = m.getParameter("prodDetail");
		String prodQty = m.getParameter("prodQty");

		ProductDTO prod = new ProductDTO(prodName, prodNameEng, prodWinery, prodWineryEng, prodVatage, prodType,
				prodNation, prodAlcohol, prodSweet, Integer.parseInt(prodPrice), prodMach, prodTaste, prodDetail,
				Integer.parseInt(prodQty));

		// 파일첨부가 되었다면...
		if (m.getFilesystemName("file") != null) {

			prod.setProdImgUrl(request.getContextPath() + "/save/" + m.getFilesystemName("file"));
		}
		prodService.insertProduct(prod);

		ModelAndView mv = new ModelAndView("front?key=prod&methodName=selectAllByAdmin", true);

		return mv;
	}

	/**
	 * 상품 삭제
	 */
	public ModelAndView deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");

		prodService.deleteProduct(Integer.parseInt(prodId));

		ModelAndView mv = new ModelAndView("front?key=prod&methodName=selectAllByAdmin", true);

		return mv;
	}

	/**
	 * 수정하기 위한 폼
	 */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");

		ProductDTO prod = prodService.selectByProductDetail(Integer.parseInt(prodId));
		request.setAttribute("prod", prod);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-update.jsp");
		return mv;
	}

	/**
	 * 상품 수정
	 */
	public ModelAndView updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		String prodName = request.getParameter("prodName");
		String prodNameEng = request.getParameter("prodNameEng");
		String prodWinery = request.getParameter("prodWinery");
		String prodWineryEng = request.getParameter("prodWineryEng");
		String prodVatage = request.getParameter("prodVatage");
		String prodType = request.getParameter("prodType");
		String prodNation = request.getParameter("prodNation");
		String prodAlcohol = request.getParameter("prodAlcohol");
		String prodSweet = request.getParameter("prodSweet");
		String prodPrice = request.getParameter("prodPrice");
		String prodMach = request.getParameter("prodMach");
		String prodTaste = request.getParameter("prodTaste");
		String prodDetail = request.getParameter("prodDetail");
		String prodQty = request.getParameter("prodQty");

		ProductDTO prod = new ProductDTO(Integer.parseInt(prodId), prodName, prodNameEng, prodWinery, prodWineryEng,
				prodVatage, prodType, prodNation, prodAlcohol, prodSweet, Integer.parseInt(prodPrice), prodMach,
				prodTaste, prodDetail, Integer.parseInt(prodQty));

		prodService.updateProduct(prod);

		prod = prodService.selectByProductDetail(Integer.parseInt(prodId));
		request.setAttribute("prod", prod);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("product-single-admin.jsp");

		return mv;
	}

	@Override
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
