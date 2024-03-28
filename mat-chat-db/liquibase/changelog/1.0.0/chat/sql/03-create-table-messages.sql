/* Sequence */
create sequence messages_id_seq
    as bigint
    increment by 1
    start with 1 cache 1 no cycle
;

grant usage on sequence messages_id_seq to ${mat_chat.appl_user};

/* Table */
create table messages
(
    id                  bigint          default nextval('messages_id_seq'),
    conversation_id     bigint          not null,
    sender_id           bigint          not null,
    body                text            not null,
    created_at          timestamp(6)    default current_timestamp,
    -- constraints
    constraint messages_id_pkey primary key (id),
    constraint messages_conversation_fkey foreign key (conversation_id) references conversations (id),
    constraint messages_sender_fkey foreign key (sender_id) references users (id)
);
grant select, insert, update on table users to ${mat_chat.appl_user};

/* Indexes */
create index messages_u1_key on messages (conversation_id);

/* Comments */
comment on table conversations is 'Таблица содержит информацию по чатам';

comment on column messages.id is 'Уникальный идентификатор сообщения';
comment on column messages.conversation_id is 'Идентификатор переписки';
comment on column messages.sender_id is 'Идентификатор отправителя';
comment on column messages.body is 'Тело сообщения';
comment on column messages.created_at is 'Дата получения сервером сообщения';