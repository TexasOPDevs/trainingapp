use training_db;

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
(32, 'jason@jason.jason', 'jason', 'lindsey', '$2a$10$Al3p7.hhdQHX6LMU6CaoYOwSWCW6vx6CY8Q0bN0GDtrl0AcCif.VO', 2222222222, 'jason', 'coordinator')
