class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n2 < n1) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = n1 - 1;
        for (int i = l; i <= r; i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        while (r < n2) {

            if (map1.equals(map2)) {
                return true;
            }
            char leftChar = s2.charAt(l);
            map2.put(leftChar, map2.get(leftChar) - 1);
            if (map2.get(leftChar) == 0) {
                map2.remove(leftChar);
            }
            l++;
            r++;
            if (r < n2) {
                char rightChar = s2.charAt(r);
                map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);
            }
        }

        return false;
    }
}