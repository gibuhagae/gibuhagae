package com.gibuhagae.gibuhagae.post.service;

import com.gibuhagae.gibuhagae.post.dao.PostMapper;
import com.gibuhagae.gibuhagae.post.dto.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

    private final PostMapper postMapper;

    public PostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }
    public void addPost(PostDTO postDTO) {

        postMapper.addPost(postDTO);
    }
}
