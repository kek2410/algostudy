package com.company.level2;

public class HowMuchNeedMoney {

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        long result = solution(price, money, count);
        if (result == 10) {
            System.out.println("Success");
        }
    }

    public static long solution(int price, int money, int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * price;

        }
        if (sum > money) {
            return sum - money;
        }

        return 0;
    }


}
