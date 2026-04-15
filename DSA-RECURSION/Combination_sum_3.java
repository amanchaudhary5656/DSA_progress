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
