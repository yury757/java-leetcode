import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 */
public class getRow {
    public static void main(String[] args) {
        int rowIndex = 10;
        System.out.println(new getRow().getRow(rowIndex).toString());
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++){
            list.add(1);
            for (int j = i - 1; j > 0; j--){
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}
