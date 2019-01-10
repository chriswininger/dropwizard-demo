--liquibase formatted sql

-- add-chapter-table

--changeset cwininger:library-data-002_add_chapter_table

CREATE TABLE chapters (
  id SERIAL PRIMARY KEY,
  name CHAR (100) NOT NULL,
book_id INTEGER NOT NULL CONSTRAINT chapters_book_id_fk REFERENCES books ON DELETE CASCADE,
  copyright_year INTEGER
);

CREATE INDEX chapters_book_id_idx on chapters(book_id);
