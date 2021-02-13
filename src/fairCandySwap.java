import java.util.Arrays;

/**
 * 888. 公平的糖果棒交换
 */
public class fairCandySwap {

    public static void main(String[] args) {
        int[] A = {1, 2, 5};
        int[] B = {2, 4};
        System.out.println(Arrays.toString(new fairCandySwap().fairCandySwap(A, B)));
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int diff = sum(A) - sum(B);
        for(int a: A){
            for(int b: B){
                if (a - b == diff / 2){
                    res[0] = a;
                    res[1] = b;
                    return res;
                }
            }
        }
        return res;
    }

    public static int sum(int[] array){
        int value = 0;
        for (int i: array){
            value += i;
        }
        return value;
    }
}
