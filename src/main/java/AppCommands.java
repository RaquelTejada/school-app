
import java.awt.*;
import java.util.Scanner;
import java.util.Map;

public class AppCommands {
    private Map<String, Teacher> teacherList;
    private Map<String, Course> coursesList;
    private Map<String, Student> studentsList;

    public static final String YELLOW = "\u001B[0m\u001B[33;1m";
    public static final String RED = "\033[31m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\u001B[0m";
    public static  final String PLAIN = "\033[0;0m"; //PLAIN text
    public static final String BOLD = "\033[0;1m"; //BOLD text
    public static final String ITALIC= "\033[3m"; //ITALICS text


    private final String COMMANDS_INFO = YELLOW + "ENROLL [STUDENT_ID] [COURSE_ID]:"+ WHITE + " Enroll the student specified in the corresponding course.\n"
            +YELLOW + "ASSIGN [TEACHER_ID] [COURSE_ID]:"+ WHITE + " Assign the teacher specified to the corresponding course\n"
            +YELLOW + "SHOW COURSES:"+ WHITE + " Display a list of all courses\n"
            +YELLOW + "LOOKUP COURSE [COURSE_ID]:"+ WHITE + " Display the full details of the specified course.\n"
            +YELLOW + "SHOW STUDENTS: "+ WHITE + " Display a list of all students\n"
            +YELLOW + "LOOKUP STUDENT [STUDENT_ID]:"+ WHITE + " Display the full details of the specified student.\n"
            +YELLOW + "SHOW TEACHERS:"+ WHITE + " Display a list of all teachers\n"
            +YELLOW + "LOOKUP TEACHER [TEACHER_ID]:"+ WHITE + " Display the full details of the specified teacher.\n"
            +YELLOW + "SHOW PROFIT:"+ WHITE + "Calculate the benefit.\n"
            +YELLOW + "HELP:"+ WHITE + " To show these instructions.\n"
            +YELLOW + "QUIT:"+ WHITE + " To exit.\n";


    public void setUpCommand(Map<String, Teacher> teacherList, Map<String, Course> coursesList, Map<String, Student> studentsList) {
        this.teacherList = teacherList;
        this.coursesList = coursesList;
        this.studentsList = studentsList;
    }


    public void executeCommand(String commandString) {
        String[] commandParts = commandString.toUpperCase().split(" ");

        switch (commandParts[0]) {
            case "ENROLL":
                if (commandParts.length == 3) {
                        String studentId = commandParts[1];
                        String courseId = commandParts[2];
                    if (coursesList.containsKey(courseId)) {
                        Course course = coursesList.get(courseId);
                        if (studentsList.containsKey(studentId)) {
                            Student student = studentsList.get(studentId);
                            course.enroll(student);
                            student.setCourse(course);
                            System.out.println("Student " + BOLD +ITALIC + student.getName() + PLAIN+ " enrolled" + CYAN +" successfully" + WHITE +" to the '" +BOLD+ITALIC + course.getName() + PLAIN+ "' course.");
                        } else {
                            System.out.println( RED + "Student with id " + studentId + " not found."+ WHITE);
                        }
                    } else {
                        System.out.println( RED + "Course with id " + courseId + " not found."+ WHITE);
                    }
                } else {
                    System.out.println( RED + "Invalid command syntax. Maybe you forgot to introduce the ids?" + WHITE);
                }
                break;

            case "ASSIGN":
                if (commandParts.length == 3) {
                    String teacherId = commandParts[1];
                    String courseId = commandParts[2];
                    if (coursesList.containsKey(courseId)) {
                        Course course = coursesList.get(courseId);
                        if (teacherList.containsKey(teacherId)) {
                            Teacher teacher = teacherList.get(teacherId);
                            course.setTeacher(teacher);
                            System.out.println("Teacher " +BOLD+ITALIC+ teacher.getName() +PLAIN+ " assigned " + CYAN +"successfully" + WHITE +" to the '" +BOLD+ITALIC+ course.getName() +PLAIN+ "' course.");
                        } else {
                            System.out.println( RED+ "Teacher with id " + teacherId + "not found." +WHITE );
                        }
                    } else {
                        System.out.println( RED+ "Course with id " + courseId + "not found." +WHITE);
                    }
                } else {
                    System.out.println(RED+ "Invalid command syntax. Maybe you forgot to introduce the ids?"+WHITE);
                }
                break;

            case "SHOW":
                if (commandParts.length == 2) {
                    String object = commandParts[1];

                    switch (object) {
                        case "COURSES":
                            coursesList.forEach((key, value) -> {
                                System.out.println(ITALIC + "Name of the course: " +value.getName() + "\nCourse Id: " + value.getCourseId() +
                                         "\nMoney Earned: " + value.getMoneyEarned() + "\nPrice: "+ value.getPrice() +
                                         "\n   ------  " +PLAIN);
                            });
                            break;

                        case "STUDENTS":
                            studentsList.forEach((key, value) -> {
                                System.out.println(ITALIC+ "Student's name: " +value.getName() + "\n Student Id: " + value.getStudentId() +
                                         "\nEmail: "+ value.getEmail() +"\nAddress: "+ value.getAddress() +
                                        "\n   ------  "  +PLAIN);
                            });
                            break;

                        case "TEACHERS":
                            teacherList.forEach((key, value) -> {
                                System.out.println(ITALIC+ "Teacher's name: " +value.getName() + "\n Teacher Id: " + value.getTeacherId() +
                                        "\nSalary: "+value.getSalary() +"\n   ------  " +PLAIN);
                            });
                            break;

                        case "PROFIT":
                            double totalEarned = 0.0;
                            for (Course course : coursesList.values()) {
                                totalEarned += course.getMoneyEarned();
                            }
                            double totalSalary = 0.0;
                            for (Teacher teacher : teacherList.values()) {
                                totalSalary += teacher.getSalary();
                            }
                            double profit = totalEarned - totalSalary;

                            System.out.println("The total profit is: " + profit + "💸");
                            break;

                        default:
                            System.out.println(RED+ "Invalid entity: " + object +WHITE);
                            break;
                    }
                } else {
                    System.out.println(RED+ "Invalid command syntax, follow the scheme "+YELLOW+"'SHOW + ENTITY'"+WHITE);
                }
                break;

            case "LOOKUP":
                if (commandParts.length == 3) {
                    String object = commandParts[1];
                    String id = commandParts[2];

                    switch (object) {
                        case "COURSE":
                            if (coursesList.containsKey(id)) {
                                Course course = coursesList.get(id);
                                System.out.println(ITALIC + "Name of the course: " +course.getName() +
                                            "\nCourse Id: " + course.getCourseId() + "\nPrice: "+ course.getPrice() + "\nMoney Earned: " + course.getMoneyEarned() +
                                            PLAIN);

                                if(course.getTeacher() != null) {
                                    System.out.println("Teacher: " + course.getTeacher());
                                }
                                if(course.getStudentList().size() > 0) {
                                    System.out.println("Students: " + course.getStudentList());
                                }
                            } else {
                                System.out.println(RED+ "Course with id " + id + "not found."+WHITE);
                            }
                            break;

                        case "STUDENT":
                            if (studentsList.containsKey(id)) {
                                Student student = studentsList.get(id);
                                System.out.println(ITALIC+ "Student's name: " +student.getName() + "\nStudent Id: " + student.getStudentId() +
                                        "\nEmail: "+ student.getEmail() +"\nAddress: "+ student.getAddress() +PLAIN);

                                if(student.getCourse() != null) {
                                    System.out.println("Enrolled in course: " + BOLD+ITALIC+ student.getCourse().getName() +PLAIN);
                                }
                            } else {
                                System.out.println(RED + "Student with id " + id + "not found." +WHITE);
                            }
                            break;

                        case "TEACHER":
                            if (teacherList.containsKey(id)) {
                                Teacher teacher = teacherList.get(id);
                                System.out.println(ITALIC+ "Teacher's name: " +teacher.getName() + "\nTeacher Id: " + teacher.getTeacherId() +
                                        "\nSalary: "+teacher.getSalary() +PLAIN);

                            } else {
                                System.out.println(RED+ "Teacher with id " + id + "not found."+ WHITE);
                            }
                            break;

                        default:
                            System.out.println(RED+ "Invalid entity: " + object +WHITE);
                            break;
                    }
                } else {
                    System.out.println(RED+ "Invalid command syntax, follow the scheme " + YELLOW + "'LOOKUP + ENTITY'"+WHITE);
                }
                break;

            case "HELP":
                if (commandParts.length == 1) {
                    System.out.println(COMMANDS_INFO);
                }
                else {
                    System.out.println(RED +"Invalid command syntax, try with 'HELP'" +WHITE);
                }
                break;

            default:
                System.out.println(RED+ "Invalid command: '" +ITALIC+ commandString +WHITE+"'");
                System.out.println(COMMANDS_INFO);
                break;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(COMMANDS_INFO);

        while (true) {
            System.out.print("\n" + "Enter command: ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("QUIT")) {
                System.out.println(CYAN+"Byeeeeeeeeeeeeeeeeeeeeeeeeee\uD83D\uDC4B \uD83D\uDC4B \uD83D\uDC4B "+WHITE);
                break;
            }else {
                executeCommand(command);
            }
        }

        scanner.close();
    }
}