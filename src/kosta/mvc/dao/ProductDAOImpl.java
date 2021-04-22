package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.util.DbUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product order by prod_id";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));
					
					list.add(product);	
				}
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectByModelKeyword(String keyword) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product where (prod_name || prod_name_en || prod_winery || prod_winery_en || prod_nation) like ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));
					
					list.add(product);	
				}
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectByNation(String prodNation) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product where prod_nation = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodNation);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));
					
					list.add(product);	
				}
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectByType(String prodType) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product where prod_type = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, prodType);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));
					
					list.add(product);	
				}
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectByPrice(int prodPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product where prod_price = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodPrice);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));
					
					list.add(product);	
				}
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	@Override
	public ProductDTO selectByProductDetail(int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductDTO product = null;
		String sql = "select * from product where prod_id = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodId);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt(18) != -1) {
					product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));
				
				}
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return product;
	}


	@Override
	public int insertProduct(ProductDTO productDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		
		String sql = "insert into product values(prod_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,default)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDTO.getProdName());
			ps.setString(2, productDTO.getProdNameEng());
			ps.setString(3, productDTO.getProdWinery());
			ps.setString(4, productDTO.getProdWineryEng());
			ps.setString(5, productDTO.getProdVatage());
			ps.setString(6, productDTO.getProdType());
			ps.setString(7, productDTO.getProdNation());
			ps.setString(8, productDTO.getProdAlcohol());
			ps.setString(9, productDTO.getProdSweet());
			ps.setString(10, productDTO.getProdImgUrl());
			ps.setInt(11, productDTO.getProdPrice());
			ps.setString(12, productDTO.getProdMach());
			ps.setString(13, productDTO.getProdTaste());
			ps.setString(14, productDTO.getProdDetail());
			ps.setInt(15, productDTO.getProdQty());
			
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int deleteProduct(int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "update product set prod_state = -1 where prod_id = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, prodId);

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int updateProduct(ProductDTO productDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;
		String sql = "update product set prod_name = ?, prod_name_en = ?, prod_winery = ?, prod_winery_en = ?, "
				+ "prod_vintage = ?, prod_type = ?, prod_nation = ?, prod_alcohol = ?, prod_sweet = ?, prod_img_url,"
				+ "prod_price = ?, prod_mach = ?, prod_taste = ?, prod_taste = ?, prod_detail = ?, prod_qty = ?,"
				+ "prod_regdate = sysdate, prod_state = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, productDTO.getProdName());
			ps.setString(2, productDTO.getProdNameEng());
			ps.setString(3, productDTO.getProdWinery());
			ps.setString(4, productDTO.getProdWineryEng());
			ps.setString(5, productDTO.getProdVatage());
			ps.setString(6, productDTO.getProdType());
			ps.setString(7, productDTO.getProdNation());
			ps.setString(8, productDTO.getProdAlcohol());
			ps.setString(9, productDTO.getProdSweet());
			ps.setString(10, productDTO.getProdImgUrl());
			ps.setInt(11, productDTO.getProdPrice());
			ps.setString(12, productDTO.getProdMach());
			ps.setString(13, productDTO.getProdTaste());
			ps.setString(14, productDTO.getProdDetail());
			ps.setInt(15, productDTO.getProdQty());
			ps.setInt(16, productDTO.getProdState());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

}
