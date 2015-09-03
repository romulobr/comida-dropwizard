INSERT INTO user_ (name, encrypted_password) VALUES ('monkey', 'pretendItIsEncrypted');

INSERT INTO group_ (name, encrypted_password) VALUES ('group 1', 'pretendItIsEncrypted');

INSERT INTO group_ (name, encrypted_password) VALUES ('group 2', 'pretendItIsEncrypted');

INSERT INTO user_group_ (user_id, group_id) VALUES (1, 1);

INSERT INTO user_group_ (user_id, group_id) VALUES (1, 2);

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 1 in group 1', 'first restaurant', 'https://www.google.com/images/srpr/logo11w.png', '10.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (1, 'restaurant 2 in group 1', 'second restaurant', 'https://www.google.com/images/srpr/logo11w.png', '11.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (2, 'restaurant 1 in group 2', 'first restaurant', 'https://www.google.com/images/srpr/logo11w.png', '10.00');

INSERT INTO restaurant_ (group_id, name, description, image_url, default_delivery_fee)
VALUES (2, 'restaurant 2 in group 2', 'second restaurant', 'https://www.google.com/images/srpr/logo11w.png', '11.00');


INSERT INTO order_ (restaurant_id, created_at, closes_at, delivers_at)
VALUES (1, NOW(), NOW(), NOW());

INSERT INTO order_ (restaurant_id, created_at, closes_at, delivers_at)
VALUES (1, NOW(), NOW(), NOW());

INSERT INTO order_ (restaurant_id, created_at, closes_at, delivers_at)
VALUES (1, NOW(), NOW(), NOW());

INSERT INTO order_ (restaurant_id, created_at, closes_at, delivers_at)
VALUES (1, NOW(), NOW(), NOW());

INSERT INTO order_ (restaurant_id, created_at, closes_at, delivers_at)
VALUES (4, NOW(), NOW(), NOW());

INSERT INTO order_ (restaurant_id, created_at, closes_at, delivers_at)
VALUES (4, NOW(), NOW(), NOW());