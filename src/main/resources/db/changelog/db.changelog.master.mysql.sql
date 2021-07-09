-- liquibase formatted sql

-- changeset Yhtyyar:1
CREATE TABLE IF NOT EXISTS writers
(
    id         INT          NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS regions
(
    id          INT NOT NULL AUTO_INCREMENT,
    region_name VARCHAR(100) DEFAULT NULL UNIQUE,
    writer_id   INT REFERENCES writers (id),
    PRIMARY KEY (id)
);

ALTER TABLE regions
    ADD FOREIGN KEY (writer_id) REFERENCES writers (id);

CREATE TABLE IF NOT EXISTS posts
(
    id        INT NOT NULL AUTO_INCREMENT,
    content   VARCHAR(255) DEFAULT NULL,
    created   TIMESTAMP,
    updated   TIMESTAMP,
    writer_id INT REFERENCES writers (id),
    PRIMARY KEY (id)
);

ALTER TABLE posts
    ADD FOREIGN KEY (writer_id) REFERENCES writers (id);


