DELETE FROM TRANSACTIONS;

DELETE FROM WALLETS;

INSERT INTO WALLETS (ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE)
VALUES (1, 'Jefferson - user', 12345678900, 'jefferson@test.com', '12345', 1, 1000.00);

INSERT INTO WALLETS (ID, FULL_NAME, CPF, EMAIL, "PASSWORD", "TYPE", BALANCE)
VALUES (2, 'Je - lojista', 12345678901, 'je@test.com', '12345', 2, 1000.00) 