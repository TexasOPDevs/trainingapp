use training_db;

insert into material (id, name)
values (1, 'Duty Weapon'),
       (2, 'Body Worn Camera'),
       (3, 'Notebook'),
       (4, 'First Aid Kit'),
       (5, 'Body Armor'),
       (6, 'Range PPE');



INSERT INTO status (id, name)
VALUES (101, 'enrolled'),
       (102, 'pending'),
       (103, 'rejected'),
       (104, 'credited'),
       (201, 'active'),
       (202, 'assigned'),
       (203, 'closed'),
       (204, 'open for enrollment');

INSERT INTO training_db.user (id, email, first_name, last_name, password, phone, username, bio, role, img)
VALUES (1, 'nec@nec.co.uk', 'Sam', 'Moore', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(976) 328-7437', 'instructor', null, 'instructor', 'https://fer-uig.glitch.me'),
       (2, 'risus.at@euismodurnaNullam.org', 'Lucy', 'Jorden', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(810) 280-2106', 'Donec', null, 'instructor', 'https://fer-uig.glitch.me'),
       (3, 'ridiculus.mus@Nullafacilisis.edu', 'Wyoming', 'Zelenia', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(199) 264-2861', 'rutrum', null, 'student', 'https://fer-uig.glitch.me'),
       (4, 'libero.Donec@tellussem.co.uk', 'Johnny', 'Ruiz', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(511) 108-6330', 'student', null, 'student', 'https://fer-uig.glitch.me'),
       (5, 'neque@auguescelerisque.ca', 'Emi', 'Preston', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq,', '(361) 328-5613', 'eu,', null, 'student', 'https://fer-uig.glitch.me'),
       (6, 'tincidunt.aliquam@eumetusIn.org', 'Maite', 'Leandra', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(216) 600-9028', 'non', null, 'student', 'https://fer-uig.glitch.me'),
       (7, 'auctor@mollisneccursus.edu', 'Keaton', 'Thor', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(471) 173-2829', 'Integer', null, 'student', 'https://fer-uig.glitch.me'),
       (8, 'eu.lacus.Quisque@elit.ca', 'Constance', 'Odysseus', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(873) 416-6450', 'quam.', null, 'student', 'https://fer-uig.glitch.me'),
       (9, 'auctor@Nuncullamcorpervelit.org', 'Mark', 'Castor', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(572) 793-0296', 'arcu.', null, 'student', 'https://fer-uig.glitch.me'),
       (10, 'lacus@Maecenasmalesuadafringilla.edu', 'Christian', 'Hermione', 'Aliquam', '(964) 487-9478', 'et', null, 'student', 'https://fer-uig.glitch.me'),
       (11, 'libero.Proin@semperrutrumFusce.edu', 'Hashim', 'Sean', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(907) 231-0294', 'mi', null, 'student', 'https://fer-uig.glitch.me'),
       (12, 'massa@diamlorem.ca', 'Zeph', 'Karly', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq,', '(993) 739-8126', 'adipiscing', null, 'student', 'https://fer-uig.glitch.me'),
       (13, 'Quisque@velquam.ca', 'Brody', 'Dean', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(187) 644-6940', 'in,', null, 'student', 'https://fer-uig.glitch.me'),
       (14, 'nonummy@malesuadamalesuadaInteger.co.uk', 'Dylan', 'Ginger', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(109) 964-8734', 'porttitor', null, 'student','https://fer-uig.glitch.me'),
       (32, 'jason@jason.com', 'Jason', 'Lindsey', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(713) 962-9143', 'coordinator', null, 'coordinator', 'https://fer-uig.glitch.me'),
       (38, 'Nam.consequat.dolor@metus.co.uk', 'Sean', 'Nathaniel', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(829) 444-9732', 'molestie', null, 'instructor', 'https://fer-uig.glitch.me'),
       (39, 'eleifend.nunc@euodio.co.uk', 'Bell', 'Cameron', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(711) 769-7228', 'Tuam', null, 'instructor', 'https://fer-uig.glitch.me'),
       (40, 'non@acfeugiatnon.net', 'Rhonda', 'Dahlia', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(297) 398-4344', 'purus', null, 'instructor', 'https://fer-uig.glitch.me'),
       (41, 'elementum.lorem.ut@dolorFuscemi.ca', 'Melanie', 'Vance', '$2a$10$W33b0ii4ZPRlSF14uvk1SuuQ/qiIfXYvZrI1.KhOQd.9rW4FdgYMq', '(760) 663-2027', 'in', null, 'instructor', 'https://fer-uig.glitch.me');


INSERT INTO provider (id, image, name, coordinator_id)
VALUES (1, 'https://media.licdn.com/dms/image/C4E0BAQFmQKOT4l12NA/company-logo_200_200/0?e=2159024400&v=beta&t=93dv9NPLRwlQAzhJgzso3IAegJzWV9SfVITQ9dlSF2I', 'San Antonio Police Department', 1),
       (2, '/topcounty.png', 'TOP Police Dept.', 32);



INSERT INTO training_db.curriculum (id, creation_date, description, learning_objectives, name, update_date, provider_id)
VALUES       (3,  '2019-07-12', 'In this course the student will be able to use a technique of manually compressing the heart
from the exterior
of
the chest and then breathing for the victim hoping to keep them alive until the arrival of the paramedics', 'Demonstrate CPR techniques', 'CPR Class',
              '2019-07-12',
              2),
             (2,  '2019-07-26', 'Course for a individual seeking their basic jailer''s license', '1. To feel secure in
your job
2. To be able to respond in a professional manner to as many known situations as
can reasonably be expected to occur
3. To prevent the escape of persons placed in your custody
4. To understand that the violations of any constitutional right of an inmate will have
the highest potential for personnel or agency liability
5. To hold yourself in high esteem
6. To be acquainted with cultural differences and diversity of individuals you will be
interacting with in your custody ', 'Basic County Jailer''s Course', '2019-07-12', 2),
             (4,  '2019-07-10', 'To increase the law enforcement communities awareness of the issue of human trafficking, through the exposure of information including: victim identification, investigation, rescue and prosecution considerations, referral and service providers availability, the critical need for development of a coordinated community response and the inter-connectivity of  state, federal and global human trafficking concerns.', '1.   Describe the concept of Human Trafficking from a global perspective
2.   Discuss definitions of the term human trafficking, based on international and U.S. laws
3.   List the different forms of human trafficking
4.   Summarize the history of human trafficking
5.   Discuss modern trafficking patterns
6.   Discuss the factors giving rise to human trafficking
7.   Explain the stages of human trafficking
8.   Describe characteristics predominant in the identification of offenders, victims, and consumers
9.   Discuss the art of control over victims
10. Explain the invisibility of victims and the difficulty identifying the victim of human trafficking', 'Human Trafficking', '2019-07-12', 2),
             (5,  '2019-07-03', 'This course is required before a law enforcement agency can implement a body worn camera program.', '1. A law enforcement agency that operates a body worn camera program shall adopt a policy for use of body worn cameras.
             2. Body worn cameras are activated only for a law enforcement purpose, and the policy must include guidelines for these purposes.', 'Body Worn Cameras', '2019-07-12', 2),
             (6,  '2009-07-14', 'This course is designed to provide the county corrections officer with an understanding of use of force situations encountered in a corrections environment.', '1. The student will be able
to summarize some issues involving the
Statutory Authority for Use of Force
2. The student will be able to recognize circumstances which justify use of force to subdue inmate or defend self.
3. The student will be able to determine when the use of Force can be considered excessive.
4. The student will be able to identify possible indicators of excessive use of force.
Introduction to Use of Force
5. The student will be able to define terms relating to use of force.
6. The student will be able to recognize psychological aspects of use of force.
7. The student will be able to identification factors to consider when determining the need to use force.', 'Use of Force in a Jail', '2014-02-14', 2);


INSERT INTO training_db.course (id, capacity, end_date, evaluation_file, location, start_date, start_time,
                                curriculum_id, status_id)
VALUES (1, 28, '2020-09-07', null, 'Ap #512-4625 Cras Av.', '2019-02-22', '12:00:00', 3, 201),
       (2, 26, '2020-08-02', null, '217-1172 Ad Rd.', '2018-07-27', '16:00:00', 2, 201),
       (3, 27, '2020-04-02', null, 'P.O. Box 680, 1294 Leo, Rd.', '2019-03-30', '08:00:00', 3, 204),
       (4, 33, '2020-04-04', null, 'P.O. Box 393, 8316 Sed St.', '2019-01-23', '08:00:00', 4, 203),
       (5, 12, '2019-12-15', null, 'P.O. Box 634, 6632 Ac Street', '2019-06-04', '18:00:00', 5, 202),
       (6, 31, '2020-07-27', null, '6997 Dictum St.', '2020-01-20', '18:00:00', 6, 203),
       (7, 10, '2020-04-26', null, 'P.O. Box 641, 7303 Sem St.', '2019-09-26', '20:00:00', 6, 202),
       (8, 40, '2020-01-23', null, '180-3073 Eu Ave', '2019-09-04', '08:00:00', 3, 201),
       (9, 11, '2020-08-17', null, '7428 Lobortis Avenue', '2019-03-02', '08:00:00', 3, 204),
       (10, 21, '2020-02-21', null, '9632 Nec Rd.', '2019-08-13', '09:00:00', 6, 204),
       (11, 27, '2020-01-05', null, '4338 Senectus Rd.', '2019-10-24', '14:00:00', 5, 201),
       (12, 20, '2020-11-06', null, 'Ap #776-6206 Neque Av.', '2019-05-09', '18:00:00', 4, 203),
       (14, 39, '2020-08-17', null, 'Ap #411-631 Accumsan Road', '2019-12-10', '18:00:00', 5, 202),
       (13, 33, '2020-10-06', null, 'P.O. Box 878, 6037 Consequat Avenue', '2018-11-02', '10:00:00', 2, 201),
       (15, 25, '2020-07-16', null, '844-2922 Sed Rd.', '2019-04-22', '12:00:00', 2, 202);




INSERT INTO training_db.attendances (id, date, present, course_id, user_id)
VALUES                              (1, '2019-07-09', true, 2, 3),
                                    (2, '2019-07-09', true, 2, 4),
                                    (3, '2019-07-09', true, 2, 5),
                                    (4, '2019-07-09', true, 2, 6),
                                    (5, '2019-07-09', true, 2, 7),
                                    (6, '2019-07-09', false, 2, 8),
                                    (7, '2019-07-09', true, 2, 9),
                                    (8, '2019-07-09', true, 2, 10),
                                    (9, '2019-07-09', true, 2, 11),
                                    (10, '2019-07-09', true, 2, 12),
                                    (11, '2019-07-09', false, 2, 13),
                                    (12, '2019-07-09', true, 2, 14),
                                    (13, '2019-07-10', true, 2, 3),
                                    (14, '2019-07-10', true, 2, 4),
                                    (15, '2019-07-10', true, 2, 5),
                                    (16, '2019-07-10', false, 2, 6),
                                    (17, '2019-07-10', true, 2, 7),
                                    (18, '2019-07-10', true, 2, 8),
                                    (19, '2019-07-10', false, 2, 9),
                                    (20, '2019-07-10', true, 2, 10),
                                    (21, '2019-07-10', true, 2, 11),
                                    (22, '2019-07-10', true, 2, 12),
                                    (23, '2019-07-10', true, 2, 13),
                                    (24, '2019-07-10', true, 2, 14),
                                    (25, '2019-07-11', false, 2, 3),
                                    (26, '2019-07-11', true, 2, 4),
                                    (27, '2019-07-11', true, 2, 5),
                                    (28, '2019-07-11', false, 2, 6),
                                    (29, '2019-07-11', true, 2, 7),
                                    (30, '2019-07-11', true, 2, 8),
                                    (31, '2019-07-11', true, 2, 9),
                                    (32, '2019-07-11', false, 2, 10),
                                    (33, '2019-07-11', true, 2, 11),
                                    (34, '2019-07-11', true, 2, 12),
                                    (35, '2019-07-11', false, 2, 13),
                                    (36, '2019-07-11', true, 2, 14);

insert into curriculum_material (curriculum_id, material_id)
values  (2, 4),
        (3, 4),
        (4, 3),
        (5, 2),
        (5, 3),
        (6, 3);



insert into instructors (course_id, user_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2),
       (5, 38),
       (6, 38),
       (7, 39),
       (8, 39),
       (9, 40),
       (10, 40),
       (11, 41),
       (12, 41),
       (13, 1),
       (14, 2),
       (15, 41);


INSERT INTO training_db.student (id, course, status_id, user_id)
VALUES (1, 2, 101, 3),
       (2, 2, 101, 4),
       (3, 2, 101, 5),
       (4, 2, 101, 6),
       (5, 2, 101, 7),
       (6, 2, 101, 8),
       (7, 2, 101, 9),
       (8, 2, 101, 10),
       (9, 2, 101, 11),
       (10, 2, 101, 12),
       (11, 2, 101, 13),
       (12, 2, 101, 14),
       (13, 4, 104, 4),
       (14, 6, 104, 4);

INSERT INTO user_provider (user_id, provider_id)
VALUES (1, 2),
       (2, 2),
       (38, 2),
       (39, 2),
       (40, 2),
       (41, 2),
       (3, 2),
       (4, 2),
       (5, 2),
       (6, 2),
       (7, 2),
       (8, 2),
       (9, 2);



INSERT INTO gradeable (creation_date, name, update_date, weight, curriculum_id)
VALUES ('2019-06-09', 'Test 1', null, 20, 2),
       ('2019-06-09', 'Quiz 1', null, 10, 2),
       ('2019-06-09', 'Quiz 2', null, 20, 2),
       ('2019-06-09', 'Test 2', null, 20, 2),
       ('2019-06-09', 'Demo', null, 30, 2);




INSERT INTO gradable_student (grade, posted_at, course_id, gradable_id, user_id)
 VALUES (80, '2019-07-09', 2, 1, 3),
       (75, '2019-07-09', 2, 1, 4),
       (92, '2019-07-09', 2, 1, 5),
       (94, '2019-07-09', 2, 1, 6),
       (50, '2019-07-09', 2, 1, 7),
       (78, '2019-07-09', 2, 1, 8),
       (82, '2019-07-09', 2, 1, 9),
       (93, '2019-07-09', 2, 1, 10),
       (94, '2019-07-09', 2, 1, 11),
       (100, '2019-07-09', 2, 1, 12),
       (100, '2019-07-09', 2, 1, 13),
       (89, '2019-07-09', 2, 1, 14),

       (92, '2019-07-09', 2, 2, 3),
       (83, '2019-07-09', 2, 2, 4),
       (79, '2019-07-09', 2, 2, 5),
       (86, '2019-07-09', 2, 2, 6),
       (95, '2019-07-09', 2, 2, 7),
       (91, '2019-07-09', 2, 2, 8),
       (91, '2019-07-09', 2, 2, 9),
       (91, '2019-07-09', 2, 2, 10),
       (97, '2019-07-09', 2, 2, 11),
       (86, '2019-07-09', 2, 2, 12),
       (88, '2019-07-09', 2, 2, 13),
       (78, '2019-07-09', 2, 2, 14),

       (87, '2019-07-10', 2, 3, 3),
       (88, '2019-07-10', 2, 3, 4),
       (93, '2019-07-10', 2, 3, 5),
       (40, '2019-07-10', 2, 3, 6),
       (87, '2019-07-10', 2, 3, 7),
       (97, '2019-07-10', 2, 3, 8),
       (93, '2019-07-10', 2, 3, 9),
       (89, '2019-07-10', 2, 3, 10),
       (86, '2019-07-10', 2, 3, 11),
       (67, '2019-07-10', 2, 3, 12),
       (88, '2019-07-10', 2, 3, 13),
       (98, '2019-07-10', 2, 3, 14),

       (86, '2019-07-10', 2, 4, 3),
       (98, '2019-07-10', 2, 4, 4),
       (95, '2019-07-10', 2, 4, 5),
       (89, '2019-07-10', 2, 4, 6),
       (70, '2019-07-10', 2, 4, 7),
       (98, '2019-07-10', 2, 4, 8),
       (85, '2019-07-10', 2, 4, 9),
       (77, '2019-07-10', 2, 4, 10),
       (93, '2019-07-10', 2, 4, 11),
       (88, '2019-07-10', 2, 4, 12),
       (77, '2019-07-10', 2, 4, 13),
       (88, '2019-07-10', 2, 4, 14),

       (null, '2019-07-11', 2, 5, 3),
       (null, '2019-07-11', 2, 5, 4),
       (null, '2019-07-11', 2, 5, 5),
       (null, '2019-07-11', 2, 5, 6),
       (null, '2019-07-11', 2, 5, 7),
       (null, '2019-07-11', 2, 5, 8),
       (null, '2019-07-11', 2, 5, 9),
       (null, '2019-07-11', 2, 5, 10),
       (null, '2019-07-11', 2, 5, 11),
       (null, '2019-07-11', 2, 5, 12),
       (null, '2019-07-11', 2, 5, 13),
       (null, '2019-07-11', 2, 5, 14);

