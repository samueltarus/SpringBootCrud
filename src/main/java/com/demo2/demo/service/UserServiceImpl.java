package com.demo2.demo.service;

import com.demo2.demo.model.User;
import com.demo2.demo.repository.UserRepository;
import com.demo2.demo.util.ResponseDto;
import com.demo2.demo.util.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponseService responseService;

    @Override
    public ResponseDto list() {
        try {
            List<User> user =  userRepository.findAll();
            System.out.println(user.toString());
            System.out.println("user.toString()");
                return this.responseService.formulateResponseDto(user, "", HttpStatus.OK.value(), true);
        }
        catch (Exception exception){
            System.out.println("user.toString()");
            return responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        }

    }

    @Override
    public ResponseDto save(User user) {
        try {
            //check if id exist

              User user1=  userRepository.save(user);

                return this.responseService.formulateResponseDto(user1, "Successfully Created User", HttpStatus.OK.value(), true);
        } catch (Exception exception) {

            return this.responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.BAD_REQUEST.value(), false);
        }
    }

    @Override
    public ResponseDto update(Long id, User user) {
        try {
            boolean user1 = userRepository.existsById(id);
            if (user1) {
                User user2 = new User();
                user2.setId(id);
                user2.setEmail(user.getEmail());
                user2.setPassword(user.getPassword());
                user2.setUsername(user.getUsername());
                user2.setIdNumber(user.getIdNumber());
                user2.setPhoneNumber(user.getEmail());
                return this.responseService.formulateResponseDto(userRepository.save(user2), "Successfully Updated User Details", HttpStatus.OK.value(), true);
            }
            return this.responseService.formulateResponseDto(null, "User not found with username :" + user.getUsername() + "", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        } catch (Exception exception) {
            return this.responseService.formulateResponseDto(null, "An Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
        }

    }

    @Override
    public ResponseDto delete(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            if (user != null) {
                userRepository.deleteById(id);
                return this.responseService.formulateResponseDto(null, "User Deleted Successfully", HttpStatus.OK.value(), true);
            }
        } catch (Exception exception) {
            return this.responseService.formulateResponseDto(null, "Found no User with the Id" + id + "", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);

        }
        return this.responseService.formulateResponseDto(null, "n Error Occurred,Contact Admin", HttpStatus.INTERNAL_SERVER_ERROR.value(), false);
    }
}
