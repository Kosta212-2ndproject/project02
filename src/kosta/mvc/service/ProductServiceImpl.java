package kosta.mvc.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import kosta.mvc.dao.ProductDAO;
import kosta.mvc.dao.ProductDAOImpl;
import kosta.mvc.dao.ReviewDAO;
import kosta.mvc.dao.ReviewDAOImpl;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.dto.ReviewDTO;

public class ProductServiceImpl implements ProductService {
	private ProductDAO prodDAO = new ProductDAOImpl();
	
	@Override
	public List<ProductDTO> selectAll(int pageNo, String category, String order, String values) throws SQLException {
		List<ProductDTO> list = prodDAO.selectAll(pageNo, category, order, values);
		
		return list;
	}
	
	public List<ProductDTO> selectAllByQty() throws SQLException{
		List<ProductDTO> list = prodDAO.selectAllByQty();
		
		return list;
	}
	

	@Override
	public ProductDTO selectByProductDetail(int prodId) throws SQLException {

		ProductDTO prodDTO = prodDAO.selectByProductDetail(prodId);
		if (prodDTO == null) {
			throw new SQLException("정보를 검색하지 못했습니다.");
		}
		return prodDTO;
	}

	@Override
	public void insertProduct(ProductDTO productDTO) throws SQLException {
		int result = prodDAO.insertProduct(productDTO);
		if (result == 0)
			throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void deleteProduct(int prodId) throws SQLException {
		if (prodDAO.deleteProduct(prodId) == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}
	}

	@Override
	public void updateProduct(ProductDTO productDTO) throws SQLException {
		int result = prodDAO.updateProduct(productDTO);
		if (result == 0) {
			throw new SQLException("수정되지 않았습니다.");
		}

	}

}
