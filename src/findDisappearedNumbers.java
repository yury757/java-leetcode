import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class findDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(new findDisappearedNumbers().findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            res.add(i + 1);
        }
        for (int each: nums){
            res.set(each - 1, -1);
        }
        for (int i = nums.length - 1; i >= 0; i--){
            if (res.get(i) == -1) res.remove(i);
        }
        return res;
    }
}
