class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int l = 0, r = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        while (r < n) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0)
                    count++;

                map.put(ch, map.get(ch) - 1);
            }

            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char left = s.charAt(l);

                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);

                    if (map.get(left) > 0)
                        count--;
                }

                l++;
            }

            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}