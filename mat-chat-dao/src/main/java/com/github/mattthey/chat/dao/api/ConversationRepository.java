package com.github.mattthey.chat.dao.api;

import com.github.mattthey.chat.dao.model.Conversation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {

    @Query("""
            select c.*
            from users u
            join conversation_users cu on u.id = cu.user_id
            join conversations c on c.id = cu.conversation_id
            where u.username = :username
            """)
    List<Conversation> findConversationByUsername(
            @Param("username") final String username
    );
}
