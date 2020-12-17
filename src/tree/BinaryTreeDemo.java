package tree;

/**
 * @program: dataStur
 * @description: 二叉树
 * @author: zzs
 * @create: 2020-07-17 17:04
 **/
public class BinaryTreeDemo {

    /**
     * 理解
     * 有参数  (root递归): (root.leftChild)
     * 无参数  root.():   root.leftChild.()
     */

    public static void main(String[] args) {

        HeroNode root = new HeroNode(1, "宋江");
        BinaryTree binaryTree = new BinaryTree(root);
        HeroNode ch2 = new HeroNode(2, "吴用");
        HeroNode ch3 = new HeroNode(3, "卢俊义");
        HeroNode ch4 = new HeroNode(4, "林冲");
        HeroNode ch5 = new HeroNode(5, "鲁智深");
        root.leftChild=ch2;
        root.rightChild=ch3;
        ch3.rightChild=ch4;
        ch3.leftChild=ch5;
        binaryTree.preOrder();
        binaryTree.inOrder();
        binaryTree.postOrder();

//        System.out.println("list():");
//        binaryTree.root.list();
//
//        System.out.println("Binary(in)");
//        BinaryTree.list(root);


    }
}


/**
 * 二叉树定义
 */
class BinaryTree{
     public HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

//    public static void list(HeroNode root) {
//        //中序遍历
//        if (root!=null){
//            //先找左
//            BinaryTree.list(root.leftChild);
//            //打印中间的节点
//            System.out.println(root);
//            //再找右
//            BinaryTree.list(root.rightChild);
//        }
//    }

    /**
     * 前序遍历：先root在左子树再右子树
     */
    public void preOrder(){
        System.out.println("pre:");
         root.preOrder();
    }

    public void inOrder(){
        System.out.println("in:");
        root.inOrder();
    }

    public void postOrder(){
        System.out.println("post:");
        root.postOrder();
    }
}
/**
 * 节点对象定义
 */
class HeroNode{
    public int no;
    public String name;
    public HeroNode leftChild;
    public HeroNode rightChild;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 前序遍历：先root在左子树再右子树
     */
    public void preOrder(){
        System.out.println(this);
        if (this.leftChild!=null){
            this.leftChild.preOrder();
        }
        if (this.rightChild!=null){
            this.rightChild.preOrder();
        }
    }

    public void inOrder(){
        if (this.leftChild!=null){
            this.leftChild.inOrder();
        }
        System.out.println(this);
        if (this.rightChild!=null){
            this.rightChild.inOrder();
        }
    }

    public void postOrder(){

        if (this.leftChild!=null){
            this.leftChild.postOrder();
        }

        if (this.rightChild!=null){
            this.rightChild.postOrder();
        }
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

//    public void list() {
//        //root
//        System.out.println(this.toString());
//        //left
//        if (this.leftChild!=null){
//            this.leftChild.list();
//        }
//        //right
//        if (this.rightChild!=null){
//            this.rightChild.list();
//        }
//    }
}
