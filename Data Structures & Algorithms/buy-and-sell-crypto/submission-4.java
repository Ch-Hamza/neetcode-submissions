class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0; int sell = 1; int bestProfit = 0;

        // while (start < end && end < prices.length) {
        //     int profit = prices[end] - prices[start];
        //     if (profit > bestProfit) {
        //         bestProfit = profit;
        //         start++;
        //     } else {
        //         end++;
        //     }

            
        // }
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - prices[buy];
            if (profit > bestProfit) {
                bestProfit = profit;
            }

            if (prices[i] < prices[buy]) {
                buy = i;
            }
        }

        return bestProfit;
    }
}
