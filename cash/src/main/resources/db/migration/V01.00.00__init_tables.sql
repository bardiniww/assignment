CREATE TABLE cash_agent_type (
    id INT NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL
);

INSERT INTO cash_agent_type VALUES
(0, 'System'),
(1, 'Pure customer'),
(2, 'Huge company');

CREATE TABLE cash_agent (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    account_id BIGINT UNIQUE NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (type_id) REFERENCES cash_agent_type (id)
);



CREATE TABLE cash_transaction_type (
                                 id INT NOT NULL UNIQUE,
                                 description VARCHAR(500) NOT NULL
);

INSERT INTO cash_transaction_type VALUES
                                (1, 'Initial accrual'),
                                (2, 'Money transfer'),
                                (3, 'Purchase operation');



CREATE TABLE cash_transaction (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    creditor_cash_agent_id BIGINT NOT NULL,
    debtor_cash_agent_id BIGINT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (creditor_cash_agent_id) REFERENCES cash_agent (id),
    FOREIGN KEY (debtor_cash_agent_id) REFERENCES cash_agent (id),
    FOREIGN KEY (type_id) REFERENCES cash_transaction_type (id)
);

CREATE INDEX cash_transaction_creditor_cash_agent_id_idx on cash_transaction using btree (creditor_cash_agent_id);
CREATE INDEX cash_transaction_debtor_cash_agent_id_idx on cash_transaction using btree (debtor_cash_agent_id);


CREATE VIEW cash_balance AS
SELECT cash_agent.id AS cash_agent_id,
       COALESCE(SUM(CASE WHEN cash_transaction.creditor_cash_agent_id = cash_agent.id THEN cash_transaction.amount ELSE 0 END),0) AS credit,
       COALESCE(SUM(CASE WHEN cash_transaction.debtor_cash_agent_id = cash_agent.id THEN cash_transaction.amount ELSE 0 END),0) AS debit,
       COALESCE(SUM(CASE WHEN cash_transaction.creditor_cash_agent_id = cash_agent.id THEN -cash_transaction.amount ELSE cash_transaction.amount END),0) AS balance
FROM cash_agent
         LEFT JOIN cash_transaction ON cash_agent.id = cash_transaction.creditor_cash_agent_id OR cash_agent.id = cash_transaction.debtor_cash_agent_id
GROUP BY cash_agent.id;



