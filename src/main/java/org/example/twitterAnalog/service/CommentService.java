package org.example.twitterAnalog.service;

import org.example.twitterAnalog.enity.Comment;
import org.example.twitterAnalog.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForPost(String postId) {
        return commentRepository.findByPostId(postId);
    }
}
