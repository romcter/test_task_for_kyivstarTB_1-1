package org.example.twitterAnalog.repository;

import org.example.twitterAnalog.enity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
