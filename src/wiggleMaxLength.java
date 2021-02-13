public class wiggleMaxLength {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,9,2,5};
        System.out.println(new wiggleMaxLength().wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++){
            diff[i] = nums[i + 1] - nums[i];
        }
        int last = 0;
        for (int i = 0; i < diff.length; i++){
            if (diff[i] != 0){
                last = diff[i] > 0 ? -1 : 1;
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < diff.length; i++){
            if (last > 0 && diff[i] < 0 || last < 0 && diff[i] > 0){
                last = diff[i];
                res++;
            }
        }
        return res + 1;
    }
}
