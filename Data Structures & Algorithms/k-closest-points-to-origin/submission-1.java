class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> p = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        for(int i = 0; i < points.length; i++) {
            if (p.size() < k) {
                double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
                p.offer(new double[]{i, distance});
                continue;
            }
            
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            double maxDistance = Math.sqrt(Math.pow(points[(int)p.peek()[0]][0], 2) + Math.pow(points[(int)p.peek()[0]][1], 2));
            System.out.println(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            System.out.println(Math.pow(points[(int)p.peek()[0]][0], 2) + Math.pow(points[(int)p.peek()[0]][1], 2));
            
            if (p.size() == k && distance < maxDistance) {
                p.poll();
                p.offer(new double[]{i, distance});
            }
        }

        int[][] x = new int[k][2];
        for (int j = 0; j < k; j++) {
            x[j] = points[(int)p.poll()[0]];
        }
        return x;
    }
}
