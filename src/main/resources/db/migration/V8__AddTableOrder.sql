CREATE TABLE orders
(
    id              integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    user_id         integer,
    sub_category_id integer,
    date_of_create  DATE,
    status TEXT,
    PRIMARY KEY (id)

);

ALTER TABLE orders
    ADD FOREIGN KEY (user_id) references users(id),
    ADD FOREIGN KEY (sub_category_id) REFERENCES sub_categories(id)


