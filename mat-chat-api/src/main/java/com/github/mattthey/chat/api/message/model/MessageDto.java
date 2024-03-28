package com.github.mattthey.chat.api.message.model;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record MessageDto(
        Long conversationId,
        Long senderId,
        String body,
        OffsetDateTime createAt
) {
}
