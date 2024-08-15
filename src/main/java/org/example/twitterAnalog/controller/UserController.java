package org.example.twitterAnalog.controller;

import lombok.AllArgsConstructor;
import org.example.twitterAnalog.enity.User;
import org.example.twitterAnalog.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/{followerId}/follow/{followedId}")
    public void followUser(@PathVariable String followerId, @PathVariable String followedId) {
        userService.followUser(followerId, followedId);
    }

    @PostMapping("/{followerId}/unfollow/{followedId}")
    public void unfollowUser(@PathVariable String followerId, @PathVariable String followedId) {
        userService.unfollowUser(followerId, followedId);
    }

    @GetMapping("/{userId}/followers")
    public List<User> getFollowers(@PathVariable String userId) {
        return userService.getFollowers(userId);
    }
}