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
    public static int findMax(Integer[] input) {
        int maxVal = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > maxVal)
                maxVal = input[i];
        }
        return maxVal;
    }

    public static Integer[] findDuplicates(Integer[] input) {
        Map<Integer, Integer> duplicateHashMap = new HashMap<>();
        for (Integer elem : input) {
            if (duplicateHashMap.get(elem) == null) {
                duplicateHashMap.put(elem, 1);
            } else {
                duplicateHashMap.put(elem, duplicateHashMap.get(elem) + 1);
            }
        }
        duplicateHashMap.values().removeIf(value -> value == 1);
        return duplicateHashMap.keySet().toArray(Integer[]::new);
    }

    public static Integer[] findUnique(Integer[] input) {
        Map<Integer, Integer> uniqueHashMap = new HashMap<>();
        for (Integer elem : input) {
            if (uniqueHashMap.get(elem) == null) {
                uniqueHashMap.put(elem, 1);
            } else {
                uniqueHashMap.put(elem, uniqueHashMap.get(elem) + 1);
            }
        }
        uniqueHashMap.values().removeIf(value -> value > 1);

        return uniqueHashMap.keySet().toArray(Integer[]::new);
    }
}

