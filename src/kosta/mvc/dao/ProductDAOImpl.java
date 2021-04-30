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

	ReviewDAO reviewDao = new ReviewDAOImpl();
	
	@Override
	public List<ProductDTO> selectAll(int pageNo, String category, String order, String values) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		String sql = null;
		if (category == null || category.equals("")) {// 전체검색일때
			if (order == null || order.equals("") ) {// 정렬선택이 없을때
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_id desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceHigh")) {// 가격높은순
				sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_price desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceLow")) {// 가격낮은순
				sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_price) a) where rnum <=? and rnum>=?";
			} else if (order.equals("newProduct")) {// 신제품순
				sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_regdate desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyHigh")) {// 재고많은순
				sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_qty desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyLow")) {// 재고적은순
				sql = "select * from (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM product ORDER BY prod_qty) a) where rnum <=? and rnum>=?";
			} 
		}

		else if (category.equals("keyWord")) {// 검색창 검색일때

			if (order == null || order.equals("")) {// 정렬선택이 없을때
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ORDER BY prod_id desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceHigh")) {// 가격높은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ORDER BY prod_price desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceLow")) {// 가격낮은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ORDER BY prod_price) a) where rnum <=? and rnum>=?";
			} else if (order.equals("newProduct")) {// 신제품순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ORDER BY prod_regdate desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyHigh")) {// 재고많은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ORDER BY prod_qty desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyLow")) {// 재고적은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ORDER BY prod_qty) a) where rnum <=? and rnum>=?";
			}
		}

		else if (category.equals("prodNation")) {// 국가검색일때
			if (order == null || order.equals("")) { // 정렬선택이 없을때
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_nation like ? ORDER BY prod_id desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceHigh")) {// 가격높은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_nation like ? ORDER BY prod_price desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceLow")) {// 가격낮은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_nation like ? ORDER BY prod_price) a) where rnum <=? and rnum>=?";
			} else if (order.equals("newProduct")) {// 신제품순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_nation like ? ORDER BY prod_regdate desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyHigh")) {// 재고많은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_nation like ? ORDER BY prod_qty desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyLow")) {// 재고적은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_nation like ? ORDER BY prod_qty) a) where rnum <=? and rnum>=?";
			}
		}

		else if (category.equals("prodType")) {// 타입검색일때
			if (order == null || order.equals("")) { // 정렬선택이 없을때
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_type like ? ORDER BY prod_id desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceHigh")) {// 가격높은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_type like ? ORDER BY prod_price desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceLow")) {// 가격낮은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_type like ? ORDER BY prod_price) a) where rnum <=? and rnum>=?";
			} else if (order.equals("newProduct")) {// 신제품순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_type like ? ORDER BY prod_regdate desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyHigh")) {// 재고많은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_type like ? ORDER BY prod_qty desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyLow")) {// 재고적은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_type like ? ORDER BY prod_qty) a) where rnum <=? and rnum>=?";
			}
		}

		else if (category.equals("prodPrice")) {// 가격검색일때
			if (order == null || order.equals("")) { // 정렬선택이 없을때
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_price between ? and ? ORDER BY prod_id desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceHigh")) {// 가격높은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_price between ? and ? ORDER BY prod_price desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("priceLow")) {// 가격낮은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_price between ? and ? ORDER BY prod_price) a) where rnum <=? and rnum>=?";
			} else if (order.equals("newProduct")) {// 신제품순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_price between ? and ? ORDER BY prod_regdate desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyHigh")) {// 재고많은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_price between ? and ? ORDER BY prod_qty desc) a) where rnum <=? and rnum>=?";
			} else if (order.equals("qtyLow")) {// 재고적은순
				sql = "select * from  (SELECT a.*, ROWNUM rnum FROM (select * from product where prod_price between ? and ? ORDER BY prod_qty) a) where rnum <=? and rnum>=?";
			}
		}

		try {
			int totalCount = getSelectTotalCount(category, values);
			PageCntProduct page = new PageCntProduct();
			page.setPageCnt(totalCount % page.getPagesize() == 0 ? totalCount / page.getPagesize()
					: totalCount / page.getPagesize() + 1);
			page.setPageNo(pageNo);

			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			if (category == null || category.equals("")) {
				ps.setInt(1, pageNo * page.getPagesize());
				ps.setInt(2, (pageNo - 1) * page.getPagesize() + 1);
			}

			else if (category.equals("keyWord")) {
				ps.setString(1, "%" + values + "%");
				ps.setInt(2, pageNo * page.getPagesize());
				ps.setInt(3, (pageNo - 1) * page.getPagesize() + 1);
			} else if (category.equals("prodNation")) {
				ps.setString(1, "%" + values + "%");
				ps.setInt(2, pageNo * page.getPagesize());
				ps.setInt(3, (pageNo - 1) * page.getPagesize() + 1);
			} else if (category.equals("prodType")) {
				ps.setString(1, "%" + values + "%");
				ps.setInt(2, pageNo * page.getPagesize());
				ps.setInt(3, (pageNo - 1) * page.getPagesize() + 1);
			} else if (category.equals("prodPrice")) {
				switch (values) {
				case "cheap":
					ps.setInt(1, 0);
					ps.setInt(2, 50000);
					ps.setInt(3, pageNo * page.getPagesize());
					ps.setInt(4, (pageNo - 1) * page.getPagesize() + 1);
					break;
				case "middle":
					ps.setInt(1, 50000);
					ps.setInt(2, 100000);
					ps.setInt(3, pageNo * page.getPagesize());
					ps.setInt(4, (pageNo - 1) * page.getPagesize() + 1);
					break;
				case "expensive":
					ps.setInt(1, 100000);
					ps.setInt(2, 200000);
					ps.setInt(3, pageNo * page.getPagesize());
					ps.setInt(4, (pageNo - 1) * page.getPagesize() + 1);
					break;
				case "luxury":
					ps.setInt(1, 200000);
					ps.setInt(2, 1000000);
					ps.setInt(3, pageNo * page.getPagesize());
					ps.setInt(4, (pageNo - 1) * page.getPagesize() + 1);
					break;
				}
			}

			System.out.println("sql = " + sql);
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

	/**
	 * 전체 게시물수
	 */
	public int getSelectTotalCount(String category, String values) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;

		if (category == null || category.equals("")) {// 전체상품일때
			sql = "select count(*) from product";
		} else if (category.equals("keyWord")) {// 검색한 상품일때
			sql = "select count(*) from product where prod_name || upper(prod_name_en) || prod_winery || upper(prod_winery_en) || prod_nation like upper(?) ";
		} else if (category.equals("prodNation")) {// 국가로 검색한 상품일때
			sql = "select count(*) from product where prod_nation like ?";
		} else if (category.equals("prodType")) {// 타입으로 검색한 상품일때
			sql = "select count(*) from product where prod_type like ?";
		} else if (category.equals("prodPrice")) {// 가격대로 검색한 상품일때
			sql = "select count(*) from product where prod_price between ? and ?";
		}

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			if (category == null || category.equals("")) {

			} else if (category.equals("keyWord"))
				ps.setString(1, "%" + values + "%");
			else if (category.equals("prodNation"))
				ps.setString(1, "%" + values + "%");
			else if (category.equals("prodType"))
				ps.setString(1, "%" + values + "%");
			else if (category.equals("prodPrice")) {
				switch (values) {
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
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return result;
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

}
