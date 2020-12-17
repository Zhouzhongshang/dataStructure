package Recursive;

/**
 * @program: dataStur
 * @description: 递归
 * @author: zzs
 * @create: 2020-04-11 15:14
 *
 * 栈空间，先执行最上面的
 *
 *   一个完整的程序，分为多个相同的方法，第一个方法未执行完成，接着就执行第二个方法了
 *   ，且只有最后一个方法才有值【也就是终点】，然后最后来到第一个方法前获得结果。
 *   参考：文档。
 **/
public class Recursive {
    /**
     * @Description: 走迷宫问题，用一个二维数组代表迷宫棋盘，从左上角开始走，走到右下角，为一个完整的路径。
     * @Param:        输出棋子走过的路径。
     * @return: 
     * @Author: 86157
     * @Date: 2020/4/11
     * @Implementation:
     *      1二维数组的默认值为0，墙的值为1，走通的值为2，走过的值为3【但是此路不通】
     *      2走路策略 下->右->上->左
     *
     */
    public static void main(String[] args) {

        int [][] map = new int[7][8];
        //设置上下的为1
        for (int i=0;i<8;i++){
            map[0][i]=1;
            map[6][i]=1;
        }
        //左右为1
        for (int i = 0;i<7;i++){
            map[i][0]=1;
            map[i][7]=1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("原始棋盘为：");
        out(map);

        //路线设定
        int i = 1;
        int j =1;
        setWay(map,i,j);
        System.out.println("找到的路线为：");
        out(map);

    }

    /**
     * 设置棋盘路线 0 未走 1墙 2能走通 3已经走过，走不通。
     *              下右上左策略
     *
     *         递归流程。
     *         1，先看终点是否为2，是则返回true.             <<<<<
     *         2,看当前点是否为0，是则可以走来，同时设置点为2.   |
     *         3，当设置点为2后，【执行找路策略】                |
     *                            向下走--------------------------
     *
     *
     * @param map
     * @param i
     * @param j
     */
    private static boolean setWay(int[][] map, int i, int j) {
        //路线找到
        if (map[5][6] == 2){
            return true;
        }
        //可以走
        if (map[i][j] == 0){
            //假设这个点能走通
             map[i][j] = 2;

             //关键点if条件的boolean
             if (setWay(map,i+1,j)){
                 //向下走
               return  true;
             }else if (setWay(map,i,j+1)){
                 //右
                 return true;
             }else if (setWay(map,i-1,j)){
                 //上
                 return true;
             }else if (setWay(map,i,j-1)){
                 //左
                 return true;
             }else {
               //尝试下后发现后面没有路了，标记这个点为3 ，走不通
                 map[i][j] =3;
                 return false;
             }
        }else {
            //已经走过了
            return false;
        }
    }

    private static void out(int[][] map) {
        for (int i = 0; i<map.length;i++){
            for (int j = 0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            //每输出一行就换行
            System.out.println();
        }
    }
}
