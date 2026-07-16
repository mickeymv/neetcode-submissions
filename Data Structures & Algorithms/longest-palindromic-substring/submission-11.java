class Solution {
    public String longestPalindrome(String s) {
        int lengthOfLongestSubstring=0;
        String longestPalindromicSubString="";
        int left,right;
        for(int i=0;i<s.length();i++) {
            //check for odd palindromes 
            left=i;
            right=i;
            while(left<=right && left>=0 && right<s.length()){
                if(s.charAt(left)!=s.charAt(right)) {
                    break;
                }
                int lengthOfPalindrome = right-left+1;
                if(lengthOfPalindrome>lengthOfLongestSubstring) {
                    longestPalindromicSubString=s.substring(left,right+1);
                    lengthOfLongestSubstring=longestPalindromicSubString.length();
                }
                left--;
                right++;
            } 

            //check for even palindromes 
            left=i;
            right=i+1;
            while(left<=right && left>=0 && right<s.length()){
                if(s.charAt(left)!=s.charAt(right)) {
                    break;
                }
                int lengthOfPalindrome = right-left+1;
                if(lengthOfPalindrome>lengthOfLongestSubstring) {
                    longestPalindromicSubString=s.substring(left,right+1);
                                        lengthOfLongestSubstring=longestPalindromicSubString.length();

                }
                left--;
                right++;
            } 
        }

        return longestPalindromicSubString;
    }
}
