CREATE TABLE public.sub_categories
(
    id           integer      NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    name   varchar(255) NOT NULL,
    description  varchar(255),
    category_id integer,
    PRIMARY KEY (id)
);

ALTER TABLE public.sub_categories
    ADD CONSTRAINT FK_category_subCategory FOREIGN KEY (category_id) references public.categories (id);