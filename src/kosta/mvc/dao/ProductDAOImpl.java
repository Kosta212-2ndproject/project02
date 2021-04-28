package kosta.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.mvc.dto.PageCntProduct;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.util.DbUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public List<ProductDTO> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product order by prod_id desc";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

					list.add(product);
				}
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	//////////// 페이징 처리
	@Override
	public List<ProductDTO> selectAll(int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_id desc) a) where rnum <=? and rnum>=?";

		try {
			// 전체 레코드수 가져오기
			int totalCount = getSelectTotalCount(); // 107개

			PageCntProduct page = new PageCntProduct();
			// 전체 페이지수 구한다. ( EX) 전체게시물수 /한페이지당보여줄게시물수 -> 최종결과 올림
			page.setPageCnt(totalCount % page.getPagesize() == 0 ? totalCount / page.getPagesize()
					: totalCount / page.getPagesize() + 1);
			page.setPageNo(pageNo);

			con = DbUtil.getConnection();
			// 총 레코드수를 가져오기
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageNo * page.getPagesize()); // 3 *5 --> 15
			ps.setInt(2, (pageNo - 1) * page.getPagesize() + 1); // (3-1) *5 + 1 -->11

			// 게시물 가져오기
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

					list.add(product);
				}
			}
		} finally {
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

		String sql = "select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

					list.add(product);
				}
			}
		} finally {
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
		String sql = "select * from product where prod_nation like ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + prodNation + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

					list.add(product);
				}
			}
		} finally {
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
		String sql = "select * from product where prod_type like ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + prodType + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

					list.add(product);
				}
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectByPrice(String prodPrice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = "select * from product where prod_price between ? and ?";
		// String max = "(SELECT MAX(PROD_PRICE)FROM PRODUCT)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			switch (prodPrice) {
			case "cheap":
				ps.setInt(1, 0);
				ps.setInt(2, 50000);
				break;
			case "middle":
				ps.setInt(1, 50000);
				ps.setInt(2, 100000);
				break;
			case "expensive":
				ps.setInt(1, 100000);
				ps.setInt(2, 200000);
				break;
			case "luxury":

				ps.setInt(1, 200000);
				ps.setInt(2, 1000000);
				break;
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getInt(18) != -1) {
					ProductDTO product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

					list.add(product);
				}
			}
		} finally {
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
			if (rs.next()) {
				if (rs.getInt(18) != -1) {
					product = new ProductDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getInt(16), rs.getString(17), rs.getInt(18));

				}
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return product;
	}

	@Override
	public int insertProduct(ProductDTO productDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

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

		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int deleteProduct(int prodId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
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
		int result = 0;
		String sql = "update product set prod_name = ?, prod_name_en = ?, prod_winery = ?, prod_winery_en = ?, "
				+ "prod_vintage = ?, prod_type = ?, prod_nation = ?, prod_alcohol = ?, prod_sweet = ?, "
				+ "prod_price = ?, prod_mach = ?, prod_taste = ?, prod_detail = ?, prod_qty = ? where prod_id = ?";
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
			ps.setInt(10, productDTO.getProdPrice());
			ps.setString(11, productDTO.getProdMach());
			ps.setString(12, productDTO.getProdTaste());
			ps.setString(13, productDTO.getProdDetail());
			ps.setInt(14, productDTO.getProdQty());
			ps.setInt(15, productDTO.getProdId());

			result = ps.executeUpdate();

		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	/**
	 * 전체 게시물수
	 */
	public int getSelectTotalCount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		String sql = "select count(*) from product";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?의 개수만큼 순서대로 값이 설정.

			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return result;
	}
	
	/**
	 * 가격순= P, 인기순-A , 별점순- S 가져오기
	 * */
     public List<ProductDTO> test(String type , String nation, String price ){
    	 String sql="";
    	 if(type.equals("P")) {
    		 sql="????";
    	 }
    	 
    	 return null;
    	 
     }
}



















