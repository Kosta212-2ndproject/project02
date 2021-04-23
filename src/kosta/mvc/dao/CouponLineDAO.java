package kosta.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dto.CouponLineDTO;

public interface CouponLineDAO {


	/**
	 * 쿠폰 전체 검색
	 * @return
	 * @throws SQLException
	 */
	List<CouponLineDTO> selectAllCoupons() throws SQLException;
	
	/**
	 * 쿠폰 생성
	 * @param couponDTO
	 * @return
	 * @throws SQLException
	 */
	int createCoupon(CouponLineDTO couponDTO) throws SQLException;
	
	/**
	 * 쿠폰 상태 업데이트
	 * 0 -사용, 1-미사용
	 * @param couponDTO
	 * @return
	 * @throws SQLException
	 */
	int updateCoupon(CouponLineDTO couponDTO) throws SQLException;
	
	/**
	 * 쿠폰명으로 검색
	 * @param cponName
	 * @return
	 * @throws SQLException
	 */
	CouponLineDTO selectBycponName(String cponName) throws SQLException;
	
	/**
	 * 할인율로 쿠폰 검색
	 * @param cponDcPercent
	 * @return
	 * @throws SQLException
	 */
	CouponLineDTO selectBycponDcPercent(double cponDcPercent) throws SQLException;
	
	
}
