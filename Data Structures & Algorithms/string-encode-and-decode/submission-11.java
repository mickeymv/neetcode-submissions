class Solution {

    String DELIMITTER  = "&&&&";

    public String encode(List<String> strs) {
        if(strs.size()==0) {
            return "";
        }
        return String.join(DELIMITTER, strs);
    }

    public List<String> decode(String str) {
        if(str=="") {
            return new ArrayList<>();
        }

        return Arrays.asList(str.split(DELIMITTER,-1));
    }
}
