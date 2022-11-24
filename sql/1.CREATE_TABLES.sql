CREATE TABLE calls (
                       ID int AUTO_INCREMENT NOT NULL primary key,
                       USER_NAME varchar(12),
                       CALL_DURATION int,
                       BLOCK_COUNT int,
                       CREATE_DATE date,
                       UPDATE_DATE date,
                       CREATE_BY varchar(128),
                       UPDATE_BY varchar(128)
);
CREATE TABLE call_billing (
                              USER_NAME varchar(12) NOT NULL primary key,
                              CALL_COUNT int,
                              BLOCK_COUNT int,
                              CREATE_DATE date,
                              UPDATE_DATE date,
                              CREATE_BY varchar(128),
                              UPDATE_BY varchar(128)
);