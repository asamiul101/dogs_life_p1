create table dogs
(
    id int auto_increment PRIMARY KEY,
    name varchar (50) not null,
    age int not null,
    FOREIGN key (id) REFERENCES owners (owner_id)
);