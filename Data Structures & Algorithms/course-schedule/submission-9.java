class Solution {

    Map<Integer, List<Integer>> courseToPreReqs = new HashMap<>();
    Set<Integer> coursesCompleted = new HashSet<>();
    Set<Integer> coursesCurrentlyTaking = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] courseToPreReq:prerequisites) {
            int course = courseToPreReq[0];
            int preReq = courseToPreReq[1];
            courseToPreReqs.computeIfAbsent(course, k->new ArrayList<>()).add(preReq);
        }

        for(int course=0; course<numCourses;course++) {
            if(!canFinish(course)) {
                return false;
            }
        }

        return true;
    }

    public boolean canFinish(int course) {
        if(coursesCompleted.contains(course)) {
            return true;
        }
        if(coursesCurrentlyTaking.contains(course)) {
            return false;
        }

        if(courseToPreReqs.containsKey(course)) {
            coursesCurrentlyTaking.add(course);
            for(int preReq: courseToPreReqs.get(course)) {
                if(!canFinish(preReq)) {
                    return false;
                }
            }
            coursesCurrentlyTaking.remove((Integer)course);
        }

        coursesCompleted.add(course);
        return true;
    }
}
