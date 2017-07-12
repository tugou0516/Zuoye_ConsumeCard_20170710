package org.forten.si.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by student1 on 2017/7/10.
 */
@Entity
@Table(name="card")
public class Card {
    @Id
    private int id;
    @Column
    private String cardName;
    @Column
    private int countLes;
    @Column
    private int countAll;
    @Column
    private int balance;
    @Column
    private int price;
    @Column
    private int customerId;
    @Column
    private String customerName;
    @Column
    private String customerGender;
    @Column
    private String customerTel;
    @Column
    private Date customerBirthday;
    @Column
    private Date registTime;
    @Column
    private String status;

    public Card() {
        this.countLes = this.countAll;
        this.balance = this.price;
        this.customerId = this.id;
        this.registTime = new Date();
        this.status = "初始";
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

    public int getCountAll() {
        return countAll;
    }

    public void setCountAll(int countAll) {
        this.countAll = countAll;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (id != card.id) return false;
        if (countLes != card.countLes) return false;
        if (countAll != card.countAll) return false;
        if (balance != card.balance) return false;
        if (price != card.price) return false;
        if (customerId != card.customerId) return false;
        if (cardName != null ? !cardName.equals(card.cardName) : card.cardName != null) return false;
        if (customerName != null ? !customerName.equals(card.customerName) : card.customerName != null) return false;
        if (customerGender != null ? !customerGender.equals(card.customerGender) : card.customerGender != null)
            return false;
        if (customerTel != null ? !customerTel.equals(card.customerTel) : card.customerTel != null) return false;
        if (customerBirthday != null ? !customerBirthday.equals(card.customerBirthday) : card.customerBirthday != null)
            return false;
        if (registTime != null ? !registTime.equals(card.registTime) : card.registTime != null) return false;
        return status != null ? status.equals(card.status) : card.status == null;
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
        return "Card{" +
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
