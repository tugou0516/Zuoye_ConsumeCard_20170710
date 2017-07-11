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
@Table(name="consumehistory")
public class ConsumeHistory {
    @Id
    private int id;
    @Column
    private int cardId;
    @Column
    private int countNum;
    @Column
    private int sum;
    @Column
    private String project;
    @Column
    private Date consumeTime;

    public ConsumeHistory() {
    }

    public ConsumeHistory(int id, int cardId, int countNum, int sum, String project, Date consumeTime) {
        this.id = id;
        this.cardId = cardId;
        this.countNum = countNum;
        this.sum = sum;
        this.project = project;
        this.consumeTime = consumeTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Date getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Date consumeTime) {
        this.consumeTime = consumeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConsumeHistory that = (ConsumeHistory) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "ConsumeHistory{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", countNum=" + countNum +
                ", sum=" + sum +
                ", project='" + project + '\'' +
                ", consumeTime=" + consumeTime +
                '}';
    }
}
