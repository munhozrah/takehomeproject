DROP TABLE IF EXISTS user_roles;
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

CREATE TABLE IF NOT EXISTS courses (
    id UUID PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    duration INT NOT NULL
);

CREATE TABLE IF NOT EXISTS registrations (
    id UUID PRIMARY KEY,
    student_id UUID NOT NULL,
    course_id  UUID NOT NULL,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id)  REFERENCES courses(id)
);

CREATE TABLE IF NOT EXISTS task_category (
    id INT PRIMARY KEY,
    category_type VARCHAR(20) NOT NULL
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

CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(20) PRIMARY KEY,
    passwd VARCHAR(50) NOT NULL,
    dt_creation DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
    username VARCHAR(20) PRIMARY KEY,
    role_name VARCHAR(20) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
);