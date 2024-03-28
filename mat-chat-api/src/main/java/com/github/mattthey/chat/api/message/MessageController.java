package com.github.mattthey.chat.api.message;

import com.github.mattthey.chat.api.message.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PutMapping("/create")
    public void addMessage(
            @RequestBody MessageDto messageDto
    ) {
        messageService.createMessage(messageDto);
    }

    @GetMapping("/{conversationId}")
    public List<MessageDto> getMessagesFromConversation(
            @PathVariable Long conversationId,
            @RequestParam(name = "offset", required = false) Duration duration
    ) {
        return messageService.getMessagesFromConversation(conversationId);
    }
}
