class Solution {
    public List<String> mostVisitedPattern(String[] usernames, int[] timestamps, String[] websites) {
        int n = timestamps.length;
        
        //first order timestamps in the order that they are present

        List<int[]> orderedTimestamps = new ArrayList<>();

        for(int i=0;i<n;i++) {
            orderedTimestamps.add(new int[]{timestamps[i],i}); //(timestamp,index)
        }

        orderedTimestamps.sort((a,b) -> a[0]-b[0]);
        //^ order the timestamps by their timing 


        //generate a map of users to their website visits 

        Map<String, ArrayList<String>> userToWebsites = new HashMap<>();

        for(int i=0;i<n;i++) {
            int index = orderedTimestamps.get(i)[1];
            userToWebsites.computeIfAbsent(usernames[index], k->new ArrayList<>()).add(websites[index]);
        }

        //now for every user, we have to add every pattern that they went through to a set, 
        //as well as count the pattern against the user's visit once 


        HashMap<String, Integer> patternToCount = new HashMap<>();

        for(String user : userToWebsites.keySet()) {
            List<String> userWebsites = userToWebsites.get(user);
            Set<String> patterns = new HashSet<>();
            for(int i=0;i<userWebsites.size();i++) {
                for(int j=i+1;j<userWebsites.size();j++) {
                    for(int k=j+1;k<userWebsites.size();k++) {
                        patterns.add(userWebsites.get(i)+"#"+userWebsites.get(j)+"#"+userWebsites.get(k));
                    }
                }
            }
            for(String pattern : patterns) {
                patternToCount.put(pattern, patternToCount.getOrDefault(pattern, 0)+1);
            }
        }

        int highestCount=0;
        String highestPattern="";

        for(String pattern : patternToCount.keySet()) {
            int count = patternToCount.get(pattern);
            if (count>highestCount || (count==highestCount && pattern.compareTo(highestPattern)<0)) {
                highestCount=count;
                highestPattern=pattern;
            }
        }

        return Arrays.asList(highestPattern.split("#"));
    }
}