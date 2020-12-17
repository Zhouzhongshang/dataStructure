package zzs4Test;

/**
 * @program: dataStur
 * @description: 学生类
 * @author: zzs
 * @create: 2020-07-08 10:18
 **/
public class Student implements Comparable<Student> {
    public Integer getAge() {
        return age;
    }

    private Integer age;

    public Student(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return o.age-this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
