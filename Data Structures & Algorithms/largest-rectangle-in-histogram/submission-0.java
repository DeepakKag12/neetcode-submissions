class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int ans = 0;

        Stack<Integer> st = new Stack<>();

        // Nearest Smaller to Left
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            left[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        st.clear();

        // Nearest Smaller to Right
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();

            right[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;

            ans = Math.max(ans, width * heights[i]);
        }

        return ans;
    }
}