class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0) {
            return "";
        }

        StringBuilder encoded = new StringBuilder();

        for(String string:strs) {
            encoded.append(String.valueOf(string.length()));
            encoded.append("#");
            encoded.append(string);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        if("".equals(str)) {
            return new ArrayList<>();
        }

        List<String> strings = new ArrayList<>();

        for(int i=0;i<str.length();) {
            int indexOfPound = i;
            while(str.charAt(indexOfPound)!='#') {
                indexOfPound++;
            }
            String sizeOfString = str.substring(i,indexOfPound);
            int stringSize = Integer.valueOf(sizeOfString);

            strings.add(str.substring(indexOfPound+1, indexOfPound+1+stringSize));
            i=indexOfPound+1+stringSize;
        }

        return strings;
    }
}
