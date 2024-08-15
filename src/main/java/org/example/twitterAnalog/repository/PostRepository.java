package org.example.twitterAnalog.repository;

import org.example.twitterAnalog.enity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByUserIdOrderByCreatedAtDesc(String userId);
}
