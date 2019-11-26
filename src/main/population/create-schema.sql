
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcements` (
       `id` integer not null,
        `version` integer not null,
        `addinfo` varchar(255),
        `creationdate` datetime(6),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `banners` (
       `id` integer not null,
        `version` integer not null,
        `banner` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `bronze` varchar(255),
        `bronzereward_amount` double precision,
        `bronzereward_currency` varchar(255),
        `deadline` datetime(6),
        `description` varchar(255),
        `gold` varchar(255),
        `goldreward_amount` double precision,
        `goldreward_currency` varchar(255),
        `silver` varchar(255),
        `silverreward_amount` double precision,
        `silverreward_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial` (
       `id` integer not null,
        `version` integer not null,
        `banner` varchar(255),
        `card` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `company_records` (
       `id` integer not null,
        `version` integer not null,
        `ceoname` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `incorporated` bit,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `web` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `employer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor_record` (
       `id` integer not null,
        `version` integer not null,
        `name` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `job` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `final_mode` bit not null,
        `more_info` varchar(255),
        `reference` varchar(255),
        `salary_amount` double precision,
        `salary_currency` varchar(255),
        `title` varchar(255),
        `employer_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `non_commercial` (
       `id` integer not null,
        `version` integer not null,
        `banner` varchar(255),
        `jingle` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `creationmoment` datetime(6),
        `deadline` datetime(6),
        `description` varchar(255),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `creation_moment` datetime(6),
        `dead_line` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `spamlist` (
       `id` integer not null,
        `version` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `spamlist_spamword` (
       `spamlist_id` integer not null,
        `spamwordslist_id` integer not null
    ) engine=InnoDB;

    create table `spamword` (
       `id` integer not null,
        `version` integer not null,
        `spamword` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );

    alter table `job` 
       add constraint UK_7jmfdvs0b0jx7i33qxgv22h7b unique (`reference`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);
create index IDXcp4664f36sgqsd0ihmirt0w0 on `offer` (`ticker`);

    alter table `offer` 
       add constraint UK_iex7e8fs0fh89yxpcnm1orjkm unique (`ticker`);
create index IDX9ita8hqkxsxlcd2hsrtgslqm0 on `request` (`dead_line`);
create index IDXq4d9sbuyxv92qtwohvgbai27y on `request` (`dead_line`, `ticker`);

    alter table `request` 
       add constraint UK_9mxq3powq8tqctclj0fbi2nih unique (`ticker`);

    alter table `spamlist_spamword` 
       add constraint UK_2p294jdiyi4liuqsm6btfd869 unique (`spamwordslist_id`);
create index IDX2insomc4a40jprju8tmgcvmig on `spamword` (`spamword`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `employer` 
       add constraint FK_na4dfobmeuxkwf6p75abmb2tr 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `job` 
       add constraint `FK3rxjf8uh6fh2u990pe8i2at0e` 
       foreign key (`employer_id`) 
       references `employer` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `spamlist_spamword` 
       add constraint `FK3yymitdjrt0d5uga8pg7curk3` 
       foreign key (`spamwordslist_id`) 
       references `spamword` (`id`);

    alter table `spamlist_spamword` 
       add constraint `FK5jb8ulpt52m5bpmunrt22733b` 
       foreign key (`spamlist_id`) 
       references `spamlist` (`id`);
