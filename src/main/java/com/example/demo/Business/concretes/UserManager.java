package com.example.demo.Business.concretes;

import com.example.demo.Business.abstracts.UserService;
import com.example.demo.Core.dataAccess.asbtracts.UserDao;
import com.example.demo.Core.entities.concretes.User;
import com.example.demo.Core.entities.dtos.UserDetailDto;
import com.example.demo.Core.entities.dtos.UserLoginDto;
import com.example.demo.Core.entities.dtos.UserRegisterDto;
import com.example.demo.Core.utilities.results.DataResult;
import com.example.demo.Core.utilities.results.ErrorDataResult;
import com.example.demo.Core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<User> getById(Long id) {
        return new SuccessDataResult<>(this.userDao.getById(id));
    }

    @Override
    public DataResult<User> getByEmail(String mail) {
        return new SuccessDataResult<>(this.userDao.findByMail(mail));
    }

    @Override
    public DataResult<User> getByPasswordAndEmail(String password, String mail) {
        return new SuccessDataResult<>(this.userDao.findByPasswordAndMail(password,mail));
    }

    @Override
    public DataResult<UserRegisterDto> register(UserRegisterDto userRegisterDto) {
        User user = new User();
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setPassword(userRegisterDto.getPassword());
        user.setMail(userRegisterDto.getMail());
        userDao.save(user);
        return new SuccessDataResult<>(userRegisterDto,"Kayıt başarılı");
    }

    @Override
    public DataResult<UserDetailDto> login(UserLoginDto userLoginDto) {
        var result = this.getByPasswordAndEmail(userLoginDto.getPassword(), userLoginDto.getMail()).getData();
        if(result != null){
            var userDetail = new UserDetailDto();
            userDetail.setId(result.getId());
            userDetail.setFirstName(result.getFirstName());
            userDetail.setLastName(result.getLastName());
            userDetail.setMail(result.getMail());
            return new SuccessDataResult<>(userDetail,"Giriş başarılır");
        }
        return new ErrorDataResult<>("Kullanıcı Adı veya şifre başarısız");
    }
}
