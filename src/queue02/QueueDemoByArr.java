package queue02;

import java.util.Scanner;

/**
 * @author 86157
 *
 * 队列是先进先出的结构模型：排队叫号等场景
 * 实现一个用数组的队列：要求添加元素 取出元素 显示头部元素
 * 出队列操作getQueue
 * 显示队列的情况showQueue
 * 查看队列头元素headQueue
 * 退出系统exit
 */
public class QueueDemoByArr {
    public static void main(String[] args) {

        //测试
        QueueArr queueArr = new QueueArr(4);
        boolean loop =true;
        String key="";
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加队列");
            System.out.println("g(get):取出队列数据");
            System.out.println("h(show):头部展示");

            Scanner scanner = new Scanner(System.in);
            key = scanner.nextLine();
            /**
             * switch（key）{
             *   case "":
             *     break;
             *    default:
             *      break;
             * }
             */
            switch (key){
                case "s":
                  System.out.println(queueArr.showQueue()+"个数字");
                    break;
                case "e":
                    scanner.close();
                    loop=false;
                    break;
                case "a":
                    System.out.print("输入一个数字");
                    int val = scanner.nextInt();
                    try {
                        queueArr.addQueue(val);
                    }catch (Exception e){
                        System.out.print(e.getMessage());
                    }

                    break;
                case "g":
                    try{
                        int res = queueArr.getQueue();
                        System.out.printf("取出%d\n",res);
                    }catch (Exception e){
                        System.out.print(e.getMessage());
                    }

                    break;
                case "h":
                    int i = queueArr.headQueue();
                    System.out.printf("头部数据%d\n",i);
                    break;
                default:
                    break;
            }
        }
        System.out.print("退出程序");
 }
}

    /**
     * 定义一个数组数据结构队列
     * front:初始值为-1，取出元素后，front指向取出的位置：为头部元素的前一个位置
     * real:初始值为-1，存入元素后，real指向存入元素的位置：为尾部元素的位置
     * null: real=front
     * full: real+1=maxSize
     *
     * 改为循环队列：
     * 定义如下
     * front:指向数组的头部元素
     * real:指向数组的尾部元素的后一个位置
     * 联想环形图留一个空位置
     * null:取，real=front
     * 满：放，下一个位置=front----->(real+1)%maxsize==front
     */
     class QueueArr {

        private int maxSize;
        /**
         * 头部
         */
        private int front;
        /**
         * 尾部
         */
        private int real;
        /**
         * '容器
         */

        private int[] arr;

        public QueueArr(int maxSize){
            this.maxSize=maxSize;
           // this.front=-1;
            this.front=0;
            //this.real=-1;
            this.real=0;
            this.arr=new int[maxSize];
        }

        /**
         * 判断队列是否为没有元素了
         */

        boolean isEmpty(){
            if (real == front){
                return true;
            }
            return false;
        }
        /**
        *判断队列是否满了 尾部指针指向最后一个元素的地址
         *
         * :2下一个位置是否是头部指针 是：则满
         *                            不是：则放再尾部指针处
         */
        boolean isFull(){
         /*   if (real == maxSize -1){
                return true;
            }
            return false;*/
         return (real+1)%maxSize == front;


        }

        /**
         * 添加元素
         */

        void addQueue(int val){
            //1,判断是否满了 如果满了不能添加 抛出异常
            if (isFull()){
                System.out.println("元素已经满了");
                throw new RuntimeException("队列已满不能添加~~~~~~~");
            }
            //2添加数据：将real=real+1 然后将数据放在arr[real处]
        /*    real++;
            arr[real]=val;*/
        //环形队列元素直接放在real处，指针下移动
            arr[real]=val;
            real=(real+1)%maxSize;

        }

        //取出元素
        int getQueue(){
          //1判断是否为空，如果为空，则抛出
            if (isEmpty()){
                System.out.println("队列为空不能取出数据~~~~~");
                throw new RuntimeException("队列为空，不能取出数据！~~~~~");
            }
            //取出数据：先将front=front+1 然后取出arr[front]处的数据
           /* front++;*/
            //2.环形队列
            int getVal=arr[front];
            front=(front+1)%maxSize;
            return getVal;
        }

        //显示所有的数据
        int  showQueue(){
            if (isEmpty()){
                System.out.println("队列为null");
                return 0;
            }
           /* for (int i= front+1;i<=real;i++){
                System.out.printf("a[%d]=%d\n",i,arr[i]);
            }*/
           //环形队列的话直接遍历数组就行改为有多少数据real-front个
            //(real-front+maxSize)%maxSize  0123 0-2=3个
         for (int i=front;i<front+(real-front+maxSize)%maxSize;i++){
             System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
         }
            return (real-front+maxSize)%maxSize;

        }

        //显示头部数据
        int headQueue(){
            if (isEmpty()){
                throw new RuntimeException("为null");
            }
            return arr[front];
        }


    }

