package com.gibuhagae.gibuhagae.post.controller;

import com.gibuhagae.gibuhagae.payment.dto.PaymentDTO;
import com.gibuhagae.gibuhagae.post.dto.PostDTO;
import com.gibuhagae.gibuhagae.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post/regist")
    public ResponseEntity<String> addPost(@RequestBody PostDTO postDTO) {

        postService.addPost(postDTO);

        return ResponseEntity.ok("성공");
    }

}
