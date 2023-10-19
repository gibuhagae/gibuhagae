package com.gibuhagae.gibuhagae.SettlementManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CancelAndReturnAndSwapDTO {
    private int cancelAndReturnCount;
    private int cancelAndReturnPrice;

    private int swapCount;

    private int searchCancelAndReturnPrice;
    private int searchCancelAndReturnCount;
    private int searchSwapCount;
}
