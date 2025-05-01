DROP TABLE IF EXISTS PASSENGER;
DROP SEQUENCE IF EXISTS PASSENGER_SEQ;

CREATE SEQUENCE PASSENGER_SEQ 
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
START WITH 1; 

create table passenger (
   id long not null,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   passport_number varchar(10) not null,
   number_of_bags int not null,
   primary key(id)
);

DROP TABLE IF EXISTS BAGGAGE_CLASS;
DROP SEQUENCE IF EXISTS BAGGAGE_CLASS_SEQ;

CREATE SEQUENCE BAGGAGE_CLASS_SEQ 
MINVALUE 1 
MAXVALUE 999999999 
INCREMENT BY 1 
START WITH 1;

create table baggage_class (
   id long not null,
   min_weight NUMERIC(4,2) not null,
   max_weight NUMERIC(4,2) not null,
   fee NUMERIC(4,2) not null,
   baggage_type varchar(20) not null,
   primary key(id)
);