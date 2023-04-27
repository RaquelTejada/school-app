import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppSetUpTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }


    @Test
    void setSchoolName() {
        System.setIn(new ByteArrayInputStream("test\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        String schoolName = AppSetUp.setSchoolName(scanner);
        assertEquals("test", schoolName);
    }

    @Test
    void setTeacherNum() {
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        int teacherNum = AppSetUp.setTeacherNum(scanner);
        assertEquals(2, teacherNum);
    }

    @Test
    void setCoursesNum() {
        System.setIn(new ByteArrayInputStream("4\n".getBytes()));
        Scanner scanner = new Scanner(System.in);
        int coursesNum = AppSetUp.setCoursesNum(scanner);
        assertEquals(4, coursesNum);
    }
}