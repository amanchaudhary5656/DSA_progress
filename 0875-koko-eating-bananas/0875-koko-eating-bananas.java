class Solution {
    public boolean check(int[] piles, int h, int k){
        int ans=0;
        for(int i: piles){
            ans = ans+ (int)Math.ceil((double)i/k);
        }
        return ans<=h;


    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1, high=Integer.MAX_VALUE;
        
        int ans=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(piles, h, mid)){
                ans =mid;
                high = mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }
}