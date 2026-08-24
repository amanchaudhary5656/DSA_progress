class Solution {
    public int mySqrt(int x) {
        int low=1, high = x;
        int ans=0;
        if(x==1 || x==2) return 1;
        if(x==0) return 0;
        while(low<=high){
            long mid = low+(high-low)/2;
            if(mid*mid<=x){
                ans =(int) mid;
                low=(int)mid+1;
            }
            else high = (int)mid-1;
        }
        return ans;

    }
}