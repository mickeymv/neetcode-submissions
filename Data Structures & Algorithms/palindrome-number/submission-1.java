class Solution {
    public boolean isPalindrome(int x) {
        String xString = String.valueOf(x);

        int left=0,right=xString.length()-1;

        while(left<right) {
            if(xString.charAt(left)!=xString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}