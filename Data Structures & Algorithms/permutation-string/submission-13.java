class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) {
            return false;
        }
        
        //we will sort s1
        //then we will compare all substrings of s2 that 
        //are of length s1, and then sort them and compare them 

        //if the sorted permutations are equal, we return true 

        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        String sortedS1 = new String(s1Chars);

        int left=0, right=s1.length();

        while(left<right && right<=s2.length()) {
            String substring = s2.substring(left,right);
            char[] substringChars = substring.toCharArray();
            Arrays.sort(substringChars);
            String sortedSubstring = new String(substringChars);
            if(sortedS1.equals(sortedSubstring)) {
                return true;
            }
            left++;
            right++;
        }

        return false;
    }
}
