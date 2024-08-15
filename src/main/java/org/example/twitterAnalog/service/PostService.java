package org.example.twitterAnalog.service;

import lombok.AllArgsConstructor;
import org.example.twitterAnalog.enity.Comment;
import org.example.twitterAnalog.enity.Post;
import org.example.twitterAnalog.repository.CommentRepository;
import org.example.twitterAnalog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> getFeed(String userId) {
        return postRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public Post likePost(String postId, String userId) {
        Post post = postRepository.findById(postId).orElseThrow();
        if (!post.getLikes().contains(userId)) {
            post.getLikes().add(userId);
            return postRepository.save(post);
        }
        return post;
    }

    public Post unlikePost(String postId, String userId) {
        Post post = postRepository.findById(postId).orElseThrow();
        post.getLikes().remove(userId);
        return postRepository.save(post);
    }

    public Comment addComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForPost(String postId) {
        return commentRepository.findByPostId(postId);
    }
}