class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramToStrings = new HashMap<>();

        for(String str : strs) {
            char[] anagram = str.toCharArray();
            Arrays.sort(anagram);
            String anagStr = new String(anagram);
            anagramToStrings.computeIfAbsent(anagStr, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> anagrams = new ArrayList<>();

        for (List<String> strings: anagramToStrings.values()) {
            anagrams.add(strings);
        }

        return anagrams;
    }
}
