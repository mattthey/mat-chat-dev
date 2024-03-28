package com.github.mattthey.chat.api.conversation;

import com.github.mattthey.chat.api.conversation.model.ConversationDto;
import com.github.mattthey.chat.api.conversation.model.ConversationUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conversation")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @GetMapping("/my")
    public List<ConversationDto> getMyConversations() {
        return conversationService.getConversationForUser();
    }

    @PutMapping("/create")
    public void createConversation(@RequestBody ConversationDto conversationDto) {
        conversationService.createConversation(conversationDto);
    }

    @PostMapping("/add-user")
    public void addUserToConversation(@RequestBody ConversationUserDto conversationDto) {
        conversationService.addUserToConversation(conversationDto);
    }
}
