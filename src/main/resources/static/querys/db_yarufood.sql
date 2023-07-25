DROP DATABASE IF EXISTS yarufood;
CREATE DATABASE IF NOT EXISTS yarufood;
use yarufood;
CREATE TABLE tb_adress (
    adress_id INT NOT NULL AUTO_INCREMENT,
    city VARCHAR(255),
    complement VARCHAR(255),
    state ENUM('AC','AL','AM','AP','BA','CE','DF','ES','GO','MA','MG','MS','MT','PA','PB','PE','PI','PR','RJ','RN','RO','RR','RS','SC','SE','SP','TO'),
    street VARCHAR(255),
    street_number VARCHAR(255),
    zipcode VARCHAR(255),
    client_cpf VARCHAR(255),
    PRIMARY KEY (adress_id)
) ENGINE=InnoDB;

CREATE TABLE tb_category (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE tb_client (
    cpf VARCHAR(255) NOT NULL,
    ddd VARCHAR(255),
    phone_number VARCHAR(255),
    email VARCHAR(255),
    name VARCHAR(255),
    PRIMARY KEY (cpf)
) ENGINE=InnoDB;

CREATE TABLE tb_client_adress (
    client_adress_id INT NOT NULL AUTO_INCREMENT,
    adress_name VARCHAR(255),
    adress_id INT,
    client_cpf VARCHAR(255),
    PRIMARY KEY (client_adress_id)
) ENGINE=InnoDB;

CREATE TABLE tb_order (
    order_id INT NOT NULL AUTO_INCREMENT,
    date_order DATETIME(6),
    total_price DECIMAL(38,2),
    client_cpf VARCHAR(255),
    PRIMARY KEY (order_id)
) ENGINE=InnoDB;

CREATE TABLE tb_order_product (
    order_product_id INT NOT NULL AUTO_INCREMENT,
    price DECIMAL(38,2),
    quantity INT,
    sold_price DECIMAL(38,2),
    order_id INT,
    product_id INT,
    PRIMARY KEY (order_product_id)
) ENGINE=InnoDB;

CREATE TABLE tb_product (
    product_id INT NOT NULL AUTO_INCREMENT,
    available BIT,
    description VARCHAR(255),
    name VARCHAR(255),
    price DECIMAL(38,2),
    register_date DATETIME(6),
    category_id INT,
    PRIMARY KEY (product_id)
) ENGINE=InnoDB;

ALTER TABLE tb_adress
    ADD CONSTRAINT FKjc6shmldv2w46vf1d24rsvilv
    FOREIGN KEY (client_cpf)
    REFERENCES tb_client (cpf);

ALTER TABLE tb_client_adress
    ADD CONSTRAINT FKglrygctst3tnt4s29kdj82pgl
    FOREIGN KEY (adress_id)
    REFERENCES tb_adress (adress_id);

ALTER TABLE tb_client_adress
    ADD CONSTRAINT FKd6mikf49mnr9vut7odqgq0sl6
    FOREIGN KEY (client_cpf)
    REFERENCES tb_client (cpf);

ALTER TABLE tb_order
    ADD CONSTRAINT FKb1u4v5s5vsy4okkqxcpy5i20c
    FOREIGN KEY (client_cpf)
    REFERENCES tb_client (cpf);

ALTER TABLE tb_order_product
    ADD CONSTRAINT FK40anaevs16kmc2tbh7wc511fq
    FOREIGN KEY (order_id)
    REFERENCES tb_order (order_id);

ALTER TABLE tb_order_product
    ADD CONSTRAINT FKsu03ywlcvyqg5y78qey2q25lc
    FOREIGN KEY (product_id)
    REFERENCES tb_product (product_id);

ALTER TABLE tb_product
    ADD CONSTRAINT FK8i0sq9mfbpsrabrm2pum9fspo
    FOREIGN KEY (category_id)
    REFERENCES tb_category (id);


/*
---------------INSERINDO MASSAS--------------------
*/
#
INSERT INTO yarufood.tb_client (ddd, phone_number, name, cpf, email) VALUES('11','999999999','Felipe','11111111111','felipe@email.com');
INSERT INTO yarufood.tb_client (ddd, phone_number, name, cpf, email) VALUES('11','999999998','Tayane','11111111112','tayane@email.com');
INSERT INTO yarufood.tb_client (ddd, phone_number, name, cpf, email) VALUES('11','999999997','Denise','11111111113','denise@email.com');
INSERT INTO yarufood.tb_client (ddd, phone_number, name, cpf, email) VALUES('11','999999996','Calvin','11111111114','calvin@email.com');
INSERT INTO yarufood.tb_client (ddd, phone_number, name, cpf, email) VALUES('11','999999995','Italo','11111111115','italo@email.com');
INSERT INTO yarufood.tb_client (ddd, phone_number, name, cpf, email) VALUES('11','999999994','Maria','11111111116','maria@email.com');

INSERT
    INTO yarufood.tb_adress(adress_id, zipcode, city, client_cpf, complement, state, street)
    VALUES (null,'1111222','São Paulo','11111111111','apt 001','SP','Augusta');
INSERT
    INTO yarufood.tb_adress(adress_id, zipcode, city, client_cpf, complement, state, street)
    VALUES (null,'1111223','Santos','11111111112','apt 002','SP','Washington Luiz');
INSERT
    INTO yarufood.tb_adress(adress_id, zipcode, city, client_cpf, complement, state, street)
    VALUES (null,'1111224','Santos','11111111113','apt 003','SP','Washington Luiz');
INSERT
    INTO yarufood.tb_adress(adress_id, zipcode, city, client_cpf, complement, state, street)
    VALUES (null,'1111225','São Paulo','11111111114','apt 004','SP','Prainha');
INSERT
    INTO yarufood.tb_adress(adress_id, zipcode, city, client_cpf, complement, state, street)
    VALUES (null,'1111226','São Paulo','11111111115','apt 005','SP','Augusta');
INSERT
    INTO yarufood.tb_adress(adress_id, zipcode, city, client_cpf, complement, state, street)
    VALUES (null,'1111226','São Paulo','11111111116','apt 006','SP','Augusta');



use yarufood;
SHOW TABLES;
DESCRIBE tb_client;
DESCRIBE tb_adress;
DESCRIBE TB_ORDER;