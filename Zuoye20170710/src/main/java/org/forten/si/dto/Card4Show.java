package org.forten.si.dto;

import org.forten.utils.common.DateUtil;

import java.util.Date;

/**
 * Created by student1 on 2017/7/10.
 */
public class Card4Show {
    private int id;
    private String cardName;
    private int countLes;
    private int countAll;
    private int balance;
    private int price;
    private int customerId;
    private String customerName;
    private String customerGender;
    private String customerTel;
    private Date customerBirthday;
    private Date registTime;
    private String status;

    public Card4Show() {
    }

    public Card4Show(int id, String cardName, int countLes, int countAll, int balance, int price, int customerId, String customerName, String customerGender, String customerTel, Date customerBirthday, Date registTime, String status) {
        this.id = id;
        this.cardName = cardName;
        this.countLes = countLes;
        this.countAll = countAll;
        this.balance = balance;
        this.price = price;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerTel = customerTel;
        this.customerBirthday = customerBirthday;
        this.registTime = registTime;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public String getCustomerBirthdayStr(){
        return DateUtil.convertDateToString(customerBirthday,"yyyy-MM-dd");
    }

    public String getRegistTimeStr(){
        return DateUtil.convertDateToString(registTime,"yyyy-MM-dd");
    }

    public Double getUnitPrice(){
        return (double)balance/ countLes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCountLes() {
        return countLes;
    }

    public void setCountLes(int countLes) {
        this.countLes = countLes;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card4Show card4Show = (Card4Show) o;

        if (id != card4Show.id) return false;
        if (countLes != card4Show.countLes) return false;
        if (countAll != card4Show.countAll) return false;
        if (balance != card4Show.balance) return false;
        if (price != card4Show.price) return false;
        if (customerId != card4Show.customerId) return false;
        if (cardName != null ? !cardName.equals(card4Show.cardName) : card4Show.cardName != null) return false;
        if (customerName != null ? !customerName.equals(card4Show.customerName) : card4Show.customerName != null)
            return false;
        if (customerGender != null ? !customerGender.equals(card4Show.customerGender) : card4Show.customerGender != null)
            return false;
        if (customerTel != null ? !customerTel.equals(card4Show.customerTel) : card4Show.customerTel != null)
            return false;
        if (customerBirthday != null ? !customerBirthday.equals(card4Show.customerBirthday) : card4Show.customerBirthday != null)
            return false;
        if (registTime != null ? !registTime.equals(card4Show.registTime) : card4Show.registTime != null) return false;
        return status != null ? status.equals(card4Show.status) : card4Show.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cardName != null ? cardName.hashCode() : 0);
        result = 31 * result + countLes;
        result = 31 * result + countAll;
        result = 31 * result + balance;
        result = 31 * result + price;
        result = 31 * result + customerId;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerGender != null ? customerGender.hashCode() : 0);
        result = 31 * result + (customerTel != null ? customerTel.hashCode() : 0);
        result = 31 * result + (customerBirthday != null ? customerBirthday.hashCode() : 0);
        result = 31 * result + (registTime != null ? registTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card4Show{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", countLes=" + countLes +
                ", countAll=" + countAll +
                ", balance=" + balance +
                ", price=" + price +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerGender='" + customerGender + '\'' +
                ", customerTel='" + customerTel + '\'' +
                ", customerBirthday=" + customerBirthday +
                ", registTime=" + registTime +
                ", status='" + status + '\'' +
                '}';
    }
}
