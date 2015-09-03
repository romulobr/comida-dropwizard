INSERT INTO user_ (name, encrypted_password) VALUES ('monkey', 'pretendItIsEncrypted');

INSERT INTO group_ (name, encrypted_password) VALUES ('group 1', 'pretendItIsEncrypted');
INSERT INTO group_ (name, encrypted_password) VALUES ('group 2', 'pretendItIsEncrypted');

INSERT INTO user_group_ (user_id, group_id) VALUES (1, 1);

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 1', 'first restaurant', 'https://www.google.com/images/srpr/logo11w.png', '10.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 2', 'second restaurant', 'https://www.google.com/images/srpr/logo11w.png', '11.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 3', 'third restaurant', 'https://www.google.com/images/srpr/logo11w.png', '12.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (2, 'restaurant from another group', 'alien restaurant', 'https://www.google.com/images/srpr/logo11w.png', '8.00');
