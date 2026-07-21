class Solution {

    Set<Character> vowels = new HashSet<>();

    {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int ansIndex=-1;
        for(int[] query : queries) {
            ansIndex++;
            int start = query[0];
            int end = query[1];
            int wordsWithVowels=0;
            for(int i=start;i<=end;i++) {
                String word = words[i];
                if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1))) {
                    wordsWithVowels++;
                }
            }
            ans[ansIndex]=wordsWithVowels;
        }

        return ans;
    }
}