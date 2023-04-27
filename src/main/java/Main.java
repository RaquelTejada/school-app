import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\u001B[0m";
    public static final String GREEN = "\033[32m";
    public static  final String PLAIN = "\033[0;0m"; //PLAIN text
    public static final String BOLD = "\033[0;1m"; //BOLD text
    public static final String ITALIC= "\033[3m";

    public static void main(String[] args) {
        System.out.println();
        System.out.println(CYAN+"************************************************************" +
                         "\n*        "+BOLD+CYAN+"      WELCOME to our School System!     "+PLAIN+CYAN+"          *\n" +
                           "*       In the following lines we will ask you for         *\n" +
                           "*   some information in order to create your own School!   * \n" +
                         "************************************************************"+WHITE);
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String schoolName = AppSetUp.setSchoolName(scanner);

        //set teachers
        int teacherNum = AppSetUp.setTeacherNum(scanner);
        Map<String, Teacher> teacherList = AppSetUp.setTeacherDetail(scanner, teacherNum);
        System.out.println(ITALIC+GREEN+ "\n\uD83C\uDF89The following teachers are part of your school:\uD83C\uDF89 " );
        teacherList.forEach((key, value) -> {
            System.out.println(ITALIC+GREEN + "Name: " +value.getName() + " & Id: " + value.getTeacherId() +PLAIN);
        });

        //set courses
        int courseNum = AppSetUp.setCoursesNum(scanner);
        Map<String, Course> coursesList = AppSetUp.setCoursesDetail(scanner, courseNum);
        System.out.println(ITALIC+GREEN+ "\n\uD83C\uDF89The following courses can be taken at your school:\uD83C\uDF89" );
        coursesList.forEach((key, value) -> {
            System.out.println(ITALIC +GREEN+ "Name: " +value.getName() + " & Id: " + value.getCourseId() +PLAIN);
        });

        //set students
        int studentNum = AppSetUp.setStudentsNum(scanner);
        Map<String, Student> studentsList = AppSetUp.setStudentDetail(scanner, studentNum);
        System.out.println(ITALIC+GREEN+ "\n\uD83C\uDF89The following students joined your school:\uD83C\uDF89" );
        studentsList.forEach((key, value) -> {
            System.out.println(ITALIC+GREEN+ "Name: " +value.getName() + " & Id: " + value.getStudentId() +PLAIN);
        });


        System.out.println("\n" +BOLD+CYAN + "\uD83C\uDFEB¡The school is ready!\uD83C\uDFEB"+PLAIN+WHITE+" Check the commands below to perform the available actions: " + "\n");

        AppCommands commandManager = new AppCommands();
        commandManager.setUpCommand(teacherList, coursesList, studentsList);
        commandManager.run();

    }
}

