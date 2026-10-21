class KthLargest {

    PriorityQueue<Integer> p;
    int heapSize;

    public KthLargest(int k, int[] nums) {
        p = new PriorityQueue();
        heapSize = k;
        for(int i = 0; i < nums.length; i++) {
            if (p.size() < heapSize) {
                p.add(nums[i]);
            } else if (p.size() == heapSize && nums[i] > p.peek()) {
                p.poll();
                p.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
         if (p.size() < heapSize) {
            p.add(val);
        } else if (p.size() == heapSize && val > p.peek()) {
            p.poll();
            p.add(val);
        }
        return p.peek();
    }
}
