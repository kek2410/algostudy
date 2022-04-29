package com.company.programmers.level2;

public class Country124 {

    public static void main(String[] args) {
        int n = 4;
        String result = solution(3);
        result = result.replace("0", "4");
        if (result.equals("4")) {
            System.out.println("Success");
        }
    }

    public static String solution(int number) {
        String[] numbers = {"4", "1", "2"};
        int target = 3;
        StringBuilder sb = new StringBuilder();
        // 진법 변환할 숫자가 0보다 큰 경우 지속 진행
        while (number > 0) {
            int rest = number % target;
            sb.append(numbers[rest]);
            number /= target;
            if(rest == 0) number--;
        }
        return sb.toString();
    }

}
