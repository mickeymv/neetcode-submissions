class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timesToValues = map.getOrDefault(key, new TreeMap<>());
        timesToValues.put(timestamp, value);
        map.put(key, timesToValues);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timesToValues = map.getOrDefault(key, new TreeMap<>());
        
        Integer previousTime = timesToValues.floorKey(timestamp);

        if(previousTime==null) {
            return "";
        }
        
        return timesToValues.get(previousTime);
    }
}
