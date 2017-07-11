package org.forten.si.dto;

import org.forten.utils.common.DateUtil;

import java.util.Date;

/**
 * Created by student1 on 2017/7/11.
 */
public class ConsumeHis4Show {
    private int id;
    private int cardId;
    private int countNum;
    private int sum;
    private String project;
    private Date consumeTime;

    public ConsumeHis4Show() {
    }

    public ConsumeHis4Show(int id, int cardId, int countNum, int sum, String project, Date consumeTime) {
        this.id = id;
        this.cardId = cardId;
        this.countNum = countNum;
        this.sum = sum;
        this.project = project;
        this.consumeTime = consumeTime;
    }
    public String getConsumeTimeStr(){
        return DateUtil.convertDateToString(consumeTime,"yyyy-MM-dd");
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

        ConsumeHis4Show that = (ConsumeHis4Show) o;

        if (id != that.id) return false;
        if (cardId != that.cardId) return false;
        if (countNum != that.countNum) return false;
        if (sum != that.sum) return false;
        if (project != null ? !project.equals(that.project) : that.project != null) return false;
        return consumeTime != null ? consumeTime.equals(that.consumeTime) : that.consumeTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cardId;
        result = 31 * result + countNum;
        result = 31 * result + sum;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (consumeTime != null ? consumeTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ConsumeHis4Show{" +
                "id=" + id +
                ", cardId=" + cardId +
                ", countNum=" + countNum +
                ", sum=" + sum +
                ", project='" + project + '\'' +
                ", consumeTime=" + consumeTime +
                '}';
    }
}
