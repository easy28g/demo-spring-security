insert into usr (id, username, password, email, active)
    values (0, 'admin', 'admin', 'admin@g.com', true);

insert into user_role (user_id, roles)
    values (0, 'ADMIN'), (0, 'USER');