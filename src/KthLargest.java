import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 */
public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[] {4,-2,2,2,1,-10,20};
        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
