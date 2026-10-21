class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) {
            p.add(stones[i]);
        }

        while(p.size() > 1) {
            int largestStone1 = p.poll();
            int largestStone2 = p.poll();
            p.add(Math.abs(largestStone1 - largestStone2));
        }

        return p.poll();
    }
}
