class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> points = new HashSet<>();

        int x=0,y=0;

        String currPoint = x+"-"+y;

        points.add(currPoint);

        for(char dir : path.toCharArray()) {
            if(dir=='N') {
                y++;
            } else if (dir=='S') {
                y--;
            } else if (dir=='E') {
                x++;
            } else if (dir=='W') {
                x--;
            } 

            currPoint = x+"-"+y;;

            if (points.contains(currPoint)) {
                return true;
            } else {
                points.add(currPoint);
            }

        }

        return false;
    }
}