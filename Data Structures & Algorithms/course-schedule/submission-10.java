class Solution {

    Map<Integer, Set<Integer>> courseToPreReqs = new HashMap<>();
    Set<Integer> coursesTaking = new HashSet<>();
    Set<Integer> coursesTaken = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] preReqA : prerequisites) {
            int course = preReqA[0];
            int preReq = preReqA[1];

            courseToPreReqs.computeIfAbsent(course, k->new HashSet<>()).add(preReq);
        }

        for(int course=0;course<numCourses;course++) {
            if(!canFinish(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean canFinish(int course) {
        if(coursesTaking.contains(course)) {
            return false;
        }

        if(coursesTaken.contains(course)) {
            return true;
        }

        if(courseToPreReqs.containsKey(course)) {
            coursesTaking.add(course);

            for(int preReq : courseToPreReqs.get(course)) {
                if(!canFinish(preReq)) {
                    return false;
                }
            }

            coursesTaking.remove(course);
        }

        coursesTaken.add(course);
        
        return true;
    }
}
