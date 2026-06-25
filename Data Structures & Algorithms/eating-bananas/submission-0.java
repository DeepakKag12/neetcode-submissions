class Solution {
    public boolean help(int[] piles, int h, int k) {
        int hr = 0;

        for (int p : piles) {
            hr += (p + k - 1) / k;   
        }

        return hr <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int p : piles) {
            max = Math.max(max, p);
        }

        int low = 1;
        int high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (help(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}