CREATE TABLE user
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  addr VARCHAR(200),
  bank1 VARCHAR(100),
  email VARCHAR(100),
  name VARCHAR(20),
  password VARCHAR(100),
  qq VARCHAR(15),
  tel VARCHAR(15),
  nickname VARCHAR(20),
  group_type_Id int(11),
  create_date DATETIME,
  update_date DATETIME,
  state BIT(1)
);
CREATE TABLE resource
(
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  state BIT(1),
  create_date DATETIME,
  name VARCHAR(255),
  value VARCHAR(255),
  update_date DATETIME
);
CREATE TABLE role
(
  id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  state BIT(1),
  create_date DATETIME,
  description VARCHAR(255),
  name VARCHAR(255),
  update_date DATETIME
);
CREATE TABLE user_role
(
  user_id INT(11) NOT NULL,
  role_id INT(11) NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (user_id, role_id)
);
CREATE TABLE role_resource
(
  role_id INT(11) NOT NULL,
  resource_id INT(11) NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (role_id, resource_id)
);
CREATE TABLE actions_item
(
  id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  create_date DATETIME,
  update_date DATETIME,
  action_name VARCHAR(255),
  code VARCHAR(255),
  note VARCHAR(255)
);
CREATE TABLE user_actions_item
(
  user_id INT(11) NOT NULL,
  actions_item_it INT(11) NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (user_id, actions_item_it)
);
