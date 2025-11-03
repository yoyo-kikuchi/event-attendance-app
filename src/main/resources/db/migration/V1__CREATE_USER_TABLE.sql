/* ===================================
admin_accounts Table
====================================*/

-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS admin_accounts_id_seq;

-- Table Definition
CREATE TABLE "public"."admin_accounts" (
    "id" int8 NOT NULL DEFAULT nextval('admin_accounts_id_seq'::regclass),
    "external_id" bpchar(12) NOT NULL,
    "name" varchar(255),
    "created_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "deleted_at" timestamp,
    PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX index_admin_accounts_on_external_id ON public.admin_accounts USING btree (external_id);

/* ===================================
admin_users Table
====================================*/
-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS admin_users_id_seq;

-- Table Definition
CREATE TABLE "public"."admin_users" (
    "id" int8 NOT NULL DEFAULT nextval('admin_users_id_seq'::regclass),
    "admin_account_id" int8 NOT NULL,
    "external_id" bpchar(16) NOT NULL,
    "email" varchar(255) NOT NULL,
    "encrypted_password" varchar,
    "first_name" varchar NOT NULL,
    "last_name" varchar NOT NULL,
    "reset_password_token" varchar,
    "reset_password_token_exp_at" timestamp,
    "is_admin" bool NOT NULL DEFAULT false,
    "is_root" bool NOT NULL DEFAULT false,
    "created_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "deleted_at" timestamp,
    CONSTRAINT "fk_admin_users_admin_account" FOREIGN KEY ("admin_account_id") REFERENCES "public"."admin_accounts"("id"),
    PRIMARY KEY ("id")
);

CREATE INDEX index_admin_users_on_admin_account_id ON public.admin_users USING btree (admin_account_id);
CREATE UNIQUE INDEX index_admin_users_on_external_id ON public.admin_users USING btree (external_id);
CREATE UNIQUE INDEX index_admin_users_on_reset_password_token ON public.admin_users USING btree (reset_password_token);
CREATE UNIQUE INDEX partial_index_admin_users_on_email ON public.admin_users USING btree (email) WHERE (deleted_at IS NULL);


/* ===================================
events Table
====================================*/
-- Sequence and defined type
CREATE SEQUENCE IF NOT EXISTS events_id_seq;

-- Table Definition
CREATE TABLE "public"."events" (
    "id" int8 NOT NULL DEFAULT nextval('events_id_seq'::regclass),
    "admin_account_id" int8 NOT NULL,
    "external_id" bpchar(16) NOT NULL,
    "name" varchar(255) NOT NULL,
    "description" text NOT NULL,
    "published_at" timestamp NOT NULL,
    "expires_at" timestamp NOT NULL,
    "created_user_id" int8 NOT NULL,
    "created_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_user_id" int8 NOT NULL,
    "updated_at" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "deleted_at" timestamp,
    CONSTRAINT "fk_events_admin_account" FOREIGN KEY ("admin_account_id") REFERENCES "public"."admin_accounts"("id"),
    PRIMARY KEY ("id")
);

CREATE INDEX index_events_on_admin_account_id ON public.events USING btree (admin_account_id);
CREATE INDEX index_events_on_external_id ON public.events USING btree (external_id);
