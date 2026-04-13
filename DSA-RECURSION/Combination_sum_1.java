// 2.Combination Sum 1
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        fun(0, candidates, target, ans,current);
        return ans;
    }
    public void fun(int index, int[]arr ,int k,List<List<Integer>>ans ,List<Integer> current){
        if(k==0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if(index==arr.length||k<0) return;    
        current.add(arr[index]);          //Taking
        fun(index,arr,k-arr[index],ans, current);
        
        current.remove(current.size()-1); //Backtracking
         fun(index+1,arr,k,ans,current);   //Not Taking
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr= new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        int target = sc.nextInt();
        Solution s = new Solution();
        List<List<Integer>> ans = s.combinationSum(arr, target);
        System.out.println(ans);
    }
}
//Time Complexity
//The time complexity of this algorithm is O(2^t) where t is the target

//Space Complexity
//The space complexity is O(t) for the recursion stack and the current list, where t is the target.
//The space used for the answer list can be considered O(k) where k is the number of valid combinations found, but this is not typically included in space complexity analysis as it depends on the output size.

