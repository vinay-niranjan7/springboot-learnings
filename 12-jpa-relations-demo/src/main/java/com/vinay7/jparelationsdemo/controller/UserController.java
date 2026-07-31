package com.vinay7.jparelationsdemo.controller;



import com.vinay7.jparelationsdemo.model.User;
import com.vinay7.jparelationsdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/test")
    public User addUser(@RequestBody User user,@RequestParam Long profileId) {
        return userService.addUser(user,profileId);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}