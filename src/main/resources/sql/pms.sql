create table CATEGORIES(
    ID  NUMBER generated as identity (nocache)primary key,
    NAME VARCHAR2(255)
);
create table articles(
    ID  NUMBER generated as identity (nocache)primary key,
    title varchar(255),
    description clob,
    cate_id number,
    status number(1) default 1,
    constraint fk_articles_categories foreign key (cate_id) references categories(id)
);