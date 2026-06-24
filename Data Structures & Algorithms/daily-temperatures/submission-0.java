class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        ans[n - 1] = 0;
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int curr = temp[i];
            while (!st.isEmpty() && temp[st.peek()] <= curr) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? 0 : st.peek() - i;

            st.push(i);
        }

        return ans;
    }
}