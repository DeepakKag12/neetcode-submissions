class Solution {
    public int maxArea(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MIN_VALUE;
        while(low<high)
        {
            ans=Math.max(ans,(high-low)*Math.min(nums[low],nums[high]));
            if(nums[low]<=nums[high]) low++;
            else high--;

        }
        return ans;

        
    }
}

