class Solution {
    Map<Integer, Integer> memory = new HashMap();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(computeCost(cost, 0), computeCost(cost, 1));
    }

    public int computeCost(int[] cost, int start) {
        if (start >= cost.length) {
            return 0;
        }

        if (memory.containsKey(start)) {
            return memory.get(start);
        } else {
            int minCost = cost[start] + Math.min(computeCost(cost, start + 1), computeCost(cost, start + 2));
            memory.put(start, minCost);
            return minCost;
        }

        // int cost1, cost2;
        // if (memory.containsKey()) {
        //     cost1 = cost[start] + memory.get();
        // } else {
        //    cost1 = cost[start] + computeCost(cost, start + 1, memory);
        // }

        // if (memory.containsKey()) {
        //     cost2 = cost[start + 1] + memory.get();
        // } else {
        //    cost2 = cost[start + 1] + computeCost(cost, start + 2, memory);
        // }

        // return Math.min(cost1, cost2);
    }
}
