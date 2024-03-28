/* Table */
create table data_schema_info
(
    version varchar(64) not null
)
;

grant select on table data_schema_info to ${mat_chat.appl_user};

/* Comments */
comment on table data_schema_info is 'Data schema info table';

comment on column data_schema_info.version is 'Schema version';