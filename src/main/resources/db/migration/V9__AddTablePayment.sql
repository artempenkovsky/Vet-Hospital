CREATE TABLE payments
(
    id              integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    order_id        integer,
    date_of_payment DATE,
    status          TEXT,
    PRIMARY KEY (id)

);

ALTER TABLE payments
    ADD FOREIGN KEY (order_id) references orders (id);


