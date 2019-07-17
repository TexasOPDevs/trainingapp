use training_db;

INSERT INTO training_db.material (id, name) VALUES (1, 'book');
INSERT INTO training_db.material (id, name) VALUES (2, 'scissors');
INSERT INTO training_db.material (id, name) VALUES (3, 'taser');
INSERT INTO training_db.material (id, name) VALUES (4, 'bullets');
INSERT INTO training_db.material (id, name) VALUES (5, 'cpr doll');
INSERT INTO training_db.material (id, name) VALUES (6, 'candy');
INSERT INTO training_db.material (id, name) VALUES (7, 'cold one');
INSERT INTO training_db.material (id, name) VALUES (8, 'book');
INSERT INTO training_db.material (id, name) VALUES (9, 'scissors');
INSERT INTO training_db.material (id, name) VALUES (10, 'taser');
INSERT INTO training_db.material (id, name) VALUES (11, 'bullets');
INSERT INTO training_db.material (id, name) VALUES (12, 'cpr doll');
INSERT INTO training_db.material (id, name) VALUES (13, 'candy');
INSERT INTO training_db.material (id, name) VALUES (14, 'cold one');

INSERT INTO training_db.status (id, name) VALUES (101, 'enrolled');
INSERT INTO training_db.status (id, name) VALUES (102, 'pending');
INSERT INTO training_db.status (id, name) VALUES (103, 'rejected');
INSERT INTO training_db.status (id, name) VALUES (104, 'credited');
INSERT INTO training_db.status (id, name) VALUES (201, 'active');
INSERT INTO training_db.status (id, name) VALUES (202, 'assigned');
INSERT INTO training_db.status (id, name) VALUES (203, 'closed');
INSERT INTO training_db.status (id, name) VALUES (204, 'open for enrollment');

insert into user (id, email, first_name, last_name, password, phone, username, role)
values
(1, 'johndoe@email.com', 'John','Doe', 'pass', 1111111, 'johndoe', 'instructor'),
(2, 'janedoe@email.com', 'Jane','Doe', 'pass', 2222222, 'janedoe', 'instructor'),
(3, 'billykid@email.com', 'Billy','Kid', 'pass', 3333333, 'billykid', 'coordinator'),
(4, 'johnwayne@email.com', 'John','Wayne', 'pass', 4444444, 'johnwayne', 'student'),
(5, 'michaeljordan@email.com', 'Michael','Jordan', 'pass', 5555555, 'michaeljordan', 'student'),
(6, 'chrisprat@email.com', 'Chris','Prat', 'pass', 6666666, 'chrisprat', 'student'),
(7, 'donaldduck@email.com', 'Donald','Duck', 'pass', 7777777, 'donaldduck', 'student'),
(8, 'fermendoza@email.com', 'Fer','Mendoza', 'pass', 88888888,' fermendoza', 'student'),
(9, 'sammoore@email.com', 'Sam', ' Moore', 'pass', 9999999, 'sammoore', 'student'),
(10, 'johnnycash@email.com', 'Johnny','Cash', 'pass', 1234567, 'johnnycash', 'instructor'),
(32, 'jason@jason.jason', 'jason', 'lindsey', '$2a$10$Al3p7.hhdQHX6LMU6CaoYOwSWCW6vx6CY8Q0bN0GDtrl0AcCif.VO', 2222222222, 'jason', 'coordinator');

INSERT into provider(image, name, coordinator_id)
VALUES ('https://www.ripleys.com/wp-content/uploads/2015/08/shrunken-heads_s06.jpg', 'org_1', 1),
       ('https://www.ripleys.com/wp-content/uploads/2015/08/shrunken-heads_s06.jpg', 'org_2', 32);


INSERT INTO training_db.curriculum ( capacity, certification, course_outline, creation_date, description, learning_objectives, name, update_date, provider_id) VALUES ( 16, 'CPR Certification', 'Local classes held at convenient locations and times which allow you to participate in hands-on training. You will learn from experienced instructors and receive full certification.
', '2019-07-12', 'The Adult and Pediatric First Aid/CPR/AED course incorporates the latest science and teaches students to recognize and care for a variety of first aid emergencies such as burns, cuts, scrapes, sudden illnesses, head, neck, back injuries, heat and cold emergencies and how to respond to breathing and cardiac emergencies to help victims of any age - adults (about 12 years and older) and pediatric (infants and children up to 12 years of age). Students who successfully complete this course will receive a certificate for Adult and Pediatric First Aid/CPR/AED valid for two years.', 'You will learn to do CPR', 'CPR Class', '2019-07-12', 1);
INSERT INTO training_db.curriculum ( capacity, certification, course_outline, creation_date, description, learning_objectives, name, update_date, provider_id) VALUES ( 25, 'EMT Certification', 'This course is the required course for any person seeking to become a state certified Emergency Medical Technician - Basic (EMT-B). The course is based on the Department of Transportation''s (DOT) 1994 EMT-Basic curriculum. This course has been developed for individuals who desire to perform emergency medical care.', '2019-07-26', 'Emergency Medical Technicians provide out of hospital emergency medical care and transportation for critical and emergent patients who access the emergency medical services (EMS) system. EMTs have the basic knowledge and skills necessary to stabilize and safely transport patients ranging from non-emergency and routine medical transports to life threatening emergencies. Emergency Medical Technicians function as part of a comprehensive EMS response system, under medical oversight. Emergency Medical Technicians perform interventions with the basic equipment typically found on an ambulance. Emergency Medical Technicians are a critical link between the scene of an emergency and the health care system. ', 'You will learn to become an EMT', 'EMT Class', '2019-07-12', 2);
INSERT INTO training_db.curriculum ( capacity, certification, course_outline, creation_date, description, learning_objectives, name, update_date, provider_id) VALUES ( 36, 'EMR Certification', 'You will learn the basics of teh EMR course.', '2019-07-10', 'Emergency Medical Responders provide immediate lifesaving care to critical patients who access the emergency medical services system. EMRs have the knowledge and skills necessary to provide immediate lifesaving interventions while awaiting additional EMS resources to arrive. EMRs also provide assistance to higher-level personnel at the scene of emergencies and during transport. Emergency Medical Responders are a vital part of the comprehensive EMS response. Under medical oversight, Emergency Medical Responders perform basic interventions with minimal equipment. ', 'You will learn to become a EMR', 'EMR Class', '2019-07-12', 1);
INSERT INTO training_db.curriculum ( capacity, certification, course_outline, creation_date, description, learning_objectives, name, update_date, provider_id) VALUES ( 45, 'AEMT Certification', 'This course is to prepare you for the live of a AEMT.', '2019-07-03', 'The primary focus of the Advanced Emergency Medical Technician is to provide basic and limited advanced emergency medical care and transportation for critical and emergent patients who access the emergency medical system. This individual possesses the basic knowledge and skills necessary to provide patient care and transportation. Advanced Emergency Medical Technicians function as part of a comprehensive EMS response, under medical oversight. Advanced Emergency Medical Technicians perform interventions with the basic and advanced equipment typically found on an ambulance. The Advanced Emergency Medical Technician is a link from the scene to the emergency health care system. ', 'You will learn to be a AEMT', 'AEMT CLass', '2019-07-12', 1);

insert into curriculum_material (curriculum_id, material_id)
VALUES (2,1),
       (2,2),
       (2,3),
       (3,2),
       (3,4),
       (4,3),
       (4,1),
       (2,2);

INSERT INTO course (end_date, evaluation_file, location, start_date, start_time, curriculum_id, status_id)
VALUES ('2017-06-15', 'placeholder', '5008 stowers blvd', '2017-06-02', '08:00:00', 2, 201),
       ('2019-03-18', 'placeholder', '5008 stowers blvd', '2019-07-30', '09:00:00', 2, 202),
       ('2019-04-15', 'placeholder', '5008 stowers blvd', '2019-05-02', '14:00:00', 2, 203);



insert into instructors (course_id, user_id)
values (4, 1),
       (5, 1),
       (6,1);



INSERT INTO student (course, status_id, user_id)
VALUES (4, 101, 1),
       (4, 101, 2),
       (4, 101, 3),
       (4, 101, 4),
       (4, 101, 5),
       (4, 101, 6),
       (4, 101, 7),
       (4, 101, 8),
       (4, 101, 9),
       (4, 101, 10);


insert into user_provider (user_id, provider_id)
VALUES (1, 2),
       (2, 2),
       (3, 2),
       (4, 2),
       (5, 1),
       (6, 1),
       (7, 1),
       (8, 2);