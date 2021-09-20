package com.example.demo.Controllers;

import com.example.demo.Business.abstracts.UserService;
import com.example.demo.Core.entities.dtos.UserLoginDto;
import com.example.demo.Core.entities.dtos.UserRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto){
        var result = userService.register(userRegisterDto);
        if (result.isSuccess()){
            return  new ResponseEntity<>(result ,HttpStatus.OK);
        }
        return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDto userLoginDto){
        var result = userService.login(userLoginDto);
        if (result.isSuccess()){
            return  new ResponseEntity<>(result ,HttpStatus.OK);
        }
        return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }



}
