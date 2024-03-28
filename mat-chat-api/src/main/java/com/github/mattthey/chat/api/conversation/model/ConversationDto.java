package com.github.mattthey.chat.api.conversation.model;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record ConversationDto(
        Long id,
        String title,
        OffsetDateTime createdAt
) {
}
