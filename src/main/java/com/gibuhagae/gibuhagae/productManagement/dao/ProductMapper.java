package com.gibuhagae.gibuhagae.productManagement.dao;

import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import com.gibuhagae.gibuhagae.productManagement.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

    int selectTotalCount(Map<String, String> searchMap);

    List<ProductDTO> selectProductList(SelectCriteria selectCriteria);
}
