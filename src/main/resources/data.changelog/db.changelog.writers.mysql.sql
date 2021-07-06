-- liquibase.properties formatted sql
-- changeset admin:new table
CREATE TABLE test1
(
    id   INT          NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- changeset admin:filling the table
INSERT INTO test1 (id, name)
VALUES (1, 'name 1'),
       (2, 'name 2');