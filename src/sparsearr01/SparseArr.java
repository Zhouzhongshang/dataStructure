package sparsearr01;

/**
 *
 * 稀疏数组的定义：
 * int[][] sparseArr = new [sum+1][2];
 * 第一行1:多少行  第一行2：多少列 第一行3：多少值
 * 下面的数据shi   1:i   2:j  3:value
 *
 * @author 86157
 * 稀疏数组
 * 实现：将一个棋盘中的黑白棋子保存到稀疏数组中
 *    ：将稀疏数组的值恢复到棋盘
 *    定义11*11的棋盘  1 2 1 （2行3列为1）   2 5 2 （3行6列为2）
 */
public class SparseArr {
    public static void main(String[] args) {
        int [][] chessArr =new int[11][11];
        //初始化棋盘数据
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        int sum =0;
        for (int i=0; i<chessArr.length;i++){
            for (int j=0;j<chessArr[i].length;j++){
                if (chessArr[i][j] != 0){
                   sum++;
                }
                System.out.printf("%d\t",chessArr[i][j]);
            }
            System.out.println();
        }
        //将棋盘数据转化为稀疏数组 行：数据量+1
        int [][] sparseArr =new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        /**
         * 遍历棋盘数据 第一个数据放在稀疏数组的第一行 第一列为i 第二列为j 第三列为value
         *             第二个数据放在第二行     第一列i 第二列j 第三列为value
         *             关键：怎么知道是第几个数据？计数器
         */
        int count=0;
        for (int i=0; i<chessArr.length;i++){
            for (int j=0;j<chessArr[i].length;j++){
                if (chessArr[i][j] != 0){
                    count++;
                   sparseArr[count][0]=i;
                   sparseArr[count][1]=j;
                   sparseArr[count][2]=chessArr[i][j];
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int i=0; i<sparseArr.length;i++){
            for (int j=0;j<sparseArr[i].length;j++){
                if (sparseArr[i][j] != 0){
                    sum++;
                }
                System.out.printf("%d\t",sparseArr[i][j]);
            }
            System.out.println();
        }

        System.out.println("棋盘二维数组：");
        /**
         * 创建数组：稀疏数组的第一行的第一个数据为 棋盘数组的行 第一行第二列为列 第一行的第三列为多少个不为0的数据
         * 遍历稀疏数组第二行开始遍历：第一个数据为棋盘数组的i 第二个数据为棋盘数组的j 第三个数据为棋盘数据的值
         */
        int[][] chess2Arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i= 1;i<sparseArr.length;i++){
          chess2Arr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int i=0; i<chess2Arr.length;i++){
            for (int j=0;j<chess2Arr[i].length;j++){
                if (chess2Arr[i][j] != 0){
                    sum++;
                }
                System.out.printf("%d\t",chess2Arr[i][j]);
            }
            System.out.println();
        }
    }
}
