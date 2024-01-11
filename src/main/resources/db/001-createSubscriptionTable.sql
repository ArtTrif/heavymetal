-- liquibase formatted sql
-- changeset a.trifonov:1

create table subscription (
       id uuid PRIMARY KEY,
       name VARCHAR(255),
       count_visits VARCHAR(255),
       price DECIMAL(10,2),
       action_time INT CHECK (action_time >= 0 OR action_time IS NULL)
)