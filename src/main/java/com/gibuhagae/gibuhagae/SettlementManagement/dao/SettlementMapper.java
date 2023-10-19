package com.gibuhagae.gibuhagae.SettlementManagement.dao;

import com.gibuhagae.gibuhagae.SettlementManagement.dto.CancelAndReturnAndSwapDTO;
import com.gibuhagae.gibuhagae.SettlementManagement.dto.SettlementDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SettlementMapper {

    List<SettlementDTO> selectTotalSalesList();

    List<CancelAndReturnAndSwapDTO> selectCERList();

    List<CancelAndReturnAndSwapDTO> selectSwapList();


    List<SettlementDTO> searchDateAndPayment(String startDate, String endDate);

    List<CancelAndReturnAndSwapDTO> searchCancelAndReturn(String startDate, String endDate);

    List<CancelAndReturnAndSwapDTO> searchSwap(String startDate, String endDate);
}
