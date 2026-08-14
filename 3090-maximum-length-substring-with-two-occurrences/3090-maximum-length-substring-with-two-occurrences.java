class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n= s.length();
        int r=0, l=0;
        int max = 0;
        for( r=0; r<n; r++){
            char c= s.charAt(r);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.get(c)>2){
                char ll=s.charAt(l);
                map.put(ll, map.get(ll)-1);
                l++;

            }
            max = Math.max(max, r-l+1);

        }
        return max;
        


    }
}