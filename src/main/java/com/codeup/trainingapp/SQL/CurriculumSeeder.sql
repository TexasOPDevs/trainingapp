use training_db;

INSERT INTO training_db.curriculum ( capacity, certification, outline, creationDate, description, learning_objectives, name, updateDate, provider_id) VALUES ( 16, 'CPR Certification', 'Local classes held at convenient locations and times which allow you to participate in hands-on training. You will learn from experienced instructors and receive full certification.
', '2019-07-12', 'The Adult and Pediatric First Aid/CPR/AED course incorporates the latest science and teaches students to recognize and care for a variety of first aid emergencies such as burns, cuts, scrapes, sudden illnesses, head, neck, back injuries, heat and cold emergencies and how to respond to breathing and cardiac emergencies to help victims of any age - adults (about 12 years and older) and pediatric (infants and children up to 12 years of age). Students who successfully complete this course will receive a certificate for Adult and Pediatric First Aid/CPR/AED valid for two years.', 'You will learn to do CPR', 'CPR Class', '2019-07-12', 1);
INSERT INTO training_db.curriculum ( capacity, certification, outline, creationDate, description, learning_objectives, name, updateDate, provider_id) VALUES ( 25, 'EMT Certification', 'This course is the required course for any person seeking to become a state certified Emergency Medical Technician - Basic (EMT-B). The course is based on the Department of Transportation''s (DOT) 1994 EMT-Basic curriculum. This course has been developed for individuals who desire to perform emergency medical care.', '2019-07-26', 'Emergency Medical Technicians provide out of hospital emergency medical care and transportation for critical and emergent patients who access the emergency medical services (EMS) system. EMTs have the basic knowledge and skills necessary to stabilize and safely transport patients ranging from non-emergency and routine medical transports to life threatening emergencies. Emergency Medical Technicians function as part of a comprehensive EMS response system, under medical oversight. Emergency Medical Technicians perform interventions with the basic equipment typically found on an ambulance. Emergency Medical Technicians are a critical link between the scene of an emergency and the health care system. ', 'You will learn to become an EMT', 'EMT Class', '2019-07-12', 2);
INSERT INTO training_db.curriculum ( capacity, certification, outline, creationDate, description, learning_objectives, name, updateDate, provider_id) VALUES ( 36, 'EMR Certification', 'You will learn the basics of teh EMR course.', '2019-07-10', 'Emergency Medical Responders provide immediate lifesaving care to critical patients who access the emergency medical services system. EMRs have the knowledge and skills necessary to provide immediate lifesaving interventions while awaiting additional EMS resources to arrive. EMRs also provide assistance to higher-level personnel at the scene of emergencies and during transport. Emergency Medical Responders are a vital part of the comprehensive EMS response. Under medical oversight, Emergency Medical Responders perform basic interventions with minimal equipment. ', 'You will learn to become a EMR', 'EMR Class', '2019-07-12', 1);
INSERT INTO training_db.curriculum ( capacity, certification, outline, creationDate, description, learning_objectives, name, updateDate, provider_id) VALUES ( 45, 'AEMT Certification', 'This course is to prepare you for the live of a AEMT.', '2019-07-03', 'The primary focus of the Advanced Emergency Medical Technician is to provide basic and limited advanced emergency medical care and transportation for critical and emergent patients who access the emergency medical system. This individual possesses the basic knowledge and skills necessary to provide patient care and transportation. Advanced Emergency Medical Technicians function as part of a comprehensive EMS response, under medical oversight. Advanced Emergency Medical Technicians perform interventions with the basic and advanced equipment typically found on an ambulance. The Advanced Emergency Medical Technician is a link from the scene to the emergency health care system. ', 'You will learn to be a AEMT', 'AEMT CLass', '2019-07-12', 1);


insert into curriculum_material (curriculum_id, material_id)
VALUES (2,1),
       (2,2),
       (2,3),
       (3,2),
       (3,5),
       (4,3),
       (5,1),
       (5,2)
