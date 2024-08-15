package org.example.twitterAnalog.controller;

import org.example.twitterAnalog.enity.Comment;
import org.example.twitterAnalog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsForPost(@PathVariable String postId) {
        return commentService.getCommentsForPost(postId);
    }
}
