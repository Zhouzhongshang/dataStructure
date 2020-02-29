package jumpstairs;

import java.util.Scanner;

/**
 * @author 86157
 */
public class Jump{
    public static void main(String[] args) {
        System.out.print("请输入台阶的个数:");
        long i = new Scanner(System.in).nextLong();
        int total=val(i);
        System.out.printf("有%d种",total);
    }

    private static int val(long i) {
        if (i==1){
            return 1;
        }
        if (i==2){
            return 2;
        }
        if (i==3){
            return 3;
        }
        /**
         * 第一次跳1个台阶剩下的有f(n-1) 跳2个台阶剩下的有f(n-2)
         * 当n个台阶时总数为f(n)=f(n-1)+f(n-2)
         */
        return val(i-1)+val(i-2);
    }
}
