package com.company.codility;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class File {

  public static void main(String[] args) {
    var s = new File();
//    var ss = s.solution("my.song.mp3 11b\n"
//        + "greatSong.flac 1000b\n"
//        + "not3.txt 5b\n"
//        + "video.mp4 200b\n"
//        + "game.exe 100b\n"
//        + "mov!e.mkv 10000b");
//
//    System.out.println("Ss " + ss);

//    var sss = s.ss(new int[]{1, 2, 3, -4});
//    System.out.println(sss);

    var a = s.solution2(new int[]{1, 3, 2, 1, 6, 10}, new int[]{4, 9, 5, 10, 11});
    System.out.println(a);
  }

  public int solution2(int[] A, int[] B) {
    int n = A.length;
    int m = B.length;
    Arrays.sort(A);
    Arrays.sort(B);
    int i = 0;
    for (int k = 0; k < n; k++) {
      System.out.println("k: " + k + " number: " + A[k] + " <> "+ B[i]);
      while (i < m - 1 && B[i] < A[k])
        i += 1;
      if (A[k] == B[i])
        return A[k];
    }
    return -1;
  }



  public String solution(String S) {
    // write your code in Java SE 11
    var split = S.split("\n");

    var musicExt = List.of("mp3", "aac", "flac");
    var imageExt = List.of("jpg", "bmp", "gif");
    var movieExt = List.of("mp4", "avi", "mkv");

    var music = new AtomicInteger();
    var image = new AtomicInteger();
    var movie = new AtomicInteger();
    var other = new AtomicInteger();

    Arrays.stream(split)
        .forEach(str -> {
              var bt = str.substring(str.lastIndexOf(" ") + 1, str.lastIndexOf("b"));
              System.out.println(bt);
              var ext = str.substring(str.lastIndexOf(".") + 1, str.lastIndexOf(" "));
              System.out.println(ext);
              if (musicExt.contains(ext)) {
                music.addAndGet(Integer.parseInt(bt));
                return;
              }
              if (imageExt.contains(ext)) {
                image.addAndGet(Integer.parseInt(bt));
                return;
              }
              if (movieExt.contains(ext)) {
                movie.addAndGet(Integer.parseInt(bt));
                return;
              }
              other.addAndGet(Integer.parseInt(bt));
            }
        );
    return "music " + music + "b\n"
        + "images " + image + "b\n"
        + "movies " + movie + "b\n"
        + "other " + other + "b";
  }

  public int ss(int[] A) {
//    return Arrays.stream(A).map(Math::abs).distinct().findFirst().orElse(0);
    var res = 0;
    for (int i = 0; i < A.length - 1; i++) {
      var a = A[i];
      for (int j = i + 1; j < A.length; j++) {
        if (Math.abs(a) == Math.abs(A[j])) {
          res = Math.abs(a);
          break;
        }
      }
      if (res != 0) {
        break;
      }
    }
    return res;
  }


}
