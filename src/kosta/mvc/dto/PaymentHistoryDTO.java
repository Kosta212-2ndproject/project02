package kosta.mvc.dto;

public class PaymentHistoryDTO {
   private String impUid;  // 거래 고유번호
   private String merchantUid;   // 주문번호
   private String payStatus;  // 결제상태
   private String cardNumber; // 카드번호
   private String cardName;   // 카드이름
   private String cardQuota;  // 할부 개월수 (0이면 일시불)
   private int payPrice;   // 가격


   // 결제 금액은 주문 테이블에서 join 에서 화면에 뿌려주자.

   public PaymentHistoryDTO() {

   }

   public PaymentHistoryDTO(String impUid, String merchantUid, String payStatus, String cardNumber, String cardName, String cardQuota, int payPrice) {
      this.impUid = impUid;
      this.merchantUid = merchantUid;
      this.payStatus = payStatus;
      this.cardNumber = cardNumber;
      this.cardName = cardName;
      this.cardQuota = cardQuota;
      this.payPrice = payPrice;
   }

   public String getImpUid() {
      return impUid;
   }

   public void setImpUid(String impUid) {
      this.impUid = impUid;
   }

   public String getMerchantUid() {
      return merchantUid;
   }

   public void setMerchantUid(String merchantUid) {
      this.merchantUid = merchantUid;
   }

   public String getPayStatus() {
      return payStatus;
   }

   public void setPayStatus(String payStatus) {
      this.payStatus = payStatus;
   }

   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }

   public String getCardName() {
      return cardName;
   }

   public void setCardName(String cardName) {
      this.cardName = cardName;
   }

   public String getCardQuota() {
      return cardQuota;
   }

   public void setCardQuota(String cardQuota) {
      this.cardQuota = cardQuota;
   }

   public int getPayPrice() {
      return payPrice;
   }

   public void setPayPrice(int payPrice) {
      this.payPrice = payPrice;
   }
}


