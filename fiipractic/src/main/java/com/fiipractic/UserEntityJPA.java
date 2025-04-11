package com.fiipractic;

import org.springframework.data.jpa.repository.JpaRepository;

public class UserEntityJPA {


    public interface UserRepository extends JpaRepository < UserEntity.User, Long> {
        UserEntity.User findByUsername(String username);
    }

}
