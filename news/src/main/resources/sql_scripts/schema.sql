-- Database: news

-- DROP DATABASE news;

CREATE DATABASE news
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- User: postgres
-- DROP USER postgres;

CREATE USER postgres WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION;

-- SCHEMA: schema_news

-- DROP SCHEMA schema_news ;

CREATE SCHEMA schema_news
    AUTHORIZATION postgres;

-- Table: schema_news.article

-- DROP TABLE schema_news.article;

CREATE TABLE schema_news.article
(
    id uuid NOT NULL,
    title character varying(250) COLLATE pg_catalog."default",
    content text COLLATE pg_catalog."default",
    publish boolean,
    author_id uuid,
    CONSTRAINT article_pkey PRIMARY KEY (id),
    CONSTRAINT fk_author FOREIGN KEY (author_id)
        REFERENCES schema_news.author (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE schema_news.article
    OWNER to postgres;

-- Table: schema_news.author

-- DROP TABLE schema_news.author;

CREATE TABLE schema_news.author
(
    id uuid NOT NULL,
    firstname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    bio character varying(750) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT author_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE schema_news.author
    OWNER to postgres;

-- Table: schema_news.role

-- DROP TABLE schema_news.role;

CREATE TABLE schema_news.role
(
    id uuid NOT NULL,
    rolename character varying(250) COLLATE pg_catalog."default" NOT NULL,
    description character varying(250) COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE schema_news.role
    OWNER to postgres;

-- Table: schema_news.users

-- DROP TABLE schema_news.users;

CREATE TABLE schema_news.users
(
    id uuid NOT NULL,
    email character varying(250) COLLATE pg_catalog."default" NOT NULL,
    usertype character varying(250) COLLATE pg_catalog."default",
    password character varying(250) COLLATE pg_catalog."default",
    author_id uuid,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fk_author FOREIGN KEY (author_id)
        REFERENCES schema_news.author (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE schema_news.users
    OWNER to postgres;

-- Table: schema_news.users_role

-- DROP TABLE schema_news.users_role;

CREATE TABLE schema_news.users_role
(
    role_id uuid,
    users_id uuid,
    CONSTRAINT fk_role FOREIGN KEY (role_id)
        REFERENCES schema_news.role (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_users FOREIGN KEY (users_id)
        REFERENCES schema_news.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE schema_news.users_role
    OWNER to postgres;