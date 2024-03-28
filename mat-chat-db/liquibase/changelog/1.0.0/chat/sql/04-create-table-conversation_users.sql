/* Sequence */
create sequence conversation_users_id_seq
    as bigint
    increment by 1
    start with 1 cache 1 no cycle
;
grant usage on sequence conversation_users_id_seq to ${mat_chat.appl_user};

/* Table */
create table conversation_users
(
    id                  bigint          default nextval('conversation_users_id_seq'),
    conversation_id     bigint          not null,
    user_id             bigint          not null,
    -- constraints
    constraint conversation_users_pkey primary key (id),
    constraint conversation_users_conversation_fkey foreign key (conversation_id) references conversations (id),
    constraint conversation_users_user_fkey foreign key (user_id) references users (id)
);
grant select, insert, delete on table conversation_users to ${mat_chat.appl_user};

/* Indexes */
create unique index conversation_users_u1_key on conversation_users (conversation_id, user_id);
create index conversation_users_i1_key on conversation_users (user_id);

/* Comments */
comment on table conversation_users is 'Таблица содержит соответсвие между переписками и участниками переписки';

comment on column conversation_users.conversation_id is 'Идентификатор переписки';
comment on column conversation_users.user_id is 'Идентификатор отправителя';
