class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1=0,i2=0;

        String string = "";

        while(i1<word1.length() && i2<word2.length()) {
            string+=word1.charAt(i1++);
            string+=word2.charAt(i2++);
        }

        while(i1<word1.length()) {
            string+=word1.charAt(i1++);
        }

                while(i2<word2.length()) {
            string+=word2.charAt(i2++);
        }

        return string;
    }
}