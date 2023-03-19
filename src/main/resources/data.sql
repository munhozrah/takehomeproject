INSERT INTO students (
        id, 
        first_name, 
        last_name, 
        dob, 
        addr, 
        email, 
        phone_number
     ) VALUES (
        'c75122b1-f0f6-4111-bf45-a03fa20e876a', 
        'JOHN', 
        'BLACK', 
        '1987-12-18', 
        '2140 MAIN ST SUITE C, RED BLUFF, CA 96080, UNITED STATES', 
        'john.black@mail.com', 
        '+1 530-527-4729');

INSERT INTO courses (
        id, 
        course_name)
     VALUES (
        'd0ce3a0a-86f9-49f7-a609-65f90ff78b3e',
        'Computer Science'
     );

INSERT INTO registrations (
        id, 
        student_id,
        course_id)
     VALUES (
        'a4e3ecdf-1e27-442d-b9bb-0870e642e21e',
        'c75122b1-f0f6-4111-bf45-a03fa20e876a',
        'd0ce3a0a-86f9-49f7-a609-65f90ff78b3e'
     );

INSERT INTO task_category (
        id, 
        category_type)
     VALUES (
        1,
        'RESEARCHING'
    );

INSERT INTO task_category (
        id, 
        category_type)
     VALUES (
        2,
        'PRACTICING'
    );


INSERT INTO task_category (
        id, 
        category_type)
     VALUES (
        3,
        'WATCHING VIDEOS'
    );

INSERT INTO students_tasks (
    id,
    registration_id,
    task_date,
    category_id,
    time_spent)
     VALUES (
        '42dbc281-7aab-418a-901e-aea757639000',
        'a4e3ecdf-1e27-442d-b9bb-0870e642e21e',
        '2023-03-17',
        1,
        30
    );

INSERT INTO users(username, passwd, dt_creation) VALUES ('john.black', '1234', '2023-03-17');

INSERT INTO user_roles(username, role_name) VALUES ('john.black', 'ADMIN');

COMMIT;