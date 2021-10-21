create table task.user
(
    id         serial primary key,
    first_name varchar     not null,
    last_name  varchar     not null,
    email      varchar     not null,
    created_at timestamptz not null default now()
);

create table task.task
(
    id         serial primary key,
    title      varchar     not null,
    text    varchar,
    priority      varchar,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),
    creator_id int         not null
        references task.user (id)
);