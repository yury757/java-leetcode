import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * 567. 字符串的排列
 */
public class checkInclusion {

    public static void main(String[] args) {
        String s1 = "aba";
        String s2 = "eidbabobaoo";
        System.out.println(new checkInclusion().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int mapLen = s1.length();
        for(int i = 0; i < s1.length(); i++){
            if (map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }else{
                map.put(s1.charAt(i), 1);
            }
        }
        int left = 0;
        int right = 0;
        while (right < s2.length()){
            if (map.containsKey(s2.charAt(right)) && map.get(s2.charAt(right)) > 0){
                // s1中的字符在s2的连续子字符中
                map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
                mapLen--;
                if (mapLen == 0) return true;
            }else if (map.containsKey(s2.charAt(right)) && map.get(s2.charAt(right)) == 0){
                // s1中的字符在s2的连续子字符中，但s1的字符用完了
                // 从left开始复原，直到第一次出现那个用完了的字符
                while (s2.charAt(left) != s2.charAt(right) && left < right){
                    if (map.containsKey(s2.charAt(left))){
                        map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
                    }else{
                        map.put(s2.charAt(left), 1);
                    }
                    left++;
                    mapLen++;
                }
                left++;
            }else{
                // 找到一个s1的字符不在s2的连续子字符中
                // 把从left到right(左闭右开)之间的字符状态还原，并且把left移动到right右边一位
                for (int i = left; i < right; i++){
                    if (map.containsKey(s2.charAt(i))){
                        map.put(s2.charAt(i), map.get(s2.charAt(i)) + 1);
                    }else{
                        map.put(s2.charAt(i), 1);
                    }
                    mapLen++;
                }
                left = right + 1;
            }
            right++;
        }
        return false;
    }
}
