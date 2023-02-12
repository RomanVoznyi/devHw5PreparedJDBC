DROP TABLE IF EXISTS project_worker;

DROP TABLE IF EXISTS project;

DROP TABLE IF EXISTS client;

DROP TABLE IF EXISTS worker;

CREATE TABLE worker(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(1000) NOT NULL,
    birthday DATE,
    level VARCHAR(10) NOT NULL,
    salary INT,
    CONSTRAINT worker_name_min CHECK(CHAR_LENGTH(name) >= 2),
    CONSTRAINT worker_birthday_min CHECK(YEAR(birthday) > 1900),
    CONSTRAINT worker_level_enum CHECK(
        level IN('Trainee', 'Junior', 'Middle', 'Senior')
    ),
    CONSTRAINT worker_salary_minmax CHECK(
        salary >= 100
        AND salary <= 100000
    )
);

CREATE TABLE client(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(1000) NOT NULL,
    CONSTRAINT client_name_min CHECK(CHAR_LENGTH(name) >= 2)
);

CREATE TABLE project(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    client_id INT NOT NULL,
    start_date DATE,
    finish_date DATE,
    CONSTRAINT project_name_min CHECK(CHAR_LENGTH(name) >= 2),
    FOREIGN KEY(client_id) REFERENCES client(id)
);

CREATE TABLE project_worker(
    project_id INT,
    worker_id INT,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY(worker_id) REFERENCES worker(id)
);