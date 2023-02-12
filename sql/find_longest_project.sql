SELECT
    id,
    project_name,
    month_count
FROM
    (
        SELECT
            id,
            name AS project_name,
            ROUND(DAY(finish_date - start_date) / 30.0, 1) AS month_count
        FROM
            project
    )
WHERE
    month_count = (
        SELECT
            MAX(month_count)
        FROM
            (
                SELECT
                    ROUND(DAY(finish_date - start_date) / 30.0, 1) AS month_count
                FROM
                    project
            )
    );