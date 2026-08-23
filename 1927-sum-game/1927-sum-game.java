class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n/2;
        int rsum=0, lsum=0, rq=0,lq=0;
        for(int i=0; i<half; i++){
            char ch = num.charAt(i);
            if(ch=='?') lq++;
            else lsum+=ch-'0';
        }
        for(int i=half; i<n; i++){
            char ch = num.charAt(i);
            if(ch=='?') rq++;
            else rsum+=ch-'0';
        }
        if((lq+rq)%2!=0) return true;
        return 2*(lsum-rsum) + 9*(lq-rq) !=0;
    }
}