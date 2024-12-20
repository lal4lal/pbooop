INSERT INTO course (title, description) VALUES ('Introduction to Java', 'Learn the basics of Java programming.');
INSERT INTO course (title, description) VALUES ('Advanced Java', 'Deep dive into advanced Java topics.');
INSERT INTO course (title, description) VALUES ('Data Science', 'Introduction to data science and machine learning.');

-- Modules for 'Introduction to Java' (courseId = 1)
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Java Basics', 'Introduction to Java syntax and structure.', 'Java content 1', 1, 1);
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('OOP in Java', 'Learn Object-Oriented Programming in Java.', 'Java content 2', 1, 2);
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Java Data Structures', 'Introduction to data structures in Java.', 'Java content 3', 1, 3);

-- Modules for 'Advanced Java' (courseId = 2)
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Java Collections', 'Introduction to Java Collections Framework.', 'Java content 1', 2, 4);
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Java Streams', 'Learn about Java Streams API.', 'Java content 2', 2, 5);
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Concurrency in Java', 'Advanced concepts of concurrency in Java.', 'Java content 3', 2, 6);

-- Modules for 'Data Science' (courseId = 4)
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Introduction to Python', 'Learn the basics of Python programming.', 'Data Science content 1', 3, 7);
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Data Analysis with Pandas', 'Data analysis using the Pandas library.', 'Data Science content 2', 3, 8);
INSERT INTO modules (title, description, content, course_id, quiz_id) VALUES ('Machine Learning Basics', 'Introduction to machine learning concepts.', 'Data Science content 3', 3, 9);

UPDATE modules
SET QUIZ_ID = 1
WHERE MODULE_ID = 1;
UPDATE modules
SET QUIZ_ID = 2
WHERE MODULE_ID = 2;
UPDATE modules
SET QUIZ_ID = 3
WHERE MODULE_ID = 3;
UPDATE modules
SET QUIZ_ID = 4
WHERE MODULE_ID = 4;
UPDATE modules
SET QUIZ_ID = 5
WHERE MODULE_ID = 5;
UPDATE modules
SET QUIZ_ID = 6
WHERE MODULE_ID = 6;
UPDATE modules
SET QUIZ_ID = 7
WHERE MODULE_ID = 7;
UPDATE modules
SET QUIZ_ID = 8
WHERE MODULE_ID = 8;
UPDATE modules
SET QUIZ_ID = 9
WHERE MODULE_ID = 9;


-- Create Quiz for each module
INSERT INTO quiz (reward_Points) VALUES (10);
INSERT INTO quiz (reward_Points) VALUES (15);
INSERT INTO quiz (reward_Points) VALUES (20);
INSERT INTO quiz (reward_Points) VALUES (25);
INSERT INTO quiz (reward_Points) VALUES (30);
INSERT INTO quiz (reward_Points) VALUES (35);
INSERT INTO quiz (reward_Points) VALUES (40);
INSERT INTO quiz (reward_Points) VALUES (45);
INSERT INTO quiz (reward_Points) VALUES (50);

-- Insert Single Choice and Multiple Choice Questions
-- Java Basics Quiz Questions (QuizId = 1)
INSERT INTO question (quiz_id, question_type, question_text)
VALUES (1, 'SINGLE_CHOICE', 'What is the correct way to define a main method in Java?');
INSERT INTO options (question_id, options) VALUES (1, 'public static void main(String[] args)');
INSERT INTO options (question_id, options) VALUES (1, 'static public void main(String args[])');
INSERT INTO options (question_id, options) VALUES (1, 'public void static main(String args[])');
INSERT INTO options (question_id, options) VALUES (1, 'void static main(String[] args)');
INSERT INTO correct_answers (question_id, correct_answer) values (1, 'public static void main(String[] args)');

INSERT INTO question (quiz_id, question_type, question_text)
VALUES (1, 'SINGLE_CHOICE', 'Which data type is used to create a variable that should store text?');
INSERT INTO options (question_id, options) VALUES (2, 'int');
INSERT INTO options (question_id, options) VALUES (2, 'float');
INSERT INTO options (question_id, options) VALUES (2, 'String');
INSERT INTO options (question_id, options) VALUES (2, 'boolean');
INSERT INTO correct_answer (question_id, correct_answer) values (2, 'String');

INSERT INTO question (quiz_id, question_type, question_text)
VALUES (1, 'MULTIPLE_CHOICE', 'Which of the following are valid Java keywords?');
INSERT INTO options (question_id, options) VALUES (3, 'class');
INSERT INTO options (question_id, options) VALUES (3, 'public');
INSERT INTO options (question_id, options) VALUES (3, 'inherit');
INSERT INTO options (question_id, options) VALUES (3, 'void');
INSERT INTO correct_answer (question_id, correct_answer) values (3, 'class');
INSERT INTO correct_answer (question_id, correct_answer) values (3, 'public');
INSERT INTO correct_answer (question_id, correct_answer) values (3, 'void');

(1, 'Which of the following are valid Java keywords?', '["class", "public", "inherit", "void"]', '["class", "public", "void"]'),
(1, 'Which of the following are primitive data types in Java?', '["int", "String", "double", "float"]', '["int", "double", "float"]'),
(1, 'Select all valid access modifiers in Java:', '["public", "private", "protected", "internal"]', '["public", "private", "protected"]');

-- OOP in Java Quiz Questions (QuizId = 2)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(2, 'Which of these is not a principle of OOP?', '["Encapsulation", "Abstraction", "Polymorphism", "Interpretation"]', '["Interpretation"]'),
(2, 'Which keyword is used to inherit a class in Java?', '["inherits", "extends", "implements", "super"]', '["extends"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(2, 'Which of the following are features of OOP?', '["Inheritance", "Encapsulation", "Abstraction", "Polymorphism"]', '["Inheritance", "Encapsulation", "Abstraction", "Polymorphism"]'),
(2, 'Which of the following classes are part of Java’s OOP hierarchy?', '["Object", "String", "Integer", "Collections"]', '["Object", "String", "Integer"]'),
(2, 'Select valid object-oriented design principles:', '["Open-Closed Principle", "Single Responsibility Principle", "Circular Dependency", "Dependency Inversion"]', '["Open-Closed Principle", "Single Responsibility Principle", "Dependency Inversion"]');

-- Java Data Structures Quiz Questions (QuizId = 3)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(3, 'Which data structure uses LIFO (Last In First Out)?', '["Queue", "Stack", "Array", "LinkedList"]', '["Stack"]'),
(3, 'Which is the fastest for accessing data by index?', '["Array", "LinkedList", "Stack", "Queue"]', '["Array"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(3, 'Which of the following are examples of linear data structures?', '["Array", "Stack", "Graph", "Queue"]', '["Array", "Stack", "Queue"]'),
(3, 'Select all operations commonly associated with stacks:', '["Push", "Pop", "Enqueue", "Dequeue"]', '["Push", "Pop"]'),
(3, 'Which of these data structures can be used for traversal?', '["Graph", "Tree", "Stack", "Array"]', '["Graph", "Tree", "Array"]');

-- Java Collections Quiz Questions (QuizId = 4)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(4, 'Which Java collection uses key-value pairs?', '["List", "Set", "Map", "Queue"]', '["Map"]'),
(4, 'Which collection does not allow duplicate elements?', '["List", "Set", "Queue", "Array"]', '["Set"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(4, 'Which of the following are part of the Java Collections Framework?', '["List", "Map", "Set", "Stream"]', '["List", "Map", "Set"]'),
(4, 'Which operations are commonly supported by a List?', '["Add", "Remove", "Sort", "Reverse"]', '["Add", "Remove", "Sort", "Reverse"]'),
(4, 'Which types of Map exist in Java?', '["HashMap", "TreeMap", "ConcurrentHashMap", "ArrayMap"]', '["HashMap", "TreeMap", "ConcurrentHashMap"]');

-- Java Streams Quiz Questions (QuizId = 5)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(5, 'Which stream operation is terminal?', '["filter", "map", "collect", "peek"]', '["collect"]'),
(5, 'Which Java package provides the Streams API?', '["java.util.stream", "java.io.stream", "java.nio.stream", "java.net.stream"]', '["java.util.stream"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(5, 'Which of the following are stream intermediate operations?', '["map", "filter", "sorted", "reduce"]', '["map", "filter", "sorted"]'),
(5, 'Select valid characteristics of streams in Java:', '["Lazy", "Stateless", "Thread-safe", "Sequential"]', '["Lazy", "Stateless"]'),
(5, 'Which are valid ways to create streams in Java?', '["From Collections", "Using Stream.generate()", "Using Stream.of()", "From BufferedReader"]', '["From Collections", "Using Stream.generate()", "Using Stream.of()", "From BufferedReader"]');

-- Concurrency in Java Quiz Questions (QuizId = 6)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(6, 'Which keyword is used to create threads in Java?', '["extends", "implements", "synchronize", "thread"]', '["implements"]'),
(6, 'Which method is used to start a thread?', '["run()", "execute()", "start()", "begin()"]', '["start()"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(6, 'Which are valid thread states in Java?', '["New", "Runnable", "Blocked", "Terminated"]', '["New", "Runnable", "Blocked", "Terminated"]'),
(6, 'Which classes support thread synchronization?', '["Semaphore", "Lock", "ReentrantLock", "Thread"]', '["Semaphore", "Lock", "ReentrantLock"]'),
(6, 'Which methods can pause thread execution?', '["sleep()", "wait()", "yield()", "stop()"]', '["sleep()", "wait()", "yield()"]');

-- Introduction to Python Quiz Questions (QuizId = 7)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(7, 'Which is the correct file extension for Python files?', '[".py", ".python", ".pyt", ".txt"]', '[".py"]'),
(7, 'Which of the following is used to print in Python?', '["echo", "print", "printf", "write"]', '["print"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(7, 'Which are valid Python data types?', '["int", "float", "string", "list"]', '["int", "float", "string", "list"]'),
(7, 'Which methods can be used to manipulate strings in Python?', '["split()", "join()", "append()", "replace()"]', '["split()", "join()", "replace()"]'),
(7, 'Which Python keywords are used for loops?', '["for", "while", "do", "repeat"]', '["for", "while"]');

-- Data Analysis with Pandas Quiz Questions (QuizId = 8)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(8, 'Which Python library is used for data analysis?', '["numpy", "pandas", "matplotlib", "scipy"]', '["pandas"]'),
(8, 'Which method is used to read a CSV file in Pandas?', '["read_csv()", "load_csv()", "import_csv()", "open_csv()"]', '["read_csv()"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(8, 'Which Pandas methods are used for data cleaning?', '["dropna()", "fillna()", "replace()", "strip()"]', '["dropna()", "fillna()", "replace()"]'),
(8, 'Which data structures are provided by Pandas?', '["DataFrame", "Series", "Panel", "Array"]', '["DataFrame", "Series"]'),
(8, 'Which Pandas methods are used for data aggregation?', '["groupby()", "pivot()", "sum()", "agg()"]', '["groupby()", "pivot()", "agg()"]');

-- Machine Learning Basics Quiz Questions (QuizId = 9)
INSERT INTO single_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(9, 'Which library is commonly used for machine learning in Python?', '["numpy", "pandas", "scikit-learn", "matplotlib"]', '["scikit-learn"]'),
(9, 'Which is a supervised learning algorithm?', '["K-means", "Linear Regression", "PCA", "Clustering"]', '["Linear Regression"]');

INSERT INTO multiple_choice (quiz_id, questionText, options, correctAnswer)
VALUES
(9, 'Which algorithms are used for classification?', '["Logistic Regression", "Decision Trees", "KNN", "Random Forest"]', '["Logistic Regression", "Decision Trees", "KNN", "Random Forest"]'),
(9, 'Which metrics are used to evaluate classification models?', '["Accuracy", "Precision", "Recall", "MAE"]', '["Accuracy", "Precision", "Recall"]'),
(9, 'Which libraries are used for deep learning?', '["TensorFlow", "Keras", "PyTorch", "OpenCV"]', '["TensorFlow", "Keras", "PyTorch"]');
