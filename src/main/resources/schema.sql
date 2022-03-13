create schema netology;


create table CUSTOMERS
(
    id int not null auto_increment,
    name varchar(64),
    surname varchar(64),
    age int,
    phone_number char(11) not null,
    PRIMARY KEY (id)
);

insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Andrey' ,'Ivanov' ,25 ,'89017778338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Evgeniy' ,'Sergeev' ,31 ,'89018278338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Sergey' ,'Petrov' ,29 ,'89017776513' );
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Ivan' ,'Petrov' ,30 ,'89517778338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Anton' ,'Semenov' ,54 ,'89007778338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Anatoliy' ,'Azarov' ,27 ,'89017678338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Nikolay' ,'Sidorov' ,41 ,'89018878338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Valeriy' ,'Stasov' ,72 ,'89817778338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Alexey' ,'Genich' ,21 ,'89012278338');
insert into CUSTOMERS(name, surname, age, phone_number) VALUES ('Gennadiy' ,'Jukov' ,22 ,'89017778138');

create table ORDERS
(
    id int not null auto_increment,
    date DATE,
    customer_id int,
    product_name varchar(64),
    amount int check ( amount > -1),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id)
        REFERENCES CUSTOMERS(id)
);

insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-01', 2, 'chips', 3);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 4, 'apple', 15);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 9, 'apple', 10);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-05', 3, 'brad', 18);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-07', 1, 'sugar', 10);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-08', 9, 'sugar', 1);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-08', 7, 'orange', 5);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 9, 'lemon', 3);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 9, 'burger', 7);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 2, 'chips', 2);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 9, 'cola', 77);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 2, 'pepsi', 11);
insert into ORDERS(date, customer_id, product_name, amount) VALUES ('2022-01-03', 4, 'lemon', 10);

