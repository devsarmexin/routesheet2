create sequence hibernate_sequence start 1 increment 1;
create table route
(
    id                BIGINT PRIMARY KEY ,
    created           timestamp,
    status            VARCHAR(255),
    updated           timestamp,
    departure_point   VARCHAR(2048),
    destination_point VARCHAR(2048),
    distance          SMALLINT,
    route_sheet_id    BIGINT
);
create table route_sheet
(
    id               BIGINT PRIMARY KEY ,
    created          timestamp,
    status           VARCHAR(255),
    updated          timestamp,
    consumption_fact FLOAT,
    consumption_norm FLOAT,
    distance         INTEGER,
    fuel_finish      FLOAT,
    fuel_start       FLOAT,
    fueling          SMALLINT,
    mileage_finish   INTEGER,
    mileage_start    INTEGER,
    saving           FLOAT,
    trip_date        date,
    waybill_number   INTEGER,
    user_id          BIGINT
);
create table user_role
(
    user_id BIGINT,
    roles   varchar(255)
);
create table users
(
    id         BIGINT PRIMARY KEY ,
    created    timestamp,
    status     VARCHAR(255),
    updated    timestamp,
    email      VARCHAR(2048),
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    password   VARCHAR(2048) NOT NULL ,
    username   VARCHAR(255) NOT NULL
);
alter table if exists route
    add constraint route_route_sheet_fk foreign key (route_sheet_id) references route_sheet;
alter table if exists route_sheet
    add constraint route_sheet_user_fk foreign key (user_id) references users;
alter table if exists user_role
    add constraint user_role_user_fk foreign key (user_id) references users;