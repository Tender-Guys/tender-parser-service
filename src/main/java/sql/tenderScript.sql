DROP TABLE IF EXISTS 	users, 
						tenders, 
						key_words, 
						users_key_words, 
						tender_sites, 
						tender_initiators;

CREATE TABLE users (
	user_id INT NOT NULL AUTO_INCREMENT,
	user_phone VARCHAR(32) UNIQUE NOT NULL, 
    user_nameid VARCHAR(32),
    user_first_name VARCHAR(32),
    user_last_name VARCHAR(32),

	CONSTRAINT pk_users_user_id PRIMARY KEY (user_id)
);

CREATE TABLE key_words (
	key_word_id INT NOT NULL AUTO_INCREMENT,
	key_word_value VARCHAR(256) UNIQUE NOT NULL,	

	CONSTRAINT pk_key_words_key_words_id PRIMARY KEY (key_word_id)
);

CREATE TABLE users_key_words (
	user_id	INT NOT NULL,
	key_word_id	INT NOT NULL,
	
	CONSTRAINT pk_users_key_words_user_id_key_word_id PRIMARY KEY (user_id, key_word_id),
	CONSTRAINT fk_users_key_words_user FOREIGN KEY (user_id) 
		REFERENCES users (user_id),
	CONSTRAINT fk_users_key_words_key_word FOREIGN KEY (key_word_id) 
		REFERENCES key_words (key_word_id)
);


CREATE TABLE tender_sites (
	tender_site_id INT NOT NULL AUTO_INCREMENT,
	tender_site_name VARCHAR(32) NOT NULL,
	tender_site_home_url VARCHAR(512) UNIQUE NOT NULL,

	CONSTRAINT pk_tender_sites_tender_site_id PRIMARY KEY (tender_site_id)
);

CREATE TABLE tender_initiators (
	tender_initiator_id	INT NOT NULL AUTO_INCREMENT,
	tender_initiator_name VARCHAR(256) NOT NULL,
    tender_initiator_contact_name VARCHAR(256),
    tender_initiator_contact_phone VARCHAR(32),

	CONSTRAINT pk_initiators_initiator_id PRIMARY KEY (tender_initiator_id)
);

CREATE TABLE tenders (
	tender_id INT NOT NULL AUTO_INCREMENT,
	tender_site_id INT,
	tender_site_inner_id VARCHAR(32) NOT NULL,
	tender_initiator_id	INT,
	tender_subject VARCHAR(512) NOT NULL,
	tender_start_time TIMESTAMP NOT NULL,
	tender_end_time	TIMESTAMP NOT NULL,
	tender_url VARCHAR(512) UNIQUE NOT NULL,

	CONSTRAINT pk_tenders_tender_id PRIMARY KEY (tender_id),
	CONSTRAINT fk_tenders_tender_site_id FOREIGN KEY (tender_site_id) 
		REFERENCES tender_sites (tender_site_id),
	CONSTRAINT fk_tenders_tender_initiator_id FOREIGN KEY (tender_initiator_id) 
		REFERENCES tender_initiators (tender_initiator_id)
);


INSERT INTO key_words (key_word_value)
VALUES ('кран'),
	('мотор'),
    ('балка'),
    ('ford focus'),
    ('spirax sarco'),
    ('масло'),
    ('гуси-лебеди'),
    ('колесо'),
    ('пластик'),
    ('амперметр'),
    ('трубка Перкінсона'),
    ('халат'),
    ('яйцо куриное'),
    ('сервисное обслуживание');
    
INSERT INTO tender_initiators (tender_initiator_name)
VALUES ('ТОВ "СП ВІТМАРК-УКРАЇНА"'),
	('ПРАТ "КРЕМЕНЧУЦЬКИЙ МІСЬКМОЛОКОЗАВОД"'),
    ('ФГ "ОРГАНІК СІСТЕМС"'),
    ('ТОВ "ДУНАПАК"'),
    ('ТОВ "ПЕРША ПРИВАТНА БРОВАРНЯ"'),
    ('ПРАТ "ПОЛТАВСЬКИЙ МАСЛОЕКСТРАКЦІЙНИЙ ЗАВОД"'),
    ('ПРАТ "РУДЬ"'),
    ('ТОВ "ПРОКТЕР ЕНД ГЕМБЛ УКРАЇНА"'),
    ('ЧП "ВІКТОР І К"'),
    ('ПРАТ "ПОЛТАВСЬКИЙ ГІРНИЧОЗБАГАЧУВАЛЬНИЙ КОМБІНАТ"');
    
INSERT INTO tender_sites (tender_site_name, tender_site_home_url)
VALUES ('СМАРТТЕНДЕР', 'https://smarttender.biz'),
	('ПОЛАТВСЬКИЙ ГЗК', 'https://poltavagzk.com'),
    ('Е-ТЕНДЕР', 'http://e-tender.com'),
    ('ПРОЗОРО', 'https://prozoro.gov.ua'),
    ('ASP ТЕНДЕР','http://asp.tender.org'),
    ('МЕГА ТРЕЙД','https://mega-trade.ua');
    
INSERT INTO users (user_phone)
VALUES ('+38 (067) 438-51-72'),
('+38 (067) 191-22-32'),
('+38 (050) 022-14-77'),
('+38 (063) 123-54-76'),
('+38 (067) 911-92-11'),
('+38 (097) 686-13-13'),
('+38 (097) 799-66-23'),
('+38 (050) 123-54-47'),
('+38 (050) 987-65-43'),
('+38 (066) 852-43-97'),
('+38 (063) 115-72-38'),
('+38 (097) 181-29-33'),
('+38 (067) 051-52-53');

INSERT INTO users_key_words
VALUES (1, 1),
	(1, 5),
	(1, 8),
    (2, 2),
    (2, 14),
    (3, 7),
    (4, 4),
    (4, 5),
    (4, 9),
    (4, 11),
    (5, 2),
    (7, 6),
    (7, 13),
    (9, 4),
    (9, 7),
    (9, 11),
    (9, 14),
    (10, 3),
    (11, 2),
    (11, 5),
    (11, 6),
    (12, 9),
    (13, 10);
    
INSERT INTO tenders (tender_site_id, tender_site_inner_id, tender_initiator_id, tender_subject, tender_start_time, tender_end_time, tender_url)
VALUES 
	(1, 107010, 1, 'Конденсатоотводчик ARI CONA Ду25 FLT55 PN25', '2023-03-02 15:00:00', '2023-03-04 13:30:00', 'anyoneurl.com.ua/123'),
	(1, 132313, 3, 'Халаты белые, медицинские (1000 шт.)', '2022-10-12 16:30:00', '2022-11-01 00:30:00', 'anyoneurl.com.ua/444'),
    (1, 161616, 10, 'Повысительный насос WILO RF450-10', '2023-03-05 14:00:00', '2023-03-17 14:00:00', 'anyoneurl.com.ua/777'),
    (1, 171717, 2, 'Азотные удобрения, 20 м.куб', '2023-02-06 20:00:00', '2023-03-01 12:00:00', 'anyoneurl.com.ua/888'),
    (1, 151545, 8, 'Послуги з космічного туризму на колоземну орбіту (6 чоловік)', '2023-03-01 11:00:00', '2023-03-06 16:00:00', 'anyoneurl.com.ua/666'),
	(1, 111811, 2, 'Халат белый, медицинский, новый', '2023-02-01 00:00:00', '2023-02-20 11:00:00', 'anyoneurl.com.ua/222'),
    (1, 121212, 2, 'Запасные засти к сепаратору сливок Tetra-pak', '2023-04-02 12:00:00', '2023-04-02 20:00:00', 'anyoneurl.com.ua/333'),
    (1, 141414, 6, 'Конденсатоотводчик Spirax Sarco DN25 FT14-10 PN16', '2023-03-02 10:00:00', '2023-03-04 13:30:00', 'anyoneurl.com.ua/555'),
    (2, 939191, 5, 'Комплект зимової гуми для автомобіля FORD FOCUS', '2023-01-23 08:00:00', '2023-02-14 12:30:00', 'anyoneurl.com.ua/112'),
    (2, 181818, 5, 'Централізована закупка подарункової продукції: блокноти та ручки з логотипом компанії', '2022-12-01 08:00:00', '2022-12-31 10:00:00', 'anyoneurl.com.ua/999'),
    (2, 505151, 8, 'Гуси білі', '2023-02-11 11:00:00', '2023-02-16 13:00:00', 'anyoneurl.com.ua/411'),
    (2, 818181, 2, 'Перчатки, рукавицы', '2022-12-04 13:00:00', '2022-12-19 10:00:00', 'anyoneurl.com.ua/113'),
    (2, 717871, 9, 'Насос WILO Helix V 3603/1-2/16/V/K/400-5 Арт. 4150751 (аналоги не розглядаються)', '2023-01-16 10:00:00', '2023-01-21 16:30:00', 'anyoneurl.com.ua/211'),
    (2, 616161, 9, 'Премікси, та добавки для годівлі ВРХ та телят ПК', '2023-02-20 12:00:00', '2023-02-28 12:00:00', 'anyoneurl.com.ua/311'),
    (2, 414141, 8, 'хомути', '2023-02-20 09:00:00', '2023-03-07 16:10:00', 'anyoneurl.com.ua/511'),
    (2, 191919, 7, 'Розробка web-застосунку компанії з застосуванням передових технологій HTML/CSS/COBOL', '2023-03-01 10:00:00', '2023-03-04 10:00:00', 'anyoneurl.com.ua/101'),
    (3, 343131, 1, 'Центробежный насос РЕГ10-10/2535Р', '2023-03-17 19:00:00', '2023-03-18 10:30:00', 'anyoneurl.com.ua/1111'),
    (3, 212121, 2, 'Колесо від чумацького воза 22 дюйми, переднє, ліве', '2022-09-28 20:00:00', '2022-09-30 00:00:00', 'anyoneurl.com.ua/2222'),
    (3, 223333, 5, 'Мотор-редуктор до підйомного крану', '2023-03-03 10:00:00', '2023-03-14 15:30:00', 'anyoneurl.com.ua/4444'),
    (3, 303444, 8, 'Амперметри, вольтметри, омметри згідно специфікації', '2023-01-10 10:00:00', '2023-01-20 10:00:00', 'anyoneurl.com.ua/5555'),
    (3, 111292, 3, 'олива моторна+антифриз', '2022-11-28 14:00:00', '2022-12-04 17:00:00', 'anyoneurl.com.ua/3333'),
    (3, 606771, 8, 'Придбання шин до вантажної техніки та автонавантажувачів', '2023-02-11 09:00:00', '2023-03-01 13:00:00', 'anyoneurl.com.ua/8888'),
    (3, 555646, 2, 'Закупка продукции компаний Philips, Sony, Samsung согласно спецификации', '2023-01-24 22:00:00', '2023-01-28 14:30:00', 'anyoneurl.com.ua/6666'),
    (3, 444955, 8, 'Гранитные столбы высотой 12 метров для фонарей освещения', '2023-02-07 09:00:00', '2023-02-09 09:00:00', 'anyoneurl.com.ua/7777'),
    (4, 777858, 6, 'Бухта медного провода (100 метров) с сечением 12 мм.кв.', '2022-12-01 10:00:00', '2023-01-10 10:00:00', 'anyoneurl.com.ua/9999'),
    (4, 991898, 4, 'Самовар бронзовый для памятника', '2023-01-02 15:00:00', '2023-02-07 16:00:00', 'anyoneurl.com.ua/1212'),
    (4, 666535, 2, 'Халат рабочий для сварщика', '2023-02-07 12:00:00', '2023-03-01 10:00:00', 'anyoneurl.com.ua/1515'),
    (4, 848999, 4, 'Закупівля соди каустичної', '2023-01-23 15:00:00', '2023-01-27 12:00:00', 'anyoneurl.com.ua/1010'),
    (4, 880177, 10, 'Брухт металевий', '2023-03-10 17:00:00', '2023-03-10 20:51:00', 'anyoneurl.com.ua/1313'),
    (4, 799666, 8, 'Послуги з технічного обслуговування, а саме: технічне діагностування, технічне опосвідчення, перезаряджання та ремонт вогнегасників типів ВП (вогнегасник порошковий) та ВВК (вогнегасник вуглекислотний), розміщених на об’єктах АТ «Укртелеком»', '2023-03-07 23:00:00', '2023-03-23 14:30:00', 'anyoneurl.com.ua/1414'),
    (4, 515444, 6, 'Придбання кондиціонерів та послуг з їх монтажу і пусконалагодженню', '2023-02-11 10:00:00', '2023-04-05 10:00:00', 'anyoneurl.com.ua/1616'),
    (4, 333222, 6, 'виготовлення та монтаж вентиляційних решіток, вул.Драгоманова, 31-з у Дарницькому району м.Києва', '2022-12-25 10:00:00', '2023-02-01 00:00:00', 'anyoneurl.com.ua/1818'),
    (4, 222111, 2, 'поставка герметику для зовнішньої герметизації вікон, м.Київ', '2023-01-01 14:00:00', '2023-02-02 16:00:00', 'anyoneurl.com.ua/2020'),
    (4, 112233, 3, 'Вікна метало-пластикові STEKO', '2023-02-16 08:00:00', '2023-02-22 14:20:00', 'anyoneurl.com.ua/4040'),
    (4, 444353, 6, 'Пленка пищевая, 0,3 мкм в рулонах', '2023-01-12 12:30:00', '2023-01-25 16:30:00', 'anyoneurl.com.ua/1717'),
    (4, 171090, 9, 'Шарові крани, зворотні клапани та деталі трубопроводу', '2023-02-02 16:00:00', '2023-04-02 10:00:00', 'anyoneurl.com.ua/3030'),
    (4, 223344, 8, 'Виготовлення поліграфічної продукції. Візитні картки', '2023-01-24 11:00:00', '2023-01-31 10:00:00', 'anyoneurl.com.ua/5050'),
    (5, 334455, 7, 'Сервисное обслуживание котельного агрегата КА-10/43ВГ', '2023-02-24 15:00:00', '2023-02-26 15:00:00', 'anyoneurl.com.ua/6060'),
    (5, 995511, 2, 'Услуги финансового аудита бухгалтеских бумаг за 2020 год', '2022-12-28 15:00:00', '2023-01-13 12:00:00', 'anyoneurl.com.ua/8080'),
    (5, 224451, 4, 'Замена рулевого колеса', '2023-03-04 15:00:00', '2023-03-17 14:30:00', 'anyoneurl.com.ua/9090'),
    (5, 558811, 3, 'Яйцо куриное, гусиное и страусиное. Сорт С0. 100 шт.', '2022-11-11 10:00:00', '2022-12-10 10:00:00', 'anyoneurl.com.ua/7070'),
    (6, 661234, 4, 'Амиак', '2023-03-08 10:00:00', '2023-03-12 12:30:00', 'anyoneurl.com.ua/5648'),
    (6, 951753, 9, 'Услуги по транспортировке серого слона (4 т) по маршруту Киев-Вильнюс', '2023-04-04 00:00:00', '2023-04-20 00:00:00', 'anyoneurl.com.ua/51246'),
	(6, 369258, 10, 'Комплект рожкових ключів 8-40', '2023-03-01 14:20:00', '2023-04-01 12:00:00', 'anyoneurl.com.ua/42561'),
    (6, 123456, 2, 'Емкость пищевая из нержавеющей стали (2 м.куб.) с теплоизоляцией 50 мм. Чертеж', '2023-03-21 12:00:00', '2023-03-27 10:30:00', 'anyoneurl.com.ua/6234'),
    (6, 881124, 7, 'Закупка пластиковых ведер 11л', '2022-10-20 11:00:00', '2022-12-01 13:30:00', 'anyoneurl.com.ua/1234'),
    (6, 741852, 1, 'Растительное масло марки "П"', '2023-04-17 09:00:00', '2023-04-26 13:00:00', 'anyoneurl.com.ua/51277');

SELECT ti.tender_initiator_name, t.tender_subject, t.tender_start_time, t.tender_end_time, t.tender_url
FROM tenders t
JOIN tender_initiators ti USING (tender_initiator_id)
WHERE tender_end_time > NOW()
ORDER BY t.tender_end_time; 
    
