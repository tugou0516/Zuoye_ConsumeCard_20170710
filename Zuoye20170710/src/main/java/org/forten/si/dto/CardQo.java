package org.forten.si.dto;

/**
 * Created by student1 on 2017/7/11.
 */
public class CardQo {
    private String customerName;
    private int pageNo;
    private int pageSize;

    public CardQo() {
        this.customerName = "";
        this.pageNo = 1;
        this.pageSize = 2;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CardQo{" +
                "customerName='" + customerName + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
