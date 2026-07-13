class Solution {
    public String largestGoodInteger(String num) {
        String maxGoodInteger = "";

        int left=0, right=1;

        while(right<num.length()) {
            if(num.charAt(right)==num.charAt(right-1)) {
                //we are good
                if(right-left+1 == 3) {
                    //we have a good integer of size 3;
                    String goodInteger = num.substring(left,right+1);
                    if(goodInteger.compareTo(maxGoodInteger)>0) {
                        maxGoodInteger = goodInteger;
                    }
                    left++;
                } 
            } else {
                //update left and right 
                left=right;
            }
            right++;
        }

        return maxGoodInteger;
    }
}