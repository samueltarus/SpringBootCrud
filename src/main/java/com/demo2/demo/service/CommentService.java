package com.demo2.demo.service;

import com.demo2.demo.model.Comment;
import com.demo2.demo.util.ResponseDto;

public interface CommentService {
    ResponseDto list();

    ResponseDto save(Comment comment);

    ResponseDto update(Long id, Comment comment);

    ResponseDto delete(Long id);
}
