INSERT INTO user_ (name, encrypted_password) VALUES ('monkey', 'pretendItIsEncrypted');

INSERT INTO group_ (name, encrypted_password) VALUES ('group 1', 'pretendItIsEncrypted');

INSERT INTO user_group_ (user_id, group_id) VALUES (1, 1);

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 1', 'first restaurant', 'https://www.google.com/images/srpr/logo11w.png', '10.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 2', 'second restaurant', 'https://www.google.com/images/srpr/logo11w.png', '11.00');

INSERT INTO restaurant_item_ (restaurant_id, name, description, price)
VALUES (1, 'item 1', 'coke 2L', '5.00');

INSERT INTO restaurant_item_ (restaurant_id, name, description, price)
VALUES (1, 'item 2', 'coke 600ml', '2.00');

INSERT INTO restaurant_item_ (restaurant_id, name, description, price)
VALUES (2, 'item 3', 'coke 2L', '5.00');

INSERT INTO restaurant_item_ (restaurant_id, name, description, price)
VALUES (2, 'item 4', 'coke 600ml', '2.00');

INSERT INTO restaurant_item_ (restaurant_id, name, description, price)
VALUES (2, 'item 4', 'chiken', '4.00');

