package Solutions;

import java.util.Arrays;

public class Permutation {
    // 递归实现全排列
    static int ans=0;
    public static void permutation(int[] arr, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(arr));
            ans+=check(arr);
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i); // 交换元素
                permutation(arr, start + 1, end); // 递归求解
                swap(arr, start, i); // 恢复原数组
            }
        }
    }

    // 交换数组中两个元素的位置
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int check(int[] arr) {
        if (arr[0] + arr[1] / arr[2] + arr[3] * arr[4] * arr[5] / arr[6] * arr[7] * arr[8] == 10) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        permutation(arr, 0, arr.length - 1);
        System.out.println(ans);


    }


}

