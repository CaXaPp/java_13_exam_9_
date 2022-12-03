create table users
(
    id         bigserial PRIMARY KEY,
    name       text,
    login      text,
    password   text,
    email      text,
    enabled    boolean,
    created_by bigint references users (id),
    role       varchar(255)
);

create table tasks
(
    id           bigserial PRIMARY KEY,
    name         text,
    created_time timestamp,
    created_by   bigint references users (id) not null,
    developer_id bigint references users (id),
    status       varchar(255)
);

create table work_logs
(
    id           bigserial PRIMARY KEY,
    created_time timestamp,
    developer_id bigint references users (id),
    time         text,
    task_id      bigint references tasks (id),
    description  text
);

CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO users(name, login, password, email, enabled, created_by, role)
VALUES ('manager', 'manager', crypt('123456', gen_salt('bf')), 'man@mail.ru', true, null, 'MANAGER'),
       ('developer', 'developer', crypt('123456', gen_salt('bf')), 'developer@mail.ru', true, null, 'DEVELOPER'),
       ('senior', 'senior', crypt('123456', gen_salt('bf')), 'senior@mail.ru', true, null, 'DEVELOPER');







