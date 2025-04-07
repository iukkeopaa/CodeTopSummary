package org.wqz.Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TopologicalSort {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 存储每个节点的入度
        int[] inDegree = new int[numCourses];
        // 存储图的邻接表
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // 构建图和入度数组
        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            adjList.get(bi).add(ai);
            inDegree[ai]++;
        }
        // 存储入度为 0 的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 存储拓扑排序结果
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            // 遍历当前节点的所有邻居
            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // 如果拓扑排序的结果长度不等于节点数量，说明存在环
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }

    public static void main(String[] args) {
        TopologicalSort solution = new TopologicalSort();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = solution.findOrder(numCourses, prerequisites);
        for (int node : order) {
            System.out.print(node + " ");
        }
    }
}    