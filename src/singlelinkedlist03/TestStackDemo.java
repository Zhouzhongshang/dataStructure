package singlelinkedlist03;


import java.util.Stack;

/**
 * @program: dataSturs
 * @description: 栈的演示：特点先进后出，逆序
 * @author: zzs
 * @create: 2020-02-29 13:05
 **/
public class TestStackDemo {
    public static void main(String[] args) {
        Stack<String> objects = new Stack<>();
        objects.push("a");
        objects.push("b");
        objects.push("c");
        while (objects.size()>0){
            System.out.print(objects.pop());
        }
    }
}
