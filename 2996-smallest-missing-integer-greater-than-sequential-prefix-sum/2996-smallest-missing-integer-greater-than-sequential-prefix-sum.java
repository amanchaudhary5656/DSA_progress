class Solution {
    public int missingInteger(int[] nums) {
        int n= nums.length;
        HashSet< Integer> set = new HashSet<>();
        if(n==1) return nums[0]+1;
        int sum=nums[0];
        int i=1;
        while(i<n && nums[i]==nums[i-1]+1){
            sum +=nums[i];
            i++;
        }
        for(int j=0;j<n;j++){
            set.add(nums[j]);
        }
        while(true){
        if(!set.contains(sum)) return sum;
        else sum=sum+1;
        }



    }
}