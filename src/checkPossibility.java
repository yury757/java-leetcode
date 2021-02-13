/**
 * 665. 非递减数列
 */
public class checkPossibility {
    public static void main(String[] args) {
        int[] nums = new int[] {3,4,2,3};
        System.out.println(new checkPossibility().checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        int number = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max){
                max = nums[i];
            }else{
                number++;
            }
            if (number > 1) return false;
        }
        return true;
    }
}
