# IRON-SCHOOL :school:

Project developed by:
* :woman_technologist: Carla Gómez 
* :woman_technologist: Helen Saborit 
* :woman_technologist: Yanting Chen
* :woman_technologist: Raquel Tejada
* :woman_technologist: Leyre Gracia 


## HOW TO RUN THE APP :running:
To run the application, you only need to execute the Main file (Class).

## PARTS OF THE PROJECT :construction:

The project required three main classes: Teacher, Student and Course.

1. :mortar_board: The Teacher class includes a private auto-generated teacherId variable, a private name variable, and a private salary variable. It has a parameterized constructor that takes name and salary, and public getter and setter functions for the variables.

2. :books: The Course class includes a private auto-generated courseId variable, a private name variable, a private price variable, a private money_earned variable, and a nullable teacher variable of type Teacher. It has a parameterized constructor that takes name and price, and public getter and setter functions for the variables.

3. :woman_student: The Student class includes a private auto-generated studentId variable, a private name variable, a private address variable, a private email variable, and a nullable course variable of type Course. It has a parameterized constructor that takes name, address, and email, and public getter and setter functions for the variables.

#### CLASS DIAGRAM :chart_with_upwards_trend:

![image](https://user-images.githubusercontent.com/118773922/234622295-55fa8bf2-b045-438b-842a-2e5cf4291f86.png)


## HOW IT WORKS :gear:
This application allows users to create a school system by creating teachers, courses, and students. The application prompts the user to enter the details of each teacher, course, and student and then allows them to execute various commands.

The available commands include:

* Enrolling a student in a course :mortar_board:
* Assigning a teacher to a course :clipboard:
* Displaying a list of all courses :page_with_curl:
* Looking up the details of a specific course or student or teacher :mag:
* Calculating the school's profit :moneybag:
* The application automatically generates IDs for all entities. :id:

#### USE DIAGRAM :chart_with_upwards_trend:

![image](https://user-images.githubusercontent.com/118773922/234652417-50a8a23a-1821-454a-b053-79a88db59eda.png)

