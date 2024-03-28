/* Sequence */
create sequence users_id_seq
    as bigint
    increment by 1
    start with 1 cache 1 no cycle
;

grant usage on sequence users_id_seq to ${mat_chat.appl_user};

/* Table */
create table users
(
    id          bigint          default nextval('users_id_seq'),
    username    varchar(255)    not null,
    password    varchar(255)     not null,
    -- constraints
    constraint users_id_pkey primary key (id)
);
grant select, insert, update on table users to ${mat_chat.appl_user};

/* Indexes */
create unique index users_u1_key on users (username);

/* Comments */
comment on table users is 'Таблица содержит список пользователей и хэш их паролей для сравнения';

comment on column users.id is 'Уникальный идентификатор пользователя';
comment on column users.username is 'Уникальное имя пользователя';
comment on column users.password is 'Хэш пароля пользователя';