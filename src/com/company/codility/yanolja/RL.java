package com.company.codility.yanolja;

public class RL {

  public static void main(String[] args) {
    var a = new RL();
    System.out.println(a.sol("RLRRLLRLRRLL"));;
    System.out.println(a.sol("RLLLRRRLLR"));;
    System.out.println(a.sol("LLRLRLRLRLRLRR"));;
  }

  public int sol(String s) {
    int resultCount = 0;
    int compareCount = 1;
    for (int i = 0; i < s.chars().count(); i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        compareCount++;
      } else {
        i += compareCount;
        resultCount++;
        compareCount = 1;
      }
    }
    return resultCount;
  }

}
