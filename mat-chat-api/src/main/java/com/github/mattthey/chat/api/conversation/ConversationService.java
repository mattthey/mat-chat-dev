package com.github.mattthey.chat.api.conversation;

import com.github.mattthey.chat.api.auth.model.UserInfoDetails;
import com.github.mattthey.chat.api.conversation.model.ConversationDto;
import com.github.mattthey.chat.api.conversation.model.ConversationUserDto;
import com.github.mattthey.chat.api.conversation.model.converter.ConversationConverter;
import com.github.mattthey.chat.api.conversation.model.converter.ConversationUserConverter;
import com.github.mattthey.chat.dao.api.ConversationRepository;
import com.github.mattthey.chat.dao.api.ConversationUsersRepository;
import com.github.mattthey.chat.dao.api.UserRepository;
import com.github.mattthey.chat.dao.model.ConversationUsers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversationService {

    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;
    private final ConversationUsersRepository conversationUsersRepository;

    public List<ConversationDto> getConversationForUser() {
        final var currentUser = getCurrentUser();
        return conversationRepository.findConversationByUsername(currentUser.getUsername()).stream()
                .map(ConversationConverter::toDto)
                .toList();
    }

    @Transactional
    public void createConversation(
            final ConversationDto conversationDto
    ) {
        final var entity = ConversationConverter.toEntity(conversationDto);
        // какое же убожество
        entity.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
        final var createdConversation = conversationRepository.save(entity);

        final var currentUser = getCurrentUser();
        final var conversationUsers = ConversationUsers.builder()
                .conversationId(createdConversation.getId())
                .userId(currentUser.getId())
                .build();
        conversationUsersRepository.save(conversationUsers);
    }

    @Transactional
    public void addUserToConversation(
            final ConversationUserDto conversationUserDto
    ) {
        // todo check only oner can add user to conversation
        // todo GEG
        final var entity = ConversationUserConverter.toEntity(conversationUserDto);
        final var user = userRepository.findByUsername(conversationUserDto.username()).orElseThrow();
        entity.setUserId(user.getId());
        conversationUsersRepository.save(entity);
    }

    private UserInfoDetails getCurrentUser() {
        final var authentication = SecurityContextHolder.getContext().getAuthentication();
        final var principal = authentication.getPrincipal();
        if (!(principal instanceof UserInfoDetails userInfoDetails)) {
            throw new RuntimeException("Principal must be not null and type ");
        }

        return userInfoDetails;
    }
}
