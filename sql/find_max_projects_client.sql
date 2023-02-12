SELECT
    name,
    project_count
FROM
    (
        SELECT
            name,
            count(client_id) AS project_count
        FROM
            (
                SELECT
                    client.name as name,
                    client_id
                FROM
                    project
                    JOIN client ON client_id = client.id
            )
        GROUP BY
            client_id
    )
WHERE
    project_count = (
        SELECT
            MAX(project_count)
        FROM
            (
                SELECT
                    count(client_id) AS project_count
                FROM
                    project
                GROUP BY
                    client_id
            )
    );