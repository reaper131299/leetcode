package leetcode.medium;

import java.util.*;

public class CourseSchedule {

    public static void main(String args[]) {
        CourseSchedule c = new CourseSchedule();
        c.canFinish(3, new int[][]{
                {0,1},
                {0,2},
                {1,2}
        });
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] map = new Set[numCourses];

        for (int[] p : prerequisites) {
            if (map[p[0]] == null) {
                map[p[0]] = new HashSet<>();
            }
            map[p[0]].add(p[1]);
        }

        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i<map.length; i++){
            if (!canFinishUtil(i, map, visited)) {
                return false;
            }
        }

        return true;
    }

    public boolean canFinishUtil(int courseId, Set<Integer>[] map, boolean[] visited) {
        if(map[courseId] == null || map[courseId].isEmpty()) return true;
        if(visited[courseId]) return false;
        visited[courseId]=true;
        Iterator<Integer> itr = map[courseId].iterator();
        while (itr.hasNext()){
            int c = itr.next();
            if (!canFinishUtil(c, map, visited)) {
                return false;
            } else{
                itr.remove();
                visited[c] =false;
            }
        }
        return true;
    }
}
