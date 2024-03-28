package com.github.mattthey.chat.dao.api;

import com.github.mattthey.chat.dao.model.ConversationUsers;
import org.springframework.data.repository.CrudRepository;

public interface ConversationUsersRepository extends CrudRepository<ConversationUsers, Long> {
}
