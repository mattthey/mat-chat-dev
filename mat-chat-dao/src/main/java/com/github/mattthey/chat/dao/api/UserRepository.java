package com.github.mattthey.chat.dao.api;

import com.github.mattthey.chat.dao.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select * from users where username = :username")
    Optional<User> findByUsername(
            @Param("username") final String username
    );
}
