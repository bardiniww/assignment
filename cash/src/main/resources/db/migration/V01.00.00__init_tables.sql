CREATE TABLE IF NOT EXISTS cash_agent (
    id BIGSERIAL PRIMARY KEY,
    account_id INT UNIQUE NOT NULL,
    type_id INT NOT NULL
);