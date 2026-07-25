class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];
        int taken = 0;
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int prereq = pair[1];
            int course = pair[0];
            adjList.get(prereq).add(course);
            inDegree[course]++;
        }

        for  (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.addLast(i);
            }
        }

        while(!q.isEmpty()) {
            int top = q.removeFirst();
            taken++;
            for (int c: adjList.get(top)) {
                inDegree[c]--;
                if (inDegree[c] == 0) {
                    q.addLast(c);
                }
            }
        }

        return taken == numCourses;
    }

}
