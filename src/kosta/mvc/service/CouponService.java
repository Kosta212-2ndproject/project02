package kosta.mvc.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.CouponLineDTO;

public interface CouponService {

	/**
	 * 쿠폰 전체 검색
	 */
	List<CouponLineDTO> selectAllCoupons() throws SQLException;
	
	
	/**
	 * 쿠폰 생성
	 */
	void createCoupon(CouponLineDTO couponDTO) throws SQLException;
	
	/**
	 * 쿠폰 상태 업데이트
	 */
	void updateCoupon(CouponLineDTO couponDTO) throws SQLException;
	
	/**
	 * 쿠폰명으로 검색
	 */
	CouponLineDTO selectBycponName(String cponName) throws SQLException;

	
	/**
	 * 할인율로 쿠폰 검색
	 */
	CouponLineDTO selectBycponDcPercent(double cponDcPercent) throws SQLException;

	
}
