package com.github.mattthey.chat.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("messages")
public class Message {
    @Id
    private long id;
    private long senderId;
    private long conversationId;
    private String body;
    private OffsetDateTime createdAt;
}
