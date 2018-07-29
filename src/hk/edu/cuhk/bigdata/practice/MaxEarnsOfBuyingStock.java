package hk.edu.cuhk.bigdata.practice;

/**
 * 面试题63：股票的最大利润
 * 假设把某股票的价格按时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大
 * 利润是多少？例如价格为{9, 11, 8, 5, 7, 12, 16, 14}。如果在5的时候买，在16的时候
 * 卖，可以获得最大利润11。
 *
 * 思路：在遍历数组到i时，如果维护前i-1个数的最小值，以及最大利润就可以实现O(n)的
 * 复杂度方案。
 */

public class MaxEarnsOfBuyingStock {
    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxEarns(prices));
    }
    private static int maxEarns(int[] prices) {
        if(prices.length < 2) return 0;
        int min = prices[0];
        int maxValue = prices[1] - prices[0];
        for(int i = 2; i < prices.length; i++) {
            if(prices[i-1] < min) min = prices[i-1];
            int currentEarn = prices[i] - min;
            if(currentEarn > maxValue) maxValue = currentEarn;
        }
        return maxValue;
    }
}
