package org.example.twitterAnalog.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    private String id;
    private String postId;
    private String userId;
    private String content;
    private LocalDateTime createdAt;
}
