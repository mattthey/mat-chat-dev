package com.github.mattthey.chat.api.conversation.model;

import lombok.Builder;

@Builder
public record ConversationUserDto(
        long conversationId,
        String username
) {
}
