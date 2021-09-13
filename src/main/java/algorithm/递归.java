package algorithm;

/**
 * TODO
 * <p>
 * User: zhf
 * DateTime: 2020/11/6 12:02 上午
 */
public class 递归 {

    // 递归判断数组是否有序

    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] str = new char[]{'a','b','c','d','e','f','g','h','i','j','k'};
 //        System.out.println(judgeIfSorted(temp.length - 1, temp));
//        printStrDesc(0, temp);
        System.out.print(reverseStr(0,str.length - 1, str).toString());
    }

    /**
     * 递归判断数组是否有序
     * 依次判断相邻的值 a[n] > a[n-1] 继续判断 a[n-1] > a[n-2] 否则false
      */
    public static  Boolean judgeIfSorted(int n, int[] array) {
        if (n == 1) {
            return array[1] >= array[0] ? true : false;
        } else{
            return array[n] >= array[n - 1] ? judgeIfSorted(n-1, array) : false;
        }
    }

    /**
     * 以相反顺序打印字符串
     * 递归的方法是栈 先入栈后操作 全部入栈之后在输出 然后依次出栈输出 就变成了倒序
     */
    public static void printStrDesc(int n, int[] array){
        if(n >= array.length) {
            return;
        }
        printStrDesc(n + 1, array);
        System.out.println(array[n]);
    }

    /**
     * 反转字符串 修改数组
     * 输入[1,2,3,4,5]
     * 输出[5,4,3,2,1]
     */
    public static char[] reverseStr(int start, int end, char[] array){
        char temp ;
        temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        if(start + 1 != end && start != end){
            reverseStr(start + 1, end - 1,array);
        }
        return array;
    }

}