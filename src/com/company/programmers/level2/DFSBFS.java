package com.company.programmers.level2;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSBFS {

  class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
      V = v;
      adj = new LinkedList[v];

      // 인접 리스트 초기화
      for (int i = 0; i < v; ++i) adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
      adj[v].add(w);
    } /* DFS */

    void DFS(int v) {
      boolean[] visited = new boolean[V]; // v를 시작 노드로 DFSUtil 재귀 호출
      dfsUtil(v, visited);
    } /* DFS에 의해 사용되는 함수 */

    void dfsUtil(int v, boolean[] visited) {
      // 현재 노드를 방문한 것으로 표시하고 값을 출력
      visited[v] = true;
      System.out.print(v + " ");
      // 방문한 노드와 인접한 모든 노드를 가져온다.
      Iterator<Integer> it = adj[v].listIterator();
      while (it.hasNext()) {
        int n = it.next();
        // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
        if (!visited[n]) dfsUtil(n, visited);
      }
    }

    void BFS(int s) {
      boolean visited[] = new boolean[V];
      // 방문여부 확인용 변수
      LinkedList<Integer> queue = new LinkedList<Integer>();
      // 연결리스트 생성
      visited[s] = true;
      queue.add(s);
      while (queue.size() != 0) {
        // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
        s = queue.poll();
        System.out.print(s + " ");
        // 방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
          int n = i.next();
          // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
          if (!visited[n]) {
            visited[n] = true;
            queue.add(n);
          }
        }
      }
    }
  }
}
