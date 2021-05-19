CREATE TABLE persons
(
    `id`            varchar(36) NOT NULL,
    `first_name`    varchar(36) NULL,
    `last_name`     varchar(36) NULL,
    `age`           int default null,
    `created_date`  datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_date`  datetime(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    PRIMARY KEY (`id`)
);