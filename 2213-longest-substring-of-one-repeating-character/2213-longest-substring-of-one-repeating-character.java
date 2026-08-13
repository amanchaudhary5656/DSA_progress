class Solution {
    static class Node {
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int best;
        int length;

        Node(char leftChar, char rightChar,
             int prefix, int suffix, int best, int length) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.length = length;
        }
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String query, int[] arr) {
        chars = s.toCharArray();

        int n = chars.length;
        int q = arr.length;

        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int[] answer = new int[q];

        for (int i = 0; i < q; i++) {
            int index = arr[i];
            chars[index] = query.charAt(i);

            update(1, 0, n - 1, index);

            answer[i] = tree[1].best;
        }

        return answer;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(
                chars[start],
                chars[start],
                1,
                1,
                1,
                1
            );
            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int start, int end, int index) {
        if (start == end) {
            tree[node] = new Node(
                chars[index],
                chars[index],
                1,
                1,
                1,
                1
            );
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, end, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {
        Node result = new Node(
            left.leftChar,
            right.rightChar,
            left.prefix,
            right.suffix,
            Math.max(left.best, right.best),
            left.length + right.length
        );

        if (left.rightChar == right.leftChar) {
            result.best = Math.max(
                result.best,
                left.suffix + right.prefix
            );

            if (left.prefix == left.length) {
                result.prefix = left.length + right.prefix;
            }

            if (right.suffix == right.length) {
                result.suffix = right.length + left.suffix;
            }
        }

        return result;
    }
}