class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        int matched = 0;
        while (matched < n && count[target.charAt(matched) - 'a'] > 0) {
            count[target.charAt(matched) - 'a']--;
            matched++;
        }
        
        for (int k = matched; k >= 0; k--) {
            if (k < n) {
                int targetCharIdx = target.charAt(k) - 'a';
                
                for (int c = targetCharIdx + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        count[c]--;
                        
                        StringBuilder sb = new StringBuilder();
                        sb.append(target, 0, k);
                        sb.append((char) ('a' + c));
                        
                        for (int i = 0; i < 26; i++) {
                            while (count[i] > 0) {
                                sb.append((char) ('a' + i));
                                count[i]--;
                            }
                        }
                        
                        return sb.toString();
                    }
                }
            }
            
            if (k > 0) {
                count[target.charAt(k - 1) - 'a']++;
            }
        }
        
        return "";
    }
}