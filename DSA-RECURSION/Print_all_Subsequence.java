// 1. Brute Force Approach to print all subsequence for an Array?

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> ans = new ArrayList<>();

        fun(0, arr, ans, new ArrayList<>());

        // Better printing
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    public static void fun(int index, int[] arr, List<List<Integer>> ans, List<Integer> current) {
        if (index == arr.length) {
            ans.add(new ArrayList<>(current)); // correct copy
            return;
        }

        // Take element
        current.add(arr[index]);
        fun(index + 1, arr, ans, current);

        // Not take element (backtrack)
        current.remove(current.size() - 1);
        fun(index + 1, arr, ans, current);
    }
}
//Total Time Complexity
//Number of subsequences = 2ⁿ
//Copy per subsequence = O(n)
//Overall Time Complexity = O(n * 2ⁿ)

//Space Complexity
//Auxiliary Space = O(n) (for the current list and recursion stack)