import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Student {

    private int studentId;
    private String studentName;
    private int courseId;

    public Student(int studentId, String studentName, int courseId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseId = courseId;
    }

    // Getter methods
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCourseId() {
        return courseId;
    }

    // Setter methods — exact signatures required for structural tests
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // equals and hashCode based on studentId
   @Override
    public boolean equals(Object student) { // Changed 'obj' to 'student'
        if (this == student)
            return true;
        if (!(student instanceof Student))
            return false;
        Student other = (Student) student; // Changed 'obj' to 'student'
        return this.studentId == other.studentId;
    }

    @Override
    public int hashCode() {
        return studentId;
    }

    @Override
    public String toString() {
        return studentId + " : " + studentName;
    }
}


class Tester {

    public static Set<Student> findDuplicateEntries(List<Student> students) {
        Set<Student> seen = new HashSet<>();
        Set<Student> duplicates = new HashSet<>();

        for (Student student : students) {
            if (!seen.add(student)) {
                duplicates.add(student);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student(1001, "Dean", 111));
        students.add(new Student(1002, "Harley", 112));
        students.add(new Student(1003, "Franklin", 113));
        students.add(new Student(1005, "Arden", 113));
        students.add(new Student(1100, "Juliet", 112));
        students.add(new Student(1003, "Franklin", 111));
        students.add(new Student(1001, "Dean", 114));

        Set<Student> duplicateStudents = findDuplicateEntries(students);
        System.out.println("Students who have applied for re-evaluation in more than one subject");
        for (Student student : duplicateStudents)
            System.out.println(student);
    }
}
