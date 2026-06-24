class Solution {
    public boolean isPalindrome(String s) {
        int str = 0;
        int end = s.length() - 1;
        while (str < end) {
            if (!Character.isLetterOrDigit(s.charAt(str))) {
                str++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(str)) !=
                Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            str++;
            end--;
        }

        return true;
    }
}