package org.example.twitterAnalog.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String id;
    private String userId;
    private String content;
    private LocalDateTime createdAt;
    private List<String> comments;
    private List<String> likes;
}