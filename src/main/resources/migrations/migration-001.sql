--liquibase formatted sql

-- initial-setup

--changeset cwininger:library-data-001_initial_setup

CREATE TABLE authors (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  title CHAR (100) NOT NULL,
  author_id INTEGER NOT NULL CONSTRAINT books_author_id_fk REFERENCES authors,
  copyright_year INTEGER
);

CREATE INDEX books_author_id_idx on books(author_id);