class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
       
        
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
         Boolean [][]dp  = new Boolean[nums.length][sum+1];
        return function(nums,sum/2, 0,dp);
    }

    public static boolean function(int [] arr, int s, int i,Boolean [][]dp){
        if(s==0) return true;
        if(i>=arr.length || s<0) return false;
        if(dp[i][s]!=null) return dp[i][s];
        
        boolean pick=false;;
        if(arr[i]<=s){
            pick = function(arr,s-arr[i] , i+1,dp);
        }
        boolean notpick = function(arr, s, i+1,dp);
        return dp[i][s]=pick || notpick;
    }
}