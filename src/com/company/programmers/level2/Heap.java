package com.company.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = solution2(scoville, K);
        System.out.println(result);
    }

    public static int solution2(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(scoville).forEach(queue::offer);

        while (queue.peek() < K) {
            if (queue.size() <= 1) {
                return -1;
            }

            int a = queue.poll();
            int b = queue.poll();
            int c = a + (b * 2);
            queue.offer(c);
            answer++;
        }

        return answer;
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        List<Integer> queue = new LinkedList<>();
        for (int s : scoville) {
            queue.add(s);
        }
        queue.sort(Comparator.comparingInt(a -> a));
        while (!queue.isEmpty()) {
            if (queue.size() <= 1) {
                return -1;
            }

            int a = queue.remove(0);
            int b = queue.remove(0);
            int c = a + (b * 2);
            answer++;
            if (c > K) {
                return answer;
            }
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i) > c) {
                    queue.add(i, c);
                    break;
                } else if (i == queue.size() - 1) {
                    queue.add(c);
                    break;
                }

            }
        }
        return answer;
    }

}
