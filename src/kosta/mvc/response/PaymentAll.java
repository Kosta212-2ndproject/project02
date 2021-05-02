package kosta.mvc.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PaymentAll {
   @SerializedName("total")
   int total;

   @SerializedName("previous")
   int previous;

   @SerializedName("next")
   int next;

   @SerializedName("list")
   List<Payment> list;

   public int getTotal() {
      return total;
   }

   public void setTotal(int total) {
      this.total = total;
   }

   public int getPrevious() {
      return previous;
   }

   public void setPrevious(int previous) {
      this.previous = previous;
   }

   public int getNext() {
      return next;
   }

   public void setNext(int next) {
      this.next = next;
   }

   public List<Payment> getList() {
      return list;
   }

   public void setList(List<Payment> list) {
      this.list = list;
   }
}
