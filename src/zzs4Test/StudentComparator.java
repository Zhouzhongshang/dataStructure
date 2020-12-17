package zzs4Test;

import java.util.Comparator;

/**
 * @program: dataStur
 * @description: 自定义学生比较器
 * @author: zzs
 * @create: 2020-07-08 10:36
 **/
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.getAge()-o2.getAge());
    }
}
