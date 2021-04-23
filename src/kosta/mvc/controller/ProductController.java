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
 * */
public class ProductController implements Controller {
	private ProductService prodService = new ProductServiceImpl();
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 상품전체 검색
	 * */
	public ModelAndView selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<ProductDTO> listAll = prodService.selectAll();
		request.setAttribute("listAll", listAll);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productAll.jsp");
		return mv;
	}
	
	/**
	 * 상품 키워드 검색
	 * */
	public ModelAndView selectByModelKeyword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyWord = request.getParameter("keyWord");
		
		List<ProductDTO> listKeyWord = prodService.selectByModelKeyword(keyWord);
		
		
		System.out.println("메소드 진입");
		request.setAttribute("listKeyWord", listKeyWord);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productKeyword.jsp");
		return mv;
	}
	
	/**
	 * 나라별 상품 검색
	 * */
	public ModelAndView selectByNation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodNation = request.getParameter("prodNation");
		
		List<ProductDTO> listNation = prodService.selectByNation(prodNation);
		
		request.setAttribute("listNation", listNation);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("productAll.jsp");
		return mv;
	}
	
	/**
	 * 종류별 상품 검색
	 * */
	public ModelAndView selectByType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodType = request.getParameter("prodType");
		
		List<ProductDTO> listPride = prodService.selectByType(prodType);
		
		request.setAttribute("listPride", listPride);
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	/**
	 * 가격별 상품 검색
	 * */
		public ModelAndView selectByPrice(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String prodPrice = request.getParameter("prodPrice");
			
			List<ProductDTO> listPrice = prodService.selectByPrice(Integer.parseInt(prodPrice));
			
			request.setAttribute("listPrice", listPrice);
			ModelAndView mv = new ModelAndView();
			return mv;	
		}
		
	/**
	 * 상품상세 조회
	* */
		public ModelAndView selectByProductDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String prodId = request.getParameter("prodId");
			
			ProductDTO prod = prodService.selectByProductDetail(Integer.parseInt(prodId));
			
			request.setAttribute("prod", prod);
			ModelAndView mv = new ModelAndView();
			mv.setViewName("product-single.jsp");
			return mv;	
		}
		
	/**
	 * 상품 등록
	 * */	
		public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//전송된 데이터 받기 -> dto 만든다.
			String saveDir =request.getServletContext().getRealPath("/save");
			String encoding = "UTF-8";
			int maxSize= 1024*1024*100; //100M
			
			MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			
			String prodId = m.getParameter("prodId");
			String ProdName = m.getParameter("ProdName");
			String ProdNameEng = m.getParameter("ProdNameEng");
			String prodWinery = m.getParameter("prodWinery");
			String prodWineryEng = m.getParameter("prodWineryEng");
			String prodVatage = m.getParameter("prodVatage");
			String prodType = m.getParameter("prodType");
			String prodNation = m.getParameter("prodNation");
			String prodAlcohol = m.getParameter("prodAlcohol");
			String prodSweet = m.getParameter("prodSweet");
			String prodImgUrl = m.getParameter("prodImgUrl");
			String prodPrice = m.getParameter("prodPrice");
			String prodMach = m.getParameter("prodMach");
			String prodTaste = m.getParameter("prodTaste");
			String prodDetail = m.getParameter("prodDetail");
			String prodQty = m.getParameter("prodQty");
			String prodRegdate = m.getParameter("prodRegdate");
			String prodState = m.getParameter("prodState");
			
			ProductDTO prod = new ProductDTO(Integer.parseInt(prodId), ProdName, ProdNameEng, prodWinery, prodWineryEng, prodVatage, prodType, prodNation, prodAlcohol, prodSweet, prodImgUrl, Integer.parseInt(prodPrice), prodMach, prodTaste, prodDetail, Integer.parseInt(prodQty), prodRegdate, Integer.parseInt(prodState));
			
			//파일첨부가 되었다면...
			if(m.getFilesystemName("file")!=null) {
				//첨부된파일이름과 사이즈를 저장
				prod.setProdImgUrl(m.getFilesystemName("file"));
			}
			prodService.insertProduct(prod);
			
			return new ModelAndView("front", true);
		}
		
	/**
	 * 상품 삭제
	 * */
		public ModelAndView deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String prodId = request.getParameter("prodId");
			
			prodService.deleteProduct(Integer.parseInt(prodId));
			
			ModelAndView mv = new ModelAndView("front", true);
			
			return mv;
		}

	@Override
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
		
		
		
	/**
	 * 상품 수정
	 * */
		
		
		
		
		
}
