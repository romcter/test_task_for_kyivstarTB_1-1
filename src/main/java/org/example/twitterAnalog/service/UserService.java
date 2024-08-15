package org.example.twitterAnalog.service;

import lombok.AllArgsConstructor;
import org.example.twitterAnalog.enity.User;
import org.example.twitterAnalog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void followUser(String followerId, String followedId) {
        User follower = userRepository.findById(followerId).orElseThrow();
        User followed = userRepository.findById(followedId).orElseThrow();

        if (!follower.getFollowing().contains(followedId)) {
            follower.getFollowing().add(followedId);
            userRepository.save(follower);
        }
    }

    public void unfollowUser(String followerId, String followedId) {
        User follower = userRepository.findById(followerId).orElseThrow();
        follower.getFollowing().remove(followedId);
        userRepository.save(follower);
    }

    public List<User> getFollowers(String userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return userRepository.findAllById(user.getFollowers());
    }
}
