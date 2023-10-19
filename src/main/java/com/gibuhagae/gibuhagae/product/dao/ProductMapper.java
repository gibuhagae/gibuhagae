package com.gibuhagae.gibuhagae.product.dao;

import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    int selectTotalProductCount();

    List<ItemDTO> selectProductList(SelectCriteria selectCriteria);

    ItemDTO selectProductDetail(Long no);

    List<ItemDTO> selectItems();
}
