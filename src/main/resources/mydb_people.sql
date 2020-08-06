create table people
(
    id int auto_increment primary key,
    name varchar(30) null,
    create_time timestamp default CURRENT_TIMESTAMP null
);

INSERT INTO mydb.people (id, name, create_time) VALUES (1, '赵云', '2020-08-05 12:53:39');
INSERT INTO mydb.people (id, name, create_time) VALUES (2, '韩信', '2020-08-05 12:55:19');
INSERT INTO mydb.people (id, name, create_time) VALUES (3, '李白', '2020-08-05 12:55:19');
INSERT INTO mydb.people (id, name, create_time) VALUES (4, '猴子', '2020-08-05 12:56:31');
INSERT INTO mydb.people (id, name, create_time) VALUES (5, '雅典娜', '2020-08-05 12:56:31');
INSERT INTO mydb.people (id, name, create_time) VALUES (6, '兰陵王', '2020-08-05 12:56:31');
INSERT INTO mydb.people (id, name, create_time) VALUES (7, '百里玄策', '2020-08-05 12:56:31');