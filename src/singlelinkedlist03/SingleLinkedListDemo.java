package singlelinkedlist03;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 86157
 * 单链表的实现
 * 有头节点，有data域 ，next域
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试添加
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode zzs = new HeroNode(1, "zzs");
        HeroNode wjj = new HeroNode(2, "wjj");
       List<HeroNode> list= new LinkedList<>();
       list.add(zzs);
       list.add(new HeroNode(9,"dsfs"));
       list.add(wjj);
       //map是取元素
        List<HeroNode> collect = list.stream().sorted(Comparator.comparing(i -> i.no)).collect(Collectors.toList());
        List<Integer> collect1 = list.stream().map(HeroNode::getNo).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        singleLinkedList.add(zzs);
        singleLinkedList.add(wjj);
        singleLinkedList.add(new HeroNode(17,"asd"));

        /**
         * 测试重复数据和顺序数据
         */
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        HeroNode heroNode = new HeroNode(6, "asd");
        HeroNode heroNode2 = new HeroNode(7, "asd");
        HeroNode heroNode3 = new HeroNode(9, "asd");
        HeroNode heroNode4 = new HeroNode(10, "asd");
        HeroNode heroNode5 = new HeroNode(11, "doff");
        singleLinkedList1.addByOrder(heroNode);
        singleLinkedList1.addByOrder(heroNode2);
        singleLinkedList1.addByOrder(heroNode3);
        singleLinkedList1.addByOrder(heroNode4);
        singleLinkedList1.addByOrder(heroNode5);

        //测试合并单链表的有序排列
        HeroNode heroNode1 = mergeLinkedList(singleLinkedList.getHead(), singleLinkedList1.getHead());
        HeroNode zzs1 = new HeroNode(7, "周中山");
        singleLinkedList1.update(zzs1);

        singleLinkedList1.del(7);

        System.out.print("添加完成");

        //获取单链表的长度
        int length = getLength(singleLinkedList1.getHead());
        //找到倒数第k个节点
        HeroNode heroNodeByLastK = findHeroNodeByLastK(singleLinkedList1.getHead(), 1);
        //单链表的反转
         reverse(singleLinkedList1.getHead());




    }


    /**
     * @Description:合并两个有序的单链表，使之后的链表任然有序
     * @Param: [node1, node2]
     * @return: singlelinkedlist03.HeroNode
     * @Author: zzs
     * @Date: 2020/2/29
     * @Implementation:
     * 1，声名一个存储链表
     * 2，同时遍历两个链表，将小的放在声名的链表中,[同时让next==null]
     * 3，返回新的链表
     */
    public static HeroNode mergeLinkedList(HeroNode node1,HeroNode node2){
        HeroNode head = new HeroNode(0, "");
        if (node1.next==null && node2.next == null){
            return head;
        }else if (node1.next==null || node2.next == null){
            //返回不为null的链表
            return node1.next == null ? node2.next : node1.next;
        }
        HeroNode cur1 = node1.next;
        HeroNode cur2 = node2.next;
        //要放入的临时变量，放入时候需要遍历放入
        HeroNode tempPut =null;
        while (true){
            if (cur1==null){
                addNode(head,cur2);
                break;
            }else if (cur2 ==null){
                addNode(head,cur1);
                break;
            }
            if (cur1.no<=cur2.no){
                //取出小的保存起来
                tempPut=cur1;
                cur1=cur1.next;


                //需要将保存起来的节点的next=null
                tempPut.next=null;
                /**
                 *做链表的添加操作
                 */
                 addNode(head,tempPut);
            }else {
                //取出cur2保存
                tempPut=cur2;
                cur2=cur2.next;

                tempPut.next=null;
                /**
                 * 做链表的添加操作
                 */
                addNode(head,tempPut);
            }
        }
      return head;
    }

    /**
     * 添加节点数据
     * @param head
     * @param temPut
     */
    private static void addNode(HeroNode head, HeroNode temPut) {
        HeroNode temp= head;
        while (true){
            if (temp.next==null){
                temp.next=temPut;
                break;
            }
            temp=temp.next;
        }
    }

    /**
     * @Description:实现单链表的逆序打印
     * @Param: [node]
     * @return: void
     * @Author: zzs
     * @Date: 2020/2/29
     * @Implementation:
     *  利用栈特点，将链表每个节点存入栈中，然后遍历栈
     *  将栈的节点打印出来，实现链表的逆序打印
     *
     */
    public static void reversePrint(HeroNode node){
        if (node.next==null){
            return;
        }
       Stack<HeroNode> stack= new Stack<>();
        HeroNode cur = node.next;
        while (cur!=null){
            stack.push(cur);
        }
        //遍历栈
        while (stack.size()>0){
            System.out.print(stack.pop());
        }
    }


    /**
     * @Description:求单链表的有效节点个数【单链表面试题】
     * @Param: [heroNode]
     * @return: int
     * @Author: zzs
     * @Date: 2020/2/23
     * @Implementation:
     *  遍历单链表如果cur!=null则count++最后返回count
     *
     */
    public static int getLength(HeroNode heroNode){
        if (heroNode == null || heroNode.next == null) {
            return 0;
        }
        //从非头节点开始遍历
        int count  = 0;
        HeroNode cur = heroNode.next;
        while (cur!=null) {
            count++;
            cur = cur.next;
        }
        return count;
    }


    /**
     * @Description: 查找单链表中的倒数第k个节点【新浪面试题】
     * @Param: [heroNode, k]
     * @return: singlelinkedlist03.HeroNode
     * @Author: zzs
     * @Date: 2020/2/23
     * @Implementation:
     *   1，从非头节点的第一个节点开始找开始计数1，2，3，，，size[为单链表的长度]
     *   2，则第K个节点为单链表的size-k+1的位置 那么就是从1开始遍历，遍历到size-k+1的位置处返回
     *   3，size的长度怎么求？【遍历链表的有效节点数】
     */
    public static HeroNode findHeroNodeByLastK(HeroNode heroNode,int k){
        if (heroNode==null || heroNode.next==null ){
            return null;
        }
        int size = getLength(heroNode);
        if (k<1||k>size){
            return null;
        }
        //需要一个指针为当前节点
        HeroNode cur = heroNode.next;
        for (int i = 1;i< size - k +1;i++){
            //假设找到了这个节点由于重新赋值了，故只需要遍历到size-k+1-1的位置处 将 i<= 改为i<
            cur=cur.next;
        }
        return cur;
    }

    /**
     * @Description:单链表的反转【腾讯面试题】
     * @Param: [heroNode]
     * @return: singlelinkedlist03.HeroNode
     * @Author: zzs
     * @Date: 2020/2/23
     * @Implementation:
     *   pre: head-[node1-node2-node3]
     *   new: head
     *   主要思路：1遍历以前的单链表将节点取出cur
     *             2cur.next=head.next[让当前节点指向新链表的第一个节点]
     *             3head.next=cur[让新链表的头节点指向当前的节点]：这样子就连接起来了
     *             4让pre的head.next=new的head.next 重新赋值
     *
     *             注意最关键的处理是遍历那么下一个节点要保存cur=next [位置要在最前面保存起来]，
     *             怎样让当前节点=当前节点的下一个节点
     *
     */
    public static void reverse(HeroNode heroNode){

        //没有节点数据或者只有一个数据直接返回
        if (heroNode.next==null || heroNode.next.next==null){
            return ;
        }

        HeroNode newNodeHead = new HeroNode(0, "");
        //当前节点
        HeroNode cur = heroNode.next;
        //当前节点的下一个节点默认值为null
        HeroNode curNext = null;
        while (cur != null){
            //先保存下一个节点【这一步很关键】
            curNext=cur.next;
           //做主要逻辑处理
            cur.next=newNodeHead.next;
            newNodeHead.next=cur;
            //这样做遍历【这一步很关键】
            cur=curNext;
        }
        heroNode.next=newNodeHead.next;

    }

}

/**
 * 单链表：
 * 理解每次添加元素之和head和temp的值的变化，next域会变，temp和head的值一直等
 */
class SingleLinkedList{

    /**
     * 存储域
     */
    private  HeroNode head= new HeroNode(0,"");


    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     * 添加节点数据：
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        /**
         * 找到最后的节点，将新节点添加到最后
         */
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            //后移
            temp = temp.next;
        }
        temp.next=heroNode;
    }

    /**
     * 找到next域为null的直接放入
     * @param heroNode
     */
    public void addByDiGui(HeroNode heroNode){

       valid(head,heroNode);

    }

    /**
     * 添加的元素排序，且不能出现重复的数据编号
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode){
        /**
         * 思路：找到(temp.next)>heroNode.no的位置处 插入
         * 1,heroNode.next=temp.next
         * 2,temp.next=heroNode
         * 3,遍历单链表 temp = temp.next
         */
        HeroNode temp = head;
        /**
         * 换一种思路是：找到位置后，直接break，结束循环，最后设置值 否则temp=temp.next;遍历
         * 目前思路：有点麻烦
         */
        while(true){
            if (temp.next ==null){
                //可以直接添加，添加之前判断编号是否相等
                if (temp.no !=heroNode.no) {
                    temp.next = heroNode;
                }else {
                    System.out.printf("编号重复不能添加%d\n",heroNode.no);
                }
                break;
            }
            if (temp.next.no > heroNode.no){
                heroNode.next = temp.next;
                temp.next=heroNode;
                break;
            }else if (temp.next.no == heroNode.no){
                System.out.printf("编号重复不能添加%d\n",heroNode.no);
            }
            //没找到就遍历
            temp = temp.next;
        }

    }

    /**
     * 通过编号删除链表的元素
     * 思路：找到删除的元素：pre ->next
     *那么本元素由于没有引用会被垃圾回收器回收
     * @param no
     */
    public void del(int no){
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                System.out.print("没有删除的元素");
                break;
            }
            if (temp.next.no==no){
                break;//找到了
            }
            temp=temp.next;
        }
        temp.next=temp.next.next;

    }

    /**
     * 修改单链表的数据
     * 思路：找到要修改数据 修改
     */
    public void update(HeroNode newHeroNode){

        //指针
        HeroNode temp = head;
        while(true){
            if (temp==null){
                //到了尾部
                System.out.print("没有要修改的");
                break;
            }
            if (temp.no==newHeroNode.no){
                //为要修改的元素
               temp.name=newHeroNode.name;
               break;
            }
            temp=temp.next;
        }
    }


    private void valid(HeroNode head,HeroNode heroNode) {
        if (head==null){
            return;
        }
        if (head.next==null){
            head.next=heroNode;
        }else {
            valid(head.next,heroNode);
        }

    }

}


/**
 * 英雄节点
 */
class HeroNode{

    public int no;
    public String name;
    /**
     * 指向下一个节点
     */
    public HeroNode next;
    /**
     * paramz : {"feeds":[{"id":299080,"oid":288342,"category":"article","data":{"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}},{"id":299076,"oid":288340,"category":"article","data":{"subject":"荔枝新闻3.0：不止是阅读","summary":"江苏广电旗下资讯类手机应用\u201c荔枝新闻\u201d于近期推出全新升级换代的3.0版。","cover":"/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG","pic":"","format":"txt","changed":"2015-09-22 16:01:41"}}],"PageIndex":1,"PageSize":20,"TotalCount":53521,"TotalPage":2677}
     */

    private ParamzBean paramz;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public ParamzBean getParamz() {
        return paramz;
    }

    public void setParamz(ParamzBean paramz) {
        this.paramz = paramz;
    }

    public static class ParamzBean {
        /**
         * feeds : [{"id":299080,"oid":288342,"category":"article","data":{"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}},{"id":299076,"oid":288340,"category":"article","data":{"subject":"荔枝新闻3.0：不止是阅读","summary":"江苏广电旗下资讯类手机应用\u201c荔枝新闻\u201d于近期推出全新升级换代的3.0版。","cover":"/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG","pic":"","format":"txt","changed":"2015-09-22 16:01:41"}}]
         * PageIndex : 1
         * PageSize : 20
         * TotalCount : 53521
         * TotalPage : 2677
         */

        private int PageIndex;
        private int PageSize;
        private int TotalCount;
        private int TotalPage;
        private List<FeedsBean> feeds;

        public int getPageIndex() {
            return PageIndex;
        }

        public void setPageIndex(int PageIndex) {
            this.PageIndex = PageIndex;
        }

        public int getPageSize() {
            return PageSize;
        }

        public void setPageSize(int PageSize) {
            this.PageSize = PageSize;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public static class FeedsBean {
            /**
             * id : 299080
             * oid : 288342
             * category : article
             * data : {"subject":"视频直播：习近平马英九会面","summary":"两岸领导人习近平、马英九在新加坡会面","cover":"/Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG","pic":"","format":"video","changed":"2015-11-07 14:35:22"}
             */

            private int id;
            private int oid;
            private String category;
            private DataBean data;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * subject : 视频直播：习近平马英九会面
                 * summary : 两岸领导人习近平、马英九在新加坡会面
                 * cover : /Attachs/Article/288342/56a263bcab4a4c55b0bef0528ce880b6_padmini.JPG
                 * pic :
                 * format : video
                 * changed : 2015-11-07 14:35:22
                 */

                private String subject;
                private String summary;
                private String cover;
                private String pic;
                private String format;
                private String changed;

                public String getSubject() {
                    return subject;
                }

                public void setSubject(String subject) {
                    this.subject = subject;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }

                public String getChanged() {
                    return changed;
                }

                public void setChanged(String changed) {
                    this.changed = changed;
                }
            }
        }
    }
}

