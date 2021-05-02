package kosta.mvc.request;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class CancelDatas {
   @SerializedName("imp_uid")
   private String imp_uid;
   @SerializedName("merchant_uid")
   private String merchant_uid;
   @SerializedName("amount")
   private BigDecimal amount;
   @SerializedName("reason")
   private String reason;
   @SerializedName("refund_holder")
   private String refund_holder;
   @SerializedName("refund_bank")
   private String refund_bank;
   @SerializedName("refund_account")
   private String refund_account;

   public CancelDatas(String uid, boolean imp_uid_or_not) {
      if (imp_uid_or_not) {
         this.imp_uid = uid;
      } else {
         this.merchant_uid = uid;
      }

   }

   public CancelDatas(String uid, boolean imp_uid_or_not, BigDecimal amount) {
      this(uid, imp_uid_or_not);
      this.amount = amount;
   }

   public CancelDatas(String merchant_uid, String reason) {
      this.merchant_uid = merchant_uid;
      this.reason = reason;
   }

   public String getImp_uid() {
      return imp_uid;
   }

   public void setImp_uid(String imp_uid) {
      this.imp_uid = imp_uid;
   }

   public String getMerchant_uid() {
      return merchant_uid;
   }

   public void setMerchant_uid(String merchant_uid) {
      this.merchant_uid = merchant_uid;
   }

   public BigDecimal getAmount() {
      return amount;
   }

   public void setAmount(BigDecimal amount) {
      this.amount = amount;
   }

   public String getReason() {
      return reason;
   }

   public void setReason(String reason) {
      this.reason = reason;
   }

   public String getRefund_holder() {
      return refund_holder;
   }

   public void setRefund_holder(String refund_holder) {
      this.refund_holder = refund_holder;
   }

   public String getRefund_bank() {
      return refund_bank;
   }

   public void setRefund_bank(String refund_bank) {
      this.refund_bank = refund_bank;
   }

   public String getRefund_account() {
      return refund_account;
   }

   public void setRefund_account(String refund_account) {
      this.refund_account = refund_account;
   }
}