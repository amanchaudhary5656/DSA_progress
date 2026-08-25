class Solution {
    public boolean check(int[] arr, int m, int k, int mid){
        int count=0, b=0;
        for(int i=0; i<arr.length; i++){
             if(arr[i]<=mid) count++;
             else count=0;
             if(count==k){
                b++;
                count=0;
             }
             if(b>=m) return true;
        }
        
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low=Integer.MAX_VALUE, high =0;
        for(int i : bloomDay){
            low = Math.min(low, i);
            high = Math.max(high, i);
        }
        int ans= -1;
        while(low<=high){
            int mid  = low + (high-low)/2;
            if(check(bloomDay, m , k , mid)){
                ans= mid;
                high = mid-1;
            }
            else low= mid+1;
        }
        return ans;

    }
}