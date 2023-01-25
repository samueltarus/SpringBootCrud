package com.demo2.demo.service;

import com.demo2.demo.model.User;
import com.demo2.demo.util.ResponseDto;

public interface UserService {

    ResponseDto list();

    ResponseDto save(User user);

    ResponseDto update(Long id, User user);

    ResponseDto delete(Long id);

}
