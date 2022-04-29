package com.company.codility.yanolja;

public class ABC {

  public static void main(String[] args) {
    System.out.println(new ABC().solution(6, 1, 1));
  }

  public String solution(int A, int B, int C) {
    var result = "";

    int aCount = A / 2;
    int aRest = A % 2;
    int bCount = B / 2;
    int bRest = B % 2;
    int cCount = C / 2;
    int cRest = C % 2;

    while (aCount > 0 || aRest > 0 || bCount > 0 || bRest > 0 || cCount > 0 || cRest > 0) {
      if (aCount > 0) {
        aCount--;
        if (!(result.length() > 2 && result.endsWith("aa"))) {
          result += "aa";
        }
      } else if (aRest > 0) {
        if (!(result.length() > 2 && result.endsWith("aa"))) {
          result += "a";
        }
        aRest = 0;
      }

      if (bCount > 0) {
        bCount--;
        if (!(result.length() > 2 && result.endsWith("bb"))) {
          result += "bb";
        }
      } else if (bRest > 0) {
        if (!(result.length() > 2 && result.endsWith("bb"))) {
          result += "b";
        }
        bRest = 0;
      }

      if (cCount > 0) {
        cCount--;
        if (!(result.length() > 2 && result.endsWith("cc"))) {
          result += "cc";
        }
      } else if (cRest > 0) {
        if (!(result.length() > 2 && result.endsWith("cc"))) {
          result += "c";
        }
        cRest = 0;
      }
    }

    return result;
  }


}
