-- liquibase formatted sql
-- changeset a.trifonov:0

create table sportsman (
      id uuid PRIMARY KEY,
      name VARCHAR(255),
      surname VARCHAR(255),
      barcode VARCHAR (255)
)