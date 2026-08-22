class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int d=n;
        while(d>0){
            int temp= d%10;
            sum+=temp;
            product*=temp;
            d/=10;
        }
        
        return (n%(sum+product)==0) ? true: false;
    }
}