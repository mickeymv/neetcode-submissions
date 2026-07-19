class Solution {
    public boolean wordPattern(String pattern, String string) {
        Map<Character, String> patternToWord = new HashMap<>();

        String[] words = string.split(" ");

        if(pattern.length()!=words.length) {
            return false;
        }

        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(patternToWord.containsKey(ch)) {
                //pattern is already present, check if the word matches 
                String existingWordForPattern = patternToWord.get(ch);
                if(!existingWordForPattern.equals(words[i])) {
                    return false;
                }
            } else {
                //new pattern, add it to the map if the word doesn't already exist 
                if(patternToWord.values().contains(words[i])) {
                    //word is already mapped to another pattern 
                    return false;
                }
                patternToWord.put(ch, words[i]);
            }
        }

        return true;
    }
}