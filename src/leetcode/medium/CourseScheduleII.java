package leetcode.medium;

import java.util.*;

public class CourseScheduleII {
    Set<Integer>[] map;
    int[] list;
    int idx = 0;

    public static void main(String args[]) {
        CourseScheduleII c = new CourseScheduleII();
        c.findOrder(6, new int[][]{
                {2, 3},
                {1, 2},
                {0, 1},
                {0, 4},
                {4, 5},
                {5, 1}
        });
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new Set[numCourses];
        list = new int[numCourses];

        for(int[] n : prerequisites){
            if(map[n[0]] == null){
                map[n[0]] = new HashSet<>();
            }
            map[n[0]].add(n[1]);
        }

        //iterate over every element and the course path using topological sort.
        boolean[]  visited = new boolean[numCourses];
        boolean[]  addedToSeq = new boolean[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(!findCoursePath(i, visited, addedToSeq)){
                return new int[0];
            }
        }

        return list;
    }

    public boolean findCoursePath(int courseId, boolean[] visited, boolean[] addedToSeq) {
        if(map[courseId] == null || map[courseId].isEmpty()) {
            if(!addedToSeq[courseId]) {
                addedToSeq[courseId] = true;
                list[idx++] = courseId;
            }
            return true;
        }
        if(visited[courseId]) return false;

        visited[courseId] = true;

        Iterator<Integer> itr = map[courseId].iterator();
        while (itr.hasNext()){
            int course = itr.next();
            if(!findCoursePath(course, visited, addedToSeq)){
                return false;
            } else {
                visited[course] = false;
                itr.remove();
            }
        }

        addedToSeq[courseId] = true;
        list[idx++] = courseId;

        return true;
    }
}































