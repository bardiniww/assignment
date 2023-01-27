CREATE TABLE cash_agent_type (
    id INT NOT NULL UNIQUE,
    description VARCHAR(500) NOT NULL
);

INSERT INTO cash_agent_type VALUES
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
    amount DECIMAL NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (creditor_cash_agent_id) REFERENCES cash_agent (id),
    FOREIGN KEY (debtor_cash_agent_id) REFERENCES cash_agent (id),
    FOREIGN KEY (type_id) REFERENCES cash_transaction_type (id)
);

CREATE INDEX cash_transaction_creditor_cash_agent_id_idx on cash_transaction using btree (creditor_cash_agent_id);
CREATE INDEX cash_transaction_debtor_cash_agent_id_idx on cash_transaction using btree (debtor_cash_agent_id);


