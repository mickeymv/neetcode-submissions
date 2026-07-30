class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()) {
            return false;
        }

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        Arrays.sort(sA);
        Arrays.sort(tA);

        for(int i=0;i<s.length();i++) {
            if(sA[i]!=tA[i]) {
                return false;
            }
        }

        return true; 
    }
}
