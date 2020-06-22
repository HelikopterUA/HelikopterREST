drop table if exists students;
create table students
(
    id               bigint primary key auto_increment,
    first_name       varchar(50)  not null,
    last_name        varchar(100) not null,
    email            varchar(100) not null,
    student_group_id bigint,
    rating_score     bigint       not null,
    address_id       bigint
);

create table address
(
    address_id bigint primary key auto_increment,
    country    varchar(250) not null,
    city       varchar(250) not null
);

create table student_group
(
    student_group_id   bigint primary key auto_increment,
    student_group_name varchar(20) not null
);

