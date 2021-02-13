import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 992. K 个不同整数的子数组
 */
public class subarraysWithKDistinct {

    public static void main(String[] args) {

    }

    // 暴力法，超时了
    public int subarraysWithKDistinct2(int[] A, int K) {
        int res = 0;
        Set set = new HashSet();
        int len = A.length;
        for (int i = 0; i < len - K + 1; i++) {
            int setLen = 0;
            set.clear();
            for (int j = i; j < len; j++) {
                if (setLen < K){
                    if (!set.contains(A[j])){
                        set.add(A[j]);
                        setLen++;
                        if (setLen == K) res++;
                    }
                }else if(setLen == K){
                    if (set.contains(A[j])){
                        res++;
                    }else{
                        break;
                    }
                }
            }
        }
        return res;
    }

    // 双指针，来自于官方题解
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    /**
     * @param A
     * @param K
     * @return 最多包含 K 个不同整数的子区间的个数
     */
    private int atMostKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;
        // [left, right) 包含不同整数的个数小于等于 K
        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            // [left, right) 区间的长度就是对结果的贡献
            res += right - left;
        }
        return res;
    }

}
