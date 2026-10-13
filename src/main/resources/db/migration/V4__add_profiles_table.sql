create table profiles
(
    id             bigint      not null,
    bio            text        null,
    phone_number   varchar(15) null,
    date_of_birth  date        null,
    loyalty_points int unsigned default 0
);