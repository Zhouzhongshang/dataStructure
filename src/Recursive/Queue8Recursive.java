package Recursive;

import java.util.stream.Stream;

/**
 * @program: dataStur
 * @description: 8皇后问题
 * @author: zzs
 * @create: 2020-04-12 14:45
 **/
public class Queue8Recursive {

    int max = 8;
    int [] arr = new int[max];

    /**
     * 1) 第一个皇后先放第一行第一列
     * 2) 第二个皇后放在第二行第一列、然后判断是否 OK， 如果不 OK，继续放在第二列、第三列、依次把所有列都 放完，找到一个合适
     * 3) 继续第三个皇后，还是第一列、第二列……直到第 8 个皇后也能放在一个不冲突的位置，算是找到了一个正确 解
     * 4) 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解， 全部得到.
     * 5) 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4 的步骤
     *
     * 定义一个一位数组，数组下表代表第几行，数组的值arr[index] 代表第几列
     *   例如：{0 , 4, 7, 5, 2, 6, 1, 3}  第一列第一行 第二列第五行 、、、第八列第四行
     * @param args
     */
    public static void main(String[] args) {
        Queue8Recursive queue8Recursive = new Queue8Recursive();

    }

    /**
     * 表例第n个皇后 是否满足条件
     * @param
     * @return
     */
  /*  private boolean judge(int n){
           //同一行X  列判断  斜线判断
      for (int i= 0;i< n; i++){
          if ()
      }
    }*/



    //打印数组
    private  void out(int [] arr){
        Stream.of(arr).forEach(i->{
            System.out.println(i+" ");
        });
    }

}
