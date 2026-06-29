class Solution {
    public int maxProfit(int[] num) {
        int n= num.length;
        int buy=num[0];
        int profit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            buy=Math.min(buy,num[i]);
            profit=Math.max(profit,num[i]-buy);
        }
        return profit;
        
    }
}
