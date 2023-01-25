package com.demo2.demo.controller;

import com.demo2.demo.model.Comment;
import com.demo2.demo.service.CommentService;
import com.demo2.demo.util.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    private ResponseDto getPost(){
        return  commentService.list();
    }
    @PostMapping
    private ResponseDto save(@RequestBody Comment comment){
        return  commentService.save(comment);
    }

    @PutMapping("/{id}")
    public ResponseDto update(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        return commentService.delete(id);
    }
}
