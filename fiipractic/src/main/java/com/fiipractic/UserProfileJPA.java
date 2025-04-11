package com.fiipractic;

import org.springframework.data.jpa.repository.JpaRepository;
public class UserProfileJPA {


    public interface UserProfileRepository extends JpaRepository <UserProfileEntity.UserProfile, Long> {
    }

}
