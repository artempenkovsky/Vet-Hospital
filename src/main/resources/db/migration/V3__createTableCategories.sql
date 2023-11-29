CREATE TABLE public.categories
(
    id   integer      NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);