package com.gibuhagae.gibuhagae.completePayMent.service;

import com.gibuhagae.gibuhagae.completePayMent.dao.CompleteMapper;
import com.gibuhagae.gibuhagae.completePayMent.dto.CompleteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CompleteService {

    private final CompleteMapper completeMapper;

    public CompleteService(CompleteMapper completeMapper) {
        this.completeMapper = completeMapper;
    }
    public List<CompleteDTO> selectOrder(Map<String, Integer> map) {

        List<CompleteDTO> completeDTOList = completeMapper.selectOrder(map);

        return completeDTOList;
    }
}
