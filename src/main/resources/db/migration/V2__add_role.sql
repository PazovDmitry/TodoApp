create table task.role
(
    id   int primary key,
    code varchar not null
);

insert into task.role
values
    (1, 'admin'),
    (2, 'user');

create table task.user_role
(
    id      serial primary key,
    user_id int not null
        references task.user (id),
    role_id int not null
        references task.role (id)
);