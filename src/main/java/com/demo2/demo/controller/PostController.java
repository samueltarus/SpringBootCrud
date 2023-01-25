package com.demo2.demo.controller;

import com.demo2.demo.model.Post;
import com.demo2.demo.service.PostService;
import com.demo2.demo.util.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    private ResponseDto getPost(){
        return  postService.list();
    }
    @PostMapping
    private ResponseDto save(@RequestBody Post post){
        System.out.println("post = " + post);
        return  postService.save(post);
    }

    @PutMapping("/{id}")
    public ResponseDto update(@PathVariable Long id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        return postService.delete(id);
    }
}
