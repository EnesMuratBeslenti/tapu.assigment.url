package com.example.demo.Core.dataAccess.asbtracts;

import com.example.demo.Core.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findByMail(String mail);
    User findByPasswordAndMail(String password , String mail);

}
