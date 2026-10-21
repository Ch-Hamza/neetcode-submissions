class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return recursiveSearch(nums, target, start, end);
        // while(start <= end) {
        //     int mid = start + (end - start)/2;
        //     if (nums[mid] == target) {
        //         return mid;
        //     }

        //     if (target > nums[mid]) {
        //         start = mid + 1;
        //     } else {
        //         end = mid - 1;
        //     }
        // }

        // return -1;
    }

    private int recursiveSearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start)/2;
        if (nums[mid] == target) {
            return mid;
        }

        if (target > nums[mid]) {
            return recursiveSearch(nums, target, mid + 1, end);
        } else {
            return recursiveSearch(nums, target, start, mid - 1);
        }
    }
}
