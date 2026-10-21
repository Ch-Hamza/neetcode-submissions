class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> dupes = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if (dupes.containsKey(nums[i]))
                return true;
            else
                dupes.put(nums[i], 1);
        }
        return false;
    }
}