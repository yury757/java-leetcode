import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 480. 滑动窗口中位数
 */
public class medianSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new medianSlidingWindow().medianSlidingWindow(nums, 5)));
    }

    // 暴力解法
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        double[] ans = new double[cnt];
        int[] t = new int[k];
        for (int l = 0, r = l + k - 1; r < n; l++, r++) {
            for (int i = l; i <= r; i++) t[i - l] = nums[i];
            Arrays.sort(t);
            ans[l] = (t[k / 2] / 2.0) + (t[(k - 1) / 2] / 2.0);
        }
        return ans;
    }

    // 优先队列（堆）解法
    public double[] medianSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        double[] ans = new double[cnt];
        // 如果是奇数滑动窗口，让 right 的数量比 left 多一个
        PriorityQueue<Integer> left  = new PriorityQueue<>((a,b)->Integer.compare(b,a)); // 滑动窗口的左半部分
        PriorityQueue<Integer> right = new PriorityQueue<>((a,b)->Integer.compare(a,b)); // 滑动窗口的右半部分
        for (int i = 0; i < k; i++) right.add(nums[i]);
        for (int i = 0; i < k / 2; i++) left.add(right.poll());
        ans[0] = getMid(left, right);
        for (int i = k; i < n; i++) {
            // 人为确保了 right 会比 left 多，因此，删除和添加都与 right 比较（left 可能为空）
            int add = nums[i], del = nums[i - k];
            if (add >= right.peek()) {
                right.add(add);
            } else {
                left.add(add);
            }
            if (del >= right.peek()) {
                right.remove(del);
            } else {
                left.remove(del);
            }
            adjust(left, right);
            ans[i - k + 1] = getMid(left, right);
        }
        return ans;
    }
    void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size() > right.size()) right.add(left.poll());
        while (right.size() - left.size() > 1) left.add(right.poll());
    }
    double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return (left.peek() / 2.0) + (right.peek() / 2.0);
        } else {
            return right.peek() * 1.0;
        }
    }

}

