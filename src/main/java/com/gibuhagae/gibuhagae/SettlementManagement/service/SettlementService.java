package com.gibuhagae.gibuhagae.SettlementManagement.service;

import com.gibuhagae.gibuhagae.SettlementManagement.dao.SettlementMapper;
import com.gibuhagae.gibuhagae.SettlementManagement.dto.CancelAndReturnAndSwapDTO;
import com.gibuhagae.gibuhagae.SettlementManagement.dto.SettlementDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SettlementService {

    private final SettlementMapper settlementMapper ;

    public SettlementService(SettlementMapper settlementMapper) {
        this.settlementMapper = settlementMapper;
    }


    public List<SettlementDTO> selectTotalSalesList() {

    return settlementMapper.selectTotalSalesList();
    }

    public List<CancelAndReturnAndSwapDTO> selectCERList() {
        return settlementMapper.selectCERList();
    }

    public List<CancelAndReturnAndSwapDTO> selectSwapList() {
        return settlementMapper.selectSwapList();
    }


    public List<SettlementDTO> searchDateAndPayment(String startDate, String endDate) {
        return settlementMapper.searchDateAndPayment(startDate,endDate);
    }

    public List<CancelAndReturnAndSwapDTO> searchCancelAndReturn(String startDate, String endDate) {
        return settlementMapper.searchCancelAndReturn(startDate,endDate);
    }

    public List<CancelAndReturnAndSwapDTO> searchSwap(String startDate, String endDate) {
        return settlementMapper.searchSwap(startDate,endDate);
    }
}
