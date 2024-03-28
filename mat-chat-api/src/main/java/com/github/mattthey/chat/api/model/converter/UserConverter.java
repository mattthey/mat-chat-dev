package com.github.mattthey.chat.api.model.converter;

import com.github.mattthey.chat.api.model.UserDto;
import com.github.mattthey.chat.dao.model.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class UserConverter {
    public static User toEntity(final UserDto userDto) {
        return User.builder()
                .username(userDto.name())
                .password(userDto.password())
                .build();
    }
}
