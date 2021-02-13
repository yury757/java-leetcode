/**
 * 1208. 尽可能使字符串相等
 */
public class equalSubstring {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "dcde";
        int maxCost = 0;
        System.out.println(new equalSubstring().equalSubstring(s, t, maxCost));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost_array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost_array[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0, right = 0, sum = 0;
        int res = 0;
        while(right < s.length()){
            sum += cost_array[right];
            if (sum <= maxCost){
                res ++;
            }else{
                sum -= cost_array[left];
                left ++;
            }
            right ++;
        }
        return res;
    }
}
