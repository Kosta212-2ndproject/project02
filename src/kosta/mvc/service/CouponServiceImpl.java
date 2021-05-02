package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.CouponLineDAO;
import kosta.mvc.dao.CouponLineDAOImpl;
import kosta.mvc.dto.CouponLineDTO;

public class CouponServiceImpl implements CouponService {
	private CouponLineDAO couponLineDAO = new CouponLineDAOImpl();
	
	@Override
	public List<CouponLineDTO> selectAllCoupons() throws SQLException {

		return couponLineDAO.selectAllCoupons();
	}

	@Override
	public void createCoupon(CouponLineDTO couponDTO) throws SQLException {
		int result = couponLineDAO.createCoupon(couponDTO);
		if(result ==0 ) throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void updateCoupon(CouponLineDTO couponLineDTO) throws SQLException {
		CouponLineDTO coupon = couponLineDAO.selectBycponName(couponLineDTO.getCponName());
		if(coupon.getCponUseState()==1) {
			throw new SQLException("이미 사용한 쿠폰입니다.");
		}
	}

	@Override
	public CouponLineDTO selectBycponName(String cponName) throws SQLException {

		CouponLineDTO couponList = couponLineDAO.selectBycponName(cponName);
		if(couponList==null) {
			throw new SQLException("쿠폰을 검색하지 못했습니다.");		
			}
		
		return couponList;
	}

	@Override
	public CouponLineDTO selectBycponDcPercent(double cponDcPercent) throws SQLException {
		CouponLineDTO couponList = couponLineDAO.selectBycponDcPercent(cponDcPercent);
		if(couponList==null) {
			throw new SQLException("쿠폰을 검색하지 못했습니다.");		
			}
		
		return couponList;
	}

}
