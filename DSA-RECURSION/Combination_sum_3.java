//4. Combination sum 3 https://leetcode.com/problems/combination-sum-iii/submissions/1959774697/

import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        fun(k,n,ans,current,1);
        return ans;
    }
    public void fun(int k, int n, List<List<Integer>> ans ,  List<Integer> current,int index){
        if(n==0&& current.size()==k){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(current.size()>k||n<0) return;
        for(int start=index;start<=9;start++){
            current.add(start);
            fun(k,n-start,ans,current,start+1);
            current.remove(current.size()-1);

        }
    }
    public static void main(String[] args0){
        Scanner sc= new Scanner(System.in);
        int k =sc.nextInt();
        int n = sc.nextInt();
        Solution s= new Solution();
        List<List<Integer>> ans = s.combinationSum3(k, n);
        System.out.println(ans);
    }
}
//Time Complexity
//The time complexity of this algorithm is O(2^k) where k is the number
//of numbers to be chosen, as in the worst case, we may explore all combinations of numbers from 1 to 9 that sum up to n.
//Space Complexity  
//The space complexity is O(k) for the recursion stack and the current list, where k is the number of numbers to be chosen.
// The space used for the answer list can be considered O(m) where m is the number of valid combinations found, but this is not typically included in space complexity analysis as it depends on the output size.