CREATE TABLE prices
(
    id              integer        NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    price           NUMERIC(10, 2) NOT NULL,
    date_of_start   DATE           NOT NULL,
    date_of_end     DATE           NOT NULL,
    active          BOOLEAN        NOT NULL,
    sub_category_id integer        NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE prices
    ADD CONSTRAINT fk_sub_category
        FOREIGN KEY (sub_category_id)
            REFERENCES sub_categories (id);