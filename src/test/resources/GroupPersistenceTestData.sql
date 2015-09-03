INSERT INTO user_ (name, encrypted_password) VALUES ('monkey', 'pretendItIsEncrypted');
INSERT INTO user_ (name, encrypted_password) VALUES ('zebra', 'pretendItIsAlsoEncrypted');

INSERT INTO group_ (name, encrypted_password) VALUES ('group 1', 'pretendItIsEncrypted');
INSERT INTO group_ (name, encrypted_password) VALUES ('group 2', 'pretendItIsEncrypted');
INSERT INTO group_ (name, encrypted_password) VALUES ('group 3', 'pretendItIsEncrypted');

INSERT INTO user_group_ (user_id, group_id) VALUES (1, 1);
INSERT INTO user_group_ (user_id, group_id) VALUES (1, 2);
INSERT INTO user_group_ (user_id, group_id) VALUES (1, 3);
