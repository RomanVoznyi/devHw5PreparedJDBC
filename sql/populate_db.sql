INSERT INTO
    worker (name, birthday, level, salary)
VALUES
    ('John 1', '1985-10-05', 'Senior', 100000),
    ('John 2', '1986-10-05', 'Senior', 100000),
    ('John 3', '1985-10-05', 'Senior', 70000),
    ('John 4', '1988-11-05', 'Senior', 60000),
    ('John 5', '1989-11-05', 'Middle', 30000),
    ('John 6', '1990-11-05', 'Middle', 25000),
    ('John 7', '1995-12-05', 'Middle', 20000),
    ('John 8', '1996-12-05', 'Middle', 20000),
    ('John 9', '1997-12-05', 'Junior', 10000),
    ('John 10', '1998-08-05', 'Junior', 10000),
    ('John 11', '2000-08-05', 'Junior', 5000),
    ('John 12', '2000-09-05', 'Junior', 2000),
    ('John 13', '2001-10-05', 'Trainee', 1000),
    ('John 14', '2002-10-05', 'Trainee', 500),
    ('John 15', '2003-10-05', 'Trainee', 100);

INSERT INTO
    client (name)
VALUES
    ('Anna'),
    ('Bill'),
    ('Courtney'),
    ('Dilan'),
    ('Elon'),
    ('Fred'),
    ('George'),
    ('Helen');

INSERT INTO
    project (client_id, name, start_date, finish_date)
VALUES
    (1, 'Project A', '2023-01-01', '2023-01-30'),
    (2, 'Project B', '2023-01-01', '2023-02-15'),
    (3, 'Project C', '2023-01-01', '2023-03-20'),
    (4, 'Project D', '2023-01-01', '2023-04-25'),
    (5, 'Project E', '2023-01-01', '2023-05-20'),
    (6, 'Project F', '2023-01-01', '2023-06-15'),
    (7, 'Project G', '2023-01-01', '2023-07-10'),
    (8, 'Project H', '2023-01-01', '2023-08-05'),
    (1, 'Project I', '2023-01-01', '2024-01-10'),
    (1, 'Project J', '2023-01-01', '2031-01-01'),
    (8, 'Project K', '2023-01-01', '2023-02-15');

INSERT INTO
    project_worker (project_id, worker_id)
VALUES
    (1, 1),
    (2, 2),
    (2, 15),
    (3, 3),
    (3, 5),
    (3, 14),
    (4, 4),
    (4, 6),
    (4, 9),
    (4, 13),
    (5, 2),
    (5, 7),
    (6, 3),
    (6, 8),
    (7, 4),
    (7, 8),
    (7, 12),
    (8, 1),
    (8, 11),
    (9, 8),
    (10, 1),
    (10, 5),
    (10, 6),
    (10, 10),
    (10, 11),
    (11, 4),
    (11, 10);