import java.util.Comparator;
import java.util.PriorityQueue;

public class LibrariesPractice {
    public static void main(String[] args) {
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.cgpa < s2.cgpa) {
            return -1;
        } else if (s1.cgpa > s2.cgpa) {
            return 1;
        } else {
            return 0;
        }
    }
}

class Student {
    public String name;
    public double cgpa;

    public Student(String name, double cgpa) {

        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }
}