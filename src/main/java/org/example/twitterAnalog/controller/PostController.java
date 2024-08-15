package org.example.twitterAnalog.controller;

import org.example.twitterAnalog.enity.Comment;
import org.example.twitterAnalog.enity.Post;
import org.example.twitterAnalog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping("/feed/{userId}")
    public List<Post> getFeed(@PathVariable String userId) {
        return postService.getFeed(userId);
    }

    @PostMapping("/{postId}/like/{userId}")
    public Post likePost(@PathVariable String postId, @PathVariable String userId) {
        return postService.likePost(postId, userId);
    }

    @PostMapping("/{postId}/unlike/{userId}")
    public Post unlikePost(@PathVariable String postId, @PathVariable String userId) {
        return postService.unlikePost(postId, userId);
    }

    @PostMapping("/comments/")
    public Comment addComment(@RequestBody Comment comment) {
        return postService.addComment(comment);
    }

    @GetMapping("/comments/{postId}")
    public List<Comment> getCommentsForPost(@PathVariable String postId) {
        return postService.getCommentsForPost(postId);
    }
}
