package com.github.mattthey.chat.dao.api;

import com.github.mattthey.chat.dao.model.Message;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select m.* from messages m where m.conversation_id = :conversationId")
    List<Message> findMessagesFromConversation(
            @Param("conversationId") Long conversationId
    );
}
