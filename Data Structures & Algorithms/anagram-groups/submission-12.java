class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*

        My initial idea with this is that I have a HashMap where I store the 
        sorted version of every string, to the list of the unSorted versions. 
        So the anagram group is keyed by the sorted version of their strings. 
        This means, for every string, I would do a nlogn operation, which would 
        lead to a n^2logn algorithmic complexity. 

        Another way to do it is using a HashMap with the counts of each character in the string 
        as the key to the anagram list. this would give me a n^2 complexity, because 
        for each string I am only going through it once linearly. 

        */

        HashMap<HashMap<Character, Integer>, List<String>> mapOfCountsToListOfAnagrams = new HashMap<>();

        for(String string : strs) {
            HashMap<Character, Integer> charToCounts = new HashMap<>();
            for(char ch : string.toCharArray()) {
                charToCounts.put(ch, charToCounts.getOrDefault(ch, 0)+1);
            }
            mapOfCountsToListOfAnagrams.computeIfAbsent(charToCounts, k->new ArrayList<>()).add(string);
        }

        List<List<String>> groupAnagrams = new ArrayList<>();

        for(List<String> anagrams : mapOfCountsToListOfAnagrams.values()) {
            groupAnagrams.add(anagrams);
        }

        return groupAnagrams;

    }
}
