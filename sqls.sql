create table BATCH_JOB_EXECUTION_SEQ
(
    ID         bigint              not null,
    UNIQUE_KEY char charset utf8_unicode_ci not null,
    constraint UNIQUE_KEY_UN
        unique (UNIQUE_KEY)
);

create table BATCH_JOB_INSTANCE
(
    JOB_INSTANCE_ID bigint                      not null
        primary key,
    VERSION         bigint                      null,
    JOB_NAME        varchar(100) charset utf8_unicode_ci not null,
    JOB_KEY         varchar(32) charset utf8_unicode_ci  not null,
    constraint JOB_INST_UN
        unique (JOB_NAME, JOB_KEY)
);

create table BATCH_JOB_EXECUTION
(
    JOB_EXECUTION_ID           bigint                       not null
        primary key,
    VERSION                    bigint                       null,
    JOB_INSTANCE_ID            bigint                       not null,
    CREATE_TIME                datetime(6)                  not null,
    START_TIME                 datetime(6)                  null,
    END_TIME                   datetime(6)                  null,
    STATUS                     varchar(10) charset utf8_unicode_ci   null,
    EXIT_CODE                  varchar(2500) charset utf8_unicode_ci null,
    EXIT_MESSAGE               varchar(2500) charset utf8_unicode_ci null,
    LAST_UPDATED               datetime(6)                  null,
    JOB_CONFIGURATION_LOCATION varchar(2500) charset utf8_unicode_ci null,
    constraint JOB_INST_EXEC_FK
        foreign key (JOB_INSTANCE_ID) references BATCH_JOB_INSTANCE (JOB_INSTANCE_ID)
);

create table BATCH_JOB_EXECUTION_CONTEXT
(
    JOB_EXECUTION_ID   bigint                       not null
        primary key,
    SHORT_CONTEXT      varchar(2500) charset utf8_unicode_ci not null,
    SERIALIZED_CONTEXT text charset utf8_unicode_ci          null,
    constraint JOB_EXEC_CTX_FK
        foreign key (JOB_EXECUTION_ID) references BATCH_JOB_EXECUTION (JOB_EXECUTION_ID)
);

create table BATCH_JOB_EXECUTION_PARAMS
(
    JOB_EXECUTION_ID bigint                      not null,
    TYPE_CD          varchar(6) charset utf8_unicode_ci   not null,
    KEY_NAME         varchar(100) charset utf8_unicode_ci not null,
    STRING_VAL       varchar(250) charset utf8_unicode_ci null,
    DATE_VAL         datetime(6)                 null,
    LONG_VAL         bigint                      null,
    DOUBLE_VAL       double                      null,
    IDENTIFYING      char charset utf8_unicode_ci         not null,
    constraint JOB_EXEC_PARAMS_FK
        foreign key (JOB_EXECUTION_ID) references BATCH_JOB_EXECUTION (JOB_EXECUTION_ID)
);

create table BATCH_JOB_SEQ
(
    ID         bigint              not null,
    UNIQUE_KEY char charset utf8_unicode_ci not null,
    constraint UNIQUE_KEY_UN
        unique (UNIQUE_KEY)
);

create table BATCH_STEP_EXECUTION
(
    STEP_EXECUTION_ID  bigint                       not null
        primary key,
    VERSION            bigint                       not null,
    STEP_NAME          varchar(100) charset utf8_unicode_ci  not null,
    JOB_EXECUTION_ID   bigint                       not null,
    START_TIME         datetime(6)                  not null,
    END_TIME           datetime(6)                  null,
    STATUS             varchar(10) charset utf8_unicode_ci   null,
    COMMIT_COUNT       bigint                       null,
    READ_COUNT         bigint                       null,
    FILTER_COUNT       bigint                       null,
    WRITE_COUNT        bigint                       null,
    READ_SKIP_COUNT    bigint                       null,
    WRITE_SKIP_COUNT   bigint                       null,
    PROCESS_SKIP_COUNT bigint                       null,
    ROLLBACK_COUNT     bigint                       null,
    EXIT_CODE          varchar(2500) charset utf8_unicode_ci null,
    EXIT_MESSAGE       varchar(2500) charset utf8_unicode_ci null,
    LAST_UPDATED       datetime(6)                  null,
    constraint JOB_EXEC_STEP_FK
        foreign key (JOB_EXECUTION_ID) references BATCH_JOB_EXECUTION (JOB_EXECUTION_ID)
);

create table BATCH_STEP_EXECUTION_CONTEXT
(
    STEP_EXECUTION_ID  bigint                       not null
        primary key,
    SHORT_CONTEXT      varchar(2500) charset utf8_unicode_ci not null,
    SERIALIZED_CONTEXT text charset utf8_unicode_ci          null,
    constraint STEP_EXEC_CTX_FK
        foreign key (STEP_EXECUTION_ID) references BATCH_STEP_EXECUTION (STEP_EXECUTION_ID)
);

create table BATCH_STEP_EXECUTION_SEQ
(
    ID         bigint              not null,
    UNIQUE_KEY char charset utf8_unicode_ci not null,
    constraint UNIQUE_KEY_UN
        unique (UNIQUE_KEY)
);

create table arca_crawler_test
(
    item_id      int auto_increment
        primary key,
    item_content text not null,
    constraint arca_cralwer_test_item_id_uindex
        unique (item_id)
)
    comment '아카 크롤러 테스트 테이블';

