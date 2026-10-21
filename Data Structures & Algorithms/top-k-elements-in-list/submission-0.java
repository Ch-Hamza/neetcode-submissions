class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (occurrences.containsKey(nums[i])) {
                occurrences.put(nums[i], occurrences.get(nums[i]) + 1);
            } else {
                occurrences.put(nums[i], 1);
            }
        }

        int[] res = occurrences.entrySet()
            .stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
            .mapToInt(entry -> entry.getKey())
            .limit(k)
            .toArray();

        for (int i = 0; i < k; i++) {
            System.out.println(res[i]);
        }

        return res;
    }
}
