CREATE TABLE public.users
(
    id           integer      NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    first_name   varchar(255) NOT NULL,
    second_name  varchar(255) NOT NULL,
    login        varchar(255) NOT NULL,
    password     varchar(255) NOT NULL,
    user_role_id integer,
    PRIMARY KEY (id),
    CONSTRAINT "UK_login_users" UNIQUE (login)
);

CREATE TABLE public.user_roles
(
    id   integer      NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    role varchar(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT "UK_role_user_roles" UNIQUE (role)
);

ALTER TABLE public.users
    ADD CONSTRAINT FK_users_user_roles FOREIGN KEY (user_role_id) references public.user_roles (id);