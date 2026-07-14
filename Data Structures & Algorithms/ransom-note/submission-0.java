class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomFreq = new HashMap<>();
        HashMap<Character, Integer> magFreq = new HashMap<>();
    
        for(char ch : ransomNote.toCharArray()) {
            ransomFreq.put(ch, ransomFreq.getOrDefault(ch, 0)+1);
        }

        for(char ch : magazine.toCharArray()) {
            magFreq.put(ch, magFreq.getOrDefault(ch, 0)+1);
        }        
    
        for(char ch : ransomFreq.keySet()) {
            if(!magFreq.containsKey(ch)) {
                return false;
            }
            if(ransomFreq.get(ch)>magFreq.get(ch)) {
                return false;
            }
        }

        return true;

    }
}