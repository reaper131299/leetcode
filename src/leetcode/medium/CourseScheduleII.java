package leetcode.medium;

import java.util.*;

public class CourseScheduleII {
    List<Integer>[] map;
    int[] list;
    int idx = 0;

    public static void main(String args[]) {
        CourseScheduleII c = new CourseScheduleII();
        c.findOrder(2, new int[][]{
                {1, 0}
        });
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new List[numCourses];
        list = new int[numCourses];

        for (int[] n : prerequisites) {
            if (map[n[0]] == null) {
                map[n[0]] = new ArrayList<>();
            }
            map[n[0]].add(n[1]);
        }

        //iterate over every element and the course path using topological sort.
        Boolean[] visited = new Boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (findCoursePath(i, visited)) {
                return new int[0];
            }
        }

        return list;
    }

    public boolean findCoursePath(int courseId, Boolean[] visited) {
        if (visited[courseId] != null) return visited[courseId];

        if (map[courseId] == null || map[courseId].isEmpty()) {
            visited[courseId] = false;
            list[idx++] = courseId;
            return false;
        }

        visited[courseId] = true;

        List<Integer> nei = map[courseId];
        for(Integer i : nei) {
            if (findCoursePath(i, visited)) {
                return true;
            }
        }

        visited[courseId] = false;
        list[idx++] = courseId;

        return false;
    }
}































