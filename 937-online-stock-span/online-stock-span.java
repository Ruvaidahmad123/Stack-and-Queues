class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

class StockSpanner {
    int count;
    Stack<Pair> st; // Stack should store Pair objects

    public StockSpanner() {
        count = 0;
        st = new Stack<>();
    }

    public int next(int price) {
        count++;
        while (!st.isEmpty() && price >= st.peek().val) {
            st.pop();
        }
        if (st.isEmpty()) {
            st.push(new Pair(price, count)); // Push the current price and count
            return count; // If stack is empty, return the count
        }
        int ans = count - st.peek().idx;
        st.push(new Pair(price, count)); // Push the current price and count
        return ans;
    }
}
