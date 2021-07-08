-- liquibase.properties formatted sql changeLogId:ca03bd62-c2fb-411e-88fd-83111a24d37e

--changeset Yhtyyar:1
CREATE TABLE writers
(
    id         INT          NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE regions
(
    id          INT                         NOT NULL AUTO_INCREMENT,
    region_name VARCHAR(100)                NOT NULL UNIQUE,
    writer_id   INT REFERENCES writers (id),
    PRIMARY KEY (id)
);

ALTER TABLE regions
    ADD FOREIGN KEY (writer_id) REFERENCES writers (id);

CREATE TABLE posts
(
    id        INT                         NOT NULL AUTO_INCREMENT,
    content   VARCHAR(255)                NOT NULL,
    created   TIMESTAMP,
    updated   TIMESTAMP,
    writer_id INT REFERENCES writers (id),
    PRIMARY KEY (id)
);

ALTER TABLE posts
    ADD FOREIGN KEY (writer_id) REFERENCES writers (id);
