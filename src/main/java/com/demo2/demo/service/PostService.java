package com.demo2.demo.service;

import com.demo2.demo.model.Post;
import com.demo2.demo.util.ResponseDto;

public interface PostService {
    ResponseDto list();

    ResponseDto save(Post post);

    ResponseDto update(Long id, Post post);

    ResponseDto delete(Long id);
}
