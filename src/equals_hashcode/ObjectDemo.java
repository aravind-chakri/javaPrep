package equals_hashcode;

import streams.Employee;

import java.util.HashMap;
import java.util.Map;

public class ObjectDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;

        Object obj3 = new Object();


        System.out.println("is obj1 equal to obj2? " + obj1.equals(obj2));
        System.out.println("is obj1 equal to obj3? " + obj1.equals(obj3));
        System.out.println("Hashcode of obj1: " + obj1.hashCode());
        System.out.println("Hashcode of obj2: " + obj2.hashCode());
        System.out.println("Hashcode of obj3: " + obj3.hashCode());


        Student student1 = new Student(14, "John", 25);
        Student student2 = new Student(14, "John", 25);
        Student student3 = new Student(13, "Harry", 38);

        System.out.println("Student 1 equals student2? " + student1.equals(student2));
        System.out.println("Student 2 equals student3? " + student2.equals(student3));
        System.out.println("Hashcode of student 1 " + student1.hashCode());
        System.out.println("Hashcode of student 2 " + student2.hashCode());
        System.out.println("Hashcode of student 3 " + student3.hashCode());


        Map<Student, Integer> studentIntegerMap = new HashMap<>();
        studentIntegerMap.put(student1, 1);
        studentIntegerMap.put(student2, 2);
        studentIntegerMap.put(student3, 3);

        System.out.println(studentIntegerMap.size());


    }
}
