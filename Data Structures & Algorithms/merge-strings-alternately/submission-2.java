class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1=0,i2=0;

        String out="";

        while(i1<word1.length() && i2<word2.length()) {
            out+=word1.charAt(i1++);
            out+=word2.charAt(i2++);
        }

        if(i1==word1.length()) {
            out+=word2.substring(i2);
        } else {
            out+=word1.substring(i1);
        }

        return out;
    }
}