package kosta.mvc.dto;

public class OrderLineDTO {
   private int orderLineId;
   private int prodId;
   private int couponUseNum;
   private int orderLineQty;
   private int orderLinePrice;

   public int getOrderLineId() {
      return orderLineId;
   }

   public void setOrderLineId(int orderLineId) {
      this.orderLineId = orderLineId;
   }

   public int getProdId() {
      return prodId;
   }

   public void setProdId(int prodId) {
      this.prodId = prodId;
   }

   public int getCouponUseNum() {
      return couponUseNum;
   }

   public void setCouponUseNum(int couponUseNum) {
      this.couponUseNum = couponUseNum;
   }

   public int getOrderLineQty() {
      return orderLineQty;
   }

   public void setOrderLineQty(int orderLineQty) {
      this.orderLineQty = orderLineQty;
   }

   public int getOrderLinePrice() {
      return orderLinePrice;
   }

   public void setOrderLinePrice(int orderLinePrice) {
      this.orderLinePrice = orderLinePrice;
   }
}
