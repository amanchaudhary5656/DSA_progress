
//5. SubSet Sum...https://www.geeksforgeeks.org/problems/subset-sums2234/1
import java.util.*;

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        function(0, 0, result, arr);
        
        Collections.sort(result); 
        
        return result;
    }

    public void function(int sum, int i, ArrayList<Integer> result, int[] arr) {
        if (i == arr.length) {
            result.add(sum);
            return;
        }

        function(sum + arr[i], i + 1, result, arr);

        function(sum, i + 1, result, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solution s = new Solution();
        ArrayList<Integer> ans = s.subsetSums(arr);

        for (int i : ans) {
            System.out.print(i + " ");
        }

        
    }
}