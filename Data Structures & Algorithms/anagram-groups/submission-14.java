class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>, List<String>> anagramMapToStrings = new HashMap<>();

        for(String str : strs) {
            Map<Character, Integer> charToFreq = new HashMap<>();
            for(char ch : str.toCharArray()) {
                charToFreq.put(ch, charToFreq.getOrDefault(ch, 0)+1);
            }
            anagramMapToStrings.computeIfAbsent(charToFreq, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> anagrams = new ArrayList<>();

        for (List<String> strings: anagramMapToStrings.values()) {
            anagrams.add(strings);
        }

        return anagrams;
    }
}
