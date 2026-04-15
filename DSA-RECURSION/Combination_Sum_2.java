// 3. Combination Sum 1 https://leetcode.com/problems/combination-sum-ii/

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] arr, int target, int start, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break; 
            current.add(arr[i]);
            backtrack(arr, target - arr[i], i + 1, current, ans); 
            current.remove(current.size() - 1); 
        }
    }   
    public static void main(String[] args){
        Scanner sc =new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Solution s = new Solution();
        List<List<Integer>> ans = s.combinationSum2(arr, target);
        System.out.println(ans);


    }
}
