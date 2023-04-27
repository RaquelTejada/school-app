import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {

    private String courseId;

    private String name;

    private double price;

    private double moneyEarned;

    private Teacher teacher;

    private static int lastId = 1;
    private List<Student> studentList;


    public Course(String name, double price) {
        this.name = name;
        this.price = price;
        courseId = Integer.toString(lastId);
        lastId++;
        this.studentList = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", moneyEarned=" + moneyEarned +
            //    ", teacher=" + teacher +
            //    ", students=" + studentList +
                '}';
    }

    public void enroll(Student student) {
        studentList.add(student);
        this.setMoneyEarned(this.getPrice() * studentList.size());
    }
    public List<Student> getStudentList() {
        return this.studentList;
    }
}
