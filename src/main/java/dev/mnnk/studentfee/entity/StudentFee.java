package dev.mnnk.studentfee.entity;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "student_fee")
@Entity
public class StudentFee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    private String feeName;
    private String periodicity;
    private Boolean fineApplicable;
    private Boolean concessionApplicable;
    private Integer paymentPriority;
    private String accountHeads;

    public StudentFee() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Boolean getFineApplicable() {
        return fineApplicable;
    }

    public void setFineApplicable(Boolean fineApplicable) {
        this.fineApplicable = fineApplicable;
    }

    public Boolean getConcessionApplicable() {
        return concessionApplicable;
    }

    public void setConcessionApplicable(Boolean concessionApplicable) {
        this.concessionApplicable = concessionApplicable;
    }

    public Integer getPaymentPriority() {
        return paymentPriority;
    }

    public void setPaymentPriority(Integer paymentPriority) {
        this.paymentPriority = paymentPriority;
    }

    public String getAccountHeads() {
        return accountHeads;
    }

    public void setAccountHeads(String accountHeads) {
        this.accountHeads = accountHeads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentFee that = (StudentFee) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(feeName, that.feeName) && Objects.equals(periodicity, that.periodicity) && Objects.equals(fineApplicable, that.fineApplicable) && Objects.equals(concessionApplicable, that.concessionApplicable) && Objects.equals(paymentPriority, that.paymentPriority) && Objects.equals(accountHeads, that.accountHeads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, feeName, periodicity, fineApplicable, concessionApplicable, paymentPriority, accountHeads);
    }

    @Override
    public String toString() {
        return "StudentFee{" +
                "studentId=" + studentId +
                ", feeName='" + feeName + '\'' +
                ", periodicity='" + periodicity + '\'' +
                ", fineApplicable=" + fineApplicable +
                ", concessionApplicable=" + concessionApplicable +
                ", paymentPriority=" + paymentPriority +
                ", accountHeads='" + accountHeads + '\'' +
                '}';
    }
}