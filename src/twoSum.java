import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 9};
        System.out.println(Arrays.toString(new twoSum().twoSum(nums, 4)));
    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++){
            int res = find(numbers, target - numbers[i], 0, numbers.length - 1, i);
            if (res != -1){
                return new int[]{i + 1, res + 1};
            }
        }
        return new int[]{0, 0};
    }

    int find(int[] nums, int target, int left, int right, int currentindex){
        if (target < nums[left] || target > nums[right] || left > right){
            return -1;
        }
        int mid = (right + left) / 2;
        if (target > nums[mid]){
            return find(nums, target, mid + 1, right, currentindex);
        }else if (target < nums[mid]){
            return find(nums, target, left, mid - 1, currentindex);
        }else {
            if (mid == currentindex){
                if (target == nums[mid + 1]){
                    return mid + 1;
                }else{
                    return mid - 1;
                }
            }else{
                return mid;
            }
        }
    }

    // 二分查找法2
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 双指针
    public int[] twoSum3(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }

}
