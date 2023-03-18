DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS students_tasks;
DROP TABLE IF EXISTS task_category;
DROP TABLE IF EXISTS registrations;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS students;

CREATE TABLE IF NOT EXISTS students (
    id UUID PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    addr VARCHAR(100) NOT NULL, 
    email VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

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

CREATE TABLE IF NOT EXISTS courses (
    id UUID PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL
);

INSERT INTO courses (
        id, 
        course_name)
     VALUES (
        'd0ce3a0a-86f9-49f7-a609-65f90ff78b3e',
        'Computer Science'
     );

CREATE TABLE IF NOT EXISTS registrations (
    id UUID PRIMARY KEY,
    student_id UUID NOT NULL,
    course_id  UUID NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id)  REFERENCES courses(id)
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

CREATE TABLE IF NOT EXISTS task_category (
    id INT PRIMARY KEY,
    category_type VARCHAR(20) NOT NULL
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

CREATE TABLE IF NOT EXISTS students_tasks (
    id UUID PRIMARY KEY,
    registration_id UUID NOT NULL,
    task_date DATE NOT NULL,
    category_id INT NOT NULL,
    time_spent INT NOT NULL,
    FOREIGN KEY (registration_id) REFERENCES registrations(id),
    FOREIGN KEY (category_id) REFERENCES task_category(id)
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

CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(20) PRIMARY KEY,
    passwd VARCHAR(50) NOT NULL,
    dt_creation DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
    id INT PRIMARY KEY,
    role_description VARCHAR(20) NOT NULL
);

INSERT INTO users(username, passwd, dt_creation) VALUES ('john.black', 'encrypted stuff', '2023-03-17');

INSERT INTO roles (id, role_description) VALUES (1, 'STUDENT');

INSERT INTO roles (id, role_description) VALUES (2, 'ADMIN');

CREATE TABLE IF NOT EXISTS user_roles (
    username VARCHAR(20) PRIMARY KEY,
    role_id INT NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO user_roles(username, role_id) VALUES ('john.black', 1);