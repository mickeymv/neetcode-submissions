class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int gift:gifts) {
            maxHeap.add(gift);
        }

        while(k>0) {
            k--;
            int maxGift = maxHeap.poll();
            int gift = (int)Math.floor(Math.sqrt(maxGift));
            maxHeap.add(gift);
        }

        int sumOfGifts = 0;

        while(!maxHeap.isEmpty()) {
            sumOfGifts+=maxHeap.poll();
        }

        return sumOfGifts;
    }
}