package week.a337;

import org.junit.Test;

public class b100156 {
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = target.length();

        // dp[i][j] represents the minimum cost to convert source[0...i-1] to target[0...j-1]
        long[][] dp = new long[n + 1][m + 1];

        // Initialize the dp array with maximum cost
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }

        dp[0][0] = 0; // Base case: empty strings, no cost

        // Populate the dp array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                // Skip this character in source
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);

                if (j < m) {
                    // Change source[i] to target[j] if possible
                    if (source.charAt(i) == target.charAt(j)) {
                        dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                    } else {
                        int index = findIndex(original, changed, cost, source.charAt(i), target.charAt(j));
                        if (index != -1) {
                            dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + cost[index]);
                        }
                    }
                }
            }
        }

        // Check if it is possible to convert the entire source to target
        if (dp[n][m] == Long.MAX_VALUE) {
            return -1;
        }

        return dp[n][m];
    }

    private static int findIndex(char[] original, char[] changed, int[] cost, char x, char y) {
        for (int i = 0; i < original.length; i++) {
            if (original[i] == x && changed[i] == y) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(minimumCost("abcd","acbe",new char[]{'a','b','c','c','e','d'},new char[]{'b','c','b','e','b','e'},new int[]{2,5,5,1,2,20}));
    }

    public static void main(String[] args) {
        // Example 1
        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

        // Example 2
        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a', 'c'};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

        // Example 3
        String source3 = "abcd";
        String target3 = "abce";
        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
    }
}
