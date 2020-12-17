package singlelinkedlist03;

/**
 * @program: dataSturs
 * @description: 单向环形链表和约瑟夫问题demo
 * @author: zzs
 * @create: 2020-03-02 21:22
 **/
public class CircleSingleLinkedListAndJosepProblemDemo {
    public static void main(String[] args) {

        /**
         * 第一种
         */
        Boy boy = new Boy(1);
        //备份下一个节点数据
        Boy curNext = boy.getNext();
        //将当前节点得下一个节点改变，curNext值还是不会变，因为改变得是当前节点得数据
        boy.setNext(new Boy(4));

        /**
         * 第二种
         */
        //备份当前节点的数据
        Boy boy1=boy;
        //将当前节点的熟悉next改变，同样boy1值也会改变
        boy.setNext(new Boy(5));

        /**
         * 第三种
         */
        Boy boy3 = new Boy(3);
        Boy cur1 = boy3;
        boy3.setNo(4);

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        //测试添加小孩数量
        circleSingleLinkedList.add(10);
        //遍历环形链表
        circleSingleLinkedList.showBoy();

        /**
         * 有num个小孩，规定从m个开始从1数数，数到k的数出圈，求出圈的顺序
         */
        circleSingleLinkedList.countBoy(1,2,10);
    }
}


/**
 * @Description:
 * @Param: 
 * @return: 
 * @Author: zzs
 * @Date: 2020/3/2
 * @Implementation: 
 *    无头节点的环形链表的定义：一个first节点不动，n最后一个元素的next指向first
 *
 *    添加思路：1，一个first节点初始值为null。2，第一个节点进来为first,让first.next=first构造成环。
 *                              3，新进来的节点，cur.next=boy. boy.next=first. cur=cur.next[指针后移]
 */
class CircleSingleLinkedList{
    private Boy first = null;

    /**
     * 初始化一个数量级别的孩子
     * :定义一个辅助变量
     */
    public void add( int nums){
        if (nums < 1){
            System.out.print("小孩子不够做个毛游戏");
        }
        //副本意思：first无论怎么变化，cur都不变，除非cur自己操作自己变化.初始化值为null[或者]
        Boy cur = first;
        for (int i = 1 ;i<=nums;i++){
            //first不动，cur是临时变量
            if (i==1){
                //指向新的地址
                first=new Boy(i);
                first.setNext(first);
                //这一行不加cur永远为null:原因是cur是fist的第一个副本再也没有赋值过，当走到下面报错空指针异常
                cur=first;
            }else {
                Boy boy = new Boy(i);
                cur.setNext(boy);
                boy.setNext(first);
                //指针后移
                cur=boy;
            }
        }
    }
    
    /**
     * @Description: 遍历
     * @Param: 
     * @return: 
     * @Author: zzs
     * @Date: 2020/3/2
     * @Implementation:
     *   从first开始知道最尾部。
     *    1，声名一个cur,
     *    2, 遍历一次打印一次
     *    3，cur=cur.getNext()
     *    4,如果 cur==first 【结束】
     *
     */
    public void showBoy(){
        Boy curBoy = first;
        if (curBoy==null){
            System.out.print("毛都没有，打印个毛");
        }
        while (true){
            System.out.println(curBoy.toString());
            curBoy=curBoy.getNext();
            if (curBoy==first){
                break;
            }
        }
    }


    /**
     * @Description:
     * @Param: [startNo:从startNo开始, count数到count编号, num小孩数量]
     * @return: void
     * @Author: zzs
     * @Date: 2020/3/3
     * @Implementation: 出队列：让前一个元素pre,指向后一个元素.同时cur后移；走动的步数为：count-1[到达]
     *  1，初始化位置  cur: 默认指向第一个节点。pre:默认指向最后一个节点。  走动startNo-1步
     *  2，开始找到删除的节点。cur . [如何删除：cur = cur.next当前节点指针后移   ; pre.next=cur ,cur之前的一个节点就丢失了呗垃圾回收]
     *
     */
    public void countBoy(int startNo, int count, int num) {

        //0，最开始cur指向第一个，pre指向最后一个节点
        Boy cur = first;
        Boy temp= first;
        Boy pre = null;
        //找到最后一个节点
        while (temp.getNext() != first) {
            temp = temp.getNext();
        }
        pre=temp;

        //1，让cur指向开始报数的位置,pre指向cur的前一个节点。
        for (int i= 0;i< startNo-1;i++ ){
            cur=cur.getNext();
            pre=pre.getNext();
        }

        //2，开始出圈。cur=cur.next(指针后移)，pre.next=cur。【找到出圈的人，而且一直循环，按照步数找】
        while (true){
            //第一次，每次：出圈的人找出来  cur为出圈的人，pre为前面的一个人
            for (int i= 1;i<= count-1;i++ ){
                cur=cur.getNext();
                pre=pre.getNext();
            }
            //找到之后出圈操作
            System.out.printf("出圈的小孩编号为：%d\n",cur.getNo());
            cur=cur.getNext();
            pre.setNext(cur);

            //啥时候结束？？只有一个节点【条件pre=cur】
            if (cur==pre){
                break;
            }
        }

        System.out.printf("最后一个小孩的编号为：%d\n",cur.getNo());
    }
}

/**
 * 小孩节点定义：编号和下一个节点
 */
class Boy{
   private int no;
   private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}

