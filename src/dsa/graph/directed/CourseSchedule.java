package dsa.graph.directed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of N tasks you have to pick, labeled from 0 to n-1. Eg: N=3, courses names are 0,1 and 2
Some courses may have prerequisites tasks. Eg: [0 , 1] → 1 is the pre-req for 0
Like this you will be given a list of dependencies, and we have to come up with one possible course structure.
There may be multiple correct orders, you just need to return one of them.
If it is impossible to finish all tasks, return an empty dsa.array.
Sample Inputs:
1) Input: numCourses = 4, prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
Output: [0,1,2,3] or [0,2,1,3]
2)Input: numCourses = 6, prerequisites = [ [0,5], [0,4], [1,0], [2,0], [3,1], [3,2] ]
Output: [4, 5, 0, 1, 2, 3]
 */

public class CourseSchedule {
    public static List<Integer> findCourseOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prerequisiteGraph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            prerequisiteGraph.add(new ArrayList<>());
        }
        for (int[] coursePre : prerequisites) {
            int course = coursePre[0];
            int pre = coursePre[1];
            prerequisiteGraph.get(pre).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> courseOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseOrder.add(currentCourse);
            for (int neighbor : prerequisiteGraph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return courseOrder.size() == numCourses ? courseOrder : new ArrayList<>();
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = { {0, 1}, {0, 2}, {1, 2} };
        List<Integer> courseOrder = findCourseOrder(numCourses, prerequisites);
        System.out.println(courseOrder);

        int numCourses2 = 6;
        int[][] prerequisites2 = {{0,5}, {0,4}, {1,0}, {2,0}, {3,1}, {3,2}};
        List<Integer> courseOrder2 = findCourseOrder(numCourses2, prerequisites2);
        System.out.println(courseOrder2);

    }
}