package com.example.demo.Business.abstracts;

import com.example.demo.Core.entities.concretes.User;
import com.example.demo.Core.entities.dtos.UserDetailDto;
import com.example.demo.Core.entities.dtos.UserLoginDto;
import com.example.demo.Core.entities.dtos.UserRegisterDto;
import com.example.demo.Core.utilities.results.DataResult;

public interface UserService {

    DataResult<User> getById(Long id);
    DataResult<User> getByEmail(String mail);
    DataResult<User> getByPasswordAndEmail(String password,String mail);
    DataResult<UserRegisterDto> register(UserRegisterDto userRegisterDto);
    DataResult<UserDetailDto> login(UserLoginDto userLoginDto);


}
