package singlelinkedlist03;

/**
 * @program: dataSturs
 * @description: 双向链表得实现【遍历，删除，修改，新增，按照顺序新增】
 * @author: zzs
 * @create: 2020-02-29 21:36
 * 定义：头节点，pre,next域
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

/**
 * 遍历和单链表一样，(不写)
 * 删除：
 * 修改和单链表一样（不写）
 * 新增：
 */
class DoubleLinkedList{
    /**
     * 头节点
     */
    private  HeroNode2 head= new HeroNode2(0,"");



    /**
     * @Description: 删除双向链表的数据
     * @Param: [heroNode2]
     * @return: void
     * @Author: zzs
     * @Date: 2020/3/2
     * @Implementation:
     *   1，找到位置cur
     *   2,cur.pre.next=cur.next   ->   [指针指向]
     *   3,cur.next.pre=cur.pre    <-
     *
     *   4，假入cur为最后一个node, 2没有问题
     *       直接结束
     *
     */
    public void del2(HeroNode2 heroNode2){
       HeroNode2 cur = head.next;
       while (cur!=null){

       }
    }

    /**
     * @Description: 添加节点
     * @Param: 
     * @return: 
     * @Author: zzs
     * @Date: 2020/3/2
     * @Implementation:
     *  按顺序添加
     *  1，找到添加的位置的node>=cur
     *  2,cur.next=node       node.pre=cur   -> -<
     *  3,node.next=cur.next  cur.next.pre=node  -> <-
     *
     */
    public void add2(HeroNode2 heroNode2){
        
    }

}

/**
 * 节点得定义
 */
class HeroNode2 {
    public int no;
    public String name;
    /**
     * 指向下一个节点
     */
    public HeroNode2 next;
    /**
     * 指向前一个节点
     */
    public HeroNode2 pre;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }
}
