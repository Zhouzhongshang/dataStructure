package stack;

import java.util.Scanner;

/**
 * @program: dataSturs
 * @description: 用数组实现栈的功能
 * @author: zzs
 * @create: 2020-03-05 16:37
 *
 * 定义：栈是一个先进后出的线性数据结构，有数据域，有top[栈顶]，初始化为-1，其中栈底是不变的
 **/
public class ArrayTypeStackDemo {
    public static void main(String[] args) {
        /**
         * 做一个有界面的栈模拟数据
         */
        ArrayStack stack = new ArrayStack(4);

        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.print("show:  遍历栈\n");
            System.out.print("push:  添加\n");
            System.out.print("pop:  删除\n");
            System.out.print("exit:  退出程序\n");
            System.out.print("请输入你的操作：\n");

            String next = scanner.next();

            switch (next) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.print("请输入要添加的数字：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                       System.out.print(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }


        }


        System.out.print("程序退出");
    }
}

/**
 * @Description: 栈的数据结构定义
 * @Param: 
 * @return: 
 * @Author: zzs
 * @Date: 2020/3/5
 * @Implementation: 
 *
 */
class ArrayStack{
    /**
     * 栈顶
     */
    int top ;
    /**
     * 栈的内存大小
     */
    int maxSize;
    /**
     * 数据域
     */
    int [] data;

    public ArrayStack( int maxSize){
        this.data= new int[maxSize];
        this.maxSize = maxSize;
        this.top = -1;
    }

    /**
     * 是否栈满
     * 当top = maxSize -1
     */
    public boolean isFull(){
       return top == maxSize -1;
    }

    /**
     * 是否空 当top = -1
     * @return
     */
    public boolean isEmpty(){
         return top == -1;
    }


    /**
     * @Description:添加数据
     * @Param: [value]
     * @return: void
     * @Author: zzs
     * @Date: 2020/3/5
     * @Implementation:
     *   top++
     *   data[top] = value
     *
     */
    public void push(int value){
        if (isFull()){
            System.out.println("栈满不能添加数据");
            return;
        }
        top++;
        data[top] = value;
    }


    /**
     * @Description:取出数据
     * @Param: []
     * @return: int
     * @Author: zzs
     * @Date: 2020/3/5
     * @Implementation:
     *   int value = data[top]
     *   top --;
     */
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为null,不能取出数据");
        }
         int value = data[top];
         top--;
         return value;
    }

    /**
     * @Description:遍历栈，从top开始遍历
     * @Param: []
     * @return: void
     * @Author: zzs
     * @Date: 2020/3/5
     * @Implementation:
     *  for( int i = top ;i<=0; i++ )
     *
     */
    public void show(){
          if (isEmpty()){
              System.out.println("栈没有数据");
              return;
          }
          for (int i = top ; i>= 0 ; i--){
              System.out.printf("dada[%d] = %d" , i , data[i]);
          }
    }


}
