package equals_hashcode;

import java.util.Objects;

public class Student {
    int age;
    String name;
    int rollNo;


    public Student(int age, String name, int rollNo) {
        this.age = age;
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Student ) ) return false;
        Student s = (Student) o;
        return age == s.age && Objects.equals(name, s.name) && rollNo == s.rollNo;
    }

    @Override
    public int hashCode() {
        return 17 * rollNo;
    }
}
