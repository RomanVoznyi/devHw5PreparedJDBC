SELECT
    'ELDEST' type,
    name,
    birthday
from
    worker
where
    birthday = (
        SELECT
            MIN(birthday)
        from
            worker
    )
UNION
SELECT
    'YOUNGEST' type,
    name,
    birthday
from
    worker
where
    birthday = (
        SELECT
            MAX(birthday)
        from
            worker
    );