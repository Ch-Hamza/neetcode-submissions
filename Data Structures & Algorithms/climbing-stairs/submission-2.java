class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memory = new HashMap();
        return climb(n, memory);
    }

    public int climb(int n, Map<Integer, Integer> memory) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int climb1, climb2;
        if (memory.containsKey(n-1)) {
            climb1 = memory.get(n-1);
        } else {
            climb1 = climb(n-1, memory);
            memory.put(n-1, climb1); 
        }
        if (memory.containsKey(n-2)) {
            climb2 = memory.get(n-2);
        } else {
            climb2 = climb(n-2, memory);
            memory.put(n-2, climb2);
        }
        // climb1 = climb(n-1);
        // climb2 = climb(n-2);
        return climb1 + climb2;
    }
}
