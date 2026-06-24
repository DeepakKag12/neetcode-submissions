class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            // Start only if there is no previous number
            if (!set.contains(num - 1)) {

                int curr = num;
                int len = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}