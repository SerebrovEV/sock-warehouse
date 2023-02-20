-- liquibase formatted sql

--changeset sev:1
create table sock(
    id bigserial primary key,
    color text,
cotton_part int,
number_of_socks int
);


