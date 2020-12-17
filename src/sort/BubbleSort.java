package sort;

import java.util.Arrays;

/**
 * @program: dataStur
 * @description: 冒泡排序
 * @author: zzs
 * @create: 2020-07-16 18:10
 **/
public class BubbleSort {

    public static void main(String[] args) {
        //冒泡排序 从小到大 大的往后移
        int [] arrInt = {3,1,4,-1,9,-2};
        //表示外层循环遍历的次数
        for (int i = 0 ; i < arrInt.length-1;i++){
            int temp;
            //表示从第一个元素开始遍历
            for (int j= 0; j<arrInt.length-1-i;j++){
                if (arrInt[j] > arrInt[j+1]){
                    // 大的位置存放大的值，小的位置存放temp temp = 小的值
                   /* temp = arrInt[j+1];
                    arrInt[j+1] = arrInt[j];
                    arrInt[j]=temp;*/

                  //小的位置存放小的值，大的位置存放temp temp = 大的值
                  temp = arrInt[j];
                  arrInt[j] = arrInt[j+1];
                  arrInt[j+1] = temp;
                }
            }
            System.out.println("第："+i+"次"+ Arrays.toString(arrInt));
        }
          System.out.println(Arrays.toString(arrInt));
    }
}
