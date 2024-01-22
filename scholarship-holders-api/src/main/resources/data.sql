INSERT INTO tb_scholar (id, full_name, document, document_type, bank_code, bank_agency, account_number, created_at,
                        updated_at)
VALUES ('fe9835dc-2da1-4c46-8024-bbed512e173d', 'John Doe', '123456789', 'CPF', 10, 1234, 123456, NOW(), NOW());

INSERT INTO tb_payment (id, payment_status, scholar_id, amount, payment_date, created_at, updated_at)
VALUES ('fe9835dc-2da1-4c46-8024-bbed512e173e', 'PAID', 'fe9835dc-2da1-4c46-8024-bbed512e173d', 100.00, '2022-01-01', NOW(), NOW());
