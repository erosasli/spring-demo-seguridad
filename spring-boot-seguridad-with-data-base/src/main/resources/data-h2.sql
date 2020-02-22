-- INSERCCION DE LOS USUARIOS  Y ROLES 
INSERT INTO User (ID, enabled, password, username) VALUES (1, true, '$2a$04$04kP6Lsd4hkMuviIDX4/n.dOniRQTuGaj7OzKRXszwWJL1kxIjGQ6', 'admin');
INSERT INTO User (ID, enabled, password, username) VALUES (2, true, 'ab', 'user');
-- INSERCCION DE ROLES
INSERT INTO Authority (ID, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO Authority (ID, authority) VALUES (2, 'ROLE_USER');
-- INSERCCIONES DE AUTORITIZACION Y ROLES
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (1,1);
INSERT INTO authorities_users (usuario_id, authority_id) values (1,2);
INSERT INTO authorities_users (usuario_id, authority_id) VALUES (2,2);