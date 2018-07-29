package hk.edu.cuhk.bigdata.practice;

/**
 * 面试题67：把字符串转换成正数
 *
 * 思路：需要考虑正负号，非数字输入，还要考虑溢出。用一个全局变量区分是非法
 * 输入，还是“0”，如果输出是0的话。
 */

enum Status {kValid, kInvalid};

public class CharArrayToInt {
    public static void main(String[] args) {
        char[] num = "-1243".toCharArray();
        int result = strToInt(num);
        if(result == 0 && gStatus == Status.kInvalid) {
            System.out.println("Invalid input.");

        } else {
            System.out.println(result);
        }
    }

    //不合法输入返回0，但是"0"也返回0，为了区分，设置一个全局变量
    static Status gStatus = Status.kValid;



    private static int strToInt(char[] str){
        gStatus = Status.kInvalid;
        boolean minus = false;
        int index = 0;
        long result = 0;
        if(str.length == 0) return 0;
        //考虑正负
        if(str[index] == '+') {
            index++;
        }
        if(str[index] == '-') {
            minus = true;
            index++;
        }
        while(index < str.length) {
            //考虑非数字输入
            if(str[index] >= '0' && str[index] <= '9') {
                result = result * 10 + str[index] - '0';
                //考虑溢出
                if((!minus && result > 0x7FFFFFFF) || (minus && -result < (int)0x80000000)) {
                    result = 0;
                    break;
                }
                index++;
            } else {
                result = 0;
                break;
            }

        }
        if(index == str.length) gStatus = Status.kValid;
        if(minus) result = -result;
        return (int)result;

    }
}

