package com.gibuhagae.gibuhagae.post.dao;


import com.gibuhagae.gibuhagae.post.dto.PostDTOList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    int addPost(PostDTOList postDTO);
}
