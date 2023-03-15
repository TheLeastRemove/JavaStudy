package Solutions;

import java.util.*;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);


    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        permuteHelper(list, nums.length, result);
        return result;
    }

    private static void permuteHelper(List<Integer> list, int size, List<List<Integer>> result) {
        if (size == 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < size; i++) {
            permuteHelper(list, size - 1, result);
            if (size % 2 == 0) {
                Collections.swap(list, i, size - 1);
            } else {
                Collections.swap(list, 0, size - 1);
            }
        }
    }
}

