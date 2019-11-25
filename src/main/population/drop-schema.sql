
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `spamlist_spamword` 
       drop 
       foreign key `FK3yymitdjrt0d5uga8pg7curk3`;

    alter table `spamlist_spamword` 
       drop 
       foreign key `FK5jb8ulpt52m5bpmunrt22733b`;

    drop table if exists `administrator`;

    drop table if exists `announcements`;

    drop table if exists `anonymous`;

    drop table if exists `authenticated`;

    drop table if exists `banners`;

    drop table if exists `challenge`;

    drop table if exists `commercial`;

    drop table if exists `company_records`;

    drop table if exists `consumer`;

    drop table if exists `investor_record`;

    drop table if exists `non_commercial`;

    drop table if exists `offer`;

    drop table if exists `provider`;

    drop table if exists `request`;

    drop table if exists `spamlist`;

    drop table if exists `spamlist_spamword`;

    drop table if exists `spamword`;

    drop table if exists `user_account`;

    drop table if exists `hibernate_sequence`;
