class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] result = new int[numCourses];
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

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)  {
                q.addLast(i);
            }
        }
        int n = 0;
        while (!q.isEmpty()) {
            int top = q.removeFirst();
            taken++;
            result[n] = top;
            n++;
            for (int i  : adjList.get(top)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.addLast(i);
                }
            }
        }


        return (taken == numCourses) ? result : new int[0];   
    }
}
