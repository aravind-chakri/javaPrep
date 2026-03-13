package comparator_comparable;

import jdk.jfr.Percentage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + age;
    }
    /*
    * Comparable(compareTo) is used to compare current object with other object directly
    * Where as comparator(compare) is used to compare two objects by a specific condition
    * */

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(21, "Aravind"));
        students.add(new Student(28, "Chakri"));
        students.add(new Student(37, "John"));
        students.add(new Student(20, "Lary"));

        Comparator<Student> comparator = (i,j) -> i.age > j.age ? 1 : -1;

        Collections.sort(students, comparator);
        for(Student s : students) {
            System.out.println(s);
        }
    }


//    @Override
//    public int compareTo(Student that) {
//        if(this.age > that.age) {
//            return 1;
//        }else {
//            return -1;
//        }
//    }
}
