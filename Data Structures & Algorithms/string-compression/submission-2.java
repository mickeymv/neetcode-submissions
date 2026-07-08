class Solution {
    public int compress(char[] chars) {
        StringBuilder string = new StringBuilder();

        //add the char followed by the group length to string 
        //unless it is one, where we just add the char 

        for(int i=0;i<chars.length;) {
            char ch = chars[i];
            //look-ahead to next char to see if it is equal 
            int lookAhead = i+1;

            while(lookAhead<chars.length && chars[lookAhead]==ch) {
                //we have encountered repeating chars, lookahead again 
                lookAhead++;
            }

            //we break out of the loop with lookAhead!=ch, so we can decrement it 

            lookAhead--;

            if (i==lookAhead) {
                //there are no repeating chars, add this char to the string 
                string.append(ch);
                i++;
            } else {
                int lengthOfRepeatingChars = lookAhead-i+1;
                string.append(ch);
                string.append(Integer.toString(lengthOfRepeatingChars));
                i=lookAhead+1;
            }
        }

        String compressed = string.toString();

        for(int i=0;i<compressed.length();i++) {
            chars[i] = compressed.charAt(i);
        }

        return compressed.length();
    }
}