package hk.edu.cuhk.bigdata.practice;

/**
 * 面试题57：和为s的数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s，如果有多对数字
 * 和等于s，则输出任意一对即可。
 *
 * 思路：首先选择最大和最小的数字，如果它们的和大于s，那么最大的数字换成次大，继续次操作，如果
 * 和大于s，则把大的数左移减小，如果和小于s，则把小的数右移增大。
 *
 * 变种：和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如，输入15，由于1+2+3+4+5=
 * 4+5+6=7+8=15，所以打印出3组连续序列1~5，4~6，7~8。
 *
 * 思路：初始化small为1，big为2，如果和小于s，则增大big，如果和大于s，则增大small。
 */
public class SumToS {
    public static void main(String[] args) {
        int[] dataArray = {1, 2, 4, 7, 11, 15};
        findTwoNumSumToS(dataArray, 25);
        findContinuousSequenceSumToS(15);
    }

    private static void findTwoNumSumToS(int[] dataArray, int s) {
        if(dataArray.length == 0) return;
        int begin = 0;
        int end = dataArray.length - 1;
        while(begin < end) {
            if(dataArray[begin] + dataArray[end] > s) {
                end--;
            } else if(dataArray[begin] + dataArray[end] < s) {
                begin++;
            } else {
                System.out.format("Found %d, %d", dataArray[begin], dataArray[end]);
                break;
            }
        }
    }

    private static void findContinuousSequenceSumToS(int s) {
        if(s < 3) return;
        int small = 1;
        int big = 2;
        int currentSum = small + big;
        int mid = (s + 1)/2;
        while(small < mid) {
            if(currentSum > s) {
                currentSum -= small;
                small++;
            } else if(currentSum < s) {
                big++;
                currentSum += big;
            } else {
                printSequence(small, big);
                currentSum -= small;
                small++;
            }
        }
    }

    private static void printSequence(int small, int big) {
        for(int i = small; i <= big; i++) {
            System.out.format("%d ", i);
        }
        System.out.print("\n");
    }
}
