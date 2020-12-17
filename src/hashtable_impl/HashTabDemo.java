package hashtable_impl;

/**
 * @program: dataStur
 * @description: hash表的实现
 * @author: zzs
 * @create: 2020-07-16 22:31
 **/
public class HashTabDemo {
    public static void main(String[] args) {

    }

    /**
     * 抽象hash桶：数组
     */
    class HashTab{

        private EmpLinkedList [] empLinkedLists;

        private int size;

        //初始化一个大小的数组
        public HashTab(int size) {
            this.size = size;
           empLinkedLists = new EmpLinkedList[size];
        }

        //实际增删改查的方法
    }

    /**
     * 抽象单链表
     */
    class EmpLinkedList{
        private Emp head;
        //提供增删改查的方法
    }

    /**
     * 抽象员工信息
     */
    class Emp{
        public int id;
        public String name;
        public Emp next = null;
    }

}
