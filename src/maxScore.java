import java.util.concurrent.ForkJoinPool;

/**
 * 1423. 可获得的最大点数
 */
public class maxScore {
    public static void main(String[] args) {
        int[] cardPoints = new int[] {1,79,80,1,1,1,200,1};
        int k = 3;
        System.out.println(new maxScore().maxScore(cardPoints, k));
    }

    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += cardPoints[i];
        }
        if (cardPoints.length == k) return max;
        int sum = max;
        for (int right = cardPoints.length - 1, i = 0; i < k; i++) {
            sum = sum + cardPoints[right - i] - cardPoints[k - 1 - i];
            if (sum > max) max = sum;
        }
        return max;
    }
}
