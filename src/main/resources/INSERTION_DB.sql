INSERT INTO "account"
(first_name, last_name, phone_number, user_name, password, "type")
VALUES
('Kamel', 'Zyadeh', '+375255422125', 'admin1', '12345', 'ADMIN'),
('Ali', 'Arkawazi', '+375298305587', 'taxi1', '12345', 'TAXI'),
('Raouf', 'Attar', '+375336775244', 'taxi2', '12345', 'TAXI'),
('Ziad', 'Al-Sarih', '+375444722956', 'client1', '12345', 'CLIENT');

INSERT INTO "location"
(lng, lat, account_id)
VALUES
(27.561523, 53.904541, 2),
(27.561523, 53.904541, 3);

INSERT INTO "transaction"
("date", "type")
VALUES
('2021-04-15', 'SUCCESSFUL'),
('2021-01-17', 'FAILED');

INSERT INTO "order"
(taxi_id, client_id, source_id, destination_id, transaction_id, price, "date", "type")
VALUES
(2, 1, 1, 1, 2, 7.30, '2021-04-15', 'FAILED'),
(3, 4, 2, 2, 1, 17.30, '2021-01-17', 'FAILED');

INSERT INTO taxi_orders
(order_id, taxi_id)
VALUES
(1, 2),
(2, 3);

INSERT INTO client_orders
(order_id, client_id)
VALUES
(1, 4),
(2, 4);



