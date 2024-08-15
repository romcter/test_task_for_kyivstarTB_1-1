package org.example.twitterAnalog.service;

import org.example.twitterAnalog.enity.Post;
import org.example.twitterAnalog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
//import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ActiveProfiles("test")
//@Testcontainers
public class PostServiceIntegrationTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void testCreatePost() {
        Post post = new Post();
        post.setUserId("user1");
        post.setContent("Test post.");
        post.setCreatedAt(LocalDateTime.now());

        Post savedPost = postRepository.save(post);
        assertNotNull(savedPost.getId());
    }
}
