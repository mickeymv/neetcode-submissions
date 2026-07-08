class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length()>t.length()) {
            return false;
        }

        int sI=0, tI=0, matchedChars=0;

        while(sI<s.length() && tI<t.length()) {
            if(s.charAt(sI)==t.charAt(tI)) {
                sI++;
                tI++;
                matchedChars++;
            } else {
                tI++;
            }
        }

        return matchedChars == s.length();
    }
}