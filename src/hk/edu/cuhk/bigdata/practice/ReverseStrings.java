package hk.edu.cuhk.bigdata.practice;

/**
 * 面试题58：翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 *
 * 思路：先翻转句子中的所有字符：例如"I am a student."变为".tneduts a ma I"，然后再翻转各个单词。
 *
 * 变种：左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。例如输入"abcdefg"和2，该函数返回左旋转
 * 两位得到的结果"cdefgab"。
 *
 * 思路：先把整个字符串分成两部分，前面两位和剩余的，先分别翻转这两部分得到"bagfedc"，然后再翻转整个字符串，
 * 得到"cdegfab"。
 */



public class ReverseStrings {
    public static void main(String[] args) {
        char[] sentence = "I am a student.".toCharArray();
        char[] arr = "abcdefg".toCharArray();
        reverseSentence(sentence);
        System.out.println(sentence);
        leftShiftStrings(arr, 1);
        System.out.println(arr);

    }

    // 在begin和end之间的元素调换顺序
    private static void reverse(char[] stringArray, int begin, int end) {
        if(begin >= end && stringArray.length <= 1) return;
        while(begin < end) {
            char temp = stringArray[begin];
            stringArray[begin] = stringArray[end];
            stringArray[end] = temp;
            begin++;
            end--;
        }
    }

    // 先翻转整个句子的各个字符，然后再翻转各个单词
    private static void reverseSentence(char[] sentence) {
        reverse(sentence, 0, sentence.length-1);
        int begin = 0;
        for(int i = 0; i < sentence.length; i++) {
            if(sentence[i] == ' ') {
                reverse(sentence, begin, i-1);
                begin = i + 1;
            }
        }
    }

    // 注意判断边界条件
    private static void leftShiftStrings(char[] arr, int count) {
        if(count > 0 && arr.length > count) {
            reverse(arr, 0, count-1);
            reverse(arr, count, arr.length-1);
            reverse(arr, 0, arr.length-1);
        }

    }
}
