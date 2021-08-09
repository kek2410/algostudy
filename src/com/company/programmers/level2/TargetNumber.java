package com.company.level2;

public class TargetNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = solution(numbers, target);
        if (answer == 5) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private static int dfs(int[] numbers, int idx, int sum, int target) {
        int maxIdx = numbers.length;
        if (idx == maxIdx) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, idx + 1, sum + numbers[idx], target)
                + dfs(numbers, idx + 1, sum - numbers[idx], target);
    }
}
