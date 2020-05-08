<h1> SPORT PROGRAM </h1>
This is a simple project designed to learn Java SE, Java EE, Postgresql, TomCat etc.
Functions and description of the project:
1. The project has an authorization form. You can implement the connection through third-party services (they are in the form of a login). There are 2 users with 2 roles (administrator and user). I added them statically without saving them in the database (you can edit them and add your name and password)
2. In this project you can create your own sports programs and give them descriptions, they are stored in a database.
3. In addition, the project already has its own programs recommended by the site itself, as well as descriptions and a working link to real third-party sites.
4. You can view the programs added by users and the administrator.
5. Has the same shutdown.
6. Also implemented the counter (through the servlet). Needed to view users in the stream :) Joke :-)

The project will be useful to those who need answers to questions:
1. How to create a working authorization form with a beautiful interface.
2. How to add information to the database.
3. How Java EE works (servlet / jsp).
4. How to create an entity / dao / dto / service / util / filter.
5. How to create the correct locale for changing languages.
6.How to configure the database for correct operation (connection settings)
Run Project
Create an empty database named login_repository
Also need create schema named login_storage
And you need to create 3 tables

CREATE TABLE login_storage.category
(
    id   SERIAL PRIMARY KEY,
    name CHARACTER VARYING(64) NOT NULL UNIQUE
);

CREATE TABLE login_storage.program
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(64)           NOT NULL,
    author      VARCHAR(128)          NOT NULL,
    days        INTEGER               NOT NULL,
    gender      CHARACTER VARYING(16) NOT NULL,
    level       CHARACTER VARYING(16) NOT NULL,
    period      CHARACTER VARYING(16) NOT NULL,
    category_id INTEGER               NOT NULL REFERENCES login_storage.category (id)
);

CREATE TABLE login_storage.description(
    id SERIAL PRIMARY KEY,
    name CHARACTER VARYING(64) NOT NULL,
    days INTEGER NOT NULL,
    period CHARACTER VARYING(64) NOT NULL,
    level CHARACTER VARYING(64) NOT NULL,
    type CHARACTER VARYING(64) NOT NULL,
    specification CHARACTER VARYING(512) NOT NULL,
    category_id INTEGER NOT NULL REFERENCES login_storage.category (id)
);

INSERT INTO login_storage.category (name)
VALUES ('Марш-бросок'),
       ('Проверь свою силу'),
       ('Проверь свою выносливость'),
       ('Тело в тонусе'),
       ('Набор мышечной массы'),
       ('Стальной пресс'),
       ('Круглые ягодицы'),
       ('Программа: После родов');
       
       INSERT INTO login_storage.description (name, days, period, level, type, specification, category_id)
VALUES ('Домашний вызов', 30, 'MONTHLY', 'HARD', 'Дома', 'https://full-fit.com/programmy-trenirovok/domashnie-trenirovki-dlya-muzhchin/',(SELECT id FROM login_storage.category WHERE name = 'Марш-бросок')),
       ('Сила стадиона', 7, 'WEEKLY', 'MEDIUM', 'Стадион','https://bombatelo.ru/programma-trenirovok-na-ulice/',(SELECT id FROM login_storage.category WHERE name = 'Проверь свою силу')),
       ('Быстрее ветра', 30, 'MONTHLY', 'EASY', 'Зал/улица','https://full-fit.com/programmy-trenirovok/na-vynoslivost/',(SELECT id FROM login_storage.category WHERE name = 'Проверь свою выносливость')),
       ('Подкачка мышц', 30, 'MONTHLY', 'MEDIUM', 'Зал','https://fitfan.ru/trenirovki/workouts/9996-3-dnevnaja-programma-dlja-tonusa-myshc-vsego-tela.html',(SELECT id FROM login_storage.category WHERE name = 'Тело в тонусе')),
       ('Строим тело', 30, 'MONTHLY', 'MEDIUM', 'Зал','https://builderbody.ru/programma-dlya-effektivnogo-nabora-myshechnoj-massy/',(SELECT id FROM login_storage.category WHERE name = 'Набор мышечной массы')),
       ('6 кубов', 30, 'MONTHLY', 'HARDCORE', 'Дома','https://bombatelo.ru/programma-200-pressa/',(SELECT id FROM login_storage.category WHERE name = 'Стальной пресс')),
       ('Будь лучшей', 7, 'WEEKLY', 'MEDIUM', 'Зал','https://dailyfit.ru/programmy-trenirovok/effektivnaya-trenirovka-yagodic-programma-dlya-devushek/',(SELECT id FROM login_storage.category WHERE name = 'Круглые ягодицы')),
       ('Стройная мама', 30, 'MONTHLY', 'MEDIUM', 'Дома','http://trainathome.ru/training/trenirovochnaya-programma-dlya-molodykh-mam.html',(SELECT id FROM login_storage.category WHERE name = 'Программа: После родов'));
       
IDE

Import the project into your IDE and run it as a Java WEB application.