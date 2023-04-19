class Solution {
    public long pickGifts(int[] gifts, int k) {
        // create a max heap priority queue and push all the elements into it
        // we need a max heap because we need the max out of it every time
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : gifts) {
            pq.offer(i);
        } 
        
        // we will perform our task k times
        while (k-- > 0) {
            int x = pq.poll();        // take out the richest pile
            x = (int) Math.sqrt(x);   // floor of the square root
            pq.offer(x);              // put it back
        }
        
        // now the heap only contains the leftovers
        long left = 0;
        // get the sum of all leftovers
        while (!pq.isEmpty()) {
            left += pq.poll();  
        }
        
        return left;    // return the answer
    }
}