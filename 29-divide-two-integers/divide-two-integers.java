class Solution {
    public int divide(int dividend, int divisor) {
        // 1. Handle the overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        // 2. Work with positive values using long to avoid overflow
        long ld = Math.abs((long)dividend);
        long lr = Math.abs((long)divisor);
        long ans = 0;

        // 3. Your core logic (with 'dividend' typo fixed)
        while(ld >= lr) {
            int cnt = 0;
            // Check (lr << (cnt + 1)) safely using long
            while(ld >= (lr << (cnt + 1)))
                cnt++;

            ans += (1L << cnt);
            ld = ld - (lr << cnt);
        }

        // 4. Apply the correct sign
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        return isNegative ? (int)-ans : (int)ans;
    }
}