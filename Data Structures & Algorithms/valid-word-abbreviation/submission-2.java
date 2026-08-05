class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr.length()>word.length()) {
            return false;
        }

        if(word.equals(abbr)) {
            return true;
        }

        int wordPtr=0,abbrPtr=0;

        while(wordPtr<word.length() && abbrPtr < abbr.length()) {
            if(word.charAt(wordPtr) == abbr.charAt(abbrPtr)) {
                wordPtr++;
                abbrPtr++;
                continue;
            } else if (!Character.isDigit(abbr.charAt(abbrPtr))) {
                return false;
            } else {
                if(abbr.charAt(abbrPtr)=='0') {
                    return false;
                }
                int startOfNumber = abbrPtr;

                while(abbrPtr < abbr.length() && Character.isDigit(abbr.charAt(abbrPtr))) {
                    abbrPtr++;
                }
                int num = Integer.parseInt(abbr.substring(startOfNumber, abbrPtr));
                wordPtr+=num;
            }
        }

        if (wordPtr==word.length() && abbr.length()==abbrPtr) {
            return true;
        }

        return false;
    }
}