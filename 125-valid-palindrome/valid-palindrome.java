class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char currLeft = s.charAt(left);
            char currRight = s.charAt(right);

            // 1. Move left pointer forward until we find a letter or digit
            if (!Character.isLetterOrDigit(currLeft)) {
                left++;
            } 
            // 2. Move right pointer backward until we find a letter or digit
            else if (!Character.isLetterOrDigit(currRight)) {
                right--;
            } 
            // 3. Both are alphanumeric, so compare them
            else {
                if (Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)) {
                    return false;
                }
                // After a match, move both pointers inward
                left++;
                right--;
            }
        }

        return true;
    }
}