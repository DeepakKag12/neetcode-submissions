class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int[] frq = new int[128];
        Arrays.fill(frq, -1);
        int n = s.length();
        int str = 0, end = 0;
        while (end < n) {
            char ch = s.charAt(end);
            if (frq[ch] >= str) {
                str = frq[ch] + 1;
            }
            frq[ch] = end;
            len = Math.max(len, end - str + 1);
            end++;
        }

        return len;
    }
}