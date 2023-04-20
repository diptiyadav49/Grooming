import java.util.Arrays;

public class GenericSort<T extends Comparable<T>> {

    public void sort(T[] arr) {
        if (arr == null) {
            throw new NullPointerException("Array cannot be null");
        }
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        Integer[] intArr = {4, 2, 7, 1, 3};
        String[] stringArr = {"this", "is", "generic", "sort"};
        Character[] charArr = {'c', 'a', 'b', 'f', 'e'};

        GenericSort<Integer> intSort = new GenericSort<>();
        intSort.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        GenericSort<String> stringSort = new GenericSort<>();
        stringSort.sort(stringArr);
        System.out.println(Arrays.toString(stringArr));

        GenericSort<Character> charSort = new GenericSort<>();
        charSort.sort(charArr);
        System.out.println(Arrays.toString(charArr));
    }
}