class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int str = 0;
        int end = n - 1;
        int mid = 0;

        while (str <= end) {
            mid = str + (end - str) / 2;

            if (nums[mid] == target)
                return mid;

             if (nums[mid] > nums[end]) {
                if (nums[mid] > target && nums[str] <= target) {
                    end = mid - 1;
                } else
                    str = mid + 1;
            } else {
                if (nums[mid] < target && nums[end] >= target) {
                    str = mid + 1;
                } else
                    end = mid - 1;
            }
        }

        return -1;
    }
}