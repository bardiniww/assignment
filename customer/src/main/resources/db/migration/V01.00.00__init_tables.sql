create sequence user_sequence;
create sequence account_sequence;
create sequence email_data_sequence;
create sequence phone_data_sequence;

create table public."user" (
                               id bigint primary key not null,
                               date_of_birth timestamp without time zone not null,
                               name character varying(500) not null,
                               password character varying(500) not null
);


create table public.account (
                                id bigint primary key not null,
                                user_id bigint not null,
                                foreign key (user_id) references public."user" (id)
                                    match simple on update no action on delete no action
);
create unique index account_user_id_unique on account using btree (user_id);


create table public.email_data (
                                   id bigint primary key not null,
                                   email character varying(200) not null,
                                   user_id bigint not null,
                                   foreign key (user_id) references public."user" (id)
                                       match simple on update no action on delete no action
);
create index email_data_user_id_idx on email_data using btree (user_id);
create unique index email_data_email_unique on email_data using btree (email);


create table public.phone_data (
                                   id bigint primary key not null,
                                   phone character varying(13) not null,
                                   user_id bigint not null,
                                   foreign key (user_id) references public."user" (id)
                                       match simple on update no action on delete no action
);
create index phone_data_user_id_idx on phone_data using btree (user_id);
create unique index phone_data_phone_unique on phone_data using btree (phone);
