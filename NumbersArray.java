import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static int findMax(Integer[] arr) {
        int max = arr[0];
        for (int n : arr) if (n > max) max = n;
        return max;
    }

    public static Integer[] findDuplicates(Integer[] arr) {
        Map<Integer, Integer> count = new LinkedHashMap<>();
        for (int n : arr) count.merge(n, 1, Integer::sum);
        List<Integer> dup = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() > 1) dup.add(e.getKey());
        }
        return dup.toArray(new Integer[0]);
    }

    public static Integer[] findUnique(Integer[] arr) {
        Map<Integer, Integer> count = new LinkedHashMap<>();
        for (int n : arr) count.merge(n, 1, Integer::sum);
        List<Integer> uniq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() == 1) uniq.add(e.getKey());
        }
        return uniq.toArray(new Integer[0]);
    }
}

