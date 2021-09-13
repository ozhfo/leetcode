package algorithm.二分查找;

public class LC_001 {

    public static void main(String[] args) {
        LC_001 lc = new LC_001();
        for (int i = 1; i < 20; i++) {
            int sqrt = lc.sqrt(i);
            System.out.println(i + "的平方根 = " + sqrt);
        }
    }

    /**
     * 计算平方根
     * @param x
     * @return
     */
    private int sqrt(int x) {
        if(x == 1 ){
            return 1;
        }
        int left = 1, right = x / 2 +  1;
        int sqrt = 0;
        while(left <= right){
            int middle = (left + right) / 2;
            sqrt = middle;
            if(middle * middle < x){
                left = middle + 1;
            }else if(middle * middle > x){
                right = middle - 1;
            }else{
                return middle;
            }
        }
        return sqrt;
    }


}
