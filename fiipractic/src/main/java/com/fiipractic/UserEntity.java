package com.fiipractic;

import jakarta.persistence.*;

public class UserEntity {

    public boolean getUserByUsername(String admin) {
        return false;
    }

    public void saveUserEntity(User admin) {

    }

    @Entity
    @Table(name = "users")
    public static class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String password;

        public User() {
        }

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }


        public void setPassword(String encode) {
        }

        public CharSequence getPassword() {
            return null;
        }
    }

}
