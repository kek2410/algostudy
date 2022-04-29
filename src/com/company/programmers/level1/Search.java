package com.company.programmers.level1;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Search {
  HashSet<Integer> set = new HashSet<>();
  public int solution(String numbers) {
    AtomicInteger answer = new AtomicInteger();
    rec("", numbers);
    IntPredicate isPrime = (int num) -> {
      if (num <= 1)
        return false;
      int limit = (int) Math.sqrt(num);

      for (int i = 0; i < limit; i++) {
        if (num % i == 0) return false;
      }
      return true;
    };
    set.forEach(num -> {
      if (Boolean.TRUE.equals(isPrime.test(num))) answer.getAndIncrement();
    });

    return answer.get();

  }

  public void rec(String com, String rest) {
    if (!com.equals("")) {
      set.add(Integer.valueOf(com));
    }

    for (int i = 0; i < rest.length(); i++) {
      rec(com + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1));
    }
  }

  public static void main(String[] args) {
    var a = new Search();
//    var a = new int[][]{{100000000, 4},{30000, 4}, {30000, 10}};
//    System.out.println(Arrays.toString(solution(a)));
//    Scanner sc = new Scanner(System.in);
//    int a = sc.nextInt();
//    for (int i = 0; i < a; i++) {
//      for (int j = 0; j < i + 1; j++) {
//        System.out.print(a);
//        if (j == i) {
//          System.out.print("\n");
//        }
//      }
//
//    }


  }

  public static int[] solution(int[][] v) {
    var xx = List.of(v[0][0], v[1][0], v[2][0]);
    var yy = List.of(v[0][1], v[1][1], v[2][1]);
    xx =xx.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    yy =yy.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    return new int[]{(Objects.equals(xx.get(0), xx.get(1)) ? xx.get(2) : xx.get(0)),
        (yy.get(0) == yy.get(1)) ? yy.get(2) : yy.get(0)};
 }




}
