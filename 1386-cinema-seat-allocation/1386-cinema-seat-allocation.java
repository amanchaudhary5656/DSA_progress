import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            reserved
                .computeIfAbsent(row, k -> new HashSet<>())
                .add(col);
        }

        int answer = (n - reserved.size()) * 2;

        for (Set<Integer> seats : reserved.values()) {
            boolean left = isAvailable(seats, 2, 5);
            boolean middle = isAvailable(seats, 4, 7);
            boolean right = isAvailable(seats, 6, 9);

            if (left && right) {
                answer += 2;
            } else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }

    private boolean isAvailable(Set<Integer> reserved, int start, int end) {
        for (int seat = start; seat <= end; seat++) {
            if (reserved.contains(seat)) {
                return false;
            }
        }
        return true;
    }
}