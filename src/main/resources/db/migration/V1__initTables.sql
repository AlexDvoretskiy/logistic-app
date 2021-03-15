SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(50) NOT NULL,
  password char(80) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  phone varchar(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  PRIMARY KEY (user_id,role_id),
  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES users (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES roles (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS employee_status;

CREATE TABLE employee_status (
  id	              INT(11) NOT NULL AUTO_INCREMENT,
  title               VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS licence_category;

CREATE TABLE licence_category (
  id	              INT(11) NOT NULL AUTO_INCREMENT,
  code                VARCHAR(10) NOT NULL,
  title               VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  id	               INT(11) NOT NULL AUTO_INCREMENT,
  first_name           VARCHAR(255) NOT NULL,
  middle_name          VARCHAR(255) NOT NULL,
  last_name            VARCHAR(255) NOT NULL,
  age                  SMALLINT NOT NULL,
  status_id            INT(11) NOT NULL,
  hire_date            DATETIME DEFAULT CURRENT_TIMESTAMP,
  active               BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id),
  CONSTRAINT FK_EMPLOYEE_STATUS FOREIGN KEY (status_id)
  REFERENCES employee_status (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE employees_licence_categories (
  employee_id int(11) NOT NULL,
  licence_id int(11) NOT NULL,
  PRIMARY KEY (employee_id,licence_id),
  CONSTRAINT FK_EMP_ID_01 FOREIGN KEY (employee_id)
  REFERENCES employees (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT FK_LICENCE_ID_01 FOREIGN KEY (licence_id)
  REFERENCES licence_category (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS routs;

CREATE TABLE routs (
  id     	          INT(11) NOT NULL AUTO_INCREMENT,
  city_from           VARCHAR(255) NOT NULL,
  city_to             VARCHAR(255) NOT NULL,
  distance            INT(11) NOT NULL,
  active              BOOLEAN DEFAULT TRUE,
  create_at   DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS vehicle_type;

CREATE TABLE vehicle_type (
  id	              INT(11) NOT NULL AUTO_INCREMENT,
  title               VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS vehicles;

CREATE TABLE vehicles (
  id	              INT(11) NOT NULL AUTO_INCREMENT,
  title               VARCHAR(255) NOT NULL,
  tonnage             VARCHAR(25) NOT NULL,
  horsepower          SMALLINT NOT NULL,
  manufacture_year    SMALLINT NOT NULL,
  type_id             INT(11) NOT NULL,
  active              BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id),
  CONSTRAINT FK_VEHICLE_STATUS FOREIGN KEY (type_id)
  REFERENCES vehicle_type (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tariffs;

CREATE TABLE tariffs (
  id	                       INT(11) NOT NULL AUTO_INCREMENT,
  dist_limit                   INT(11) NOT NULL,
  cost_per_km                  DOUBLE NOT NULL,
  max_volume                   DOUBLE NOT NULL,
  extra_volume_cost            DOUBLE NOT NULL,
  fragile_coeff                DOUBLE NOT NULL,
  active                       BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;