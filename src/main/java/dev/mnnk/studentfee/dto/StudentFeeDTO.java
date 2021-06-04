package dev.mnnk.studentfee.dto;

import lombok.Data;

@Data
public class StudentFeeDTO {

    private Integer studentId;
    private String feeName;
    private String periodicity;
    private Boolean fineApplicable;
    private Boolean concessionApplicable;
    private Integer paymentPriority;
    private String accountHeads;

}
