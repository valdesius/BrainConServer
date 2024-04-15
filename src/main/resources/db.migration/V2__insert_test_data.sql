-- Добавление пользователей
INSERT INTO users(id, username, email, password, role) VALUES
                                                           (1, 'Alice', 'alice@example.com', 'password123', 'STUDENT'),
                                                           (2, 'Bob', 'bob@example.com', 'password456', 'MENTOR'),
                                                           (3, 'Charlie', 'charlie@example.com', 'password789', 'STUDENT');

-- Добавление наставников
INSERT INTO mentors(user_id, expertise_area) VALUES
                                                 (2, 'Programming'),
                                                 (3, 'Mathematics');

-- Добавление студентов
INSERT INTO students(id, user_id, major) VALUES
                                             (1, 1, 'Computer Science'),
                                             (2, 2, 'Mathematics'),
                                             (3, 3, 'Physics');

-- Добавление курсов
INSERT INTO courses(title, mentor_id) VALUES
                                          ('Java Fundamentals', 2),
                                          ('Mathematics 101', 2);  -- Здесь используем существующий mentor_id=2

-- Добавление тестов
INSERT INTO tests(course_id, title) VALUES
                                        (1, 'Fundamentals Quiz 1'),
                                        (2, 'Math Final Exam');

-- Добавление вопросов
INSERT INTO questions(test_id, question_text, correct_answer) VALUES
                                                                  (1, 'What is Java?', 'A programming language'),
                                                                  (2, 'What is 2 + 2?', '4');

-- Добавление комментариев
INSERT INTO comments(course_id, user_id, message, timestamp) VALUES
                                                                 (1, 1, 'Great course!', current_timestamp),
                                                                 (2, 3, 'Interesting material.', current_timestamp);

-- Добавление связей студентов и курсов
INSERT INTO student_courses(student_id, course_id) VALUES
                                                       (1, 1),
                                                       (2, 2),
                                                       (3, 2);

-- Добавление связей наставников и курсов
INSERT INTO mentor_courses(mentor_id, course_id) VALUES
                                                     (2, 1),
                                                     (2, 2);  -- Здесь используем mentor_id=2, а не 4

-- Добавление связей тестов и студентов
INSERT INTO test_students(test_id, student_id) VALUES
                                                   (1, 1),
                                                   (2, 2);