import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(2,5));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2,4));
        ArrayList<Integer> arr3 = getUnionOf(arr1,arr2);
        System.out.println(arr3);
        ArrayList<String> arr4 = new ArrayList<>(Arrays.asList("あ","い"));
        ArrayList<String> arr5 = new ArrayList<>(Arrays.asList("い","え", "お"));
        ArrayList<String> arr6 = getUnionOf(arr4,arr5);
        System.out.println(arr6);
    }

    public static <T> ArrayList<T> getUnionOf(ArrayList<T> ints1, ArrayList<T> ints2){
        ArrayList<T> union = new ArrayList<T>();
        for(int i = 0;i < ints1.size();i++) {
            union.add(ints1.get(i));
        }
        for(int i = 0;i < ints2.size();i++) {
            union.add(ints2.get(i));
        }
        return union;
    }
}

