class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        int m = nums.length;
        int n = nums[0].length;
        int low = 0;
        int high = m - 1;
        int mid = 0;
        while(low <= high)
        {
            mid = low + (high - low) / 2;
            if(nums[mid][0] <= target && target <= nums[mid][n - 1])
            {
                break;
            }
            else if(nums[mid][0] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        if(low > high) return false;

        int row = mid;

        low = 0;
        high = n - 1;
        while(low <= high)
        {
            mid = low + (high - low) / 2;

            if(nums[row][mid] == target)
            {
                return true;
            }
            else if(nums[row][mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return false;
    }
}