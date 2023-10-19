package com.gibuhagae.gibuhagae.SettlementManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter @Getter @ToString
public class SettlementDTO {
    private int paymentCount;
    private int paymentPrice;
    private int completeDelivery;
    private int searchTotalPrice;
    private int searchTotalCount;
    private int searchDeliveryCount;
//    private Date todayDate;
//    private Date startDate;
//    private Date endDate;

}
