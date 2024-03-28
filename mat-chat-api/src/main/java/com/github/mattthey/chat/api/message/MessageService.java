package com.github.mattthey.chat.api.message;

import com.github.mattthey.chat.api.auth.model.UserInfoDetails;
import com.github.mattthey.chat.api.message.model.MessageDto;
import com.github.mattthey.chat.api.message.model.converter.MessageConverter;
import com.github.mattthey.chat.dao.api.MessageRepository;
import com.github.mattthey.chat.dao.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public void createMessage(
            final MessageDto messageDto
    ) {
        final var principal = (UserInfoDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        final var entity = MessageConverter.toEntity(messageDto);
        entity.setSenderId(principal.getId());
        entity.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        messageRepository.save(entity);
    }

    public List<MessageDto> getMessagesFromConversation(
            final Long conversationId
    ) {
        return messageRepository.findMessagesFromConversation(conversationId).stream()
                // todo уберите это, пожалуйста
                .sorted(Comparator.comparing(Message::getCreatedAt))
                .map(MessageConverter::toDto)
                .toList();
    }

}
