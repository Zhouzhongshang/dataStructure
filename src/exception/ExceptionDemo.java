package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86157
 * 解锁Exception的正确姿势
 */
public class ExceptionDemo {

    /**
     * 需求：将student对象添加到集合中，并且不能添加相同no的学习，否则抛出异常
     * @param args
     */
    public static void main(String[] args) {

        List<Student> listData=new ArrayList<>(5);
        for (int i = 0;i < 5 ; i++){
            Student student = new Student(i, "i:" + i);
            try {
                putList(student,listData);
                putList(student,listData);
            } catch (Exception e) {
                /**
                 * 捕获之后可以直接返回错误信息提示。
                 */
                System.out.print(e.getMessage());
            }
        }
    }

    private static void putList(Student student, List<Student> listData) throws Exception {

        if (student==null){
            throw new Exception("学生参数为null");
        }

        for (Student student1:listData){
           if (student.no==student1.no){
               throw new Exception("学生编号重复："+student.no);
           }
        }
        listData.add(student);
    }
}

class Student{
    public int no;
    public String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
