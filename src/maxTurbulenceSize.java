import com.sun.scenario.effect.impl.prism.ps.PPSBlend_MULTIPLYPeer;

/**
 * 978. 最长湍流子数组
 */
public class maxTurbulenceSize {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3};
        System.out.println(new maxTurbulenceSize().maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int flag = 0;
        int sum = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (flag > 0 && arr[i] < last || flag < 0 && arr[i] > last){
                flag = -flag;
                sum++;
                if (sum > res) res = sum;
            }else if (flag == 0 && arr[i] != last) {
                flag = arr[i] > last? 1: -1;
                sum++;
                if (sum > res) res = sum;
            }else if (flag != 0 && arr[i] != last){
                flag = arr[i] > last? 1: -1;
                sum = 2;
            }else{
                flag = 0;
                sum = 1;
            }
            last = arr[i];
        }
        return res;
    }
}
