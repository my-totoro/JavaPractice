package hk.edu.cuhk.bigdata.practice;

import java.util.Arrays;

/**
 * 面试题61：扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的，其中A为1，J为11，Q为12，K为13，
 * 而大小王可以看成任意数字。
 *
 * 思路：把大小王设置为0，判断0的个数与中间空缺的数字的个数，如果前者多，就可以组成连续的，另外如果
 * 有对子，肯定不会是连续的。首先对数组进行排序，然后算出0的个数以及空缺的个数。
 */

public class IsContinuousInPoker {
    public static void main(String[] args) {
        int[] numbers = {1, 4, 2, 5, 0, 7, 0};
        System.out.println(isContinuous(numbers));
    }

    private static boolean isContinuous(int[] numbers) {
        if(numbers.length == 0) return false;
        int numOfZeros = 0;
        int numOfGaps = 0;
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numOfZeros++;
        }
        for(int i = numOfZeros; i < numbers.length-1; i++) {
            //有顺子，肯定不是连续的
            if(numbers[i] == numbers[i+1]) return false;
            numOfGaps += numbers[i+1] - numbers[i] - 1;
        }

        return numOfGaps <= numOfZeros;
    }
}
