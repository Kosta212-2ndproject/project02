package kosta.mvc.dto;

public class OrderDTO {

   private Long orderNo;
   private String userId;
   private String orderDate;
   private int orderPrice;
   private String orderAddr;
   private String orderZipCode;
   private String orderShipNo;
   private String orderRecipientName;
   private int orderDeliveryCharge;
   private int orderStatus;

   public OrderDTO() {

   }

   public OrderDTO(Long orderNo, String userId, String orderDate, int orderPrice, String orderAddr, String orderZipCode, String orderShipNo, String orderRecipientName) {
      this.orderNo = orderNo;
      this.userId = userId;
      this.orderDate = orderDate;
      this.orderPrice = orderPrice;
      this.orderAddr = orderAddr;
      this.orderZipCode = orderZipCode;
      this.orderShipNo = orderShipNo;
      this.orderRecipientName = orderRecipientName;
   }

   public OrderDTO(Long orderNo, String userId, String orderDate, int orderPrice, String orderAddr, String orderZipCode, String orderShipNo, String orderRecipientName, int orderDeliveryCharge, int orderStatus) {
      this(orderNo, userId, orderDate, orderPrice, orderAddr, orderZipCode, orderShipNo, orderRecipientName);
      this.orderDeliveryCharge = orderDeliveryCharge;
      this.orderStatus = orderStatus;
   }

   public Long getOrderNo() {
      return orderNo;
   }

   public void setOrderNo(Long orderNo) {
      this.orderNo = orderNo;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(String orderDate) {
      this.orderDate = orderDate;
   }

   public int getOrderPrice() {
      return orderPrice;
   }

   public void setOrderPrice(int orderPrice) {
      this.orderPrice = orderPrice;
   }

   public String getOrderAddr() {
      return orderAddr;
   }

   public void setOrderAddr(String orderAddr) {
      this.orderAddr = orderAddr;
   }

   public String getOrderZipCode() {
      return orderZipCode;
   }

   public void setOrderZipCode(String orderZipCode) {
      this.orderZipCode = orderZipCode;
   }

   public String getOrderShipNo() {
      return orderShipNo;
   }

   public void setOrderShipNo(String orderShipNo) {
      this.orderShipNo = orderShipNo;
   }

   public String getOrderRecipientName() {
      return orderRecipientName;
   }

   public void setOrderRecipientName(String orderRecipientName) {
      this.orderRecipientName = orderRecipientName;
   }

   public int getOrderDeliveryCharge() {
      return orderDeliveryCharge;
   }

   public void setOrderDeliveryCharge(int orderDeliveryCharge) {
      this.orderDeliveryCharge = orderDeliveryCharge;
   }

   public int getOrderStatus() {
      return orderStatus;
   }

   public void setOrderStatus(int orderStatus) {
      this.orderStatus = orderStatus;
   }
}
