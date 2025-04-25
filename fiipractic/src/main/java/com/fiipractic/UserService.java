package com.fiipractic;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserEntityJPA.UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserService(UserEntityJPA.UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity.User saveUser(UserEntity.User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserEntity.User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity.User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity.User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserProfileEntity.UserProfile createUserProfile(UserProfileEntity.UserProfile userProfile) {
        return userProfile;
    }

    public UserProfileEntity.UserProfile getUserProfile(Long id) {
        return null;
    }

    public List<UserProfileEntity.UserProfile> getAllProfiles() {
        return List.of();
    }

    public UserProfileEntity.UserProfile updateUserProfile(UserProfileEntity.UserProfile userProfile) {
        return userProfile;
    }

    public void deleteUserProfile(Long id) {

    }
    @Cacheable(cacheNames = "profiles", key = "#id")
    public UserProfileEntity getProfile(Long id) throws Throwable {
        SimpleJpaRepository repo = null;
        return (UserProfileEntity) repo.findById(id)
                .orElseThrow(() -> new AuthorizationException("…"));
    }
}

