INSERT INTO roles (id, name)
VALUES
(1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO users (id,username,password,first_name,last_name,email,phone)
VALUES
(1, 'admin','$2a$10$RdRbvznoIMGUS5WxrDRtG.sv584GdFFRmRzTWl4TByOxXLZaTMH/W','Admin','Admin','admin@gmail.com','+79881111111'); -- pass: admin

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2);

INSERT INTO users (id, username,password,first_name,last_name,email,phone)
VALUES
(2, 'testUser','$2a$10$T7jzspE7pSKWaS3raQQffO91w8YLF8lz4WCDCvMgHeuRencB/9bNm','Test','Testov','testUser@gmail.com','+79881111111'); -- pass: qw12345

INSERT INTO users_roles (user_id, role_id)
VALUES
(2, 1);

INSERT INTO employee_status (id, title)
VALUES
(1, "Свободен"), (2, "В отпуске"), (3, "На больничном"), (4, "В рейсе");

INSERT INTO employees (id, first_name, middle_name, last_name, age, status_id)
VALUES
(1, "Петр", "Сергеевич", "Иванов", 45, 1), (2, "Кирилл", "Леонидович", "Волков", 37, 4), (3, "Сергей", "Александрович", "Зайцев", 26, 4), (4, "Леонид", "Андреевич", "Соловьев", 32, 3), (5, "Николай", "Семенович", "Преображенский", 29, 1),
(6, "Валентина", "Петровна", "Грачева", 34, 2), (7, "Андерй", "Павлович", "Карасев", 52, 4), (8, "Евгений", "Олегович", "Сидоренко", 36, 1), (9, "Геннадий", "Геннадьевич", "Афанасьев", 43, 4), (10, "Владимир", "Федорович", "Некрасов", 56, 2);

INSERT INTO licence_category (id, code, title)
VALUES
(1, "B", "Леговые автомобили"), (2, "С", "Грузовики (свыше 3,5 т)"), (3, "СЕ", "Грузовики категории С с прицепом"), (4, "С1", "Грузовики (3,5 - 7,5 т)"), (5, "С1Е", "Грузовики подкатегории С1 (до 12 т)");

INSERT INTO employees_licence_categories (employee_id, licence_id)
VALUES
(1, 1), (1, 2), (2, 1), (2, 2), (2, 3), (3, 1), (3, 2), (4, 1), (4, 2), (4, 4), (5, 2), (5, 4), (5, 5), (6, 2), (6, 3), (7, 1), (7, 2), (8, 1), (8, 2), (8, 5), (9, 2), (9, 4), (10, 1), (10, 2), (10, 3), (10, 4);

INSERT INTO routs (id, city_from, city_to, distance, active)
VALUES
(1, "Москва", "Казань", 810, 1), (2, "Москва", "Нижний Новгород", 420, 1), (3, "Москва", "Санкт-Петербург", 710, 1), (4, "Москва", "Волгоград", 970, 1), (5, "Москва", "Саратов", 850, 1),
(6, "Москва", "Ростов-на-Дону", 1100, 1), (7, "Москва", "Ярославль", 260, 1), (8, "Москва", "Тула", 180, 1), (9, "Москва", "Тамбов", 460, 1), (10, "Москва", "Чебоксары", 660, 1),
(11, "Казань", "Москва", 810, 1), (12, "Нижний Новгород", "Москва", 420, 1), (13, "Санкт-Петербург", "Москва", 710, 1), (14, "Волгоград", "Москва", 970, 1), (15, "Саратов", "Москва", 850, 1),
(16, "Ростов-на-Дону", "Москва", 1100, 1), (17, "Ярославль", "Москва", 260, 1), (18, "Тула", "Москва", 180, 1), (19, "Тамбов", "Москва", 460, 1), (20, "Чебоксары", "Москва", 660, 1);

INSERT INTO vehicle_type (id, title)
VALUES
(1, "Легкий грузовик"), (2, "Грузовик"), (3, "Тягач");

INSERT INTO vehicles (id, title, tonnage, horsepower, manufacture_year, type_id, active)
VALUES
(1, "ГАЗ ГАЗель (3302)", "1,5 т", 110, 2015, 1, 1), (2, "ГАЗ ГАЗель (3302)", "1,5 т", 110, 2018, 1, 1), (3, "ГАЗ Соболь (2310)", "1,5 т", 107, 2018, 1, 1), (4, "Hyundai HD78", "4.8 т", 140, 2009, 2, 1), (5, "MAN TGL", "12.0 т", 250, 2016, 2, 1),
(6, "Volvo FH", "17.3 т", 420, 2005, 2, 1), (7, "DAF XF", "30.0 т", 483, 2012, 3, 1), (8, "Scania R-Series", "30.0 т", 440, 2016, 3, 1), (9, "MAN TGS", "34.0 т", 400, 2012, 3, 1), (10, "КамАЗ 5490", "65.0 т", 428, 2017, 3, 1);

INSERT INTO tariffs (id, dist_limit, cost_per_km, max_volume, extra_volume_cost, fragile_coeff)
VALUES
(1, 1000, 2, 20, 3, 1.1), (2, 2000, 3, 70, 3.5, 1.15);

