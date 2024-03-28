package com.github.mattthey.chat.api.message.model.converter;

import com.github.mattthey.chat.api.message.model.MessageDto;
import com.github.mattthey.chat.dao.model.Message;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class MessageConverter {
    public static Message toEntity(final MessageDto messageDto) {
        return Message.builder()
                .body(messageDto.body())
                .conversationId(messageDto.conversationId())
                .build();
    }

    public static MessageDto toDto(final Message message) {
        return MessageDto.builder()
                .conversationId(message.getConversationId())
                .senderId(message.getSenderId())
                .body(message.getBody())
                .createAt(message.getCreatedAt())
                .build();
    }
}
