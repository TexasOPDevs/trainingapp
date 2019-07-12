use training_db;

INSERT into status(name)
VALUES ('pending'),
       ('approved'),
       ('rejected');

INSERT into role (name, user_id)
VALUES ('coordinator', 1),
       ('instructor', 2),
       ('coordinator', 3),
       ('student', 4),
       ('student', 5),
       ('student', 6),
       ('student', 7),
       ('instructor', 8),
       ('student', 9),
       ('student', 10);


INSERT into provider(image, name, coordinator_id)
VALUES ('https://www.ripleys.com/wp-content/uploads/2015/08/shrunken-heads_s06.jpg', 'org_1', 1),
       ('https://www.ripleys.com/wp-content/uploads/2015/08/shrunken-heads_s06.jpg', 'org_2', 3);