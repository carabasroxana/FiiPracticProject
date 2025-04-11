package com.fiipractic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserProfileController {


    @RestController
    @RequestMapping("/api/profiles")
    public class UserProfileCtrl {

        private final UserService userProfileService;

        public UserProfileCtrl(UserService userProfileService) {
            this.userProfileService = userProfileService;
        }

        @PostMapping
        public UserProfileEntity.UserProfile createProfile(@RequestBody UserProfileEntity.UserProfile userProfile) {
            return userProfileService.createUserProfile(userProfile);
        }

        @GetMapping("/{id}")
        public UserProfileEntity.UserProfile getProfileById(@PathVariable Long id) {
            return userProfileService.getUserProfile(id);
        }

        @GetMapping
        public List<UserProfileEntity.UserProfile> getAllProfiles() {
            return userProfileService.getAllProfiles();
        }

        @PutMapping("/{id}")
        public UserProfileEntity.UserProfile updateProfile(@PathVariable Long id, @RequestBody UserProfileEntity.UserProfile userProfile) {
            userProfile.setId(id);
            return userProfileService.updateUserProfile(userProfile);
        }

        @DeleteMapping("/{id}")
        public void deleteProfile(@PathVariable Long id) {
            userProfileService.deleteUserProfile(id);
        }
    }

}
