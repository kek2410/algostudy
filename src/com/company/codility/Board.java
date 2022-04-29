package com.company.codility;

import java.util.Arrays;

public class Board {

  public static void main(String[] args) {
    var s = new Board();
    System.out.println(s.solution(3, 2, new int[]{2, 1, 1, 0, 1}));
  }

  public String solution(int U, int L, int[] C) {
    if (U + L != Arrays.stream(C).sum()) {
      return "IMPOSSIBLE";
    }
    var first = new String[C.length];
    var second = new String[C.length];
    for (var i = 0; i < C.length; i++) {
      var c = C[i];
      if (c == 2) {
        first[i] = "1";
        second[i] = "1";
      } else if (c == 1) {
        if (U > 1) {
          first[i] = "1";
          second[i] = "0";
          U--;
        } else if (L > 1) {
          first[i] = "0";
          second[i] = "1";
          L--;
        } else {
          first[i] = "0";
          second[i] = "0";
        }
      } else {
        first[i] = "0";
        second[i] = "0";
      }
    }
    return String.join("", first) + "," + String.join("", second);
  }



}
