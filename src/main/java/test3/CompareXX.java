package test3;

import java.util.Arrays;

/**
 * @ClassName ScalaDemo-CompareXX
 * @Author Holden_—__——___———____————_____Xiao
 * @Create 2021年10月19日18:18 - 周二
 * @Describe
 */
public class CompareXX {
    public static void main(String[] args) {
        String[] arr = new String[]{"BB", "AA", "DD", "KK", "MM", "JJ", "DD"};
        Arrays.sort(arr); //这是将地址传过去，所以可以直接改数组中的位置
        System.out.println(Arrays.toString(arr));
    }

    static void change(Object[] strs) {
        String temp = "";
        temp = (String) strs[0];
        strs[0] = strs[1];
        strs[1] = temp;
    }
}
