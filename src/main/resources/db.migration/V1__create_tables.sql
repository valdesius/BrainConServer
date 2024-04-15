CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       role VARCHAR(10) NOT NULL
);

CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          user_id INT UNIQUE REFERENCES users(id),
                          major VARCHAR(50),
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE mentors (
                         id SERIAL PRIMARY KEY,
                         user_id INT UNIQUE REFERENCES users(id),
                         expertise_area VARCHAR(50),
                         FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE courses (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR(100) NOT NULL,
                         mentor_id INT REFERENCES mentors(id),
                         FOREIGN KEY (mentor_id) REFERENCES mentors(id)
);

CREATE TABLE tests (
                       id SERIAL PRIMARY KEY,
                       course_id INT REFERENCES courses(id),
                       title VARCHAR(100) NOT NULL,
                       FOREIGN KEY (course_id) REFERENCES courses(id)
);

CREATE TABLE questions (
                           id SERIAL PRIMARY KEY,
                           test_id INT REFERENCES tests(id),
                           question_text TEXT,
                           correct_answer TEXT,
                           FOREIGN KEY (test_id) REFERENCES tests(id)
);

CREATE TABLE comments (
                          id SERIAL PRIMARY KEY,
                          course_id INT REFERENCES courses(id),
                          user_id INT REFERENCES users(id),
                          message TEXT,
                          timestamp TIMESTAMP,
                          FOREIGN KEY (course_id) REFERENCES courses(id),
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE student_courses (
                                 student_id INT REFERENCES students(id),
                                 course_id INT REFERENCES courses(id),
                                 PRIMARY KEY (student_id, course_id)
);

CREATE TABLE mentor_courses (
                                mentor_id INT REFERENCES mentors(id),
                                course_id INT REFERENCES courses(id),
                                PRIMARY KEY (mentor_id, course_id)
);

CREATE TABLE test_students (
                               test_id INT REFERENCES tests(id),
                               student_id INT REFERENCES students(id),
                               PRIMARY KEY (test_id, student_id)
);