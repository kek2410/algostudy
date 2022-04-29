package com.company.bucketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Test1 {

  ArrayList<HashMap<Integer, Round>> record = new ArrayList<>();
  public int aa(String[][] rounds) {
    var answer = -1;

    Function<String, Integer> con = (str) -> {
      if (str.equals("a")) return 0;
      if (str.equals("b")) return 1;
      if (str.equals("c")) return 2;
      return 3;
    };


    for (int index = 0; index < rounds.length; index++) {
      var round = rounds[index];
      record.add(new HashMap<>());
      System.out.println(record.size());
      for (int i = 0; i < round.length; i++) {
        System.out.println(record);
        if (record.get(i).containsKey(i)) {
          continue;
        }
        var selected = (int) con.apply(round[i]);
        if (i == selected) {
          record.get(i).put(i, new Round(selected, true, false));
          answer++;
          continue;
        }

        if (i > 0) {
          var beforeRound = record.get(i - 1);
          if (selected == beforeRound.get(i).getSelected() && beforeRound.get(i).isCouple()) {
            record.get(i).put(i, new Round(selected, true, false));
            answer++;
            continue;
          }

          var target = con.apply(round[selected]);

          if (i != target) {
            record.get(i).put(i, new Round(selected, false, false));
            continue;
          }

          if (target == beforeRound.get(selected).getSelected() && beforeRound.get(selected).isCouple()) {
            record.get(i).put(i, new Round(selected, false, false));
            record.get(i).put(selected, new Round(target, true, false));
          } else {
            record.get(i).put(i, new Round(selected, false, true));
            record.get(i).put(selected, new Round(target, false, true));
          }
        }
      }
    }

    return answer;
  }

  public class Round {
    int selected;
    Boolean foul;
    Boolean couple;

    public Round(int selected, boolean foul, boolean couple) {
      this.selected = selected;
      this.foul = foul;
      this.couple = couple;
    }

    public int getSelected() {
      return this.selected;
    }

    public boolean isFoul() {
      return this.foul;
    }

    public boolean isCouple() {
      return this.couple;
    }

    @Override
    public String toString() {
      return String.format("%s, %s, %s", this.selected, this.foul.toString(), this.couple.toString());
    }
  }

  public static void main(String[] args) {
    var a = new Test1();
    var rounds = new String[][]{{"b", "a", "a", "d"}};
//    var rounds = new String[][]{{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}};
//    var rounds = new String[][]{{"b", "a", "a", "d"}, {"b", "c", "a", "c"}, {"b", "a", "d", "c"}};
    System.out.println("result : " + a.aa(rounds));
  }


}
