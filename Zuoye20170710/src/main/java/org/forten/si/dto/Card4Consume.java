package org.forten.si.dto;

/**
 * Created by student1 on 2017/7/11.
 */
public class Card4Consume {
    private int cardId;
    private int countNum;
    private int sum;
    private String project;

    public Card4Consume() {
    }

    public Card4Consume(int cardId, int countNum, int sum, String project) {
        this.cardId = cardId;
        this.countNum = countNum;
        this.sum = sum;
        this.project = project;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card4Consume that = (Card4Consume) o;

        if (cardId != that.cardId) return false;
        if (countNum != that.countNum) return false;
        if (sum != that.sum) return false;
        return project != null ? project.equals(that.project) : that.project == null;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + countNum;
        result = 31 * result + sum;
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card4Consume{" +
                "cardId=" + cardId +
                ", countNum=" + countNum +
                ", sum=" + sum +
                ", project='" + project + '\'' +
                '}';
    }
}
