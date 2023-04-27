import java.util.*;

public class AppSetUp {
    public static final String RED = "\033[31m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\u001B[0m";
    public static  final String PLAIN = "\033[0;0m"; //bold text
    public static final String BOLD = "\033[0;1m"; //plain text
    public static final String UNDERLINE = "\033[0;4m";

    public static String setSchoolName(Scanner scanner) {
        String schoolName = null;
        while (schoolName == null) {
            System.out.println("Please enter the "+UNDERLINE+"school name"+PLAIN+".");
            schoolName = scanner.nextLine();
            if (schoolName.isEmpty()) {
                System.out.println(RED+"It's not a valid school name!!"+WHITE);
                schoolName = null;
            }
        }
        return schoolName;
    }

    public static int setTeacherNum(Scanner scanner) {
        int teacherNum = 0;
        while (teacherNum == 0) {
            System.out.println("\n------------\uD83C\uDF93"+BOLD+"TEACHERS"+PLAIN+"\uD83C\uDF93----------------"+WHITE);
            System.out.println("How many teachers would you want to have?");
            if (scanner.hasNextInt()) {
                teacherNum = scanner.nextInt();
                if (teacherNum <= 0) {
                    System.out.println(RED+"It's not a valid number!!"+WHITE);
                    teacherNum = 0;
                }
            } else {
                System.out.println(RED+"It's not a valid number!!"+WHITE);
                scanner.nextLine();
            }
        }
        return teacherNum;
    }

    public static Map<String, Teacher> setTeacherDetail(Scanner scanner, int teacherNum) {
        Map<String, Teacher> teachersList = new HashMap<>();
        int teacherAlready = 1;
        for (int i = 1; i <= teacherNum; i++) {
            scanner.nextLine();
            String teacherName = null;
            int teacherSalary = 0;
            while (teacherName == null) {
                System.out.println("\nWhat is the name of the teacher nª " + teacherAlready + "?");
                teacherName = scanner.nextLine();

                if (teacherName.isEmpty()) {
                    System.out.println("It's not a valid teacher name!!");
                    teacherName = null;
                }
            }

            while (teacherSalary == 0) {
                System.out.println("How much the teacher nª " + teacherAlready + " earn?");
                if (scanner.hasNextInt()) {
                    teacherSalary = scanner.nextInt();
                    if (teacherSalary <= 0) {
                        System.out.println(RED+"It's not a valid number!!"+WHITE);
                        teacherSalary = 0;
                    }
                } else {
                    System.out.println(RED+"Please enter a valid salary number!"+WHITE);
                    scanner.nextLine();
                }
            }
            teacherAlready++;
            Teacher teacher = new Teacher(teacherName, teacherSalary);
            teachersList.put(teacher.getTeacherId(), teacher);
        }
        return teachersList;
    }

    public static int setCoursesNum(Scanner scanner) {
        int courseNum = 0;
        while (courseNum == 0) {
            System.out.println("\n------------\uD83D\uDCC3"+BOLD+"COURSES"+PLAIN+"\uD83D\uDCC3----------------"+WHITE);
            System.out.println("How many courses would you want to have?");
            if (scanner.hasNextInt()) {
                courseNum = scanner.nextInt();
                if (courseNum <= 0) {
                    System.out.println(RED+"It's not a valid number!!"+WHITE);
                    courseNum = 0;
                }
            } else {
                System.out.println(RED+ "It's not a valid number!!"+WHITE);
                scanner.nextLine();
            }
        }
        return courseNum;
    }

    public static Map<String, Course> setCoursesDetail(Scanner scanner, int courseNum) {

        Map<String, Course> coursesList = new HashMap<>();
        int courseAlready = 1;
        for (int i = 1; i <= courseNum; i++) {
            scanner.nextLine();
            String courseName = null;
            int coursePrice = 0;
            while (courseName == null) {
//                System.out.println();
                System.out.println("\nWhat is the name of the course nª " + courseAlready + "?");
                courseName = scanner.nextLine();

                if (courseName.isEmpty()) {
                    System.out.println(RED+"It's not a valid course name!!"+WHITE);
                    courseName = null;
                }
            }

            while (coursePrice == 0) {
                System.out.println("How much the course nª " + courseAlready + " costs?");
                if (scanner.hasNextInt()) {
                    coursePrice = scanner.nextInt();
                    if (coursePrice <= 0) {
                        System.out.println(RED+"It's not a valid number!!"+WHITE);
                        coursePrice = 0;
                    }
                } else {
                    System.out.println(RED+"Please enter a valid number"+WHITE);
                    scanner.nextLine();
                }
            }
            courseAlready++;
            Course course = new Course(courseName, coursePrice);
            coursesList.put(course.getCourseId(), course);
        }
        return coursesList;
    }

    public static int setStudentsNum(Scanner scanner) {
        int studentNum = 0;
        while (studentNum == 0) {
            System.out.println("\n------------\uD83D\uDCCB"+BOLD+"STUDENTS"+PLAIN+"\uD83D\uDCCB----------------"+WHITE);
            System.out.println("How many students would you want to have?");
            if (scanner.hasNextInt()) {
                studentNum = scanner.nextInt();
                if (studentNum <= 0) {
                    System.out.println(RED+ "It's not a valid number!!"+WHITE);
                    studentNum = 0;
                }
            } else {
                System.out.println(RED+ "It's not a valid number!!" +WHITE);
                scanner.nextLine();
            }
        }
        return studentNum;
    }

    public static Map<String, Student> setStudentDetail(Scanner scanner, int courseNum) {
        Map<String, Student> studentsList = new HashMap<>();
        int studentAlready = 1;
        scanner.nextLine();
        for (int i = 1; i <= courseNum; i++) {
            String studentName = null;
            String studentEmail = null;
            String studentAddress = null;
            while (studentName == null) {
                System.out.println("\nWhat is the name of the student nª " + studentAlready + "?");
                studentName = scanner.nextLine();
                if (studentName.isEmpty()) {
                    System.out.println(RED+"It's not a valid student name!!"+WHITE);
                    studentName = null;
                }
            }

            while (studentEmail == null) {
                System.out.println("What is the email of the student nª " + studentAlready + "?");
                studentEmail = scanner.nextLine();
                if (studentEmail.isEmpty()) {
                    System.out.println(RED+"It's not a valid student email!!"+WHITE);
                    studentEmail = null;
                }
            }

            while (studentAddress == null) {
                System.out.println("What is the address of the student nª " + studentAlready + "?");
                studentAddress = scanner.nextLine();
                if (studentAddress.isEmpty()) {
                    System.out.println(RED+"It's not a valid student address!!"+WHITE);
                    studentAddress = null;
                }
            }
            Student student = new Student(studentName, studentAddress, studentEmail);
            studentsList.put(student.getStudentId(), student);
            studentAlready++;
        }
        return studentsList;
    }

}
