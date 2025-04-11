package com.fiipractic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    @RestController
    @RequestMapping("/api/users")
    public class UserCtrl{

        private final UserService userService;

        public UserCtrl(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public UserEntity.User createUser(@RequestBody UserEntity.User user) {
            return userService.saveUser(user);
        }

        @GetMapping
        public List<UserEntity.User> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{id}")
        public UserEntity.User getUserById(@PathVariable Long id) {
            return userService.getUserById(id);
        }
    }

}
