class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suffix = new int[m + 1];
        Arrays.fill(suffix, -1);
        int i = n - 1;
        for (int j = m - 1; j >= 0; j--) {
            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                break;
            }

            suffix[j] = i;
            i--;
        }

        List<Integer> answer = new ArrayList<>();
        int word2Index = 0;
        boolean mismatchUsed = false;
        for (i = 0; i < n && word2Index < m; i++) {
            char current = word1.charAt(i);
            char required = word2.charAt(word2Index);
            if (current == required) {
                answer.add(i);
                word2Index++;
            }
            else if (!mismatchUsed &&
                    (word2Index == m - 1 ||
                     (suffix[word2Index + 1] != -1 &&
                      suffix[word2Index + 1] > i))) {

                answer.add(i);
                word2Index++;
                mismatchUsed = true;
            }
        }

        if (answer.size() != m) {
            return new int[0];
        }

        int[] result = new int[m];

        for (i = 0; i < m; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}