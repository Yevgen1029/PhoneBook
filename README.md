CREATE DATABASE PHONEBOOK CHARACTER SET utf8 COLLATE utf8_general_ci;
USE PHONEBOOK;
CREATE TABLE `PHONEBOOK`.`USERS` (
  `LOGIN`    VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `FIO`      VARCHAR(45) NOT NULL,
  `ENABLED`  TINYINT(1)  NULL,
  PRIMARY KEY (`LOGIN`)
)
  ENGINE = InnoDB;
CREATE TABLE USER_ROLES (
  ROLE_ID INT NOT NULL AUTO_INCREMENT,
  ROLE    VARCHAR(45) NOT NULL,
  LOGIN   VARCHAR(45) NOT NULL,
  PRIMARY KEY (ROLE_ID),
  FOREIGN KEY (LOGIN)
  REFERENCES PHONEBOOK.USERS (LOGIN)
);
CREATE TABLE PHONEBOOK.USER_CONTACTS (
  CONTACT_ID          INT NOT NULL AUTO_INCREMENT,
  FIRST_NAME          VARCHAR(45) NOT NULL,
  SECOND_NAME         VARCHAR(45) NOT NULL,
  PATRONYMIC          VARCHAR(45) NOT NULL,
  MOBILE_PHONE_NUMBER VARCHAR(15) NOT NULL,
  HOME_PHONE_NUMBER   VARCHAR(15),
  EMAIL               VARCHAR(70),
  ADDRESS             VARCHAR(255),
  LOGIN               VARCHAR(45),
  PRIMARY KEY (CONTACT_ID),
  FOREIGN KEY (LOGIN)
  REFERENCES PHONEBOOK.USERS (LOGIN)
);
INSERT INTO PHONEBOOK.USERS (LOGIN, PASSWORD, FIO, ENABLED)
VALUES ('Yevgen', 123456, 'Ostapiuk Yevgen Volodimirovich', TRUE),
  ('Logan', 234567, 'Lisicin Genadij Nickolajevich', TRUE),
  ('Varich', 345678, 'Voda Renath Christophorovich', TRUE),
  ('Bozia', 456789, 'Bespalaya Zita Alphonsovna', TRUE);
INSERT INTO PHONEBOOK.USER_ROLES (ROLE_ID, ROLE, LOGIN)
VALUES (1, 'ROLE_USER', 'Yevgen'),
  (2, 'ROLE_USER', 'Logan'),
  (3, 'ROLE_USER', 'Varich'),
  (4, 'ROLE_USER', 'Bozia');
INSERT INTO PHONEBOOK.USER_CONTACTS (CONTACT_ID, FIRST_NAME, SECOND_NAME, PATRONYMIC, MOBILE_PHONE_NUMBER, HOME_PHONE_NUMBER, EMAIL, ADDRESS, LOGIN)
VALUES (1, 'Pavlo', 'Litenko', 'Genadiyovich', '+380(68)3811733', '+380(44)5667819', NULL, 'Kiev', 'Yevgen'),
  (2, 'Artur', 'Kondratik', 'Robertovich', '+380(67)5182948', NULL, 'Akrobert@gmail.com', 'Kiev', 'Yevgen'),
  (3, 'Liza', 'Parhomenko', 'Vasiliyevna', '+380(99)4335571', NULL, NULL, 'Kharkiv', 'Yevgen'),
  (4, 'Inna', 'Laskutok', 'Semenivna', '+380(67)5796255', NULL, 'yoda_magistr@ukr.net', NULL, 'Yevgen'),
  (5, 'Kutep', 'Bashkir', 'Zahirovich', '+380(98)7958854', NULL, 'Chingis_Khanr@mail.ru', 'Kiev', 'Logan'),
  (6, 'Sergiy', 'Bloch', 'Sergiyevich', '+380(66)3466654', NULL, 'Circle_square@gmail.com', NULL, 'Logan'),
  (7, 'Max', 'Lobanovskiy', 'Valeriyevich', '+380(67)1646258', NULL, 'vanadij_Mg@ukr.net', NULL, 'Logan'),
  (8, 'Andrij', 'Khoroshev', 'Petrovich', '+380(67)1646258', NULL, 'Andrij.k.p@gmail.com', NULL, 'Varich'),
  (9, 'Yulia', 'Goloborodjko', 'Aleksandrovna', '+380(63)4323334', NULL, 'krem_bruleg@ukr.net', NULL, 'Varich'),
  (10, 'Vania', 'Hoyen', 'Haime', '+380(99)5557882', NULL, 'van_hoen_haym@gmail.com', NULL, 'Varich'),
  (11, 'Алинка', 'Печенька', 'Ккофу', '+380(67)1646258', NULL, 'pechenie.k.kofu@gmail.com', NULL, 'Bozia'),
  (12, 'Артём', 'Кондратенко', 'Алексеевич', '+380(63)4323334', NULL, 'murzik_pes@ukr.net', NULL, 'Bozia'),
  (13, 'Иван', 'Доброзычлывый', 'Богданович', '+380(99)5557882', NULL, 'bog_odin@gmail.com', NULL, 'Bozia');