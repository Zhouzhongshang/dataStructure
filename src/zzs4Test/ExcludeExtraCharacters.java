package zzs4Test;

/**
 * @program: dataStur
 * @description: 排除多余字符
 * @author: zzs
 * @create: 2020-07-14 14:31
 *
 *
 *   思路; 从尾部遍历，如果额外的字符串中包含 输入的字符串的尾部字符则继续遍历
 *    如果不包含则直接输出。
 **/
public class ExcludeExtraCharacters {
    public static void main(String[] args) {
        String extraCharacters = "*#&$";
        String inputString = "asdfghj#$g#";

        byte[] extraCharactersBytes = extraCharacters.getBytes();
        byte[] inputStringBytes = inputString.getBytes();

        //不包含直接输出
        for (int j = inputStringBytes.length - 1; j >= 0 ; j--){
            boolean flag = false;
             for (int a = 0; a < extraCharactersBytes.length; a++ ){
                 if (extraCharactersBytes.equals(inputStringBytes[j])){
                     flag = true;
                 }
             }
             if (!flag){
                 System.out.println(inputString.substring(0,j));
                 break;
             }
        }

        for (int i= inputString.length() - 1 ; i >= 0 ; i-- ){
            char c = inputString.charAt(i);
            if (!extraCharacters.contains(String.valueOf(c))){
                System.out.println(inputString.substring(0,i+1));
                break;
            }
        }

    }
}
