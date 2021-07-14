-- liquibase formatted sql

-- changeset Yhtyyar:1
CREATE TABLE IF NOT EXISTS practice.writers
(
    id         BIGINT AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS practice.regions
(
    id          BIGINT AUTO_INCREMENT,
    region_name VARCHAR(100) DEFAULT NULL,
    writer_id   BIGINT NOT NULL UNIQUE,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS practice.posts
(
    id        BIGINT AUTO_INCREMENT,
    content   TEXT DEFAULT NULL,
    created   TIMESTAMP,
    updated   TIMESTAMP,
    writer_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);




