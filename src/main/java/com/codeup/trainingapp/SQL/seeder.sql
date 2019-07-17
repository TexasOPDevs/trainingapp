use training_db;

# INSERT into status(name)
# VALUES ('pending'),
#        ('approved'),
#        ('rejected'),
#        ('active'),
#        ('closed');

# INSERT into role (name, user_id)
# VALUES ('coordinator', 1),
#        ('instructor', 2),
#        ('coordinator', 3),
#        ('student', 4),
#        ('student', 5),
#        ('student', 6),
#        ('student', 7),
#        ('instructor', 8),
#        ('student', 9),
#        ('student', 10);


# INSERT into provider(image, name, coordinator_id)
# VALUES ('https://www.ripleys.com/wp-content/uploads/2015/08/shrunken-heads_s06.jpg', 'org_1', 1),
#        ('https://www.ripleys.com/wp-content/uploads/2015/08/shrunken-heads_s06.jpg', 'org_2', 3);

# INSERT INTO material(name)
# VALUES ('book'),
#        ('scissors'),
#        ('taser'),
#        ('bullets'),
#        ('cpr doll'),
#        ('candy'),
#        ('cold one');

# INSERT INTO course (end_date, evaluation_file, location, start_date, start_time, curriculum_id, status_id)
# VALUES ('2017-06-15', 'placeholder', '5008 stowers blvd', '2017-06-02', '08:00:00', 2, 4),
#        ('2019-03-18', 'placeholder', '5008 stowers blvd', '2019-07-30', '09:00:00', 2, 4),
#        ('2019-04-15', 'placeholder', '5008 stowers blvd', '2019-05-02', '14:00:00', 2, 4);

INSERT INTO student (course, status_id, user_id)
VALUES (4, 2, 1),
       (4, 2, 2),
       (4, 2, 3),
       (4, 2, 4),
       (4, 2, 5),
       (4, 2, 6),
       (4, 2, 7),
       (4, 2, 8),
       (4, 2, 9),
       (4, 2, 10);



insert into user_provider (user_id, provider_id)
VALUES (1, 2),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 2);




# insert into role (name, user_id)
# VALUES ('instructor', 1);


# insert into instructors (course_id, user_id)
# values (4, 1);
#
# insert into attendances (id, date, present, course_id, user_id)
# values (1, '2017-06-02', 1, 4, 2),
#        (2, '2017-06-02', 1, 4, 3),
#        (3, '2017-06-02', 1, 4, 2),
#        (4, '2017-06-02', 1, 4, 3)

