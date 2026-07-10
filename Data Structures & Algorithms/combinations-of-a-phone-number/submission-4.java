class Solution {


    Map<Character, List<String>> digitToLetters = new HashMap<>();
    {
        digitToLetters.put('2', List.of("a","b","c"));
        digitToLetters.put('3', List.of("d","e","f"));
        digitToLetters.put('4', List.of("g","h","i"));
        digitToLetters.put('5', List.of("j","k","l"));
        digitToLetters.put('6', List.of("m","n","o"));
        digitToLetters.put('7', List.of("p","q","r","s"));
        digitToLetters.put('8', List.of("t","u","v"));
        digitToLetters.put('9', List.of("w","x","y","z"));
    }


    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if(digits.length()>0) {
            combinations.addAll(digitToLetters.get(digits.charAt(0)));
        }

        for(int i=1;i<digits.length();i++) {
            char digit = digits.charAt(i);
            List<String> chars = digitToLetters.get(digit);
            List<String> newCombinations = new ArrayList<>();
            
            for(String combination : combinations) {
                for(String ch : chars) {
                    newCombinations.add(combination + ch);
                }
            }

            combinations = newCombinations;
        }

        return combinations;
    }
}
