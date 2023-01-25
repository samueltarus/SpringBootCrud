package com.demo2.demo.controller;

import com.demo2.demo.model.User;
import com.demo2.demo.service.UserService;
import com.demo2.demo.util.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private ResponseDto getUsers(){
       return  userService.list();
    }
    @PostMapping
    private ResponseDto save(@RequestBody User user){
        return  userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseDto update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
       return userService.delete(id);
    }

}
