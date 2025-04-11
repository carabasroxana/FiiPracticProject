package com.fiipractic;

import jakarta.persistence.*;

public class UserProfileEntity {

    @Entity
    @Table(name = "user_profile")
    public class UserProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String firstName;
        private String lastName;
        private String email;

        // If a one-to-one or many-to-one relationship to User is desired:
        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private UserEntity.User user;

        public UserProfile() {
        }

        public UserProfile(String firstName, String lastName, String email, UserEntity.User user) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.user = user;
        }

        public void setId(Long id) {
            
        }
    }

}
