package com.gibuhagae.gibuhagae.SettlementManagement.controller;
import com.gibuhagae.gibuhagae.SettlementManagement.dto.CancelAndReturnAndSwapDTO;
import com.gibuhagae.gibuhagae.SettlementManagement.dto.SettlementDTO;
import com.gibuhagae.gibuhagae.SettlementManagement.service.SettlementService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/settlementManagement")
public class SettlementController {

    private final SettlementService TotalSaleService;


    public SettlementController(SettlementService TotalSaleService) {
        this.TotalSaleService = TotalSaleService;
    }

    @GetMapping("/settlement")
    public String getTotalSale(Model model) {

        List<SettlementDTO> Payment = TotalSaleService.selectTotalSalesList();
        List<CancelAndReturnAndSwapDTO> CancelAndReturnAndSwap =TotalSaleService.selectCERList();
        List<CancelAndReturnAndSwapDTO> Swap = TotalSaleService.selectSwapList();

        System.out.println("Payment" + Payment);
        System.out.println("CancelAndReturnAndSwap" + CancelAndReturnAndSwap);
        System.out.println("Swap" + Swap);


        model.addAttribute( "todayPayment" , Payment);
        model.addAttribute("CancelAndReturnAndSwap", CancelAndReturnAndSwap);
        model.addAttribute("Swap", Swap);


        return "settlementManagement/settlement";
    }

    @PostMapping("/settlement")
    public ResponseEntity<Map<String, Object>> searchDateAndPayment(@RequestParam("startDate") String startDate,
                                         @RequestParam("endDate") String endDate) {

        List<SettlementDTO> searchDateAndPayment = TotalSaleService.searchDateAndPayment(startDate,endDate);
        List<CancelAndReturnAndSwapDTO> searchCancelAndReturn =TotalSaleService.searchCancelAndReturn(startDate, endDate);
        List<CancelAndReturnAndSwapDTO> searchSwap = TotalSaleService.searchSwap(startDate, endDate);

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("searchDateAndPayment", searchDateAndPayment);
        hashMap.put("searchCancelAndReturn", searchCancelAndReturn);
        hashMap.put("searchSwap", searchSwap);

        System.out.println("searchDateAndPayment" + searchDateAndPayment);
        System.out.println("searchCancelAndReturn" + searchCancelAndReturn);
        System.out.println("searchSwap" + searchSwap);


        return ResponseEntity.ok(hashMap);
    }

}
