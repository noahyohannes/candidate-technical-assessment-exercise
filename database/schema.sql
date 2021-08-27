BEGIN TRANSACTION;

DROP TABLE IF EXISTS contact;

CREATE TABLE contact (
	contact_id serial primary key,
	first_name varchar(32) NOT NULL,
	last_name varchar(12) NOT NULL
);

INSERT INTO contact (first_name, last_name) VALUES ('John', 'Wayne');
INSERT INTO contact (first_name, last_name) VALUES ('Tony', 'Stark');
INSERT INTO contact (first_name, last_name) VALUES ('Peter', 'Parker');
INSERT INTO contact (first_name, last_name) VALUES ('Bruce', 'Banner');

COMMIT TRANSACTION;



 