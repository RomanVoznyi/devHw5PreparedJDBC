SELECT
    project_name,
    SUM(project_worker_salary) AS price
FROM
    (
        SELECT
            project.name AS project_name,
            ROUND(
                DAY(project.finish_date - project.start_date) / 30.0,
                1
            ) * worker.salary AS project_worker_salary
        FROM
            project_worker
            JOIN project ON project_id = project.id
            JOIN worker ON worker_id = worker.id
    )
GROUP BY
    project_name
ORDER BY
    price DESC;