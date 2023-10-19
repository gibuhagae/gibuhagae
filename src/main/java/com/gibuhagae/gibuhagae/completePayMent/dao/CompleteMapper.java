package com.gibuhagae.gibuhagae.completePayMent.dao;

import com.gibuhagae.gibuhagae.completePayMent.dto.CompleteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CompleteMapper {
    List<CompleteDTO> selectOrder(Map<String, Integer> map);
}
