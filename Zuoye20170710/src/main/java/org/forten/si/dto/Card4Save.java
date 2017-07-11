package org.forten.si.dto;

import org.forten.utils.common.DateUtil;

import java.util.Date;

/**
 * Created by student1 on 2017/7/11.
 */
public class Card4Save {
    private String cardName;
    private int countAll;
    private int price;
    private String customerName;
    private String customerGender;
    private String customerTel;
    private Date customerBirthday;

    public Card4Save() {
    }

    public Card4Save(String cardName, int countAll, int price, String customerName, String customerGender, String customerTel, Date customerBirthday) {
        this.cardName = cardName;
        this.countAll = countAll;
        this.price = price;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerTel = customerTel;
        this.customerBirthday = customerBirthday;
    }
    public String getCustomerBirthdayStr(){
        return DateUtil.convertDateToString(customerBirthday,"yyyy-MM-dd");
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCountAll() {
        return countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card4Save card4Save = (Card4Save) o;

        if (countAll != card4Save.countAll) return false;
        if (price != card4Save.price) return false;
        if (cardName != null ? !cardName.equals(card4Save.cardName) : card4Save.cardName != null) return false;
        if (customerName != null ? !customerName.equals(card4Save.customerName) : card4Save.customerName != null)
            return false;
        if (customerGender != null ? !customerGender.equals(card4Save.customerGender) : card4Save.customerGender != null)
            return false;
        if (customerTel != null ? !customerTel.equals(card4Save.customerTel) : card4Save.customerTel != null)
            return false;
        return customerBirthday != null ? customerBirthday.equals(card4Save.customerBirthday) : card4Save.customerBirthday == null;
    }

    @Override
    public int hashCode() {
        int result = cardName != null ? cardName.hashCode() : 0;
        result = 31 * result + countAll;
        result = 31 * result + price;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerGender != null ? customerGender.hashCode() : 0);
        result = 31 * result + (customerTel != null ? customerTel.hashCode() : 0);
        result = 31 * result + (customerBirthday != null ? customerBirthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card4Save{" +
                "cardName='" + cardName + '\'' +
                ", countAll=" + countAll +
                ", price=" + price +
                ", customerName='" + customerName + '\'' +
                ", customerGender='" + customerGender + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerBirthday=" + customerBirthday +
                '}';
    }
}
