class Solution {
    public int minSubArrayLen(int target, int[] nums) {
      int  left=0, pre=0, ans=nums.length+1;
      for(int right=0; right<nums.length; right++){
        pre+=nums[right];
        while(pre>=target){
            ans= Math.min(ans, right-left+1);
            pre-=nums[left++];
           
        }
      }
      return ans==nums.length+1?0:ans;

    }
}