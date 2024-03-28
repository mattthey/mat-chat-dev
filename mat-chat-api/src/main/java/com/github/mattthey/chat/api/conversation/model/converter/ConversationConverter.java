package com.github.mattthey.chat.api.conversation.model.converter;

import com.github.mattthey.chat.api.conversation.model.ConversationDto;
import com.github.mattthey.chat.dao.model.Conversation;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConversationConverter {
    public static ConversationDto toDto(
            final Conversation conversation
    ) {
        return ConversationDto.builder()
                .id(conversation.getId())
                .title(conversation.getTitle())
                .createdAt(conversation.getCreatedAt())
                .build();
    }

    public static Conversation toEntity(
            final ConversationDto conversationDto
    ) {
        return Conversation.builder()
                .title(conversationDto.title())
                .build();
    }
}
