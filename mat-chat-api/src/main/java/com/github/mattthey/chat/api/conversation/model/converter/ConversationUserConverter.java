package com.github.mattthey.chat.api.conversation.model.converter;

import com.github.mattthey.chat.api.conversation.model.ConversationUserDto;
import com.github.mattthey.chat.dao.model.ConversationUsers;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConversationUserConverter {
    public static ConversationUsers toEntity(
            final ConversationUserDto conversationUserDto
    ) {
        return ConversationUsers.builder()
                .conversationId(conversationUserDto.conversationId())
                .build();
    }
}
