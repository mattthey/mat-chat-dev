CREATE SCHEMA IF NOT EXISTS mat_chat_dev AUTHORIZATION mat_chat_dev;

CREATE USER mat_chat_appl_user WITH PASSWORD 'mat_chat_appl_user';
GRANT CONNECT ON DATABASE mat_chat_dev TO mat_chat_appl_user;
GRANT USAGE ON SCHEMA mat_chat_dev TO mat_chat_appl_user;
ALTER USER mat_chat_appl_user SET search_path TO mat_chat_dev;