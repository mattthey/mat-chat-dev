/* Sequence */
create sequence conversations_id_seq
    as bigint
    increment by 1
    start with 1 cache 1 no cycle
;

grant usage on sequence conversations_id_seq to ${mat_chat.appl_user};

/* Table */
create table conversations
(
    id          bigint                          default nextval('conversations_id_seq'),
    title       varchar(255)                    not null,
    created_at  timestamp(6) with time zone     default current_timestamp(6),
    -- constraints
    constraint conversations_id_pkey primary key (id)
);
grant select, insert, update on table users to ${mat_chat.appl_user};

/* Indexes */
create unique index conversations_u1_key on conversations (title);

/* Comments */
comment on table conversations is 'Таблица содержит информацию о списке чатов';

comment on column conversations.id is 'Уникальный идентификатор переписки';
comment on column conversations.title is 'Название переписки';
comment on column conversations.created_at is 'Дата создания переписки';